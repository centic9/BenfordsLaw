/***************************************************
 * dynaTrace Diagnostics (c) dynaTrace software GmbH
 *
 * @file: BenfordsLawFileSystem.java
 * @date: 06.08.2011
 * @author: dominik.stadler
 */
package org.dstadler.benford;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.SystemUtils;


/**
 *
 * @author dominik.stadler
 */
public class BenfordsLawFileSystem {

	/**
	 *
	 * @param args
	 * @author dominik.stadler
	 * @throws IOException
	 */
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


		BenfordDirectoryWalker walkter = new BenfordDirectoryWalker();
		walkter.start(start);
	}

}
