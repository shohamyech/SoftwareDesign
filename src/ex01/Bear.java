package ex01;

public class Bear extends Animal {

    Bear(int weight, Season season) {
        super(weight,season,Color.BROWN);
    }
    @Override
    public String toString() {
        return "Bear. " + super.toString();
    }
    @Override
    public void changeSeason() {
        this.season = season.next();
    }
}
