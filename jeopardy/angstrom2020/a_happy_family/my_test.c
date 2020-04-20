#define _GNU_SOURCE

// you can always use a couple of headers
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
#include <math.h>

#define ulo unsigned long long
#define CHARS 62
#define PS 32
#define BS 128
#define FLAGSIZE 128
#define BASE 13
#define BL 18
char fifpath[64] = "/tmp/fam-";
FILE *fif;
int fval;

char randchars[CHARS + 1] =
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	  
char basechars[BASE + 1] = "angstromctf20";
char onebase[BASE+1] = "angstromcxf20";
char otherbase[BASE+1] = "angsxromctf20";
char mychars[BASE+1] =     "0123456789abc";

// this is the flag for the pwn challenge
void print_flag() {
    gid_t gid = getegid();
    setresgid(gid, gid, gid);
    FILE *file = fopen("flag.txt", "r");
    char flag[FLAGSIZE];
    if (file == NULL) {
        printf("Cannot read flag file.\n");
        exit(1);
    }
    fgets(flag, FLAGSIZE, file);
    printf("%s", flag);
}

void tobase(ulo n, char *ret) {
    ret[BL] = 0; // 18
    for (int i = BL - 1; i >= 0; --i) {
        ret[i] = basechars[n % BASE];
        n /= BASE;
    }
}
	
/*ulo reverse(char *ret){
	ulo num = 0;
	char c1[BL + 1]; // 19
	for(int i = 0; i < 18; ++i){
		double nextdo = pow(13, i);
		ulo nextint = nextdo;
		ulo nextpos = (strchr(onebase, ret[17 - i]) - onebase);
		ulo position = nextpos * nextint;
		num += position;
		tobase(num, c1);
	}
	return num;
}

ulo otherreverse(char *ret){
	ulo num = 0;
	char c1[BL + 1]; // 19
	for(int i = 0; i < 18; ++i){
		ulo nextint = pow(13, i);
		ulo nextpos = (strchr(otherbase, ret[17 - i]) - otherbase);
		ulo position = nextpos * nextint;
		num += position;
	}
	return num;
}*/

int main() {
	char c1[BL + 1]; // 19
	char fhalf[17] = "getprn_1";
	ulo n1 = *(ulo *)fhalf;
	tobase(n1, c1);
	printf("%s\n", c1);
	printf("%s\n", "artomtf2srn00tgm2f");
}