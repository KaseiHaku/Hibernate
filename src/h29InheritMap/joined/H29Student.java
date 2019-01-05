package h29InheritMap.joined;

import javax.persistence.Entity;

@Entity
public class H29Student extends H29Person{
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
