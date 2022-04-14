package ex01;

public class Bear extends Animal {

    Bear(int weight, Season season) {
        super(weight,season,Color.BROWN);
    }
    @Override
    public String toString() {
        if (season == Season.WINTER)
            return "Bear. I am sleeping. " + super.toString();
        return "Bear. " + super.toString();
    }
    @Override
    public void changeSeason() {
        season = season.next();
        switch (season){
            case WINTER:  weight = (int)Math.floor(weight * 0.8); break;
            case SPRING:  weight = (int)Math.floor(weight * 0.75);break;
            case SUMMER:  weight = (int)Math.floor(weight * (1 + (1.0/3.0)));break;
            case FALL:  weight = (int)Math.floor(weight * 1.25);};
    }
}
