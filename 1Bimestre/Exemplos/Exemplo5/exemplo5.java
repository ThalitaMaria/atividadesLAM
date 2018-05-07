import java.util.Scanner;

public class exemplo6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome = "";
        System.out.println("Digite seu nome:");    
        nome = input.next();
        System.out.printf("\nMeu nome é %s\n", nome);
        System.out.printf("Digite sua idade: ");
        int idade = Integer.parseInt(input.next());
        System.out.printf("\nMinha idade %d\n", idade);
    }
}
