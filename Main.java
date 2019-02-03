package net.ukr.andy777;

/*
Lesson06.4
Реализуйте многопоточное копирование каталога, содержащего несколько файлов. 
*/

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File folderSource = new File(".\\1");
		File folderReceiver = new File(".\\2");

		// запуск кількох циклів копіювання різною кількістю threads-потоків
		for (int qThreads = 1; qThreads <= 10; qThreads++)
			resMultiThreadCopyFiles(folderSource, folderReceiver, qThreads);
	}

	// метод запуску сортування заданим method-методом та заданою кількістю threads-потоків array-массиву + підрахунок
	// часу виконання
	public static void resMultiThreadCopyFiles(File folderSource, File folderReceiver, int qThreads) {
		long tstart = System.currentTimeMillis();
		MultiThreadCoping.copy(folderSource, folderReceiver, qThreads);
		long tend = System.currentTimeMillis();
		System.out.println((tend - tstart) + " ms" + " = " + qThreads + "-thread coping");
	}
}
