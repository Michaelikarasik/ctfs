#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <stdio.h>

int main(){
	static struct random_data rdata;
	rdata.state = NULL;
	static char state[32];

        initstate_r (1584550015, state, sizeof (state), &rdata);

	char string[] = "tcomci0_fndr4nc2fcdi}r81a5a5of_ialf6toada49_e1b{";
	int len = strlen (string);

	int idxOne[len];
	int idxTwo[len];

	for (int i = 0; i < len - 1; ++i){
                int j;
	        random_r (&rdata, &j);

		j = j % (len - i) + i;
		
		idxTwo[i] = j;

		printf("%d\n", j);
	}
}
