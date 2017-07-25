/**
 * 
 */
package com.aks.game.kalah;

/**
 * Exception thrown when user tries to perform an illegal move.
 * 
 * @author Amit Soni
 *
 */
public class InvalidMoveException extends RuntimeException {

	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = -5568996038250490803L;
	/**
	 * Error Code.
	 */
	private int errorCode;
	/**
	 * Error Message.
	 */
	private String errorMessage;

	/**
	 * Constructor to create and object from errorCode and errorMessage
	 * properties.
	 * 
	 * @param errorCode
	 *            - Integre Error Code.
	 * @param errorMessage
	 *            - String Error Message.
	 */
	public InvalidMoveException(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
