import java.util.Scanner;

public class Question {
	// TODO: Make sure that this stuff works for all of the question types
	// fields
	private String query;
	private String correctAnswer;
	private String userAnswer;
	private double pointValue;

	public Question(String query, String correctAnswer) {
		this.query = query;
		this.correctAnswer = correctAnswer;
		this.userAnswer = "";
	}

	// Accessor methods

	public String getQuery() {
		return this.query;
	}

	public String getUserAnswer() {
		return this.userAnswer;
	}

	public double getPointValue() {
		return this.pointValue;
	}

	public double getPointsEarned() {
		double output = 0;
		if (this.userAnswer.toLowerCase().trim().equals(this.correctAnswer.toLowerCase().trim())) {
			output = getPointValue();
		} else {
			output = 0;
		}
		return output;
	}

	// mutators

	// method overloading
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	// takes the user's keyboard input and stores it as userAnswer field
	public void setUserAnswer() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Your question is: \n " + getQuery() + " ");
		setUserAnswer(scan.nextLine());
	}

	public void setPointValue(double pointValue) {
		this.pointValue = pointValue;
	}

}
