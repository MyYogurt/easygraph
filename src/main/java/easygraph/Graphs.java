package easygraph;

/**
 * Utility class for graphs.
 */
public class Graphs {
	private Graphs() {
	}

	/**
	 * Returns an unmodifiable view of the graph.
	 * If changes are made to the underlying graph, those changes will be reflected in the view.
	 * @param graph the graph.
	 * @return an unmodifiable view of the graph.
	 * @param <T> the type of the data of the vertices.
	 */
	public static <T> Graph<T> unmodifiableGraph(Graph<T> graph) {
		return new UnmodifiableGraph<>(graph);
	}
}
