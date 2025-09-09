class UserSolution {
	
	int version = 0;
	Soldier[] soldiers = new Soldier[100001];
//	int[] scores = new int[1000001];
	int[] versions = new int[100001];
	Team[] teams = new Team[6];
	
	public void init()
	{
//		System.out.println("intialized");
		for(int i=1;i<=100000;i++) {
			soldiers[i] = new Soldier(i,0);
		}
		for(int i=1;i<=5;i++) {
			teams[i] = new Team();
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
//		System.out.println("hired");

		Team team = teams[mTeam];
		Soldier newSoldier = soldiers[mID];
		newSoldier.tid = mTeam;
		Soldier prevTail = team.member_tail[mScore];
		
		if(prevTail != null) prevTail.next = newSoldier;
		else team.member[mScore] = newSoldier;
		
		team.member_tail[mScore] = newSoldier;
	
	}
	
	public void fire(int mID)
	{
//		System.out.println("fired");
		versions[mID] = -1;
	}

	public void updateSoldier(int mID, int mScore)
	{
//		System.out.println("updated");

		int tid = soldiers[mID].tid;
		int prevVersion = soldiers[mID].version;
		soldiers[mID] = new Soldier(mID,prevVersion+1);
		hire(mID, tid, mScore);
		versions[mID]++;
		
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
//		System.out.println("updated team");

		int[] scores;
		if (mChangeScore > 0) scores = new int[]{4,3,2,1};
		else scores = new int[]{2,3,4,5};
		
		for(int i:scores) {
			Team team = teams[mTeam];
			int newScore = i+mChangeScore;
			if(newScore > 5) newScore = 5;
			if(newScore < 1) newScore = 1;
			
			Soldier prevTail = team.member_tail[newScore];
			Soldier newTail = team.member_tail[i];
			
			if(prevTail != null) prevTail.next = team.member[i];
			else team.member[newScore] = team.member[i];
			team.member_tail[newScore] = newTail;
			
			team.member[i] = null;
			team.member_tail[i] = null;
		}

	}
	
	public int bestSoldier(int mTeam)
	{
//		System.out.println("bestSoldier");

		Soldier node = null;
		int score = 5;
		while(node==null) {
			node = teams[mTeam].member[score];
			score--;
		}

		int maxId = Integer.MIN_VALUE;
		
		System.out.println();
		Soldier startNode = node;
		while(node != null) {
//			if(node == startNode) System.out.println("loop!!!:"+node.id);
			if(node.version == versions[node.id]) {
				maxId = Math.max(maxId, node.id);
			}
			node = node.next;
		}
		
		return 0;
	}
	
	private class Soldier {
		int id;
		int tid;
		int version;
		Soldier next;
		Soldier(int id, int version) {
			this.id = id;
			this.version = 0;
		}
	}
	
	private class Team {
		Soldier[] member = new Soldier[6];
		Soldier[] member_tail = new Soldier[6];


	}
	
}

