package src.controller;

import src.service.PeopleBookService;
import src.view.PeopleBookView;

public class PeopleBookController {
	private PeopleBookService peopleBookService = new PeopleBookService();
	private PeopleBookView peopleBookView = new PeopleBookView();

	public void start() {
		peopleBookView.start();
		while (true) {
			try {
				switch (peopleBookView.menu()) {
					case 1:
						peopleBookView.add();
						break;
					case 2:
						peopleBookView.list();
						break;
					case 0:
						peopleBookView.end();
						return;
					default:
						System.out.println("Вы ввели число не соответствующее меню");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
