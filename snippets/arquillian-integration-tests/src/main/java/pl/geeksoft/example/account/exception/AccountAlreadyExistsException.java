package pl.geeksoft.example.account.exception;

/**
 * User: Damian Dunajski
 * Date: 25.05.2013
 * Time: 21:21
 */
public class AccountAlreadyExistsException extends Exception {

	private final String email;

	public AccountAlreadyExistsException(String email) {
		this.email = email;
	}

	public AccountAlreadyExistsException(String email, String message) {
		super(message);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
