package thread;

import java.util.concurrent.Callable;

class CallableImpl implements Callable<String>{

    private int milisecond;
    private String value;

    CallableImpl(int milisecond, String value){
        this.milisecond = milisecond;
        this.value = value;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(milisecond);
        return value;
    }
    
}
