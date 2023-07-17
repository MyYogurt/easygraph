package org.moisiadis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * A graph is a data structure that consists of the following two components:
 * 1. A finite set of vertices also called as nodes.
 * 2. A finite set of a pair of the form (u, v) called as edge.
 * @param <T>
 */
public abstract class AbstractGraph<T> implements Serializable {
	/**
	 * A map of vertices and their adjacent vertices.
	 */
	protected final Map<T, List<T>> adjVertices = new HashMap<>();

	/**
	 * Adds a vertex to the graph.
	 * @param data the data of the vertex to be added.
	 */
	public abstract void addVertex(T data);

	/**
	 * Adds an edge between two vertices.
	 * @param data1 the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 */
	public abstract void addEdge(T data1, T data2);

	/**
	 * Removes a vertex from the graph.
	 * @param data the data of the vertex to be removed.
	 */
	public abstract void removeVertex(T data);

	/**
	 * Removes an edge between two vertices.
	 * @param data1	the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 */
	public abstract void removeEdge(T data1, T data2);

	/**
	 * Returns the adjacent vertices of a vertex.
	 * @param data the data of the vertex.
	 * @return the adjacent vertices of the vertex.
	 */
	public abstract Optional<List<T>> getAdjVertices(T data);

	/**
	 * Returns all the vertices of the graph.
	 * @return all the vertices of the graph.
	 */
	public abstract Optional<List<T>> getVertices();

	/**
	 * Returns the number of vertices in the graph.
	 * @return the number of vertices in the graph.
	 */
	public int getVertexCount() {
		return adjVertices.size();
	}

	/**
	 * Returns the number of edges in the graph.
	 * @return the number of edges in the graph.
	 */
	public int getEdgeCount() {
		return adjVertices.values().stream().mapToInt(List::size).sum();
	}

	/**
	 * Returns true if the graph contains the vertex.
	 * @param data the data of the vertex.
	 * @return true if the graph contains the vertex.
	 */
	public boolean hasVertex(T data) {
		return adjVertices.containsKey(data);
	}

	/**
	 * Returns true if the graph contains an edge between the two vertices.
	 * @param data1 the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 * @return true if the graph contains an edge between the two vertices.
	 */
	public boolean hasEdge(T data1, T data2) {
		if (adjVertices.containsKey(data1) && adjVertices.containsKey(data2)) {
			return adjVertices.get(data1).contains(data2);
		}
		return false;
	}

	public abstract Set<T> dfs(T data);

	public abstract Set<T> bfs(T data);

	public abstract boolean isCyclic();

	public abstract Set<T> shortestPath(T data1, T data2);

	/**
	 * Returns an immutable view of the graph.
	 * @param graph the graph.
	 * @return an immutable view of the graph.
	 * @param <T> the type of the data of the vertices.
	 */
	public static <T> AbstractGraph<T> immutableView(AbstractGraph<T> graph) {
		return new ImmutableGraph<>(graph);
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
