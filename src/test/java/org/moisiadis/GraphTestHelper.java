package org.moisiadis;

import java.util.List;

class GraphTestHelper {
	static Graph<String> generateTestGraph() {
		String[] vertices = {"0", "1", "2", "3", "4"};
		Graph<String> graph = new UndirectedGraph<>();
		graph.addVertices(List.of(vertices));
		graph.addEdge("0", "1");
		graph.addEdge("0", "4");
		graph.addEdge("1", "2");
		graph.addEdge("1", "3");
		graph.addEdge("1", "4");
		graph.addEdge("3", "2");
		return graph;
	}
}
