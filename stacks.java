import java.util.ArrayList;
import java.util.EmptyStackException;



public class stacks implements interfazStack<String> {
    ArrayList<String> stack = null;

    public stacks() {
        stack = new ArrayList<String>();
    }



    /**
     * @param elemento
     */
    public void push(String elemento) {
        stack.add(elemento);
    }


    /**
     * @return Double
     * @throws EmptyStackException
     */
    public String pop() throws EmptyStackException {
        if (empty()) {
            return null;
        } else {
            String auxiliar = "";
            auxiliar = stack.get(stack.size() - 1);
            int tam = size() - 1;
            stack.remove(tam);
            return auxiliar;
        }
    }


    /**
     * @return Double
     * @throws EmptyStackException
     */
    public String peek() throws EmptyStackException {
        if (empty()) {
            return null;
        } else {
            int tam = size() - 1;
            return stack.get(tam);
        }
    }


    /**
     * @return boolean
     */
    public boolean empty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * @return int
     */
    public int size() {
        return stack.size();
    }

}
