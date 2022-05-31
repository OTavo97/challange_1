I5913 - Sistemas Basados en Conocimiento

Mendoza Guzman Octavio
CUCEI | Universidad de Guadalajara

Compilar y Ejecutar
Challenge 1
javac -cp lib\CLIPSJNI.jar src\javaclips.java -d classes\
java -cp lib\CLIPSJNI.jar;classes\ clips.Clips

challenge 2
Compilar y Ejecutar
javac -cp lib/* src/ClipsAgent.java -d classes/
java -cp lib/*;classes/ jade.Boot -gui Octavio:clips.ClipsAgent
