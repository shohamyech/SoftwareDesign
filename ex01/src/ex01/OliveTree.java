package ex01;

public class OliveTree extends Tree {


    OliveTree(int height, Season season) {
        super(height,season,Color.GREEN);
    }

    @Override
    public String toString() {
        String message = "Olive tree. ";
        if (season == Season.FALL)
            message+= "I give fruit. ";
        message += super.toString();
        message += " and my color is: GREEN";
        return message;
    }

    @Override
    public void changeSeason() {
        season = season.next();
        switch (season) {
            case WINTER:
            case FALL:
                height += 5;
                break;
            case SPRING:
            case SUMMER:
                height += 10;
                break;
        }
    }
}
