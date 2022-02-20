package ex01;

public abstract class Tree implements Comparable, Seasonable {
    protected int height;
    protected Season season;
    protected Color leavesColor;


    Tree(int height, Season season, Color leavesColor){
        this.height = height;
        this.season = season;
        this.leavesColor = leavesColor;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) throw new NullPointerException();
        if (!(o instanceof Tree)) throw new ClassCastException();
        return (this.height - ((Tree)o).height);
    }

    @Override
    public String toString() {
        return "My height is: " + height;
    }
}
