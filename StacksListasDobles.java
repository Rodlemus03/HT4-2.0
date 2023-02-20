import java.util.*;
public class StacksListasDobles {

    
    
    public static int jerarquia(char ch) {
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

    public static String convertir(String infix) {
        StringBuilder postfix = new StringBuilder();
        LinkedList stack = new LinkedList();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // Si es un operando, agregar al resultado
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            // Si es un paréntesis izquierdo, agregar a la lista
            else if (ch == '(') {
                stack.addLast(ch);
            }

            // Si es un paréntesis derecho, desenlazar todos los operadores
            // hasta encontrar el paréntesis izquierdo correspondiente
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.tail.data != '(') {
                    postfix.append(stack.removeLast());
                }

                if (!stack.isEmpty() && stack.tail.data != '(') {
                    return "Expresión inválida";
                } else {
                    stack.removeLast();
                }
            }

            // Si es un operador, desenlazar operadores con mayor o igual precedencia
            // y agregarlos al resultado antes de agregar el operador actual a la lista
            else {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.tail.data));
            }

        }
    }
        
}