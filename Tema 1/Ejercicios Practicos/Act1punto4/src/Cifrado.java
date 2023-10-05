

public class Cifrado {
    
    public static void main(String[] args) {
        
        String text = args[0];
        String cesar = "";
        int desp = Integer.parseInt(args[1]);
        
        for (int i = 0; i < text.length(); i++){
            cesar += (char) (text.charAt(i) + desp);
        }
        System.out.println(cesar);
    }
    
}
