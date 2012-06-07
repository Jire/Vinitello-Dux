package dux.packet;

public interface IPacketParser {

	public IPacketRepresentation parse(Packet packet);

}