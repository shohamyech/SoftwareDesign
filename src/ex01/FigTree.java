package ex01;

public class FigTree extends Tree {


    FigTree(int height, Season season) {
        // TODO: Implement.
        super(height,season,null);
    }

    @Override
    public String toString() {
        // TODO: Implement.
        String message = "FigTree. ";
        if (this.season == Season.SPRING)
        {
            message += "I give fruit. ";
        }
        message += super.toString();
        return message;
    }
    @Override
    public void changeSeason() {
        // TODO: Implement.
    }
}
