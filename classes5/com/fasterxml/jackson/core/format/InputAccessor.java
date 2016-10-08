package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public abstract interface InputAccessor
{
  public abstract boolean hasMoreBytes()
    throws IOException;
  
  public abstract byte nextByte()
    throws IOException;
  
  public abstract void reset();
  
  public static class Std
    implements InputAccessor
  {
    protected final byte[] _buffer;
    protected int _bufferedEnd;
    protected final int _bufferedStart;
    protected final InputStream _in;
    protected int _ptr;
    
    public Std(InputStream paramInputStream, byte[] paramArrayOfByte)
    {
      this._in = paramInputStream;
      this._buffer = paramArrayOfByte;
      this._bufferedStart = 0;
      this._ptr = 0;
      this._bufferedEnd = 0;
    }
    
    public Std(byte[] paramArrayOfByte)
    {
      this._in = null;
      this._buffer = paramArrayOfByte;
      this._bufferedStart = 0;
      this._bufferedEnd = paramArrayOfByte.length;
    }
    
    public Std(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this._in = null;
      this._buffer = paramArrayOfByte;
      this._ptr = paramInt1;
      this._bufferedStart = paramInt1;
      this._bufferedEnd = (paramInt1 + paramInt2);
    }
    
    public DataFormatMatcher createMatcher(JsonFactory paramJsonFactory, MatchStrength paramMatchStrength)
    {
      return new DataFormatMatcher(this._in, this._buffer, this._bufferedStart, this._bufferedEnd - this._bufferedStart, paramJsonFactory, paramMatchStrength);
    }
    
    public boolean hasMoreBytes()
      throws IOException
    {
      if (this._ptr < this._bufferedEnd) {
        return true;
      }
      if (this._in == null) {
        return false;
      }
      int i = this._buffer.length - this._ptr;
      if (i < 1) {
        return false;
      }
      i = this._in.read(this._buffer, this._ptr, i);
      if (i <= 0) {
        return false;
      }
      this._bufferedEnd += i;
      return true;
    }
    
    public byte nextByte()
      throws IOException
    {
      if ((this._ptr >= this._bufferedEnd) && (!hasMoreBytes())) {
        throw new EOFException("Failed auto-detect: could not read more than " + this._ptr + " bytes (max buffer size: " + this._buffer.length + ")");
      }
      byte[] arrayOfByte = this._buffer;
      int i = this._ptr;
      this._ptr = (i + 1);
      return arrayOfByte[i];
    }
    
    public void reset()
    {
      this._ptr = this._bufferedStart;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\format\InputAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */