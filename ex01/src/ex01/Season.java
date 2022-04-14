package ex01;

public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    FALL{
        @Override
        public Season next() {
            return WINTER;
        }
    };

    public Season next() {
        return values()[ordinal() + 1];
    }
}
