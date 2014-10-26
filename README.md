BenfordsLaw
===========

Sample application showing [Benford's Law](https://en.wikipedia.org/wiki/Benford%27s_law) by looking at file sizes of
files found on the local disk.

It may initially show a different distribution, but when looking at many files it usually will converge to the default
distribution suggested by Benford unless the file sizes are not randomly spread, i.e. if large numbers of equally sized 
files are stored.

## Getting started

#### Build it and create the distribution files

	./gradlew install

#### Run it

    build/install/BenfordsLaw/bin/BenfordsLaw

It will start to fetch sizes of files on your local disk and print out the current count of sizes starting with the 
numbers from 0 to 9 (0 is only used for 0-sized files).

You can also pass in the start-directory as commandline argument.

#### Change it

Create matching Eclipse project files

	./gradlew eclipse

#### Licensing

* BenfordsLaw is licensed under the [MIT License].
