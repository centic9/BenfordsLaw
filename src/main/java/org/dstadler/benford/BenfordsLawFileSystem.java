package org.dstadler.benford;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;

/**
 * Small application which demonstrates Benford's law
 * by looking at file sizes in a given directory (or
 * in the whole filesystem if none is given)
 */
public class BenfordsLawFileSystem {
	public static void main(String[] args) throws IOException {
		final File start;
		if(args.length == 0) {
			if(SystemUtils.IS_OS_WINDOWS) {
				start = new File("C:\\");
			} else {
				start = new File("/");
			}
		} else {
			start = new File(args[0]);
		}

		new BenfordDirectoryWalker().start(start);
	}
}
