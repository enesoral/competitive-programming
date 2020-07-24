/* 
 * Add a method find() to the union-find data type so that find(i)
 * returns the largest element in the connected component containing i.
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is {1,2,6,9},
 * then the find() method should return 9 for each of the four elements in the connected components.
 */

public class FindLargestUF {

	private int[] id;
	private int[] sz;
	private int[] large;

	public FindLargestUF(int N) {
		id = new int[N];
		sz = new int[N];
		large = new int[N];
		for (int i = 0; i < N; ++i) {
			id[i] = i;
			sz[i] = 1;
			large[i] = i;
		}
	}

	public int find(int i) {
		return large[root(i)];
	}

	private int root(int i) {
		while (id[i] != i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);

		if (rootP == rootQ) {
			return;
		}

		int largestP = large[rootP];
		int largestQ = large[rootQ];

		if (sz[rootP] < sz[rootQ]) {
			id[rootP] = rootQ;
			sz[rootQ] += sz[rootP];

			if (largestP > largestQ) {
				large[rootQ] = largestP;
			}
		}
		else {
			id[rootQ] = rootP;
			sz[rootP] += sz[rootQ];

			if (largestQ > largestP) {
				large[rootP] = largestQ;
			}
		}
	}
}
