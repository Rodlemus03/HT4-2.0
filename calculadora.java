import java.util.Stack;

public class calculadora {
    Singleton singleton = Singleton.getInstance();
    private static int operar(int a, int b, String operador) {
        switch (operador) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Operador ilegal: " + operador);
        }
    }
    public static int evaluar(String expresion) {
        Stack<Integer> stack = new Stack<>();
        String[] digitos = expresion.split(" ");
        for (String digito : digitos) {
            if (isOperator(digito)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operar(a, b, digito));
            } else {
                stack.push(Integer.parseInt(digito));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        boolean bandera=false;

        if(token.equals("+")){
            bandera=true;
        }else if(token.equals("-")){
            bandera=true;
        }else if(token.equals("*")){
            bandera=true;
        }else if(token.equals("/")){
            bandera=true;
        }
        return bandera;
    }



    public static void main(String[] args) {
        String postfix = "3 5 + 2 *";
        int result = evaluar(postfix);
        System.out.println(postfix + " = " + result);
    }

}
