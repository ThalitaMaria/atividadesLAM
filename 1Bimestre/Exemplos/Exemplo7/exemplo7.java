import java.util.Scanner;

public class exemplo7 {
    public static void main(String[] args) {
        int idade;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a idade :");    
        idade = input.nextInt();
        if(idade < 18) {
            System.out.printf("Entrada não permitida");
        } else {
            System.out.printf("Entrada permitida");
        }
    }
}
