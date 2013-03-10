Bowling
=======

Ten-Pin Bowling score tracker.

I chose to develop this in java which in hindsight was probably a poor choice.
* command line input and output are relatively cumbersome
* unix executables are not that easy to produce

I found that the 64bit executable I make using ./make (in a 64-bit Ubuntu 12.04) would not execute inside a 32-bit Fedora VM (which I happenned to have lying around).
For this reason I duplicated make with make32. The only difference is the name of the output file - it's up to the user to actually run it on a 32-bit environment.

I tried to be test driven but unfortunately the complexities of Bowling scoring caused me to change my design slightly part way through development.
I didn't keep my tests up to date with this. Bad me!
