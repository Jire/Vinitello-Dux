package dux.packet.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dux.packet.IPacketRepresentation;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BuildsPacket {
	public Class<? extends IPacketRepresentation> value();
}