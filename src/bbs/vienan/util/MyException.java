package bbs.vienan.util;

public class MyException extends Exception {
	 private String message; 
	 public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MyException (String message){
	        super();//����ʡ��
	        this.message=message;
	   }
}
