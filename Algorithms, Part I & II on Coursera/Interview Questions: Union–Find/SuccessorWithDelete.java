/*
 * Given a set of N integers S={0,1,...,N-1} and a sequence of requests of the following form:
 *  - Remove x from S
 *  - Find the successor of x: the smallest y in S such that y>=x.
 * design a data type so that all operations (except construction) should take logarithmic time or better.
 */

public class SuccessorWithDelete {

	private boolean[] data;
	private FindLargestUF uf;
	private int N;

	public SuccessorWithDelete(int N) {
		this.N = N;
		data = new boolean[N];
		for (int i = 0; i < N; ++i) {
			data[i] = true;
		}
		uf = new FindLargestUF(N);
	}

	public void remove(int x) {
		data[x] = false;
		if (x > 0 && !data[x - 1]) {
			uf.union(x, x - 1);
		}
		if (x < N - 1 && !data[x + 1]) {
			uf.union(x, x + 1);
		}
	}

	public int successor(int x) {
		if (data[x]) {
			return x;
		}
		else {
			int res = uf.find(x) + 1;
			if (res < N) {
				return res;
			}
			else {
				System.out.println("No successor can be found!");
				return -1;
			}
		}
	}
}
