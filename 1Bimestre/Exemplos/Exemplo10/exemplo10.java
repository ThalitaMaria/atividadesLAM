import java.util.Scanner;

public class exemplo10 {
    public static void main(String[] args) {
        int op;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a opção :");    
        op = input.nextInt();
        do {
            System.out.printf("op vale" + op);
            op++;
        } while(op <= 3);
    }
}
