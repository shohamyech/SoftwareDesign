package ex01;

public class FigTree extends Tree {


    FigTree(int height, Season season) {
        super(height,season,null);
        this.leavesColor = switch (season)
        {
            case SPRING, SUMMER -> Color.GREEN;
            case FALL -> Color.YELLOW;
            case WINTER -> null; // Because no leaves
        };
    }

    @Override
    public String toString() {
        String message = "Fig tree. ";
        if (this.season == Season.SUMMER)
            message += "I give fruit. ";
        message += super.toString();
        if (season != Season.WINTER)
            message += " and my color is: " + leavesColor;
        else
            message += " and I have no leaves";
        return message;
    }
    @Override
    public void changeSeason() {
        season = season.next();
        switch (season) {
            case WINTER -> {
                height += 20;
                leavesColor = null;
            }
            case SPRING -> {
                height += 30;
                leavesColor = Color.GREEN;
            }
            case SUMMER -> height += 30;
            case FALL -> {
                height += 20;
                leavesColor = Color.YELLOW;
            }
        }
    }
}
