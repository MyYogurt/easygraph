package org.moisiadis;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * A graph is a data structure that consists of the following two components:
 * 1. A finite set of vertices also called as nodes.
 * 2. A finite set of a pair of the form (u, v) called as edge.
 * @param <T> the type of the data of the vertices.
 */
public interface Graph<T> extends Serializable {
	/**
	 * Adds a vertex to the graph.
	 * @param data the data of the vertex to be added.
	 */
	void addVertex(T data);

	/**
	 * Adds a collection of vertices to the graph.
	 * @param vertices the collection of vertices to be added.
	 */
	void addVertices(Collection<? extends T> vertices);

	/**
	 * Adds an edge between two vertices.
	 * @param data1 the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 */
	void addEdge(T data1, T data2);

	/**
	 * Removes a vertex from the graph.
	 * @param data the data of the vertex to be removed.
	 */
	void removeVertex(T data);

	/**
	 * Removes an edge between two vertices.
	 * @param data1	the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 */
	void removeEdge(T data1, T data2);

	/**
	 * Returns the adjacent vertices of a vertex.
	 * @param data the data of the vertex.
	 * @return the adjacent vertices of the vertex.
	 */
	Optional<List<T>> getAdjVertices(T data);

	/**
	 * Returns all the vertices of the graph.
	 * @return all the vertices of the graph.
	 */
	Set<T> getVertices();

	/**
	 * Returns the number of vertices in the graph.
	 * @return the number of vertices in the graph.
	 */
	int getVertexCount();

	/**
	 * Returns the number of edges in the graph.
	 * @return the number of edges in the graph.
	 */
	int getEdgeCount();

	/**
	 * Returns true if the graph contains the vertex.
	 * @param data the data of the vertex.
	 * @return true if the graph contains the vertex.
	 */
	boolean hasVertex(T data);

	/**
	 * Returns true if the graph contains an edge between the two vertices.
	 * @param data1 the data of the first vertex.
	 * @param data2 the data of the second vertex.
	 * @return true if the graph contains an edge between the two vertices.
	 */
	boolean hasEdge(T data1, T data2);

	/**
	 * Returns the vertices of the graph in depth-first order.
	 * @param data the data of the vertex to start the traversal from.
	 * @return the vertices of the graph in depth-first order.
	 */
	Set<T> dfs(T data);

	/**
	 * Returns the vertices of the graph in breadth-first order.
	 * @param data the data of the vertex to start the traversal from.
	 * @return the vertices of the graph in breadth-first order.
	 */
	Set<T> bfs(T data);

	/**
	 * Returns true if the graph is cyclic. Redundant for non-directed graphs.
	 * @return true if the graph is cyclic.
	 */
	boolean isCyclic();

	/**
	 * Returns the vertices of the graph in topological order.
	 * @param data1 the data of the vertex to start the traversal from.
	 * @param data2 the data of the vertex to end the traversal at.
	 * @return the vertices of the graph in topological order.
	 */
	PathResult<T> shortestPath(T data1, T data2);
}
