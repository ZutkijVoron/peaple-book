package src.view;

import java.io.File;
import java.io.FileNotFoundException;
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

	public void list() {
		System.out.println("Список людей.");
		System.out.println(
				"ФИО(Фамилия Имя Отчество) дату_рождения(dd.mm.yyyy) номер_телефона(целое беззнаковое число) пол(m/f)");
		try {
			File folder = new File("src\\data");
			if (folder.exists() && folder.isDirectory()) {
				File[] files = folder.listFiles();

				if (files != null) {
					for (File file : files) {
						if (file.isFile()) {
							System.out.println("Содержимое файла " + file.getName() + ":");

							try (Scanner scanner = new Scanner(file)) {
								while (scanner.hasNextLine()) {
									String line = scanner.nextLine();
									// Обработать строку с данными о человеке
									System.out.println(line);
								}
							} catch (FileNotFoundException e) {
								System.err.println("Файл не найден: " + file.getAbsolutePath());
							}
						}
					}
				} else {
					System.out.println("В папке 'data' нет файлов.");
				}
			} else {
				System.err.println("Папка 'data' не существует или не является директорией.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void end() {
		System.out.println("Программа завершена.");
		sc.close();
	}
}
