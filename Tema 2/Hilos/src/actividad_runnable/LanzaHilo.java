
package actividad_runnable;


public class LanzaHilo implements Runnable{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount;
    
    public LanzaHilo(){
        taskCount++;
    }
    
    public LanzaHilo(int countDown){
        taskCount++;
        this.countDown = countDown;
    }
    
    @Override
    public void run(){
       while (countDown > 0 ){
            if(id == 0){
                System.out.println(ANSI_RED + "#" + id + " (" + countDown + ")" + ANSI_RESET);
            } else if (id == 1){
                System.out.println(ANSI_GREEN + "#" + id + " (" + countDown + ")" + ANSI_RESET);
            } else {
                System.out.println(ANSI_YELLOW + "#" + id + " (" + countDown + ")" + ANSI_RESET);
            }
            countDown--;
        }
        System.out.println("Lanzamiento (" + id + ")");
    }
    
}
