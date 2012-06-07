package dux.encryption.isaac;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import dux.encryption.IEncryptionAlgorithm;

class ISAACEncryptionAlgorithm implements IEncryptionAlgorithm {

	private final SecureRandom isaac = getSecureRandom("ISAACRandom");

	@Override
	public int nextInt() {
		if (isaac != null) {
			return isaac.nextInt();
		}
		return 0;
	}

	private static SecureRandom getSecureRandom(String algorithm) {
		try {
			return SecureRandom.getInstance("ISAACRandom");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}