public class Item {
    private String name;
    private double price;
    private int index;
    
// Constructors initiation    
    public Item(int index, String name, double price) {
        this.name = name;
        this.price = price;
        this.index = index;
    }

// name getters and setters     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

// price getters and setters 
    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display(){
        System.out.println(this.name);
    }


// index getters and setters     
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}

