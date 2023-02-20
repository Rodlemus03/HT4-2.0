public class StacksArray
{
    static int jerarquia(char caracter){
        switch (caracter){
            case '+':
                return  1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 4;

        }
    }


    static String convertir(String expresion){
        String nueva="";
        stacks stacks=new stacks();
        for (int i=0;i<expresion.length();i++){
            char car=expresion.charAt(i);
            if(Character.isLetterOrDigit(car)){
                nueva+=car;
            }else if(car=='('){
                stacks.push(String.valueOf(car));
            } else if (car == ')') {
                while (!stacks.empty() && stacks.peek() != "(")
                    nueva += stacks.pop();
                if (!stacks.empty() && stacks.peek() != "(")
                    return "Expresión inválida";
                else
                    stacks.pop();
            }else{
                while (!stacks.empty() && jerarquia(car) <= jerarquia(stacks.peek().charAt(0)))
                    nueva += stacks.pop();
                stacks.push(String.valueOf(car));
            }
            }

        while(!stacks.empty()){
            nueva+=stacks.pop();


    }
        return nueva;
    }

    public static void main(String[] args) {
        System.out.println(convertir("5+5"));
    }
}
