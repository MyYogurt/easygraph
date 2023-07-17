package org.moisiadis;

import java.io.Serializable;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * An abstract graph with common methods implemented.
 * @param <T> the type of the data of the vertices.
 */
public abstract class AbstractGraph<T> implements Graph<T>, Serializable {
	/**
	 * A map of vertices and their adjacent vertices.
	 */
	protected final Map<T, List<T>> adjVertices = new HashMap<>();

	@Override
	public void addVertex(T data) {
		adjVertices.put(data, new LinkedList<>());
	}

	@Override
	public void removeVertex(T data) {
		adjVertices.remove(data);
		adjVertices.values().forEach(e -> e.remove(data));
	}

	@Override
	public Optional<List<T>> getAdjVertices(T data) {
		return Optional.ofNullable(adjVertices.get(data));
	}

	@Override
	public Set<T> getVertices() {
		return adjVertices.keySet();
	}

	@Override
	public int getVertexCount() {
		return adjVertices.size();
	}

	@Override
	public int getEdgeCount() {
		return adjVertices.values().stream().mapToInt(List::size).sum();
	}

	@Override
	public boolean hasVertex(T data) {
		return adjVertices.containsKey(data);
	}

	@Override
	public boolean hasEdge(T data1, T data2) {
		if (adjVertices.containsKey(data1) && adjVertices.containsKey(data2)) {
			return adjVertices.get(data1).contains(data2);
		}
		return false;
	}

	@Override
	public Set<T> dfs(T data) {
		Set<T> visited = new LinkedHashSet<>();
		Deque<T> stack = new LinkedList<>();
		stack.push(data);

		while (!stack.isEmpty()) {
			T vertex = stack.pop();
			if (!visited.contains(vertex)) {
				visited.add(vertex);
				getAdjVertices(vertex).ifPresent(stack::addAll);
			}
		}

		return visited;
	}

	@Override
	public Set<T> bfs(T data) {
		Set<T> visited = new LinkedHashSet<>();
		Deque<T> queue = new LinkedList<>();
		queue.add(data);

		while (!queue.isEmpty()) {
			T vertex = queue.poll();
			if (!visited.contains(vertex)) {
				visited.add(vertex);
				getAdjVertices(vertex).ifPresent(queue::addAll);
			}
		}

		return visited;
	}

	@Override
	public String toString() {
		return "Graph{" + adjVertices +'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof AbstractGraph<?> graph) {
			return Objects.equals(adjVertices, graph.adjVertices);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjVertices);
	}
}
