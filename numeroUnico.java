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
            for(int j=i+1; j<copia.length;j++){
               System.out.print(copia[i]); 
                if(copia[j]==unico){
                    copia[j] = 0;
                    copia[i] = 0;
                }
                System.out.println(copia[i]);
          }
        }
        

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
		int lista[] = { 1,1,2,2,2,3,3};
		
		System.out.println(numeroUnico(lista));
	}

}
