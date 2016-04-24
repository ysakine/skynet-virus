import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {

	public class Link {

		private int n1;
		private int n2;

		public Link(int n1, int n2) {
			this.n1 = n1;
			this.n2 = n2;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Link other = (Link) obj;

			return ((n1 == other.n1 && n2 == other.n2) || (n2 == other.n1 && n1 == other.n2));
		}

	}

	public boolean disable(int agentNode, int[] gateways, List<Link> links) {
		for (int gateway : gateways) {
			Link link = new Link(agentNode, gateway);
			int linkIndex = links.indexOf(link);
			if (linkIndex >= 0) {
				System.out.println(link.n1 + " " + link.n2);
				links.remove(linkIndex);
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Player player = new Player();
		int N = in.nextInt();
		int L = in.nextInt();
		int E = in.nextInt();

		List<Link> links = new ArrayList<Link>(L);
		int[] gateways = new int[E];

		for (int i = 0; i < L; i++) {
			int N1 = in.nextInt(); // N1 and N2 defines a link between these
									// nodes
			int N2 = in.nextInt();
			links.add(player.new Link(N1, N2));
		}

		for (int j = 0; j < E; j++) {
			gateways[j] = in.nextInt();
		}

		while (true) {
			// Read information from standard input
			int agentNode = in.nextInt();

			// Compute logic here
			if (!player.disable(agentNode, gateways, links)) {
				System.out.println(links.get(0).n1 + " " + links.get(0).n2);
				links.remove(0);
			}
		}
	}
}