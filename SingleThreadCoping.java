package net.ukr.andy777;

import java.io.File;
import java.io.IOException;

public class SingleThreadCoping implements Runnable {
	private File folderSource;
	private File folderReceiver;
	private File[] fileList;
	private int begin;
	private int end;
	private int noThread;
	private Thread thr;

	// thread constructor = конструктор потоку
	public SingleThreadCoping(File folderSource, File folderReceiver, File[] fileList, int begin, int end, int noThread) {
		super();
		this.folderSource = folderSource;
		this.folderReceiver = folderReceiver;
		this.fileList = fileList;
		this.begin = begin;
		this.end = end;
		this.noThread = noThread;
		thr = new Thread(this); // ініціалізація потоку
		thr.start(); // запуск потоку
	}

	public Thread getThr() {
		return thr;
	}

	@Override
	public void run() {// реалізація інтерфейсу Runnable для багатопотоковості
		for (int i = begin; i < end - 1; i++) {
			File in = fileList[i];
			try {
				File out = new File(folderReceiver.getPath() + "\\" + in.getName());
				FileOperation.fileCopy(in, out);
//				System.out.println("- file - " + in.getName() + " - copied by thread "+noThread);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
