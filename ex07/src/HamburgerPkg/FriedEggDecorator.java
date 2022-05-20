package HamburgerPkg;

public class FriedEggDecorator extends HamburgerDecorator{
    public FriedEggDecorator(Hamburger ham) {
        super(ham);
    }

    @Override
    public String serve() {
        return super.serve() + " with fried egg";
    }
}
