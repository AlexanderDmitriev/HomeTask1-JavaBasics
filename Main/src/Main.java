//package Main;
import javax.swing.*;
public class Main {
    public int getCommonDivisor(int firstNumber, int secondNumber) { // Задание №1
        if  ((firstNumber>0)&&(secondNumber>0)){
            while (secondNumber !=0) {
                int c=firstNumber%secondNumber; //Находим  остаток  от  деления  друг  на  друга
                firstNumber=secondNumber;
                secondNumber=c;
            }
            JOptionPane.showMessageDialog(null, "Наименьший остаток  от  деления  равен"+firstNumber);
            return firstNumber;
        }
        else JOptionPane.showMessageDialog(null, "Введенные  числа  меньше  нуля");  //ERROR_MESSAGE;
        return 1;
    }
    ////////////////////////////////////////////////////////
    /** Returns sum of digits of the given number
     *  @param number  - positive number
     * @return the sum of digits of the given number*/
    public int getSumOfDigits(int number) {  // Задание №2
        int ost=0;
        while  (number!=0) {
            ost+=number%10;
            number=number/10;
        }
        return ost;
    }
    ////////////////////////////////////
    /**Checks if the given number is prime or not
     * @param number
     * @return true - if number is prime, if not return false */
    public boolean isPrime(int number) {           // Задание №3
        boolean result=true;
        if ((number!=0)&&(number>2)) {  // 0-не рассматриваем, 1 и 2 - простые числа
            for (int i=3; i<number-1; i++ ) {
                if ((number%i)==0) { result=false;}
            }
        }
        return result;
    }
    //////////////////////////////////////////////
    /** Returns sum of row: 1! - 2! + 3! вЂ“ 4! + 5! - вЂ¦ + n!
    // * @param n - positive number */
    public static int faktor(int x) {  //Метод  нахождения  факториала
        if (x == 0) return 1;
        else return x * faktor(x-1);
    }
    public int getSumOfRow(int n) {   // Задание №4
        int sumFact=0;

        for (int i=1; i<=n; i++){
            sumFact=(int)(sumFact-(Math.pow(-1,i))*faktor(i));
        }
        return sumFact;
    }
    ///////////////////////////
    public int getSixDigitNumbersCount() {   // Задание №5
        int count=0;
        for (int i=100000; i<=999999; i++) {
            int ost1=0; int ost2=0;
            int num=i;
            for (int j=0;j<3; j++) {
                ost1+=num%10;
                num=num/10;
            }
            for (int j=0;j<3; j++) {
                ost2+=num%10;
                num=num/10;
            }
            if (ost1==ost2) {count+=1;}
        }
        return count;
    }
    /////////////////////////////////////
    /**Returns Fibonacci series of a specified length
     *  @param length - the length of the Fibonacci series
     * @return array filled with Fibonacci series  */
    public int[] getFibonacciSeries(int length) {       // Задание №6
        int [] Arr=new int[length];
        Arr[0]=1;
        Arr[1]=1;
        for (int i=2; i<length; i++){
            Arr[i]=Arr[i-2]+Arr[i-1];
       }

        return Arr;
    }
    //////////////////////////////
    /** Returns array with prime numbers
     * @param length  - the length of prime numbers series
     * @return array filled with prime numbers   */
    public int[] getPrimeSeries(int length) {                    // Задание №7
        int [] PrimeArr=new int [100];
        int last=2;
        for (int i=0; i<PrimeArr.length; i++) {
              PrimeArr[i]=last++;
            while (!isPrime(last)){
                last++;
            }
        }
        return PrimeArr;
    }
///////////////////////////
    /**Prints to console chessboard using arrays b - black square w - white square
     *  the output should be like the following
     * w b w b w b w b b w b w b w b w w b w b w b w b b w b w b w b w w b w b w
     * b w b b w b w b w b w w b w b w b w b b w b w b w b w   */
    public void printChessboard() {           // Задание №8
        char [][] Chess=new char [8][8];
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++) {
                if ((i+j)%2==0) { Chess[i][j]='W';}
                else  Chess[i][j]='B';
            }
        }  }
////////////////////////////////////
//  1.9.
public int createSixDimensionArray() {   // Задание №9
    int [][][][][][] SixArr=new int [2][2][2][2][2][2];
    int countSix=0;
    int num=0;
    for (int i1=0; i1<2; i1++){
        for (int i2=0; i2<2; i2++) {
            for (int i3=0; i3<2;i3++) {
                for (int i4=0; i4<2; i4++){
                    for (int i5=0; i5<2; i5++){
                        for (int i6=0; i6<2; i6++){
                            SixArr[i1][i2][i3][i4][i5][i6]=num+1;
                            countSix+=1;
                        }
                    }
                }
            }
        }
    }
    return countSix;
}
//////////////////////////////////////
    /**Prints to console Pascal's triangle with the given number of rows
     *@param numberOfRows  the number of rows in the triangle
     */
    public void printPascalsTriangle(int numberOfRows) {  //// Задание  №10
        long Table[][] = new long[numberOfRows + 1][numberOfRows + 1];
        for (int i = 0; i <= numberOfRows; i++) {
            Table[i][0] = Table[i][i] = 1;
            for (int k = 1; k < i; k++) {
                Table[i][k] = Table[i - 1][k - 1]
                        + Table[i - 1][k];

            }
        }

        for (int j=1; j<numberOfRows; j++){
            for (int i=1; i<numberOfRows; i++){
                Table[i][j] = Table[i - 1][j-1]+ Table[i - 1][j];
            }
        }
        for (int kt=0; kt<Table.length; kt++){
            for (int ktt=0; ktt<Table.length; ktt++){
       System.out.format("%4d", Table[kt][ktt]);}
            System.out.println();}
    }
////////////////////////////
    public static void main(String[] args) {
        Main math = new Main();
        int gdc = math.getCommonDivisor(100, 15);
        int sumOfDigits = math.getSumOfDigits(123456); // 21
        boolean isPrime = math.isPrime(7); // true
        System.out.println("isPrime =  "+isPrime);
        isPrime = math.isPrime(10); //false
        System.out.println("gdc=  " + gdc);
        System.out.println("sumOfDigits =  "+sumOfDigits);
        System.out.println("isPrime =  "+isPrime);
        int sumOfRow = math.getSumOfRow(5);
        System.out.println("sumOfRow =  "+sumOfRow);
        int count = math.getSixDigitNumbersCount();
        System.out.println("count =  "+count);
        int [] fibbonacci = math.getFibonacciSeries(10);  // [1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
        for (int k=0; k<10; k++){
        System.out.print(fibbonacci[k]+ "  ");}
        int [] primes = math.getPrimeSeries(5);// 1, 3, 5, 7, 11
        System.out.println( "\n" + "Задание №7");
        for (int k1=0; k1<100; k1++){
        System.out.print(primes[k1] + "   ");}
        math.printChessboard();
        int numbersCount = math.createSixDimensionArray();
        System.out.println( "\n" + "numbersCount =  "+numbersCount);
        math.printPascalsTriangle(3);

    }
}

