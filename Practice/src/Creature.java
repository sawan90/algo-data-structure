public class Creature {
    private int legCount;
    protected int wingCount;
    public Creature(){
    	
    }
    public Creature(int legCount) {
    	
        this.legCount = this.legCount;
        this.wingCount = 0;
    }
    
    public String toString() {
        return "legs=" + this.legCount + " wings=" + wingCount;
    }
}

 class Animal extends Creature {
    public Animal(int legCount) {
        this.wingCount = 0;
    }

}