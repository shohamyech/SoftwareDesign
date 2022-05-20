package HamburgerPkg;

public class OnionDecorator extends HamburgerDecorator{
    public OnionDecorator(Hamburger ham) {
        super(ham);
    }

    @Override
    public String serve() {
        return super.serve() + " with onion rings";
    }
}
