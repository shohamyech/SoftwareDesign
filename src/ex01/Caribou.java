package ex01;

public class Caribou extends Animal {

    Caribou(int weight, Season season) {
        super(weight, season, null);
        color = getColorBySeason(season);
    }

    @Override
    public String toString() {
        String ret = "Caribou: ";
        if (season == Season.WINTER)
            ret += "I am migrating south. ";
        else if(season == Season.SUMMER)
            ret += "I am migrating north. ";

        return  ret + super.toString();
    }

    @Override
    public void changeSeason() {
        season = season.next();
        color = getColorBySeason(season);
    }

    private Color getColorBySeason(Season season){
        return switch (season){
        case WINTER ->  Color.WHITE;
        case SPRING ->  Color.BROWN;
        default -> color;};
    }
}
