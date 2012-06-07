package dux.packet.base;

import java.util.HashMap;
import java.util.Map;

import dux.packet.IPacketBuilder;
import dux.packet.IPacketParser;
import dux.packet.IPacketRepresentation;
import dux.packet.IPacketService;
import dux.packet.Packet;
import dux.packet.annotate.BuildsPacket;
import dux.packet.annotate.ParsesPacket;

public abstract class BasePacketService implements IPacketService {

	private final Map<Class<? extends IPacketRepresentation>, IPacketBuilder> builders;
	private final Map<Integer, IPacketParser> parsers;

	protected BasePacketService(int initialRegistryCapacity) {
		builders = new HashMap<>(initialRegistryCapacity);
		parsers = new HashMap<>(initialRegistryCapacity);
	}

	@Override
	public Packet build(IPacketRepresentation packetRep) {
		IPacketBuilder builder = builders.get(packetRep.getClass());
		if (builder != null) {
			return builder.build(packetRep);
		}
		return null;
	}

	@Override
	public IPacketRepresentation parse(Packet packet) {
		IPacketParser parser = parsers.get(packet.getId());
		if (parser != null) {
			return parser.parse(packet);
		}
		return null;
	}

	@Override
	public boolean registerBuilder(Class<? extends IPacketBuilder> builder) {
		Object object = null;
		try {
			object = builder.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		BuildsPacket annotation = builder.getAnnotation(BuildsPacket.class);
		if (annotation != null) {
			builders.put(annotation.value(), (IPacketBuilder) object);
			return true;
		}
		return false;
	}

	@Override
	public boolean registerParser(Class<? extends IPacketParser> parser) {
		Object object = null;
		try {
			object = parser.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		ParsesPacket annotation = parser.getAnnotation(ParsesPacket.class);
		if (annotation != null) {
			for (int packetId : annotation.value()) {
				parsers.put(packetId, (IPacketParser) object);
			}
			return true;
		}
		return false;
	}

}