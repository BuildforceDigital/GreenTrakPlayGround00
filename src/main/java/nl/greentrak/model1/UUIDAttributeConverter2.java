package nl.greentrak.model1;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.ArrayUtils;

import java.nio.ByteBuffer;
import java.util.UUID;

@Converter(autoApply = false)
public class UUIDAttributeConverter2 implements AttributeConverter<UUID, String> {

    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        return uuid.toString();
    };

    @Override
    public UUID convertToEntityAttribute(String bytes) {
        return UUID.fromString(bytes);
    }
}