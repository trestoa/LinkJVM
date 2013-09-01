#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]){
	char command[255] = "java /usr/local/LinkJVM/lib/ecj-3.7.jar ";
	int i = 0;
	for(i; i < argc; i++){
		strcpy(command, argv[i]);
	}
	system(command);
}
