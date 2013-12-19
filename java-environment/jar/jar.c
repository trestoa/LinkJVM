#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]){
	char command[2048] = "java gnu.classpath.tools.jar.Main ";
	int i = 1;
	for(i; i < argc; i++){
		strcat(command, argv[i]);
		strcat(command, " ");
	}
	return system(command);
}
