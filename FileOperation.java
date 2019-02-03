package net.ukr.andy777;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {
	public static void fileCopy(File in, File out) throws IOException {
		byte[] bufer = new byte[1024];
		int readByte = 0;

		// jdk1.7
		// try (FileInputStream fis = new FileInputStream(in);
		// FileOutputStream fos = new FileOutputStream(out)) {
		// for (; (readByte = fis.read(bufer)) > 0;) {
		// fos.write(bufer, 0, readByte);
		// }
		// } catch (IOException e) {
		// throw e;
		// }

		// jdk1.6
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(in);
			fos = new FileOutputStream(out);

			for (; (readByte = fis.read(bufer)) > 0;) {
				fos.write(bufer, 0, readByte);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				System.out.println("Error close file" + in.getName());
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println("Error close file" + out.getName());
			}
		}

	}
}