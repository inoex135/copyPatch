copyPatch
=========

copyPatch is a small java console application to help developer copy patch files. For example in your source code, you need to patch folder1/a.txt, folder2/b.txt etc, you need one by one to copy them. Using this small application, list your patch file in a text file then running this application. Your patch files will be copied to a patch folder.

How to Compile
==============
To compile this source code, just run from this project folder : 

javac src/Main.java

It will create src/Main.class

How to Run
==========
Create a input.txt(or other names) in your source code folder that contains patch files. copy src/Main.class to your source code folder and run it.

java Main input.txt

Your patch files should be copied into patch/** folder.

Happy Coding !!!
