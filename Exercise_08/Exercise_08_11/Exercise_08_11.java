import java.util.Scanner;
public class Exercise_08_11{
    public static void main(String[] args){
        char[][] output = new char[3][3];
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 511");
        output = convert(reader.nextInt());
        for(int i = 0; i < output.length; i++)
            System.out.println(output[i][0] + " " + output[i][1] + " " + output[i][2]);

    }
    public static char[][] convert(int num){
        char temp[][] = new char[3][3];
        for(int i = 0,bit = 256; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                if(num % bit != num){
                    temp[i][j] = 'T';
                    num -= bit;
                }
                else{

                    temp[i][j] = 'H';
                }
                bit /= 2;
            }
        }
        return temp;
    }
}
