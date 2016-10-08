package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class SerializedString
  implements SerializableString, Serializable
{
  protected transient String _jdkSerializeValue;
  protected char[] _quotedChars;
  protected byte[] _quotedUTF8Ref;
  protected byte[] _unquotedUTF8Ref;
  protected final String _value;
  
  public SerializedString(String paramString)
  {
    if (paramString == null) {
      throw new IllegalStateException("Null String illegal for SerializedString");
    }
    this._value = paramString;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    this._jdkSerializeValue = paramObjectInputStream.readUTF();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeUTF(this._value);
  }
  
  public int appendQuoted(char[] paramArrayOfChar, int paramInt)
  {
    char[] arrayOfChar2 = this._quotedChars;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = JsonStringEncoder.getInstance().quoteAsString(this._value);
      this._quotedChars = arrayOfChar1;
    }
    int i = arrayOfChar1.length;
    if (paramInt + i > paramArrayOfChar.length) {
      return -1;
    }
    System.arraycopy(arrayOfChar1, 0, paramArrayOfChar, paramInt, i);
    return i;
  }
  
  public int appendQuotedUTF8(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte2 = this._quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().quoteAsUTF8(this._value);
      this._quotedUTF8Ref = arrayOfByte1;
    }
    int i = arrayOfByte1.length;
    if (paramInt + i > paramArrayOfByte.length) {
      return -1;
    }
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, i);
    return i;
  }
  
  public int appendUnquoted(char[] paramArrayOfChar, int paramInt)
  {
    String str = this._value;
    int i = str.length();
    if (paramInt + i > paramArrayOfChar.length) {
      return -1;
    }
    str.getChars(0, i, paramArrayOfChar, paramInt);
    return i;
  }
  
  public int appendUnquotedUTF8(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte2 = this._unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().encodeAsUTF8(this._value);
      this._unquotedUTF8Ref = arrayOfByte1;
    }
    int i = arrayOfByte1.length;
    if (paramInt + i > paramArrayOfByte.length) {
      return -1;
    }
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, i);
    return i;
  }
  
  public final char[] asQuotedChars()
  {
    char[] arrayOfChar2 = this._quotedChars;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = JsonStringEncoder.getInstance().quoteAsString(this._value);
      this._quotedChars = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public final byte[] asQuotedUTF8()
  {
    byte[] arrayOfByte2 = this._quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().quoteAsUTF8(this._value);
      this._quotedUTF8Ref = arrayOfByte1;
    }
    return arrayOfByte1;
  }
  
  public final byte[] asUnquotedUTF8()
  {
    byte[] arrayOfByte2 = this._unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().encodeAsUTF8(this._value);
      this._unquotedUTF8Ref = arrayOfByte1;
    }
    return arrayOfByte1;
  }
  
  public final int charLength()
  {
    return this._value.length();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      return false;
    }
    paramObject = (SerializedString)paramObject;
    return this._value.equals(((SerializedString)paramObject)._value);
  }
  
  public final String getValue()
  {
    return this._value;
  }
  
  public final int hashCode()
  {
    return this._value.hashCode();
  }
  
  public int putQuotedUTF8(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte2 = this._quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().quoteAsUTF8(this._value);
      this._quotedUTF8Ref = arrayOfByte1;
    }
    int i = arrayOfByte1.length;
    if (i > paramByteBuffer.remaining()) {
      return -1;
    }
    paramByteBuffer.put(arrayOfByte1, 0, i);
    return i;
  }
  
  public int putUnquotedUTF8(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte2 = this._unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().encodeAsUTF8(this._value);
      this._unquotedUTF8Ref = arrayOfByte1;
    }
    int i = arrayOfByte1.length;
    if (i > paramByteBuffer.remaining()) {
      return -1;
    }
    paramByteBuffer.put(arrayOfByte1, 0, i);
    return i;
  }
  
  protected Object readResolve()
  {
    return new SerializedString(this._jdkSerializeValue);
  }
  
  public final String toString()
  {
    return this._value;
  }
  
  public int writeQuotedUTF8(OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte2 = this._quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().quoteAsUTF8(this._value);
      this._quotedUTF8Ref = arrayOfByte1;
    }
    int i = arrayOfByte1.length;
    paramOutputStream.write(arrayOfByte1, 0, i);
    return i;
  }
  
  public int writeUnquotedUTF8(OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte2 = this._unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().encodeAsUTF8(this._value);
      this._unquotedUTF8Ref = arrayOfByte1;
    }
    int i = arrayOfByte1.length;
    paramOutputStream.write(arrayOfByte1, 0, i);
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\io\SerializedString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */