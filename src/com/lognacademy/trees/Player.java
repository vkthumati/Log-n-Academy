package com.lognacademy.trees;

public class Player implements Comparable<Player>{
	private int ranking;
	private String name;
	private int age;
	
	public Player(int ranking, String name, int age) {
		this.ranking = ranking;
		this.name = name;
		this.age = age;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Player otherPlayer) {
		return (this.getRanking()-otherPlayer.getRanking());
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/*public static void main(String[] args) {
		List<Player> footballTeam = new ArrayList<Player>();
		footballTeam.add(new Player(59, "John", 20));
		footballTeam.add(new Player(67, "Roger", 22));
		footballTeam.add(new Player(45, "Steven", 24));
		
		System.out.println("Before Sorting : "+footballTeam);
		Collections.sort(footballTeam);
		System.out.println("After Sorting : "+footballTeam);
	}*/
}
