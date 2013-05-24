Assumptions, Trade off, Design Choices

Assumptions:
This application does not need to be performance tuned.  I use a List of Integers
internally store the data.  That is just a convenience so I do not have to manage
arrays while computing the information.  If performance is an issue, I could easily
convert to an array while computing the values.

Design Choices:
I split this application up into three parts.
Part A the input is the file reader.
Part B the calculation is the Math Service.
Part C the glue code is the Main to bring both portions together.

Part A:
 I made a simple file reader to read the input files into the system.
 There is a potential performance issue if the file size becomes to
 large, I would guess about a couple hundred megabytes, but for smaller
 file sizes this should work just fine.

Part B:
 I would not normally make an entire service interface for calculating
 the statics you requested, but I did for two reasons.  First, it has
 been a while since I have done Medium, and Standard Deviation, so I was
 not sure I was calculating them correctly.  This allowed me to setup
 a test with some values to make sure everything was correct.  Second,
 since the whole point of the exercise is to compute those values, it
 seems like those values were important, and so the algorithm used to
 calculate them might change.

Part C:
 The glue code just the code that links the two portions together.
