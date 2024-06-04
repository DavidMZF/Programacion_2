## Getting Started

_+_
    |_-_
        |_+_
            |_-_
                |_+_
                    |

|_
  |__
     |___
         |____


123456789
12345678
1234567
123456
12345
1234
123
12
1

                  1
                1   1
              1   2   1
            1   3   3   1
          1   4   6   4   1                     + 6 + 10 + 15 + 21 + 
        1   5   10   10   5   1
      1   6   15   20   15   6   1
    1   7   21   35   35   21   7   1
  1   8   28   56   70   56   28   8   1
1   9   36   84   126   126   84   36   9   1


          1
        1   
      1   2   
    1   3   3   
  1   4   6   4   
1   5   10   10   5   

conclusion (nivelx2 - 2) Espaciado

+               +
    -       -
        +
    -       -
+               +
    -       -
        +

public void mfF18(int mfNivel){

        int mfNumero;
        int mfAux = -1;
        System.out.println("Figura 18: ");
        
        for (int i = 0; i < mfNivel; i++) {
            
            mfNumero = 1;            
            for (int j = 0; j <= i; j++) {
                if (j == i - 1){
                    mfNumero = mfAux;
                }
                System.out.print(j == i ? "2   " : mfNumero + "   ");
                mfNumero = mfNumero * (i - j) / (j + 1);
            }
            mfAux = mfAux + 2;
            System.out.println("");
        }
        System.out.println("");
    }