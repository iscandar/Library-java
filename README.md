# Library-java
I did this library to help input data for the primitive variables in Java. I hope you find it useful, if you have any idea please send me an email, I'd be happy to read them.


Library butler created by Alejandro ONTIVERO student Computer Engineering (computer systems) Sapienza 10/01/2015.
This small library has been made to help the insertion of data for the primitive variables of java.
To import it:

import butler.Lettore;

Inside you will find the following functions:
Lettore.in.leggiInt (); // read an integer, if not entered an integer return 0.
Lettore.in.leggiString (); // read a string, or one word with no spaces in it.
Lettore.in.leggiChar (); // read a single caracter. end of line characters are ignored.
Lettore.in.leggiLong (); // Read an integer (the spaces are considered late), the numeral must be expressed in base 10, and can start with a negative sign.
Lettore.in.leggiShort (); //
Lettore.in.leggiFloat (); //
Lettore.in.leggiDouble (); //
Lettore.in.leggiBoolean (); // returns false if what you typed is not a boolean.
Lettore.in.leggiLine (); // read a line of text.
eof (); // check on order flow data and returns a boolean.
eoln (); // check if you got to the end of the line.
