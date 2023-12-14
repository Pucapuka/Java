public class Main
{
    public static int numeroUnico(int [] input){
        
        int unico = 0;
        
        int [] copia = new int[input.length];
        
        for(int i = 0 ; i < input.length; i++){
            copia[i] = input[i];
        }
        
        for(int i=0; i<input.length; i++){
            unico = input[i];
            for(int j=i+1; j<copia.length;j++){
                if(copia[j]==unico)
                    copia.remove(copia[j]);
            }
        }
        
        for (int elemento:copia){
                unico = elemento;
            }
                
        
        if(copia==null)
            return -1;
        else
            return unico;
           
    }

    
	public static void main(String[] args) {
		int lista[] = {2,1,2,3,1};
		System.out.println(numeroUnico(lista));
	}

}
