package login;

import java.util.HashMap;

public class Login {
	private HashMap<Integer, Account> accounts = new HashMap<>();
	
	
	public Login(HashMap<Integer, Account> accounts) {
		this.accounts = accounts;
	}
	
	public Account getAccount(String username, String password) {
		return(accounts.get(username.hashCode() + password.hashCode()));
	}
}
