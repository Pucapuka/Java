import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.LocalDateTime;
import java.util.Date;

public class Treino{

  public static void main(String[] args){
	  String nome = "paulo"; 
	  //pegando a data
	  Date pega = new Date();
	  //ajustando o formato que quero da data
	  SimpleDateFormat formatoDeData = new SimpleDateFormat("dd/MM/yyyy");
	  //fazendo uma string da data com o novo formato
	  String novaData = formatoDeData.format(pega);
	
	  LocalDate diaDaSemana = LocalDate.now();
	  LocalDateTime hora = LocalDateTime.now();
	  Locale brasil = new Locale("pt", "BR");
	  int horario = hora.getHour();
	
	  if(horario>=0 && horario<12){
	    System.out.print("Bom dia, ");
	  }else if(horario>=12 && horario<18){
	    System.out.print("Boa tarde, ");
	  }else{                               //if(horario>=18 && horario<0){
	    System.out.print("Boa noite, ");
	  }
	  System.out.println(nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase() + "!");
	  System.out.println("Hoje e " + diaDaSemana.getDayOfWeek().getDisplayName(TextStyle.FULL,brasil) + ", dia " + novaData);
	  System.out.println("Agora sao " + hora.getHour() +":" + hora.getMinute() + "h" );
  }

}
