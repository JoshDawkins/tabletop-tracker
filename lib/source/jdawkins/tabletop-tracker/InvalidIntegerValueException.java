package jdawkins.tabletop-tracker;

public class InvalidIntegerValueException extends RuntimeException{
	private int minVal;
	private int maxVal;
	
	private static String ValidateArgs(String message, int min, int max){
		if (max < min)
			throw new RuntimeException("The value of 'max' passed to the InvalidIntegerValueException constructor cannot be less than 'min'.");
		if (message == null || message.trim().isEmpty())
			return String.format("This value must be an integer no less than %0$d and no more than %1$d.", min, max);
		return message;
	}
	
	public InvalidIntegerValueException(int min = Integer.MIN_VALUE, int max = Integer.MAX_VALUE){
		this(null, null, min, max);
	}
	public InvalidIntegerValueException(String message, int min = Integer.MIN_VALUE, int max = Integer.MAX_VALUE){
		this(message, null, min, max);
	}
	public InvalidIntegerValueException(Throwable innerException, int min = Integer.MIN_VALUE, int max = Integer.MAX_VALUE){
		this(null, innerException, min, max);
	}
	public InvalidIntegerValueException(String message, Throwable innerException, int min = Integer.MIN_VALUE, int max = Integer.MAX_VALUE){
		super(ValidateArgs(message, min, max), innerException);
		
		this.minVal = min;
		this.maxVal = max;
	}
	
	public int MinVal(){ return this.minVal; }
	public int MaxVal(){ return this.maxVal; }
}