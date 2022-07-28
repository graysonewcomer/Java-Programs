import java.util.Scanner;

public class test
{

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        boolean isPerfect;

        int n = input.nextInt();

        double sqrt = Math.sqrt(n);
        int square = (int) (Math.pow(sqrt, 2));

        if (square == n)
            isPerfect = true;
        else
            isPerfect = false;

        System.out.println(isPerfect);
    }

}
