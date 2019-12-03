import java.util.Scanner;

public class TeacherTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Welcome to this super dope quiz maker. Please enter the number of questions you would like to have on your quiz (maximum of 5 questions): ");
		int numQuestions = scan.nextInt();
		Quiz q = new Quiz(numQuestions);
		System.out.println(q.administerQuiz());
	}
}
