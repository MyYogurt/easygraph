package easygraph;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

class UnmodifiableGraph<T> implements Graph<T> {
	private final Graph<T> graph;

	UnmodifiableGraph(Graph<T> graph) {
		this.graph = graph;
	}

	@Override
	public void addVertex(T data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addVertices(Collection<? extends T> vertices) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addEdge(T data1, T data2) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeVertex(T data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeEdge(T data1, T data2) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<List<T>> getAdjVertices(T data) {
		return graph.getAdjVertices(data);
	}

	@Override
	public Set<T> getVertices() {
		return graph.getVertices();
	}

	@Override
	public int getVertexCount() {
		return graph.getVertexCount();
	}

	@Override
	public int getEdgeCount() {
		return graph.getEdgeCount();
	}

	@Override
	public boolean hasVertex(T data) {
		return graph.hasVertex(data);
	}

	@Override
	public boolean hasEdge(T data1, T data2) {
		return graph.hasEdge(data1, data2);
	}

	@Override
	public Set<T> dfs(T data) {
		return graph.dfs(data);
	}

	@Override
	public Set<T> bfs(T data) {
		return graph.bfs(data);
	}

	@Override
	public boolean isCyclic() {
		return graph.isCyclic();
	}

	@Override
	public PathResult<T> shortestPath(T start, T destination) {
		return graph.shortestPath(start, destination);
	}
}
