import java.util.Scanner;

public class Quiz {
	// fields
	private int numQuestions;
	private Question[] questions;
	private Scanner scan = new Scanner(System.in);
	private String query;
	private double pointValue;

	// constructor
	public Quiz(int numQuestions) {
		this.numQuestions = numQuestions;
		int qInt = 0;
		this.questions = new Question[numQuestions];
		// A quiz can only have 1 - 4 questions
		if (numQuestions > 5 || numQuestions < 1) {
			throw new IllegalArgumentException("On any quiz, there must be either 1, 2, 3, or 4 questions!");
		}
		// Loops through every question that the user wishes to create
		for (int i = 0; i < numQuestions; i++) {
			System.out.println(
					"What kind of question do you wish to add to your quiz: \n 1. TrueFalse \n 2. MultipleChoice \n 3. ShortAnswer \n 4. LongAnswer \n (Please enter the option number): ");

			qInt = scan.nextInt();
			scan.nextLine();
			// qInt is used to determine which type of question the user wished to create
			if (qInt == 1) {
				createTrueFalseQuestion(i);
			} else if (qInt == 2) {
				createMultipleChoiceQuestion(i);
			} else if (qInt == 3) {
				createShortAnswerQuestion(i);
			} else if (qInt == 4) {
				createLongAnswerQuestion(i);
			} else {
				throw new IllegalArgumentException("Give me an actual question number!");
			}

		}
	}

	public void createTrueFalseQuestion(int i) {
		boolean correctAnswer;
		System.out.println("What is the true-false statement which you wish to make: \n");
		query = scan.nextLine();
		System.out.println("How many points would you like your question to be: ");

		this.pointValue = scan.nextInt();
		if (this.pointValue < 0) {
			throw new IllegalArgumentException("Question cannot be worth negative points");
		}
		scan.nextLine();
		System.out.println("What is the correct answer to your question (true or false): ");

		correctAnswer = scan.nextBoolean();

		// I assign the current index of questions[] to a new question of type TrueFalse
		questions[i] = new TrueFalseQuestion(query, correctAnswer);
		// I set the point value
		questions[i].setPointValue(this.pointValue);
	}

	public void createMultipleChoiceQuestion(int i) {
		System.out.println("What is the multiple-choice question which you wish to ask: \n");
		query = scan.nextLine();
		System.out.println("How many points would you like your question to be: ");

		this.pointValue = scan.nextInt();
		if (this.pointValue < 0) {
			throw new IllegalArgumentException("Question cannot be worth negative points");
		}
		System.out.println("How many answer choices do you want to provide: ");
		String[] answerChoices = new String[scan.nextInt()];
		// I create a new answerChoices array that holds the answer choices. When the
		// user references an answer choice, they begin indexing with 1, so I just use
		// (increment - 1) to determine the index of the answer choice which they are
		// referring to
		for (int j = 0; j < answerChoices.length; j++) {
			System.out.println("What is your number " + (j + 1) + " answer choice: ");
			if (j == 0)
				scan.nextLine();
			answerChoices[j] = scan.nextLine();

			// scan.nextLine();
		}
		System.out.println("What is the number of the correct answer: ");
		int correctAnswer = scan.nextInt() - 1;
		questions[i] = new MultipleChoiceQuestion(query, correctAnswer, answerChoices);
		questions[i].setPointValue(this.pointValue);
	}

	public void createShortAnswerQuestion(int i) {
		// Long and short answer are the same except for the word limit and threshold
		System.out.println("What is the short answer question (maximum of 500 words) that you wish to ask: \n");
		query = scan.nextLine();
		System.out.println("How many points would you like your question to be: ");

		this.pointValue = scan.nextInt();
		if (this.pointValue < 0) {
			throw new IllegalArgumentException("Question cannot be worth negative points");
		}
		questions[i] = new ShortAnswerQuestion(query);
		questions[i].setPointValue(pointValue);
	}

	public void createLongAnswerQuestion(int i) {
		System.out.println("What is the long answer questions (minimum of 500 words) that you wish to ask: \n");
		query = scan.nextLine();
		System.out.println("How many points would you like your question to be: ");

		this.pointValue = scan.nextInt();
		if (this.pointValue < 0) {
			throw new IllegalArgumentException("Question cannot be worth negative points");
		}
		questions[i] = new LongAnswerQuestion(query);
		questions[i].setPointValue(pointValue);
	}

	/*
	 * For this method, just display the question and, if applicable, the choices.
	 * Then collect the user's input and store it. If they are correct, add the
	 * question value to their totalCorrect. Every question, add the question value
	 * to a variable total. Display their (totalCorrect / total) * 100. This just
	 * calls the methods that I have in my Question classes and loops through every
	 * question in the array.
	 */
	public String administerQuiz() {
		// I store the number I get correct and the total, so that I can just get the
		// percentage at the end
		double score = 0;
		double total = 0;
		for (int i = 0; i < numQuestions; i++) {
			questions[i].setUserAnswer();
			score += questions[i].getPointsEarned();
			total += questions[i].getPointValue();
		}
		return "Your score was " + (score / total) * 100 + "%";
	}
}