import java.util.Scanner;

public class exemplo9 {
    public static void main(String[] args) {
        int op;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a opção :");    
        op = input.nextInt();
        while(op <= 3) {
            System.out.printf("op vale" + op);
            op++;
        }
    }
}
