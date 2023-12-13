/*Escreva um programa que leia um número inteiro maior do que zero e devolva, na tela, a soma de todos os seus algarismos. 
Por exemplo, ao número 251 corresponderá o valor 8 (2 + 5 + 1). Se o número lido não for maior do que zero, deverá retornar -1.
*/

public class Solution {
    public static int somaAlgarismos(int input) {
        if(input>0){
            String numeroStr = Integer.toString(Math.abs(input));
            int somador = 0;
            for(char i : numeroStr.toCharArray()){
                somador += Character.getNumericValue(i);
            }
            return somador;
        }
        
        return -1;
    }
}
