package easygraph;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UndirectedGraphTest {
	private UndirectedGraph<String> graph = new UndirectedGraph<>();

	@Test
	void shortestPath() {
		Set<String> expected = Set.of("0", "1", "2");
		GraphTestHelper.addTestDataToGraph(graph);
		Set<String> actual = graph.shortestPath("0", "2").path();
		assertEquals(expected, actual);
	}
}