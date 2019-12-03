import java.util.Scanner;

public class TrueFalseQuestion extends Question {
	boolean userAnswer;
	boolean correctAnswer;

	// pretty just a regular question with two options
	// except the correctAnswer and the userAnswer are booleans
	public TrueFalseQuestion(String query, boolean correctAnswer) {
		super(query, null);
		this.correctAnswer = correctAnswer;
	}

	public void setUserAnswer() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Your true-false statement is: \n " + getQuery() + "\n What is your answer (true or false): ");
		this.userAnswer = scan.nextBoolean();
	}

	public double getPointsEarned() {
		double output = 0;
		if (this.userAnswer == this.correctAnswer) {
			output = getPointValue();
		} else {
			output = 0;
		}
		return output;
	}
}
