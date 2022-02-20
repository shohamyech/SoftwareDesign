package ex01;

public class FigTree extends Tree {


    FigTree(int height, Season season) {
        super(height,season,null);
        switch (season)
        {
            case SPRING:
            case SUMMER: this.leavesColor = Color.GREEN; break;
            case FALL: this.leavesColor = Color.YELLOW; break;
            case WINTER: this.leavesColor = null;// Because no leaves
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
            case WINTER:
                height += 20;
                leavesColor = null;
                break;
            case SPRING:
                height += 30;
                leavesColor = Color.GREEN;
                break;
            case SUMMER:
                height += 30;
                break;
            case FALL:
                height += 20;
                leavesColor = Color.YELLOW;
                break;
        }
    }
}
