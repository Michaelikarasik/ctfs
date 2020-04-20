#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <time.h>

#define ORGTIME 1586541672

int pseudocode(){
	FILE* outFile = fopen("myout.txt", "w");
	int curTime = time(0);
	srand(curTime);
	FILE* flag = fopen("flag.txt", "r");
	
	int nextWrite;
	int nextCh;
	
	while(1)
	{
		nextCh = fgetc(flag);
		if(nextCh == -1){
			break;
		}
		nextWrite = ((signed int)rand() % 1638 + 1) ^ nextCh;
		putc(nextWrite, outFile);
	}
	
	fclose(flag);
	fclose(outFile);
}

int reverse(int orgtime){
	FILE* originalout = fopen("originalout.txt", "r");
	FILE* original = fopen("originalflag.txt", "w");
	
	srand(orgtime);
	
	int nextCh;
	int nextWrite;
	
	while(1)
	{
		nextCh = fgetc(originalout);
		if(nextCh == -1){
			break;
		}
		nextWrite = ((signed int)rand() % 1638 + 1) ^ nextCh;
		putc(nextWrite, original);
	}
	
	fclose(originalout);
	fclose(original);
}

int main(){
	reverse(ORGTIME);
}