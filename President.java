import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class President implements Runnable {
	WhiteHouse whiteHouse;

	public President(WhiteHouse whiteHouse) {
		this.whiteHouse = whiteHouse; //copy local var from stack to program var
		new Thread(this).start();
	}

	public void run() {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String newLine = System.lineSeparator();
		System.out.println("The news conference has started! Please enter a statement." + 
		         newLine + "The phrase 'God bless America' will end the news conference");
		

		while(true) {
			try {
				String statement;
				do {
					statement = keyboard.readLine().toUpperCase();
					this.whiteHouse.makeAstatement(statement);
				} while (!statement.contains("GOD BLESS AMERICA"));
				System.out.println("The News Conference is over.");
				return;
			} catch (IOException ioe) {
				System.out.println("There was an error.");
			}
		}
	}
}
