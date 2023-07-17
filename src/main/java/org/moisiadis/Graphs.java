package org.moisiadis;

/**
 * Utility class for graphs.
 */
public class Graphs {
	private Graphs() {
	}

	/**
	 * Returns an immutable view of the graph.
	 * @param graph the graph.
	 * @return an immutable view of the graph.
	 * @param <T> the type of the data of the vertices.
	 */
	public static <T> Graph<T> immutableView(AbstractGraph<T> graph) {
		return new ImmutableGraph<>(graph);
	}
}
