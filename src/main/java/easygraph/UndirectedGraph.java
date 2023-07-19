package easygraph;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * An undirected graph is a graph in which all the edges are bidirectional.
 * @param <T> the type of the data of the vertices.
 */
public class UndirectedGraph<T> extends AbstractGraph<T> {
	@Override
	public void addEdge(T data1, T data2) {
		adjVertices.get(data1).add(data2);
		adjVertices.get(data2).add(data1);
	}

	@Override
	public void removeEdge(T data1, T data2) {
		List<T> eV1 = adjVertices.get(data1);
		List<T> eV2 = adjVertices.get(data2);
		if (eV1 != null) {
			eV1.remove(data2);
		}
		if (eV2 != null) {
			eV2.remove(data1);
		}
	}

	@Override
	public boolean isCyclic() {
		return false;
	}

	@Override
	public PathResult<T> shortestPath(T start, T destination) {
		// Perform dijkstra's algorithm on the graph to find the shortest path between two vertices.
		Map<T, Integer> distances = new HashMap<>();
		Map<T, T> previousVertices = new HashMap<>();
		PriorityQueue<Edge<T>> pq = new PriorityQueue<>();

		// Initialize distances to infinity and previous vertices to null
		for (T vertex : adjVertices.keySet()) {
			distances.put(vertex, Integer.MAX_VALUE);
			previousVertices.put(vertex, null);
		}

		// Set the distance of the start vertex to 0 and add it to the priority queue
		distances.put(start, 0);
		pq.add(new Edge<>(start, 0));

		while (!pq.isEmpty()) {
			Edge<T> current = pq.poll();
			T currentVertex = current.getDestination();

			// Stop if we reach the end vertex
			if (currentVertex.equals(destination))
				break;

			// Ignore if the distance to the current vertex is already greater than the calculated distance
			if (current.getWeight() > distances.get(currentVertex))
				continue;

			List<T> neighbors = adjVertices.get(currentVertex);
			if (neighbors != null) {
				for (T neighbor : neighbors) {
					int distance = distances.get(currentVertex) + 1; // Assuming all edges have weight 1

					// Update the distance and previous vertex if a shorter path is found
					if (distance < distances.get(neighbor)) {
						distances.put(neighbor, distance);
						previousVertices.put(neighbor, currentVertex);
						pq.add(new Edge<>(neighbor, distance));
					}
				}
			}
		}

		// Build the shortest path by backtracking from the end vertex to the start vertex
		Deque<T> path = new LinkedList<>();
		T vertex = destination;
		while (vertex != null) {
			path.addFirst(vertex);
			vertex = previousVertices.get(vertex);
		}

		Set<T> result = new LinkedHashSet<>(path);
		return new PathResult<>(result);
	}
}
