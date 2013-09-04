#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]){
	char command[255] = "java -jar /usr/local/LinkJVM/lib/ecj-3.7.jar ";
	int i = 1;
	for(i; i < argc; i++){
		strcat(command, argv[i]);
		strcat(command, " ");
	}
	return system(command);
}
