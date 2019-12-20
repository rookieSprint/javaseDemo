package java8Lambda;

public class AppleFunctionImpl implements AppleFunction<Integer,Apple> {

	@Override
	public Apple apply(Integer e) {
		return new Apple(e);
	}


}
