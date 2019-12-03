import java.util.Scanner;

public class MultipleChoiceQuestion extends Question {
	// field
	private String[] answerChoices;

	// constructor loops through input array and duplicates it as a field
	public MultipleChoiceQuestion(String query, int correctAnswer, String[] answerChoices) {
		super(query, answerChoices[correctAnswer]);
		this.answerChoices = new String[answerChoices.length];
		for (int i = 0; i < answerChoices.length; i++) {
			this.answerChoices[i] = answerChoices[i];
		}
	}

	// mutator
	// Collects user input and then takes the index of that input - 1 and then sets
	// field equal to that
	public void setUserAnswer() {
		int index;
		for (int i = 0; i < this.answerChoices.length; i++) {
			System.out.println("Answer choice number " + (i + 1) + ": " + answerChoices[i]);
		}
		Scanner scan = new Scanner(System.in);
		System.out.print(getQuery() + " (enter the answer choice number): ");
		index = scan.nextInt() - 1;
		if (index < 0 || index > this.answerChoices.length) {
			throw new IndexOutOfBoundsException("Please enter a valid answer choice number");
		}
		setUserAnswer(answerChoices[index]);
	}
}
