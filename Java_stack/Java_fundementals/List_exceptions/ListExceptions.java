import java.util.ArrayList;

public class ListExceptions {
    public static void main (String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("The type was casted successfully!");
            }
            catch (Exception e){
                System.out.println("The type was not casted, try to change the value!" + " at index of " + (i) + " with value of " + myList.get(i));
            }
        }
    }
}
