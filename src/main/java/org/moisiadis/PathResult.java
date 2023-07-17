package org.moisiadis;

import java.util.Set;

public record PathResult<T>(Set<T> path, double weight) {
}
