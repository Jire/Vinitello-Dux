package dux.network.base;

import java.nio.ByteBuffer;

import dux.encryption.IEncryptionAlgorithm;
import dux.network.INetworkProtocolEncoder;
import dux.network.util.ProtocolConstants;
import dux.packet.Packet;

public abstract class BaseNetworkProtocolEncoder implements INetworkProtocolEncoder {

	private final IEncryptionAlgorithm encryptionAlgorithm;

	protected BaseNetworkProtocolEncoder(IEncryptionAlgorithm encryptionAlgorithm) {
		this.encryptionAlgorithm = encryptionAlgorithm;
	}

	@Override
	public ByteBuffer encode(Packet packet) {
		// Add three to account for possible ID and length bytes
		ByteBuffer buffer = ByteBuffer.allocate(packet.getLength() + 3);

		if (!packet.isHeadless()) {
			byte packetId = (byte) (packet.getId() + encryptionAlgorithm.nextInt());
			buffer.put(packetId);

			if (ProtocolConstants.OUTGOING_PACKET_SIZES[packet.getId()] == ProtocolConstants.PACKET_SIZE_BYTE) {
				buffer.put((byte) packet.getLength());
			} else if (ProtocolConstants.OUTGOING_PACKET_SIZES[packet.getId()] == ProtocolConstants.PACKET_SIZE_SHORT) {
				buffer.putShort((short) packet.getLength());
			}
		}

		buffer.put(packet.getData(), 0, packet.getLength());
		buffer.flip();
		return buffer;
	}

}