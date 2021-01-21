package server;

import algorithms.Searchable;
import algorithms.Searcher;

public class solverSearcher<Problem,Solution> implements Solver<Problem, Solution> {
	private Searcher searcher;
	public solverSearcher(Searcher searcher) {
		this.searcher = searcher;
	}
	@Override
	public Solution solve(Problem p) {
		return (Solution) searcher.search((Searchable) p);
	}

}
