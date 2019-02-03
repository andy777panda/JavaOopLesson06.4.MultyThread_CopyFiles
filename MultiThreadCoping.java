package net.ukr.andy777;

import java.io.File;

public class MultiThreadCoping {

	// метод формування потоків, їх запуску (сортування частин) та отримання результату (складання відсортованих частин)
	static void copy(File folderSource, File folderReceiver, int qThreads) {
		SingleThreadCoping[] threadarray = new SingleThreadCoping[qThreads];
		folderReceiver.mkdirs();
		File[] fileList = folderSource.listFiles();
		// поділ масиву файлів на частини + формування потоків з кожної частини та їх запуск (в конструкторі потоку)
		for (int i = 0; i < threadarray.length; i++) {
			int size = fileList.length / qThreads;
			int begin = size * i;
			int end = ((i + 1) * size);
			if ((fileList.length - end) < size || i == (threadarray.length - 1)) {
				end = fileList.length;
			}
			threadarray[i] = new SingleThreadCoping(folderSource, folderReceiver, fileList, begin, end,i+1);
		}
		// приєднання всіх потоків для одночасного багатопотокового виконання
		for (int i = 0; i < threadarray.length; i++) {
			try {
				threadarray[i].getThr().join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
