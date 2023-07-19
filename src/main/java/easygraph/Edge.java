package easygraph;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

class Edge<T> implements Serializable, Comparable<Edge<T>> {
	private static final int DEFAULT_WEIGHT = 1;

	private final T destination;
	private final double weight;

	protected Edge(T destination) {
		this(destination, DEFAULT_WEIGHT);
	}

	protected Edge(T destination, int weight) {
		this.destination = destination;
		this.weight = weight;
	}

	public T getDestination() {
		return destination;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Edge{" + "destination=" + destination + ", weight=" + weight + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof Edge<?> edge) {
			return Objects.equals(destination, edge.destination) && weight == edge.weight;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destination, weight);
	}

	@Override
	public int compareTo(Edge<T> o) {
		return Double.compare(weight, o.weight);
	}
}