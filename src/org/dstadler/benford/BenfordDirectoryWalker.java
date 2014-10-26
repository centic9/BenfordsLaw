/***************************************************
 * dynaTrace Diagnostics (c) dynaTrace software GmbH
 *
 * @file: BenfordDirectoryWalker.java
 * @date: 06.08.2011
 * @author: dominik.stadler
 */
package org.dstadler.benford;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.io.DirectoryWalker;


/**
 *
 * @author dominik.stadler
 */
public class BenfordDirectoryWalker extends DirectoryWalker<AtomicLong> {
	int count = 0;

    public List<AtomicLong> start(File startDirectory) throws IOException {
      List<AtomicLong> results = new ArrayList<>();
      for(int i = 0;i < 10;i++) {
    	  results.add(new AtomicLong(0l));
      }

      walk(startDirectory, results);

      return results;
    }

    @Override
	protected void handleFile(File file, int depth, Collection<AtomicLong> results) {
    	long length = file.length();
    	int index = Integer.parseInt(Long.toString(length).substring(0, 1));

    	((List<AtomicLong>)results).get(index).incrementAndGet();

    	count++;

    	if(count%1000 == 0) {
    		long sum = 0;
    		for(AtomicLong i : results) {
    			sum += i.get();
    		}
    		System.out.println("Distribution (" + count + "/" + sum + "): " + results + " - " + file);
    	}
    }
  }
