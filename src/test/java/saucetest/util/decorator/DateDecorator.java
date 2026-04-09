package saucetest.util.decorator;

import saucetest.util.DateUtils;

public class DateDecorator implements StringDecorator {
	private final StringDecorator innerDecorator;

	public DateDecorator(StringDecorator stringDecorator) {
		this.innerDecorator = stringDecorator;
	}

	@Override
	public String decorate(String baseString) {
		return innerDecorator.decorate(baseString) + " " + DateUtils.formatCurrentTime();
	}
}
