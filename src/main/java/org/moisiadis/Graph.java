package org.moisiadis;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Graph<T> {
	/**
	 * Adds a vertex to the graph.
	 * @param data the data of the vertex to be added.
	 */
	public void addVertex(T data);

	/**
	 * Adds an edge between two vertices.
	 * @param data1 the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 */
	public void addEdge(T data1, T data2);

	/**
	 * Removes a vertex from the graph.
	 * @param data the data of the vertex to be removed.
	 */
	public void removeVertex(T data);

	/**
	 * Removes an edge between two vertices.
	 * @param data1	the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 */
	public void removeEdge(T data1, T data2);

	/**
	 * Returns the adjacent vertices of a vertex.
	 * @param data the data of the vertex.
	 * @return the adjacent vertices of the vertex.
	 */
	public Optional<List<T>> getAdjVertices(T data);

	/**
	 * Returns all the vertices of the graph.
	 * @return all the vertices of the graph.
	 */
	public Set<T> getVertices();

	/**
	 * Returns the number of vertices in the graph.
	 * @return the number of vertices in the graph.
	 */
	public int getVertexCount();

	/**
	 * Returns the number of edges in the graph.
	 * @return the number of edges in the graph.
	 */
	public int getEdgeCount();

	/**
	 * Returns true if the graph contains the vertex.
	 * @param data the data of the vertex.
	 * @return true if the graph contains the vertex.
	 */
	public boolean hasVertex(T data);

	/**
	 * Returns true if the graph contains an edge between the two vertices.
	 * @param data1 the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 * @return true if the graph contains an edge between the two vertices.
	 */
	public boolean hasEdge(T data1, T data2);

	/**
	 * Returns the vertices of the graph in depth-first order.
	 * @param data the data of the vertex to start the traversal from.
	 * @return the vertices of the graph in depth-first order.
	 */
	public Set<T> dfs(T data);

	/**
	 * Returns the vertices of the graph in breadth-first order.
	 * @param data the data of the vertex to start the traversal from.
	 * @return the vertices of the graph in breadth-first order.
	 */
	public Set<T> bfs(T data);

	/**
	 * Returns true if the graph is cyclic. Redundant for non-directed graphs.
	 * @return true if the graph is cyclic.
	 */
	public boolean isCyclic();

	/**
	 * Returns the vertices of the graph in topological order.
	 * @param data1 the data of the vertex to start the traversal from.
	 * @param data2 the data of the vertex to end the traversal at.
	 * @return the vertices of the graph in topological order.
	 */
	public Set<T> shortestPath(T data1, T data2);
}
