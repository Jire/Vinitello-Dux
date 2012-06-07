package dux.network.netty;

import com.google.inject.Inject;

import dux.encryption.IEncryptionAlgorithm;
import dux.network.base.BaseNetworkProtocolDecoder;

public class NettyNetworkProtocolDecoder extends BaseNetworkProtocolDecoder {

	@Inject
	protected NettyNetworkProtocolDecoder(IEncryptionAlgorithm encryptionAlgorithm) {
		super(encryptionAlgorithm);
	}

}