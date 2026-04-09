package saucetest.util.decorator;

public class PngExtensionDecorator implements StringDecorator {
	private final StringDecorator innerDecorator;

	public PngExtensionDecorator(StringDecorator stringDecorator) {
		this.innerDecorator = stringDecorator;
	}

	@Override
	public String decorate(String baseString) {
		return innerDecorator.decorate(baseString) + ".png";
	}
}
