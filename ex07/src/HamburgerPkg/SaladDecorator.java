package HamburgerPkg;

public class SaladDecorator extends HamburgerDecorator{
    public SaladDecorator(Hamburger ham) {
        super(ham);
    }

    @Override
    public String serve() {
        return super.serve() + " with salad";
    }
}