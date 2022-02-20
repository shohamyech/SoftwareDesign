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
        season = season.next();
        weight = (int)switch (season){
            case WINTER ->  Math.floor(weight * 0.8);
            case SPRING ->  Math.floor(weight * 0.75);
            case SUMMER ->  Math.floor(weight * (1 + (1.0/3.0)));
            case FALL   ->  Math.floor(weight * 1.25);};
    }
}
