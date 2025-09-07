class UserSolution {
	
	Soldier[] soldiers = new Soldier[1000001];
//	int[] scores = new int[1000001];
	
	Team[] teams = new Team[6];
	
	public void init()
	{
		for(int i=1;i<=1000000;i++) {
			soldiers[i] = new Soldier(i);
		}
		for(int i=1;i<=5;i++) {
			teams[i] = new Team(i);
		}
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		Soldier prevHead = teams[mTeam].member[mScore];
		Soldier newHead = soldiers[mID];
		newHead.score = mScore;
		newHead.next = prevHead;
		teams[mTeam].member[mScore] = newHead;
		
				
	}
	
	public void fire(int mID)
	{
		soldiers[mID].isFired = true;
	}

	public void updateSoldier(int mID, int mScore)
	{
		soldiers[mID].score = mScore;
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		
		if(newScore <= 5)
		
		for(int i=1;i<=5;i++) {
			int newScore = i+mChangeScore;
			if(newScore <= 0) newScore = 1;
			if(newScore > 5) newScore = 5;
			
			if
			
		}
		
		
	}
	
	public int bestSoldier(int mTeam)
	{
		return 0;
	}
	
	private class Soldier {
		int id;
		int score;
		Soldier next;
		boolean isFired;
		Soldier(int id) {
			this.id = id;
		}
	}
	
	private class Team {
		int tid;
		Soldier[] member = new Soldier[6];
		Team(int tid) {
			this.tid = tid;
		}
	}
	
}

