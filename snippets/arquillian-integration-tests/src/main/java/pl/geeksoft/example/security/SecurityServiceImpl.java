package pl.geeksoft.example.security;

import javax.ejb.Stateless;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * User: Damian Dunajski
 * Date: 25.05.2013
 * Time: 21:38
 */
@Stateless
public class SecurityServiceImpl implements SecurityService {

	@Override
	public String encrypt(String rawPassword) {
		return DigestUtils.sha256Hex(rawPassword);
	}

}
