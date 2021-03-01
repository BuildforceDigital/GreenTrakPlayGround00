package nl.greentrak.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.UUID;

import org.apache.commons.lang3.ArrayUtils;

@Converter
public class UUIDAttributeBoxedConverter implements AttributeConverter<UUID, Byte[]> {

    @Override
    public Byte[] convertToDatabaseColumn(UUID uuid) {
        if (uuid == null) return null;
        byte[] buffer = new byte[16];
        ByteBuffer bb = ByteBuffer.wrap(buffer);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return ArrayUtils.toObject(buffer);
    }

    @Override
    public UUID convertToEntityAttribute(Byte[] bytes) {
        if (bytes == null) return null;
        System.out.println("Hier: " + Arrays.toString(bytes));

        byte[] toBeWrapped = ArrayUtils.toPrimitive(bytes);
        ByteBuffer bb = ByteBuffer.wrap(toBeWrapped);
        long high = bb.getLong();
        long low = bb.getLong();
        return new UUID(high, low);
    }

}