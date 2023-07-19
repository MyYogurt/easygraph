package easygraph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(Lifecycle.PER_CLASS)
public class UnmodifiableGraphTest {
	private Graph<String> graph;

	@BeforeAll
	public void setUp() {
		graph = Graphs.unmodifiableGraph(GraphTestHelper.generateTestGraph());
	}

	@Test
	public void addVertex() {
		assertThrows(UnsupportedOperationException.class, () -> graph.addVertex("A"));
	}

	@Test
	public void addEdge() {
		assertThrows(UnsupportedOperationException.class, () -> graph.addVertex("A"));
	}

	@Test
	public void removeVertex() {
		assertThrows(UnsupportedOperationException.class, () -> graph.addVertex("A"));
	}

	@Test
	public void removeEdge() {
		assertThrows(UnsupportedOperationException.class, () -> graph.addVertex("A"));
	}
}