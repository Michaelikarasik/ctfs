#include <stdlib.h>
#include <stdio.h>

int main(){
	printf("[");
	for(int i = 0; i <= 10067; i++){
		srand(i);
		int x = rand();
		printf("%d, ", x);
	}
	printf("]");
}
