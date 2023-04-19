package andreidodu.modelmapper;

public class Person {

	private Consensus consensus;


	public Consensus getConsensus() {
		return consensus;
	}


	public void setConsensus(Consensus consensus) {
		this.consensus = consensus;
	}


	@Override
	public String toString() {
		return "Person [consensus=" + consensus + "]";
	}




}
