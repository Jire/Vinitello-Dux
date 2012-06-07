package dux.encryption.isaac;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import dux.encryption.IEncryptionAlgorithm;

public class ISAACEncryptionModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IEncryptionAlgorithm.class).to(ISAACEncryptionAlgorithm.class).in(Scopes.SINGLETON);
	}

}