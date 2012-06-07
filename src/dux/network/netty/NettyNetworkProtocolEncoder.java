package dux.network.netty;

import com.google.inject.Inject;

import dux.encryption.IEncryptionAlgorithm;
import dux.network.base.BaseNetworkProtocolEncoder;

public class NettyNetworkProtocolEncoder extends BaseNetworkProtocolEncoder {

	@Inject
	protected NettyNetworkProtocolEncoder(IEncryptionAlgorithm encryptionAlgorithm) {
		super(encryptionAlgorithm);
	}

}