Assumptions, Trade off, Design Choices

Assumptions:
This application is not performance tuned.  I use a List of Integers
internally store the data.  That is just a convenience so I do not have to manage
arrays while computing the information.  If performance is an issue, I could easily
convert to an array while computing the values.

If the value in the configuration file is empty I ignore the line and
continue on.  This is designed to avoid a common problem like empty lines
in the front of the file.

If the value is invalid I halt all processing, but as part of the error
message I include a line number so if there is a problem it is easy to go in
and fix the text file.  This is a better practice then simply ignoring the problem
and getting bad results, or just failing with no reference.

Trade offs
Data accuracy verses performance.  In this case using doubles will not be
as exact as using something like BigInteger, or Big Decimal the key would
be if the accuracy is needed.

Design Choices:
Part A: (read)
 I made a simple file reader to read the input files into the system.
 There is a potential performance issue if the file size becomes to
 large, I would guess about a couple hundred megabytes, but for smaller
 file sizes this should work just fine.

Part B: (calculate)
 I made this a function so that I could more easily test my results,
 without needing to hit the file system.

Part C: (write)
 I made the write function so that the methods would all be about the
 level of abstraction.

