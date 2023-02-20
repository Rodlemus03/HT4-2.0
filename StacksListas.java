import java.util.*;

public class StacksListas {
    static int jerarquia(char ch) {
        switch (ch) {
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



    static String convertir(String ex) {
        String expresion= ex.replace(" ","");
        String nueva = "";
        nodos cabeza = null;
        stacks stack=new stacks();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (Character.isLetterOrDigit(caracter)) {
                nueva += caracter;
                cabeza = new nodos(caracter);
            } else if (caracter == '(') {
                stack.push(String.valueOf(caracter));
            } else if (caracter == ')') {
                while (!stack.empty() && stack.peek() != "(")
                    nueva += stack.pop();
                if (!stack.empty() && stack.peek() != "(")
                    return "Expresión inválida";
                else
                    stack.pop();
            } else {
                while (!stack.empty() && jerarquia(caracter) <= jerarquia(stack.peek().charAt(0)))
                    nueva += stack.pop();
                stack.push(String.valueOf(caracter));
            }
        }
        while (!stack.empty())
            nueva += stack.pop();

        return nueva;
    }


}
