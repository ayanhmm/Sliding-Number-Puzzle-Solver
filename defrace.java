import java.util.*;
import javax.security.auth.x500.X500Principal;
import java.io.*;
import java.net.PortUnreachableException;
import java.rmi.StubNotFoundException;
import java.util.Locale.IsoCountryCode;
import javax.sound.midi.Soundbank;
import java.util.HashSet; 

public class defrace {
public static int[][] function(int[][] jumbled, int value, int rowsize, int columnsize, int mtterm) {
        int reqrow = value/10; int reqcolumn = value % 10; 
        if (value != 43) {if(value%10 == columnsize-4){reqcolumn = columnsize-3; reqrow = (value/10) ; }    
                           if(value%10 == columnsize-3){reqcolumn = columnsize-3; reqrow = (value/10) + 1; } 
                           if(value/10 == rowsize-4){reqcolumn = value%10 +1 ; reqrow = rowsize -3 ; }    
                           if(value/10 == rowsize-3){reqcolumn = value%10 + 2; reqrow = rowsize -3; }      }  
                           if (value == 24){reqrow =2 ; reqcolumn =5;}   if (value == 25){reqrow =3 ; reqcolumn =5;}
                           if (value == 34){reqrow =3 ; reqcolumn =5;}   if (value == 35){reqrow =4 ; reqcolumn =5;}
                           if (value == 42){reqrow =5 ; reqcolumn =2;}   if (value == 52){reqrow =5 ; reqcolumn =3;}                   
        int mtrow = 0;int mtcolumn = 0; for(int i=2;i<rowsize-2;i++){for(int j=1;j<columnsize-1;j++){if (jumbled[i][j] == mtterm){mtrow = i;mtcolumn = j ;}}}
        int currow = 0;int curcolumn = 0;for(int i=2;i<rowsize-2;i++){for(int j=1;j<columnsize-1;j++){if(jumbled[i][j]==value){currow=i;curcolumn=j;}}}
        
        int mtdesrow = 0;        int mtdescolumn = 0;
        if     (currow > reqrow && jumbled[currow-1][curcolumn] > value && jumbled[currow-1][curcolumn] != mtterm){mtdescolumn = curcolumn; mtdesrow = currow-1;}
        else if(currow > reqrow && jumbled[currow-1][curcolumn] < value && jumbled[currow][curcolumn-1] > value && jumbled[currow][curcolumn-1] != mtterm){mtdescolumn = curcolumn - 1; mtdesrow = currow;}
        else if(currow > reqrow && jumbled[currow-1][curcolumn] < value && jumbled[currow][curcolumn+1] > value && jumbled[currow][curcolumn+1] != mtterm){mtdescolumn = curcolumn + 1; mtdesrow = currow;}

        else if(currow < reqrow && jumbled[currow+1][curcolumn] > value && jumbled[currow+1][curcolumn] != mtterm){mtdescolumn = curcolumn; mtdesrow = currow+1;}
        else if(currow < reqrow && jumbled[currow+1][curcolumn] < value && jumbled[currow][curcolumn-1] > value && jumbled[currow][curcolumn-1] != mtterm){mtdescolumn = curcolumn-1; mtdesrow = currow;}
        else if(currow < reqrow && jumbled[currow+1][curcolumn] < value && jumbled[currow][curcolumn+1]> value && jumbled[currow][curcolumn+1] != mtterm){mtdescolumn = curcolumn+1; mtdesrow = currow;}

        else if(currow == reqrow) {
             if(curcolumn > reqcolumn && jumbled[currow][curcolumn-1]> value && jumbled[currow][curcolumn-1] != mtterm){mtdescolumn = curcolumn-1; mtdesrow = currow;}
             else if(curcolumn > reqcolumn && jumbled[currow][curcolumn-1] < value && jumbled[currow-1][curcolumn]> value && jumbled[currow-1][curcolumn] != mtterm){mtdescolumn = curcolumn; mtdesrow = currow-1;}
             else if(curcolumn > reqcolumn && jumbled[currow][curcolumn-1] < value && jumbled[currow+1][curcolumn] > value && jumbled[currow+1][curcolumn] != mtterm){mtdescolumn = curcolumn; mtdesrow = currow+1;}
            
             else if(curcolumn < reqcolumn && jumbled[currow][curcolumn+1] > value && jumbled[currow][curcolumn+1] != mtterm){mtdescolumn=curcolumn+1; mtdesrow = currow;}
             else if(curcolumn < reqcolumn && jumbled[currow][curcolumn+1] < value && jumbled[currow - 1][curcolumn] > value && jumbled[currow-1][curcolumn] != mtterm){mtdescolumn=curcolumn; mtdesrow = currow-1;}
             else if(curcolumn < reqcolumn && jumbled[currow][curcolumn+1] < value && jumbled[currow+1][curcolumn] > value && jumbled[currow+1][curcolumn] != mtterm){mtdescolumn=curcolumn; mtdesrow = currow+1;}}
        else{mtdesrow=mtrow;mtdescolumn=mtdesrow;}

        for(int w = 0; w<40; w++)  {
         if(mtdesrow > mtrow  && jumbled[mtrow + 1][mtcolumn] > value && jumbled[mtrow + 1][mtcolumn]> value) {
           System.out.println("move " + jumbled[mtrow + 1][mtcolumn]); 
           jumbled[mtrow][mtcolumn] = jumbled[mtrow+1][mtcolumn];
           jumbled[mtrow+1][mtcolumn] = mtterm;mtrow=mtrow+1;  }
         else if(mtdesrow < mtrow && jumbled[mtrow-1][mtcolumn] > value && jumbled[mtrow-1][mtcolumn] > value) {
            System.out.println("move " + jumbled[mtrow - 1][mtcolumn]); 
            jumbled[mtrow][mtcolumn] = jumbled[mtrow-1][mtcolumn];
            jumbled[mtrow-1][mtcolumn] = mtterm;mtrow=mtrow-1; 
         }   
         

         else if(mtdescolumn > mtcolumn && jumbled[mtrow][mtcolumn+1] > value && jumbled[mtrow][mtcolumn+1] > value){
            System.out.println("move " + jumbled[mtrow][mtcolumn+1]);
            jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn+1];
            jumbled[mtrow][mtcolumn+1] = mtterm;mtcolumn=mtcolumn+1;  
            for(int i=2 ; i< 6 ; i++){for(int j=2; j<6 ; j++){System.out.print(jumbled[i][j] + " ");}System.out.println(); } 
            }                                    
         else if(mtdescolumn < mtcolumn && jumbled[mtrow][mtcolumn-1] > value  && jumbled[mtrow][mtcolumn-1] > value){
            System.out.println("move " + jumbled[mtrow][mtcolumn-1]);
            jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn-1];
            jumbled[mtrow][mtcolumn-1] = mtterm;mtcolumn=mtcolumn-1;
            }

         else if(mtdesrow < mtrow && jumbled[mtrow-1][mtcolumn] <= value && mtcolumn != 2 &&
                 jumbled[mtrow][mtcolumn-1] > value &&
                 jumbled[mtrow-1][mtcolumn-1] > value &&
                 jumbled[mtrow-2][mtcolumn-1] > value){
          System.out.println("move " + jumbled[mtrow][mtcolumn-1]);
          System.out.println("move " + jumbled[mtrow-1][mtcolumn-1]);
          System.out.println("move " + jumbled[mtrow-2][mtcolumn-1]);
          System.out.println("move " + jumbled[mtrow-2][mtcolumn]);
            
          jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn-1];
          jumbled[mtrow][mtcolumn-1] = jumbled[mtrow-1][mtcolumn-1];
          jumbled[mtrow-1][mtcolumn-1] = jumbled[mtrow-2][mtcolumn-1];
          jumbled[mtrow-2][mtcolumn-1] = jumbled[mtrow-2][mtcolumn];
          jumbled[mtrow-2][mtcolumn] = mtterm; 
          mtdesrow = mtrow;

         }
         else if(mtdesrow < mtrow && jumbled[mtrow-1][mtcolumn] <=value && mtcolumn != 5 &&
                 jumbled[mtrow][mtcolumn+1] > value &&
                 jumbled[mtrow-1][mtcolumn+1] > value &&
                 jumbled[mtrow-2][mtcolumn+1] > value ){
          System.out.println("move " + jumbled[mtrow][mtcolumn+1]);
          System.out.println("move " + jumbled[mtrow-1][mtcolumn+1]);
          System.out.println("move " + jumbled[mtrow-2][mtcolumn+1]);
          System.out.println("move " + jumbled[mtrow-2][mtcolumn]);
               
          jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn+1];
          jumbled[mtrow][mtcolumn+1] = jumbled[mtrow-1][mtcolumn+1];
          jumbled[mtrow-1][mtcolumn+1] = jumbled[mtrow-2][mtcolumn+1];
          jumbled[mtrow-2][mtcolumn+1] = jumbled[mtrow-2][mtcolumn];
          jumbled[mtrow-2][mtcolumn] = mtterm;              
          mtdesrow = mtrow;

         }
         else if(mtdesrow > mtrow && jumbled[mtrow+1][mtcolumn] <= value  && mtcolumn != 2 &&
                 jumbled[mtrow][mtcolumn-1] > value &&
                 jumbled[mtrow+1][mtcolumn-1] > value &&
                 jumbled[mtrow+2][mtcolumn-1] > value ) {
          System.out.println("move " + jumbled[mtrow][mtcolumn-1]);
          System.out.println("move " + jumbled[mtrow+1][mtcolumn-1]);
          System.out.println("move " + jumbled[mtrow+2][mtcolumn-1]);
          System.out.println("move " + jumbled[mtrow+2][mtcolumn]);
            
          
          jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn-1];
          jumbled[mtrow][mtcolumn-1] = jumbled[mtrow+1][mtcolumn-1];
          jumbled[mtrow+1][mtcolumn-1] = jumbled[mtrow+2][mtcolumn-1];
          jumbled[mtrow+2][mtcolumn-1] = jumbled[mtrow+2][mtcolumn];
          jumbled[mtrow+2][mtcolumn] = mtterm;
          mtdesrow = mtrow;

         }
         else if(mtdesrow > mtrow && jumbled[mtrow+1][mtcolumn] <= value  && mtcolumn != 5 &&
                 jumbled[mtrow][mtcolumn+1] > value &&
                 jumbled[mtrow+1][mtcolumn+1] > value &&
                 jumbled[mtrow+2][mtcolumn+1] > value) {
          System.out.println("move " + jumbled[mtrow][mtcolumn+1]);
          System.out.println("move " + jumbled[mtrow+1][mtcolumn+1]);
          System.out.println("move " + jumbled[mtrow+2][mtcolumn+1]);
          System.out.println("move " + jumbled[mtrow+2][mtcolumn]);
            
          
          jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn+1];
          jumbled[mtrow][mtcolumn+1] = jumbled[mtrow+1][mtcolumn+1];
          jumbled[mtrow+1][mtcolumn+1] = jumbled[mtrow+2][mtcolumn+1];
          jumbled[mtrow+2][mtcolumn+1] = jumbled[mtrow+2][mtcolumn];
          jumbled[mtrow+2][mtcolumn] = mtterm;
          mtdesrow = mtrow;

         }

                              
         else if(mtdescolumn < mtcolumn && jumbled[mtrow][mtcolumn - 1] <= value && mtrow != 2 &&
                                    jumbled[mtrow-1][mtcolumn] > value &&
                                    jumbled[mtrow-1][mtcolumn-1] > value &&
                                    jumbled[mtrow-1][mtcolumn-2] > value ){
                                    System.out.println("move " + jumbled[mtrow-1][mtcolumn]);
                                    System.out.println("move " + jumbled[mtrow-1][mtcolumn-1]);
                                    System.out.println("move " + jumbled[mtrow-2][mtcolumn-2]);
                                    System.out.println("move " + jumbled[mtrow][mtcolumn-2]);
                                      
                                    jumbled[mtrow][mtcolumn] = jumbled[mtrow-1][mtcolumn];
                                    jumbled[mtrow-1][mtcolumn] = jumbled[mtrow-1][mtcolumn-1];
                                    jumbled[mtrow-1][mtcolumn-1] = jumbled[mtrow-1][mtcolumn-2];
                                    jumbled[mtrow-1][mtcolumn-2] = jumbled[mtrow][mtcolumn-2];
                                    jumbled[mtrow][mtcolumn-2] = mtterm;
                                    mtdescolumn = mtcolumn;
                                   }
         else if(mtdescolumn < mtcolumn && jumbled[mtrow][mtcolumn - 1] <= value && mtrow != 5 &&
                                    jumbled[mtrow+1][mtcolumn] > value &&
                                    jumbled[mtrow+1][mtcolumn-1] > value &&
                                    jumbled[mtrow+1][mtcolumn-2] > value ){
                                    System.out.println("move " + jumbled[mtrow+1][mtcolumn]);
                                    System.out.println("move " + jumbled[mtrow+1][mtcolumn-1]);
                                    System.out.println("move " + jumbled[mtrow+1][mtcolumn-2]);
                                    System.out.println("move " + jumbled[mtrow][mtcolumn-2]);
                                      
                                    jumbled[mtrow][mtcolumn] = jumbled[mtrow+1][mtcolumn];
                                    jumbled[mtrow+1][mtcolumn] = jumbled[mtrow+1][mtcolumn-1];
                                    jumbled[mtrow+1][mtcolumn-1] = jumbled[mtrow+1][mtcolumn-2];
                                    jumbled[mtrow+1][mtcolumn-2] = jumbled[mtrow][mtcolumn-2];
                                    jumbled[mtrow][mtcolumn-2] = mtterm;
                                    mtdescolumn = mtcolumn;
                                   }
         else if(mtdescolumn > mtcolumn && jumbled[mtrow][mtcolumn + 1] <= value && mtrow != 2 &&
                                    jumbled[mtrow-1][mtcolumn] > value &&
                                    jumbled[mtrow-1][mtcolumn+1]> value &&
                                    jumbled[mtrow-1][mtcolumn+2] > value ){
                                    System.out.println("move " + jumbled[mtrow-1][mtcolumn]);
                                    System.out.println("move " + jumbled[mtrow-1][mtcolumn-1]);
                                    System.out.println("move " + jumbled[mtrow-1][mtcolumn+2]);
                                    System.out.println("move " + jumbled[mtrow][mtcolumn+2]);
                                      
                                    jumbled[mtrow][mtcolumn] = jumbled[mtrow-1][mtcolumn];
                                    jumbled[mtrow-1][mtcolumn] = jumbled[mtrow-1][mtcolumn+1];
                                    jumbled[mtrow-1][mtcolumn+1] = jumbled[mtrow-1][mtcolumn+2];
                                    jumbled[mtrow-1][mtcolumn+2] = jumbled[mtrow][mtcolumn+2];
                                    jumbled[mtrow][mtcolumn+2] = mtterm;
                                    mtdescolumn = mtcolumn;

                                   }                                 
         else if(mtdescolumn > mtcolumn && jumbled[mtrow][mtcolumn + 1] <= value && mtrow != 5 &&
                                    jumbled[mtrow+1][mtcolumn] > value &&
                                    jumbled[mtrow+1][mtcolumn+1] > value &&
                                    jumbled[mtrow+1][mtcolumn+2] > value ){
                                    System.out.println("move " + jumbled[mtrow+1][mtcolumn]);
                                    System.out.println("move " + jumbled[mtrow+1][mtcolumn-1]);
                                    System.out.println("move " + jumbled[mtrow+1][mtcolumn+2]);
                                    System.out.println("move " + jumbled[mtrow][mtcolumn+2]);
                                      
                                    jumbled[mtrow][mtcolumn] = jumbled[mtrow+1][mtcolumn];
                                    jumbled[mtrow+1][mtcolumn] = jumbled[mtrow+1][mtcolumn+1];
                                    jumbled[mtrow+1][mtcolumn+1] = jumbled[mtrow+1][mtcolumn+2];
                                    jumbled[mtrow+1][mtcolumn+2] = jumbled[mtrow][mtcolumn+2];
                                    jumbled[mtrow][mtcolumn+2] = mtterm;
                                    mtdescolumn = mtcolumn;

                                   }   
                                
                            }
                            for(int i=2;i<rowsize-2;i++){for(int j=1;j<columnsize-2;j++){if (jumbled[i][j] == mtterm){mtrow = i;mtcolumn = j ;}}}
                            for(int i=2;i<rowsize-2;i++){for(int j=1;j<columnsize-2;j++){if(jumbled[i][j]==value){currow=i;curcolumn=j;}}}

                                System.out.println("move " + value);
                                int a=currow;int b=curcolumn; 
                                currow = mtrow;  curcolumn = mtcolumn; mtrow = a; mtcolumn = b;
                                jumbled[mtrow][mtcolumn] = mtterm;  jumbled[currow][curcolumn] = value; printfun(jumbled);
    return jumbled;}

public static int[][] moveEmptySpace(int[][] jumbled, int rowsize, int columnsize, int mtterm, int mtdesrow, int mtdescolumn, int value, int alreadyarranged ) {
    int mtrow = 0;int mtcolumn = 0; for(int i=2;i<rowsize-2;i++){for(int j=1;j<columnsize-1;j++){if (jumbled[i][j] == mtterm){mtrow = i;mtcolumn = j ;}}}
    for(int w = 0; w<40; w++)  {
        if(mtdesrow == mtrow && mtdescolumn == mtcolumn){return jumbled;}
        else if(mtdesrow > mtrow  && jumbled[mtrow + 1][mtcolumn] > value && jumbled[mtrow + 1][mtcolumn] != alreadyarranged) {
         System.out.println("move " + jumbled[mtrow + 1][mtcolumn]); 
         jumbled[mtrow][mtcolumn] = jumbled[mtrow+1][mtcolumn];
         jumbled[mtrow+1][mtcolumn] = mtterm;mtrow=mtrow+1;  }
        else if(mtdesrow < mtrow && jumbled[mtrow-1][mtcolumn] > value && jumbled[mtrow-1][mtcolumn] != alreadyarranged) {
          System.out.println("move " + jumbled[mtrow - 1][mtcolumn]); 
          jumbled[mtrow][mtcolumn] = jumbled[mtrow-1][mtcolumn];
          jumbled[mtrow-1][mtcolumn] = mtterm;mtrow=mtrow-1; }

        else if(mtdescolumn > mtcolumn && jumbled[mtrow][mtcolumn+1] > value && jumbled[mtrow][mtcolumn+1] != alreadyarranged){
            System.out.println("move " + jumbled[mtrow][mtcolumn+1]);
            jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn+1];
            jumbled[mtrow][mtcolumn+1] = mtterm;mtcolumn=mtcolumn+1;
            }                                    
        else if(mtdescolumn < mtcolumn && jumbled[mtrow][mtcolumn-1] > value  && jumbled[mtrow][mtcolumn-1] != alreadyarranged){
            System.out.println("move " + jumbled[mtrow][mtcolumn-1]);
            jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn-1];
            jumbled[mtrow][mtcolumn-1] = mtterm;mtcolumn=mtcolumn-1;
            }}return jumbled;}

public static void printfun(int[][] jumbled) {
   System.out.println(); for(int i=2 ; i< 6 ; i++){for(int j=2; j<6 ; j++){System.out.print(jumbled[i][j] + " ");}System.out.println(); } return; }

    public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in); 
        int rowsize = 8; int columnsize =8;
        int jumbled[][] = new int[rowsize][columnsize];
                
         // building border
        for(int i=0 ; i < columnsize ; i++) {jumbled[0][i] = 1;jumbled[1][i] = 1; }                 for(int i=0 ; i < rowsize ; i++) {jumbled[i][0] = 1;jumbled[i][1] = 1; }
        for(int i=0 ; i < columnsize ; i++) {jumbled[rowsize - 1][i] = 1;jumbled[rowsize - 2][i] = 1; }  for(int i=0 ; i < rowsize ; i++) {jumbled[i][columnsize - 1] = 1;jumbled[i][columnsize - 2] = 1; }

         // input puzzle
        System.out.println("input puzzle"); for(int i=2 ; i< rowsize -2  ; i++) { for(int j=2; j<columnsize - 2 ; j++){jumbled[i][j] = sc.nextInt();}} 
        int mtterm = 99 ; int mtrow = 0; int mtcolumn = 0;
//...........................................................................................................................................................................
        if(jumbled[2][2]!=22){for(int i=1 ; i< 10  ; i++) {if(jumbled[2][2] != 22) {function(jumbled, 22, rowsize, columnsize, mtterm);}}printfun(jumbled);}
        if(jumbled[2][3]!=23){for(int i=1 ; i< 10  ; i++) {if(jumbled[2][3] != 23) {function(jumbled, 23, rowsize, columnsize, mtterm);}}printfun(jumbled);}
//22,23 done...............
        if(jumbled[2][4] != 24 || jumbled[2][5] != 25  ) {
        if(jumbled[2][5] != 24){for(int i=1 ; i< 10  ; i++) {if(jumbled[2][5] != 24) {function(jumbled, 24, rowsize, columnsize, mtterm);}}printfun(jumbled);}
        if(jumbled[3][2] != 25){for(int i=1 ; i< 10  ; i++) {if(jumbled[3][5] != 25) {function(jumbled, 25, rowsize, columnsize, mtterm);}}printfun(jumbled);}
        if(jumbled[2][4] != 99) {moveEmptySpace(jumbled, rowsize,  columnsize,  mtterm,  2, 4, 25, 22 );printfun(jumbled);}
         for(int i=2;i<rowsize-2;i++){for(int j=1;j<columnsize-1;j++){if (jumbled[i][j] == mtterm){mtrow = i;mtcolumn = j ;}}}
            System.out.println("move" +jumbled[mtrow][mtcolumn+1]  +" "  + jumbled[mtrow+1][mtcolumn+1] );
            jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn+1]; jumbled[mtrow][mtcolumn+1] = jumbled[mtrow+1][mtcolumn+1]; jumbled[mtrow+1][mtcolumn+1]=99;
            printfun(jumbled); }
//.......24,25 done....................................................................................................................................................................
        if(jumbled[3][2] != 32){for(int i=1 ; i< 10  ; i++) {if(jumbled[3][2] != 32) {function(jumbled, 32, rowsize, columnsize, mtterm);}}printfun(jumbled);}
        if(jumbled[3][3] != 33){for(int i=1 ; i< 10  ; i++) {if(jumbled[3][3] != 33) {function(jumbled, 33, rowsize, columnsize, mtterm);}}printfun(jumbled);}
//32,33 done.................
        if(jumbled[3][4] != 34 || jumbled[3][5] != 35  ){
             if(jumbled[3][5] != 34){for(int i=1 ; i< 10  ; i++) {if(jumbled[3][5] != 34) {function(jumbled, 34, rowsize, columnsize, mtterm);}}printfun(jumbled);}
             if(jumbled[4][5] != 35){for(int i=1 ; i< 10  ; i++) {if(jumbled[4][5] != 35) {function(jumbled, 35, rowsize, columnsize, mtterm);}}printfun(jumbled);}
             if(jumbled[3][4] != 99){moveEmptySpace(jumbled, rowsize,  columnsize,  mtterm,  3, 4, 35, 22 );}
            
             for(int i=2;i<rowsize-2;i++){for(int j=1;j<columnsize-1;j++){if (jumbled[i][j] == mtterm){mtrow = i;mtcolumn = j ;}}}
             System.out.println("move" +jumbled[mtrow][mtcolumn+1]  +" "  + jumbled[mtrow+1][mtcolumn+1] );
             jumbled[mtrow][mtcolumn] = jumbled[mtrow][mtcolumn+1];
             jumbled[mtrow][mtcolumn+1] = jumbled[mtrow+1][mtcolumn+1];
             jumbled[mtrow+1][mtcolumn+1]=99;printfun(jumbled);}
//........34, 35 done ...................................................................................................................................................................
        if(jumbled[5][2] != 42) {for(int i=1 ; i< 10  ; i++) {if(jumbled[5][2] != 42) {function(jumbled, 42, rowsize, columnsize, mtterm);}}printfun(jumbled);}
        if(jumbled[5][3] != 52){
            if(jumbled[4][2] != 99 && jumbled[4][3] != 52){if(jumbled[4][2] != 52 && jumbled[4][3] != 99) {for(int i=1 ; i< 10  ; i++) {if(jumbled[5][3] != 52) 
                {int x =0;   
                    x = jumbled[4][3];
                    jumbled[4][3] = jumbled[4][4];
                    jumbled[4][4] = jumbled[4][5];
                    jumbled[4][5] = jumbled[5][5];
                    jumbled[5][5] = jumbled[5][4];
                    jumbled[5][4] = jumbled[5][3];
                    jumbled[5][3] = x;   System.out.println("rotate from 3,2 to 4,4 "); }}printfun(jumbled);}}
            else { int aa =  42;
                int bb = 52;
                int cc = 99;
                int dd = jumbled[5][3]; // a
                int ee = jumbled[5][4]; // b
                int ff = jumbled[4][4]; // c
                System.out.println("rotate" +dd+"" +aa+""+bb+""+dd );  System.out.println("rotate" +aa+""+ee+""+ff+""+aa );  System.out.println("rotate" +dd+""+bb+""+ee+""+dd);
                System.out.println("rotate" +aa+""+ff+""+dd);  System.out.println("rotate" +ee+""+bb+""+aa);  
                jumbled[5][2]= 52;
                jumbled[4][2] = 42;
                jumbled[5][3] = bb;
                jumbled[5][4] = aa;
                jumbled[4][4] =cc;
                jumbled[4][3] = mtterm; printfun(jumbled);}}
        moveEmptySpace(jumbled, rowsize,  columnsize,  mtterm,  4, 2, 42, 52 );printfun(jumbled);
//arrange 42 and 52.....................
        for(int i=2;i<rowsize-2;i++){for(int j=1;j<columnsize-1;j++){if (jumbled[i][j] == mtterm){mtrow = i;mtcolumn = j ;}}}
        jumbled[mtrow][mtcolumn] = jumbled[mtrow+1][mtcolumn];
        jumbled[mtrow+1][mtcolumn] = jumbled[mtrow+1][mtcolumn+1];
        jumbled[mtrow+1][mtcolumn+1]=99;
        System.out.println("move 42 52");printfun(jumbled);
//......42 , 52 done.................................................................................................................................
           for(int i=1 ; i< 10  ; i++) {
           if(jumbled[4][3] != 53) {          int x =0;   
                x = jumbled[4][3];
                jumbled[4][3] = jumbled[5][3];
                jumbled[5][3] = jumbled[5][4];
                jumbled[5][4] = jumbled[5][5];
                jumbled[5][5] = jumbled[4][5];
                jumbled[4][5] = jumbled[4][4];
                jumbled[4][4] = x; System.out.println("rotate from 3,2 to 4,4 ");}} printfun(jumbled);
//53 arranged at 4,3.................................................................................................................................          
        if(jumbled[2][2] == 22){
            if(jumbled[5][3] == 99 && jumbled[5][4] != 43  ) {        
                         jumbled[5][3] = jumbled[5][4];
                         jumbled[5][4] = mtterm; System.out.println("move " + jumbled[5][4]);
                         for(int i=1 ; i< 10  ; i++) {
                            if(jumbled[4][4] != 43) { int x =0;   
                                 x = jumbled[4][4] ;
                                 jumbled[4][4] = jumbled[4][5];
                                 jumbled[4][5] = jumbled[5][5];
                                 jumbled[5][5] = jumbled[5][4];
                                 jumbled[5][4] = x; System.out.println("rotate 4,4 to 5,5");printfun(jumbled);}}
                                 int x =0;   
                                 x = jumbled[4][3];
                                 jumbled[4][3] = jumbled[5][3];
                                 jumbled[5][3] = jumbled[5][4];
                                 jumbled[5][4] = jumbled[5][5];
                                 jumbled[5][5] = jumbled[4][5];
                                 jumbled[4][5] = jumbled[4][4];
                                 jumbled[4][4] = x;  System.out.println("rotate 3,2 to 4,4");printfun(jumbled);} 

            else if(jumbled[5][3] != 99 && jumbled[5][3] != 43  ){
                for(int i=1 ; i< 10  ; i++) {
                if(jumbled[4][4] != 43) {          int x =0;   
                     x = jumbled[4][4] ;
                     jumbled[4][4] = jumbled[4][5];
                     jumbled[4][5] = jumbled[5][5];
                     jumbled[5][5] = jumbled[5][4];
                     jumbled[5][4] = x; System.out.println("rotate 4,4 to 5,5");printfun(jumbled);}}            

                     int x =0;   
                     x = jumbled[4][3];
                     jumbled[4][3] = jumbled[4][4];
                     jumbled[4][4] = jumbled[4][5];
                     jumbled[4][5] = jumbled[5][5];
                     jumbled[5][5] = jumbled[5][4];
                     jumbled[5][4] = jumbled[5][3];
                     jumbled[5][3] = x;System.out.println("rotate 3,2 to 4,4");printfun(jumbled);} 

            else if(jumbled[5][3] == 99 && jumbled[5][4] == 43  ){  
                        int aa = jumbled[4][3]; // 53
                        int bb = jumbled[5][3]; // 99
                        int cc = jumbled[5][4]; // 43
                        int dd = jumbled[4][4]; // r
                        int ee = jumbled[4][5]; // r'
                        int ff = jumbled[5][5]; // r''
                        System.out.println("rotate" +aa+"" +dd);  System.out.println("rotate" +ee+""+ff+""+cc);  System.out.println("rotate" +ee+""+dd+""+aa+""+ee);
                        System.out.println("rotate" +aa+""+ee+""+dd);  System.out.println("rotate" +aa+""+ee+""+dd);  System.out.println("rotate" +dd+""+ff+""+ee+""+aa+""+cc );  
                         jumbled[5][3] =aa; // 53
                         jumbled[4][4] =bb; // 99
                         jumbled[4][3] =cc; // 43
                         jumbled[4][5] =dd; // r
                         jumbled[5][4] =ee; // r'
                         jumbled[5][5] =ff ; // r''
                         printfun(jumbled);}}
//43 , 53 arranges...................................................................................................................................           
        moveEmptySpace(jumbled, rowsize,  columnsize,  mtterm,  5, 5, 22, 22 );                            
        for(int i=1 ; i< 10  ; i++) {
                                if(jumbled[4][4] != 44) {          int x =0;   
                                     x = jumbled[4][4] ;
                                     jumbled[4][4] = jumbled[4][5];
                                     jumbled[4][5] = jumbled[5][5];
                                     jumbled[5][5] = jumbled[5][4];
                                     jumbled[5][4] = x; System.out.println("rotate 3,3 to 4,4"); }}
        moveEmptySpace(jumbled, rowsize,  columnsize,  mtterm,  5, 5, 22, 22 );            
        printfun(jumbled);
        if(jumbled[4][5] == 45){System.out.println("solved");} else {System.out.println("no solution");}
}}