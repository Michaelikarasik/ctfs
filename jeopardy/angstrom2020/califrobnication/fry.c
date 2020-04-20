#include <stdio.h>
#include <string.h>

int main(){
	char* flag = "024mr89cdf6_dade45af1o";
	for(int i =0; i < 30; i++){
		strfry(&flag);
		printf("%s\n", flag);
	}
}
