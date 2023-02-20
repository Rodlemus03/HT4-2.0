import java.util.*;

public class StacksVectores {
    // Función para obtener la precedencia de los operadores
    static int jerarquia(char car) {
        switch (car) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    static String convertir(String ex){
        String expresion= ex.replace(" ","");
        String nueva = "";
        char[] vector = new char[expresion.length()];
        int posicion = 0;
        stacks stack=new stacks();
        for (int i = 0; i < expresion.length(); i++) {
            char ch = expresion.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                vector[posicion++] = ch;
            } else if (ch == '(') {
                stack.push(String.valueOf(ch));
            } else if (ch == ')') {
                while (!stack.empty() && stack.peek() != "(")
                    vector[posicion++] = stack.pop().charAt(0);
                if (!stack.empty() && stack.peek() != "(")
                    return "Expresión inválida";
                else
                    stack.pop();
            } else {
                while (!stack.empty() && jerarquia(ch) <= jerarquia(stack.peek().charAt(0)))
                    vector[posicion++] = stack.pop().charAt(0);
                stack.push(String.valueOf(ch));
            }
        }
        while (!stack.empty())
            vector[posicion++] = stack.pop().charAt(0);
        int pivote=0;
        return new String(vector, pivote, posicion);
    }


    public static void main(String[] args) {
        System.out.println(convertir("5+5"));
    }
}

