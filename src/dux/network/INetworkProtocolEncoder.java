package dux.network;

import java.nio.ByteBuffer;

import dux.packet.Packet;

public interface INetworkProtocolEncoder {

	public ByteBuffer encode(Packet packet);

}