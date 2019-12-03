import java.util.Scanner;

public class LongAnswerQuestion extends Question {
	private Scanner scan = new Scanner(System.in);

	// Same as short answer, except 500 words is the minimum
	public LongAnswerQuestion(String query) {
		super(query, null);
	}

	public void setUserAnswer() {
		System.out.print("Your question is: \n " + getQuery()
				+ " \n (There is a minimum of 500 words, choose wisely!)\n (Your Answer Here): ");
		String answer = scan.nextLine();
		// regex returns array of spaces and checks if length < 500 (switch this to
		// smaller value when debugging)
		if (answer.split("\\w+").length < 1) {
			throw new IllegalArgumentException("Your long answer is too short! It has to be more than 500 words!");
		}
		setUserAnswer(answer);
	}

	// gets users input for number of points
	public double getPointsEarned() {
		System.out.println("This was the question: \n" + getQuery() + "\n This was the student's answer: \n"
				+ getUserAnswer() + "\n How many points out of " + getPointValue() + " would you like to award them: ");
		return scan.nextDouble();
	}
}
