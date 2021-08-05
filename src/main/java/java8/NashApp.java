package java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class NashApp {
    
    private ScriptEngineManager manager;
    private ScriptEngine engine;

    private NashApp(){
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName("nashorn");
    }

    private void callFunction(){
        try {
            //THIS ENGINE IS NULL
            engine.eval("print('JS from Java')");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NashApp app = new NashApp();
        app.callFunction();
    }
}
