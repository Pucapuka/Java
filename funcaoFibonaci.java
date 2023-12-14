public class Solution {
    public static String geraSequenciaFibonacci(int input) {
        //variaveis inteiras
        int[] array = new int[20];
        int primeiro = 0;
        int segundo = 1;
        int fibo = segundo + primeiro;
        int indice = 2; //indice começa no 2 por já ter os dois primeiros

        //arrays atribuidas caso necessite trabalhar nela
        array[0] = primeiro;
        array[1] = segundo;

        //para gerar a string a qual deve retornar o valor, usei StringBuilder já inicializado com 0, 1
        StringBuilder sb = new StringBuilder("0, 1");
        
        //loop infinito para gerar os valores e já ir anexando ao StringBuilder
        while(true){
            array[indice] = fibo; //o array recebe o resultado de fibo
            if(fibo>input) //e até chegar ao valor da entrada
                break;//vai gerando, se passar, breca
            fibo += array[indice-1]; //fibo soma com o elemento anterior
            sb.append(", "); //uma virgulazinha para respeitar o layout
            sb.append(array[indice]); //aí adiciona o array lá de cima
            indice++; //aí gera um novo índice para pegar o novo valor obtido
        }

        return sb.toString(); //retorna uma string a partir do StringBuilder
    }
}
