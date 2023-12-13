import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static double valorEntrada(double[] input) {

        double dia_semana = input[0];
        double valor_normal = input[1];
        double musica = input[2];//1:sim 2: nao
        double acrescimo_15 = 0.000;

        //tem musica ao vivo
        if(musica == 1.000)
            acrescimo_15 = valor_normal*0.150;
        

        //seguntas, terças e quintas, desconto de 25%
        if(dia_semana == 1.000 || dia_semana == 2.000 || dia_semana == 4.000)
            valor_normal -= valor_normal*0.250;


        double valorTotal= valor_normal + acrescimo_15;
        
        //nao esqueca o arredondamento
        //instanciando um objeto do BigDecimal
        BigDecimal bd = new BigDecimal(valorTotal).setScale(3, RoundingMode.HALF_UP);
        double Final = Double.parseDouble(bd.getValue());
        return Final; 
    }
}
