package nl.greentrak.model

import jakarta.persistence.{AttributeConverter, Converter}

import java.nio.ByteBuffer
import java.util.UUID
import java.lang.{Byte => jByte}

@Converter
class UUIDAttributeConverter2 extends AttributeConverter[UUID, Array[jByte]] {
  override def convertToDatabaseColumn(uuid: UUID): Array[jByte] =
    if (uuid != null) {
      val buffer = new Array[Byte](16)
      val bb = ByteBuffer.wrap(buffer)
      bb.putLong(uuid.getMostSignificantBits)
      bb.putLong(uuid.getLeastSignificantBits)
      buffer.asInstanceOf[Array[jByte]]
    } else null

  override def convertToEntityAttribute(bytes: Array[jByte]): UUID =
    if (bytes != null) {
      val bb: ByteBuffer = ByteBuffer.wrap(bytes.asInstanceOf[Array[Byte]])
      val high = bb.getLong
      new UUID(high, bb.getLong)
    } else null

}