import java.util.Scanner;

public class exemplo8 {
    public static void main(String[] args) {
        int op;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a opção :");    
        op = input.nextInt();
        switch(op) {
            case 1:
                System.out.printf("Opção 1");
                break;
            case 2:
                System.out.printf("Opção 2");
                break;
            case 3:
                System.out.printf("Opção 1");
                break;
            default:
                System.out.printf("Opção Inválida");
        }
    }
}
