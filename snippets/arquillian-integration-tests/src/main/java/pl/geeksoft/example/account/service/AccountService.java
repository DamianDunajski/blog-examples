package pl.geeksoft.example.account.service;

import pl.geeksoft.example.account.exception.AccountAlreadyExistsException;
import pl.geeksoft.example.account.model.Account;

public interface AccountService {
	Account register(String email, String password) throws AccountAlreadyExistsException;
}
