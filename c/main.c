#include<stdio.h>
#include<stdlib.h>

void dijkstra_Algorithm(){
    
}

int main(int argc, char** argv){ 
  if(argc < 2) { //checks if there are 2 arguments!
    fprintf(stderr,"./main {text file}"); //prints messages to stderr. Primarily for error messages
    exit(1); //exits the program with a return code 1.
  }

  FILE* file = fopen(argv[1],"r"); //this will open a file specified by the user.

  if(file == NULL){ //if fopen fails to open the file, it returns NULL
    fprintf(stderr,"%s failed to open",argv[1]);
    exit(1); //exits your program
  }

  int num; 
  if(fscanf(file,"%d", &num) == 1){
    //do something
  }
  return 0;
}