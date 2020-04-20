#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	int x = time(NULL);
	printf("%d\n", x);
}
