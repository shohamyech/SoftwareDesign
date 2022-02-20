package ex01;

public abstract class Animal implements Seasonable, Comparable{
    protected int weight;
    protected Season season;
    protected Color color;

    Animal(int weight, Season season, Color color){
        this.weight =weight;
        this.season =season;
        this.color =color;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) throw new NullPointerException();
        if (o == this) return 0;
        if (!(o instanceof Animal)) throw new ClassCastException();
        return this.weight - ((Animal)o).weight;
    }

    @Override
    public String toString() {
        return "My weight is: " + weight +
                " and my color is: " + color;
    }
}
