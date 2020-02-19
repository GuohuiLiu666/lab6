public class StartTheNewsConference {
	public static void main(String[] args) {
		System.out.println("This program loads the NewsConference, the President, and multiple Reporter(s)");
		if (args.length == 0) {
			System.out.println("Enter a command line parameter which identifies each Reporter's topic of interest.");
			return;
		}

		WhiteHouse whiteHouse = new WhiteHouse();
		whiteHouse.makeAstatement("state");

		for (String topicOfInterest : args) {

			Reporter reporter = new Reporter(whiteHouse, topicOfInterest);
			System.out.println("Reporter " + " will cover " + topicOfInterest);
		}

		President president = new President(whiteHouse);
	}
}