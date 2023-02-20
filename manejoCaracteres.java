public class manejoCaracteres {
    public manejoCaracteres(){

    }
    public static String insertSpaces(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (i < str.length() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
