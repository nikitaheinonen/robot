


#include <stdio.h>
#include <math.h>
#include <stdlib.h>

#define COLUMNS 6

int side_effect = 0;



void print_number(int z){
  if(side_effect > COLUMNS){
    printf("\n");
    side_effect = 0;
  }
  printf("%10d", z );
  side_effect++;
}

void print_sieves(int n){
  int primes[n];
  //fill the list with "true" on every position
  //using index 2->n
  for(int i = 2; i <= n; i++){
    primes[i] = 1;
  }
  for(int i = 2; i <= (int)sqrt(n); i++){
    if(primes[i]){
      for(int j = i*i; j <= n; j += i){
        primes[j] = 0;
      }
    }
  }
  for(int i = 2; i < n + 1; i++){
    if(primes[i]){
      print_number(i);
    }
  }
  printf("\n");
}
// 'argc' contains the number of program arguments, and
// 'argv' is an array of char pointers, where each
// char pointer points to a null-terminated string.
int main(int argc, char *argv[]){
  if(argc == 2)
    print_sieves(atoi(argv[1]));
  else
    printf("Please state an interger number.\n");
  return 0;
}
