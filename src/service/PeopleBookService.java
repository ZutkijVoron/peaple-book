package src.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.text.SimpleDateFormat;

import java.util.Scanner;
import java.util.Date;

import src.model.People;

public class PeopleBookService {
	public People parserData(String dataString) throws Exception {
		String[] arr = dataString.split(" ");
		if (arr.length != 6) {
			if (arr.length > 6) {
				throw new Exception("Вы ввели слишком много информации");
			}
			throw new Exception("Вы ввели слишком мало информации");
		}
		String surname = "";
		String firstName = "";
		String patronymic = "";
		Date birthDate = null;
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		int phone = 0;
		char gender = 'c';
		for (String string : arr) {
			try {
				if (phone == 0 && !string.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
					phone = Integer.parseInt(string);
					continue;
				}
			} catch (Exception e) {
			}
			try {
				if (gender == 'c' && string.length() == 1) {
					if (string.charAt(0) == 'm') {
						gender = 'm';
						continue;
					} else if (string.charAt(0) == 'f') {
						gender = 'f';
						continue;
					}
				}
			} catch (Exception e) {
			}
			if (birthDate == null && string.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
				birthDate = format.parse(string);
				continue;
			}
			if (surname == "") {
				surname = string;
				continue;
			}
			if (firstName == "") {
				firstName = string;
				continue;
			}
			if (patronymic == "") {
				patronymic = string;
				continue;
			}
		}
		if (surname == "" || patronymic == "" || firstName == "" || birthDate == null || phone == 0
				|| gender == 'c') {
			throw new Exception("Вы скорее всего ввели повторяющиеся данные");
		}
		return new People(surname, firstName, patronymic, birthDate, phone, gender);

	}

	public StringBuilder list() throws Exception {
		try {
			File folder = new File("data");
			if (folder.exists() && folder.isDirectory()) {
				File[] files = folder.listFiles();
				StringBuilder sb = new StringBuilder();
				if (files.length != 0) {
					for (File file : files) {
						if (file.isFile()) {
							sb.append("\n\rСодержимое файла " + file.getName() + ":\n\r");
							try (Scanner scanner = new Scanner(file)) {
								while (scanner.hasNextLine()) {
									String line = scanner.nextLine();
									sb.append(line + "\n\r");
								}
							} catch (FileNotFoundException e) {
								sb.append("Файл не найден: " + file.getAbsolutePath() + "\n\r");
							}
						}
					}
					return sb;
				} else {
					throw new Exception("В папке 'data' нет файлов.");
				}
			} else {
				throw new Exception("Папка 'data' не существует или не является директорией.");
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void add(String people) throws Exception {
		File folder = new File("data");
		if (!folder.exists() || !folder.isDirectory()) {
			folder.mkdir();
		}
		File[] files = folder.listFiles();
		People p;
		try {
			p = parserData(people);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		for (File file : files) {
			if (file.getName().equalsIgnoreCase(p.getSurname())) {
				try (FileWriter fw = new FileWriter(file, true)) {
					fw.append("\n\r" + p.toString());
				} catch (Exception e) {
					throw new Exception("Почему-то не удалось записать файл.....");
				}
				return;
			}
		}
		File f = new File(folder.getPath() + "/" + p.getSurname() + ".txt");
		try (FileWriter fw = new FileWriter(f)) {
			fw.append(p.toString());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
