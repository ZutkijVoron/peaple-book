package src;

import src.controller.PeopleBookController;

/**
 * Main
 */
public class Main {
	public static void main(String[] args) {
		PeopleBookController peopleBookController = new PeopleBookController();
		peopleBookController.start();
	}
}
