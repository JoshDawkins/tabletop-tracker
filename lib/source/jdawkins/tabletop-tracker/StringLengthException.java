opackage jdawkins.tabletop-tracker;

public class StringLengthException extends RuntimeException{
	private int minLength;
	private int maxLength;
	
	private static String ValidateArgs(String message, int min, int max){
		if (min < 0)
			throw new InvalidIntegerValueException(0);
		if (max > 0 && max < min)
			throw new RuntimeException("Value of 'max' given to StringLengthException constructor cannot be less than the value of 'min'");
		if (message == null || message.trim().isEmpty())
			return String.format("This String must be %0$s%1$s%2$s characters in length.", min > 0 ? String.format("no less than %0$d", min) : "", (min > 0 && max > 0) ? " and " : "", max > 0 ? String.format("no more than %0$d", max) : "");
		return message;
	}
	
	public StringLengthException(int min = 0, int max = 0){
		this(null, null, min, max);
	}
	public StringLengthException(String message, int min = 0, int max = 0){
		this(message, null, min, max);
	}
	public StringLengthException(Throwable innerException, int min = 0, int max = 0){
		this(null, innerException, min, max);
	}
	public StringLengthException(String message, Throwable innerException, int min = 0, int max = 0){
		super(ValidateArgs(message, min, max), innerException);
		
		this.minLength = min;
		this.maxLength = max;
	}
	
	public int MinLength(){ return this.minLength; }
	public int MaxLength(){ return this.maxLength; }
}