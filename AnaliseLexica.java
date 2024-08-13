public class AnaliseLexica {
    public static void main(String[] args) {
        String codigo = "position = initial + relative * 60";
        String lexema = "";
        
        for (int i = 0; i < codigo.length(); i++) {
            char currentChar = codigo.charAt(i);
            
            if (Character.isLetter(currentChar)) {
                // Acumulando lexema para identificadores
                lexema += currentChar;
            } else if (Character.isDigit(currentChar)) {
                // Acumulando lexema para números
                lexema += currentChar;
            } else {
                // Processar o lexema se não estiver vazio
                if (!lexema.isEmpty()) {
                    if (Character.isLetter(lexema.charAt(0))) {
                        System.out.println("<ID, " + lexema + ">");
                    } else if (Character.isDigit(lexema.charAt(0))) {
                        System.out.println("<NUM, " + lexema + ">");
                    }
                    lexema = ""; // Resetar o lexema
                }

                // Processar operadores
                if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '=' ) {
                    System.out.println("<OP, " + currentChar + ">");
                } else if (currentChar == ' ' || currentChar == '(' || currentChar == ')') {
                    // Ignorar outros caracteres não relevantes
                    continue;
                }
            }
        }

        // Lidar com o último lexema se houver
        if (!lexema.isEmpty()) {
            if (Character.isLetter(lexema.charAt(0))) {
                System.out.println("<ID, " + lexema + ">");
            } else if (Character.isDigit(lexema.charAt(0))) {
                System.out.println("<NUM, " + lexema + ">");
            }
        }
    }
}
