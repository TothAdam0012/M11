package saucetest.util.decorator;

public class ExactDecorator implements StringDecorator {
	private final String toAdd;

	public ExactDecorator(String toAdd) {
		this.toAdd = toAdd;
	}

	@Override
	public String decorate(String baseString) {
		return baseString + toAdd;
	}
}
