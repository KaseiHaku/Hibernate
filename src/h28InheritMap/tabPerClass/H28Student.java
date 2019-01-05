package h28InheritMap.tabPerClass;

import javax.persistence.Entity;

@Entity
public class H28Student extends H28Person{
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
