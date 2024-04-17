package src.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import src.model.People;

public class PeopleBookService {
	public People parserData(String dataString) {
		return null;
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
			return;
		}
		File[] files = folder.listFiles();
		People p = parserData(people);
		for (File file : files) {
			if (file.getName() == p.getLastName()) {
				try (FileWriter fw = new FileWriter(file)) {
					fw.append(p.toString());
				} catch (Exception e) {
					throw new Exception("Почему-то не удалось записать файл.....");
				}
				return;
			}
		}
		File f = new File(folder.getPath() + p.getLastName());
		try (FileWriter fw = new FileWriter(f)) {
			fw.append(p.toString());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
