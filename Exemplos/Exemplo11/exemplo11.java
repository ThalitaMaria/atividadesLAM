import java.util.Scanner;

public class exemplo11{
    public static void main(String[] args) {
        int op;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a opção :");    
        op = input.nextInt();
        for (int x=1; x<=op; x++) {
            System.out.printf("op vale " + op + " e x vale " + x);
        }
    }
}
