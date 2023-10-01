import java.util.Scanner;

public class MyClass {
    public static void main(String args[]) {
      //instanciando "vetor" como objeto da "classe" int[] 
        int [] vetor = new int[5];
      //instanciando o objeto "ler" como o leitor da classe Scanner
        Scanner ler = new Scanner(System.in);

      //coletando os valores com um laço de repetição for
        for(int i = 0; i<vetor.length; i++){
            System.out.print("Digite o "+(i + 1)+"º número: ");
            vetor[i] = ler.nextInt();
        }

      //imprimindo os números que foram coletados
        System.out.println("\nLista dos números coletados:");
        
        for(int i = 0; i<vetor.length; i++){
            System.out.print(vetor[i]+" ");
        }
    }
}
