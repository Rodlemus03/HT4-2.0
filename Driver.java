import java.util.Scanner;
import java.util.ArrayList;
public class Driver {
    public static void main(String[] args) {
        archivo arch=new archivo();
        ArrayList<String> listaRespuesta = arch.leerArchivo();
        calculadora calc=new calculadora();
        Scanner teclado=new Scanner(System.in);
        System.out.println("---------------- BIENVENIDA ----------------");
        System.out.println("1. ArrayList ");
        System.out.println("2. vectores ");
        System.out.println("3. Listas ");
        System.out.println("4. Listas doblemente encadenadas ");
        String numero="";
        numero=teclado.next();
        if(numero.equalsIgnoreCase("1")){
            for(int i=0;i<listaRespuesta.size();i++){
                String res="";
                StacksArray array=new StacksArray();
                res=StacksArray.convertir(listaRespuesta.get(i));
                System.out.println(res);
                int resultado = calculadora.evaluar(res);
                System.out.println(resultado);
            }

        }else if(numero.equalsIgnoreCase("2")){
            for(int i=0;i<listaRespuesta.size();i++){
                String res="";
                StacksVectores array2=new StacksVectores();
                res=StacksVectores.convertir(listaRespuesta.get(i));
                //Meterle espacios
                manejoCaracteres manejo=new manejoCaracteres();
                String res2="";
                res2=manejoCaracteres.insertSpaces(res);
                //Fin meterle espacios

                int resultado = calculadora.evaluar(res2);
                System.out.println(resultado);
            }

        }else if(numero.equalsIgnoreCase("3")){
            for(int i=0;i<listaRespuesta.size();i++){
                String res="";
                StacksListas array2=new StacksListas();
                res=StacksListas.convertir(listaRespuesta.get(i));
                //Meterle espacios
                manejoCaracteres manejo=new manejoCaracteres();
                String res2="";
                res2=manejoCaracteres.insertSpaces(res);
                //Fin meterle espacios

                int resultado = calculadora.evaluar(res2);
                System.out.println(resultado);
            }

        }else if(numero.equalsIgnoreCase("4")){

        }else{
            System.out.println("Elige la opcion correcta ");
        }


    }
}
