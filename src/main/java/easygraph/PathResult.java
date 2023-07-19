package easygraph;

import java.util.Objects;
import java.util.Set;

public final class PathResult<T> {
	private final Set<T> path;

	PathResult(Set<T> path) {
		this.path = path;
	}

	public Set<T> path() {
		return path;
	}

	public double cost() {
		return path.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj instanceof PathResult<?> pathResult) {
			return Objects.equals(path, pathResult.path);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(path);
	}

	@Override
	public String toString() {
		return "PathResult[path=" + path + ']';
	}

}
