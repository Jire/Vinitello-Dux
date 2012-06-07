package dux.packet;

public interface IPacketService extends IPacketBuilder, IPacketParser {

	public boolean registerBuilder(Class<? extends IPacketBuilder> builder);
	public boolean registerParser(Class<? extends IPacketParser> parser);

}