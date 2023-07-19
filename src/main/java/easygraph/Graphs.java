package easygraph;

/**
 * Utility class for graphs.
 */
public class Graphs {
	private Graphs() {
	}

	/**
	 * Returns an immutable view of the graph.
	 * If changes are made to the underlying graph, those changes will be reflected in the view.
	 * @param graph the graph.
	 * @return an immutable view of the graph.
	 * @param <T> the type of the data of the vertices.
	 */
	public static <T> Graph<T> immutableView(Graph<T> graph) {
		return new UnmodifiableGraph<>(graph);
	}
}
