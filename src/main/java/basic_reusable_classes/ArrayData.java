package basic_reusable_classes;

public class ArrayData {
    
    private String[] arrayRandomString = {"Level", "go", "evolve", "It is", "Clop"};
    private String[] arrayStringNumber = {"1", "2", "3", "4", "5"};
    //----------------------------------
    public String[] getArrayRandomString() {
        return arrayRandomString;
    }

    public void setArrayRandomString(String[] arrayRandomString) {
        this.arrayRandomString = arrayRandomString;
    }

    public String[] getArrayStringNumber() {
        return arrayStringNumber;
    }

    public void setArrayStringNumber(String[] arrayStringNumber) {
        this.arrayStringNumber = arrayStringNumber;
    }
    //----------------------------------
    private static ArrayData instance;
    

    public static ArrayData getInstance(){
        if(instance == null){
            instance = new ArrayData();
        }
        return instance;
    }

    private ArrayData(){

    }
}
