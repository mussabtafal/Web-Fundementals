import java.util.ArrayList;

public class SelectionSort {
    public ArrayList<Integer> Sort(ArrayList<Integer> arr){
        for (int i = 0; i < arr.size(); i++) {
            
        }

    }

} 

def selection(array):
    for j in range(0, len(array)):
        for i in range(j, len(array)):
            if array[i] < array[j]:
                array[i], array[j] = array[j], array[i]
    return array
   


print(selection([1,4,6,3,2,0,5,10]))
