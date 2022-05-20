package HamburgerPkg;

public abstract class HamburgerDecorator implements Hamburger {

    private Hamburger itsHamburger;

    public HamburgerDecorator(Hamburger ham)
    {
        itsHamburger = ham;
    }

    @Override
    public String serve() {
        return itsHamburger.serve();
    }
}
