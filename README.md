# Crypt
***
***

A command line encryption and decryption application with multiple algorithms.

***
***

Use:

git clone git@github.com:lukejm/Crypt.git

gradle build

gradle run -args="see bellow"

***
Argument types:

"-in" -> input file name (defaults to console output if not 
included).

"-data" -> text from console if not using a file (defaults to console if 
"-in" and "-data" are not included).

"-key" -> encryption / decryption key (defaults to empty key
if not provided).

"-out" -> output file name (defaults to standard
out if no file is included).

"-mode" -> "enc" for encryption, "dec" for decryption (defaults to "enc").

"-alg" -> see bellow for algorithm options more to be added (defaults 
to shift algorithm)

***
***
***

Current algorithms (pass type into "-arg").

***

"shift" -> basic: shift alphanumeric characters to right for encryption by key amount and left
for decryption by the key value. Characters circle, 'z' becomes 'a'. A key of 26 (number of alphanumeric 
characters) will make no change. 

"unicode" -> basic: shift all characters to the right for encryption by key amount and left for 
decryption by the key value. Characters do not circle.

***

More algorithms to be added.

***
***
***
This software was built with test driven development and currently test coverage is at > 95%.


