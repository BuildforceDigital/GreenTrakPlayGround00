package nl.greentrak.model

import jakarta.persistence.{AttributeConverter, Converter}

import java.nio.ByteBuffer
import java.util.UUID

@Converter
class UUIDAttributeConverter extends AttributeConverter[UUID, Array[Byte]] {
  override def convertToDatabaseColumn(uuid: UUID): Array[Byte] =
    if (uuid != null) {
      val buffer = new Array[Byte](16)
      val bb = ByteBuffer.wrap(buffer)
      bb.putLong(uuid.getMostSignificantBits)
      bb.putLong(uuid.getLeastSignificantBits)
      buffer
    } else null

  override def convertToEntityAttribute(bytes: Array[Byte]): UUID =
    if (bytes != null) {
      val bb = ByteBuffer.wrap(bytes)
      val high = bb.getLong
      new UUID(high, bb.getLong)
    } else null
}