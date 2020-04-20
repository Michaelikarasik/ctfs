#include <unistd.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

const char* users[3] = {"TrueGrit", "root", "guest"};
#define users_len (sizeof (users) / sizeof (const char *))
#define TRUEGRIT 0
#define ROOT 1
#define GUEST 2
long sessionID[users_len];

int main()
{
    time_t curtime;
    struct tm * timeinfo;
    time(&curtime);
    srand(curtime);
    for(int i = 0; i < users_len; i++){
        sessionID[i] = (rand() ^ rand());
    }
	
	printf("%ld", sessionID[0]);
}