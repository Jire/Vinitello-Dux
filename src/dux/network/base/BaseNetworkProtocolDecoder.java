package dux.network.base;

import java.nio.ByteBuffer;

import dux.encryption.IEncryptionAlgorithm;
import dux.network.INetworkProtocolDecoder;
import dux.network.util.ProtocolConstants;
import dux.packet.Packet;

public abstract class BaseNetworkProtocolDecoder implements INetworkProtocolDecoder {

	private final IEncryptionAlgorithm encryptionAlgorithm;

	protected BaseNetworkProtocolDecoder(IEncryptionAlgorithm encryptionAlgorithm) {
		this.encryptionAlgorithm = encryptionAlgorithm;
	}

	@Override
	public Packet decode(ByteBuffer buffer) {
		if (buffer.limit() <= 0) {
			return null;
		}

		int packetId = buffer.get() - (encryptionAlgorithm.nextInt() & 0xFF);

		int packetLength = getPacketLength(packetId, buffer);
		if(buffer.remaining() < packetLength) {
			return null;
		}

		byte[] packetData = new byte[packetLength];
		buffer.get(packetData);

		return new Packet(packetId, packetLength, packetData);
	}

	private int getPacketLength(int packetId, ByteBuffer buffer) {
		int possibleLength = ProtocolConstants.INCOMING_PACKET_LENGTHS[packetId];
		if (possibleLength == ProtocolConstants.PACKET_SIZE_BYTE) {
			return buffer.get() & 0xFF;
		} else if (possibleLength == ProtocolConstants.PACKET_SIZE_SHORT) {
			return buffer.getShort();
		}
		return possibleLength;
	}

}