package dux.network;

import java.nio.ByteBuffer;

import dux.packet.Packet;

public interface INetworkProtocolDecoder {

	public Packet decode(ByteBuffer buffer);

}