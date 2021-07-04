package exercise.ex08;

import java.util.Arrays;

public class Corn {

	private final int cornCount;

	public Corn(int cornCount) {
		this.cornCount = cornCount;
	}

	public static void main(String[] args) {
		Corn corn = new Corn(5);
		System.out.println(Arrays.asList(corn.makePopcorn()));
	}

	public Popcorn[] makePopcorn() {
		Popcorn[] arr = new Popcorn[cornCount];
		for (int i = 0; i < cornCount; i++) {
			arr[i] = new Popcorn();
		}
		return arr;
	}
}

class Popcorn {

	@Override
	public String toString() {
		return "Popcorn{}";
	}
}
