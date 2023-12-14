public class Main
{
    public static int numeroUnico(int [] input){

        int unico = 0; //reserva uma variável para pegar o elemento unico

        int [] copia = new int[input.length];//e uma array copia para comparar

        for(int i = 0 ; i < input.length; i++){
            copia[i] = input[i];//copia a array principal
        }

        //compara: se der igual, zera o valor do índice
        for(int i=0; i<input.length; i++){
            unico = input[i];
            for(int j=copia.length-1; j<i;j--){
                if(copia[j]==unico)
                    copia[j] = 0;
            }
        }
        
        /*//compara: se der igual, zera o valor do índice
        for(int i=0; i<input.length; i++){
            unico = input[i];
            for(int j=copia.length-1; j>=0;j--){
                if(copia[j]==unico)
                    copia[j] = 0;
            }
        }
        */
        //procura o índice que não zerou, e guarda na variável único
        for (int i=0; i<copia.length; i++){
            if(copia[i]!=0)
                unico = copia[i];
            }

        //exibe a variavel único se não for zero, caso contrário, retorna -1
        if(unico!=0)
            return unico;
        else
            return -1;

    }


	public static void main(String[] args) {
		int lista[] = {101,10,20,30,40,50,50,40,30,20,101};
		System.out.println(numeroUnico(lista));
	}

}
