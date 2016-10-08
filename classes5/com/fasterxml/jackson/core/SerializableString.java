package com.fasterxml.jackson.core;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public abstract interface SerializableString
{
  public abstract int appendQuoted(char[] paramArrayOfChar, int paramInt);
  
  public abstract int appendQuotedUTF8(byte[] paramArrayOfByte, int paramInt);
  
  public abstract int appendUnquoted(char[] paramArrayOfChar, int paramInt);
  
  public abstract int appendUnquotedUTF8(byte[] paramArrayOfByte, int paramInt);
  
  public abstract char[] asQuotedChars();
  
  public abstract byte[] asQuotedUTF8();
  
  public abstract byte[] asUnquotedUTF8();
  
  public abstract int charLength();
  
  public abstract String getValue();
  
  public abstract int putQuotedUTF8(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract int putUnquotedUTF8(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract int writeQuotedUTF8(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract int writeUnquotedUTF8(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\SerializableString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */