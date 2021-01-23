package matrix;


import algorithms.State;

public class MatrixState extends State<String> {

	public MatrixState(String state) {
		super(state);
		this.setCameFrom(null);
	}
	@Override
	public int hashCode() {
		final int code = 31;
		int result = super.hashCode();
		result = code * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
	@Override
	public boolean equals(State state) {
		if(this.state.intern()==((String) state.getState()).intern())
			return true;
		return false;
	}

	
	
	
	
}
