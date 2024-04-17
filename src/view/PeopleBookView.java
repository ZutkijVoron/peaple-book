package src.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PeopleBookView {
	private Scanner sc = new Scanner(System.in);

	public void start() {
		System.out.println(
				"Приветствую вы используете программу для работы с книгой, в которую вы можете добавлять людей.\n\r");
	}

	public int menu() throws Exception {
		System.out.println("Что вы хотите сделать?");
		System.out.println("1 - Добавить нового человека");
		System.out.println("2 - Просмотреть список людей");
		System.out.println("0 - Выход");
		try {
			int choice = sc.nextInt();
			sc.nextLine();
			return choice;
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw new InputMismatchException("Ввести вы должны были целое число......");
		} catch (Exception e) {
			sc.nextLine();
			throw new Exception("Непредвиденная ошибка......");
		}
	}

	public String add() {
		System.out.println("Добавление нового человека.");
		System.out.println("Внесите данные о человеке.");
		System.out
				.println(
						"ФИО(Фамилия Имя Отчество) дату_рождения(dd.mm.yyyy) номер_телефона(целое беззнаковое число) пол(m/f)");
		System.out.println("Например: Иванов Иван Иванович 01.01.2000 1234567 m");
		System.out.println("Или: 01.01.2000 Иванов Иван Иванович  m 1234567");
		return sc.nextLine();
	}

	public void list(StringBuilder sb) {
		System.out.println("Список людей.");
		System.out.println(
				"ФИО(Фамилия Имя Отчество) дату_рождения(dd.mm.yyyy) номер_телефона(целое беззнаковое число) пол(m/f)");
		System.out.println(sb.toString());
	}

	public void end() {
		System.out.println("Программа завершена.");
		sc.close();
	}
}
