package thread;

public class RunnableImpl implements Runnable {

    @Override
    public void run() {
        for(int a = 0;a < 10; a++){
            try {
                Thread.sleep(500);
                System.out.println(getClass().getName() + ": Running");
            } catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            
        }
        
    }
    
}
