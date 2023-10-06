package com.mycompany.alura_aula;
import java.util.Scanner;

public class Alura_aula {

    
	public static void main(String[] args) {
            int length = 5;
            int [] vetor = new int[length];
            Scanner leitor = new Scanner(System.in);
            int key=0;

            System.out.println("Insira os valores dos elementos do vetor: ");
            for(int i = 0; i < length; i++){
                System.out.print(i+1+"º elemento: ");
                vetor[i] = leitor.nextInt();
            }
            System.out.println("Hora de fazer busca por elemento\n");
            System.out.println("Qual o elemento que você busca no vetor?");
            key = leitor.nextInt();
            for (int i = 0; i < length; i++){
                if (key == vetor[i]){
                System.out.print("Elemento "+key+ " encontrado na posição "+i+".");
                return;
                }
            }
            System.out.println("Elemento não encontrado.");
            
        
    }
}

