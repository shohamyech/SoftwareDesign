package HamburgerPkg;

public class ChipsDecorator extends HamburgerDecorator{
    public ChipsDecorator(Hamburger ham) {
        super(ham);
    }

    @Override
    public String serve() {
        return super.serve() + " with chips";
    }
}
