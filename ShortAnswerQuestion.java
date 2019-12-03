import java.util.Scanner;

public class ShortAnswerQuestion extends Question{
	private Scanner scan = new Scanner(System.in);
	// Just takes user input and then prompts creator and asks whether or not answer it correct
	// 500 words maximum
	public ShortAnswerQuestion(String query) {
		super(query, null);
	}
	public void setUserAnswer() {
		System.out.print("Your question is: \n " + getQuery() + " \n (There is a maximum of 500 words, choose wisely!)\n (Your Answer Here):");
		String answer = scan.nextLine();
		// regex returns array of spaces and checks if length > 500
		if (answer.split("\\w+").length > 500) {
			throw new IllegalArgumentException("Your short answer is too long! It has to be less than 500 words!");
		}
		setUserAnswer(answer);
	}
	public double getPointsEarned() {
		System.out.println("This was the question: \n" + getQuery() + "\n This was the student's answer: \n" + getUserAnswer() + "\n How many points out of " + getPointValue() + " would you like to award them: ");
		return scan.nextDouble();
	}
}