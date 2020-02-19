
public class WhiteHouse // the meeting place for reporters & speakers
{
	private String presidentsStatement;

	public synchronized void makeAstatement(String presidentsStatement) { // back door
		this.presidentsStatement = presidentsStatement;
		notifyAll();
	}

	public synchronized String attendTheNewsConference(String topicOfInterest) {

		String myTopic = topicOfInterest.toUpperCase();

		while (true) {
			if (this.presidentsStatement.contains(myTopic)) {
				return this.presidentsStatement;
			}
			if (this.presidentsStatement.contains("GOD BLESS AMERICA")) {
				return "My topic '" + topicOfInterest + "' was not covered in today's news conference.";
			}
			try {
				wait();
			} catch (InterruptedException localInterruptedException) {
			}
		}
	}
}