#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]){
	char command[255] = "/usr/local/LinkJVM/lib/javac/java -jar ecj-3.7.jar ";
	int i = 1;
	for(i; i < argc; i++){
		strcat(command, argv[i]);
	}
	system(command);
}
