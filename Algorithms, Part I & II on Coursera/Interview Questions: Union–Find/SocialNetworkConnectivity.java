package unionfind;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Given a social network containing n members and a log file containing m timestamps at
 * which times pairs of members formed friendships, design an algorithm to determine the
 * earliest time at which all members are connected (i.e., every member is a friend of a
 * friend of a friend ... of a friend). Assume that the log file is sorted by timestamp
 * and that friendship is an equivalence relation. The running time of your algorithm should
 * be m*logn or better and use extra space proportional to n.
 *
 */
public class SocialNetworkConnectivity {
	private int[] id;
	private int[] sz;
	boolean allConnected;

	public SocialNetworkConnectivity(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; ++i) {
			id[i] = i;
			sz[i] = 1;
		}
		allConnected = false;
	}

	public int root(int i) {
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

		if (sz[rootP] < sz[rootQ]) {
			id[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
		} else {
			id[rootQ] = rootP;
			sz[rootP] += sz[rootQ];
		}

		if (sz[rootQ] == id.length || sz[rootP] == id.length) {
			allConnected = true;
		}
	}

	public boolean isAllConnected() {
		return allConnected;
	}


	public static void main(String[] args) {
		try {
			File log = new File(System.getProperty("user.dir") + "/log.txt");
			Scanner in = new Scanner(log);
			SocialNetworkConnectivity sc = new SocialNetworkConnectivity(in.nextInt());

			while (in.hasNextLine()) {
				int i = in.nextInt();
				int j = in.nextInt();
				String strDate = in.next() + " " + in.next();
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);

				if (!sc.isConnected(i, j)) {
					sc.union(i, j);
				}

				if (sc.isAllConnected()) {
					System.out.println("Now all connected: " + date);
					return;
				}
			}

			System.out.println("All of them can't be connected");
			in.close();
		} catch (FileNotFoundException | ParseException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
