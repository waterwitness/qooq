package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

public final class MergedStream
  extends InputStream
{
  byte[] _buffer;
  protected final IOContext _context;
  final int _end;
  final InputStream _in;
  int _ptr;
  
  public MergedStream(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this._context = paramIOContext;
    this._in = paramInputStream;
    this._buffer = paramArrayOfByte;
    this._ptr = paramInt1;
    this._end = paramInt2;
  }
  
  private void freeMergedBuffer()
  {
    byte[] arrayOfByte = this._buffer;
    if (arrayOfByte != null)
    {
      this._buffer = null;
      if (this._context != null) {
        this._context.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  public int available()
    throws IOException
  {
    if (this._buffer != null) {
      return this._end - this._ptr;
    }
    return this._in.available();
  }
  
  public void close()
    throws IOException
  {
    freeMergedBuffer();
    this._in.close();
  }
  
  public void mark(int paramInt)
  {
    if (this._buffer == null) {
      this._in.mark(paramInt);
    }
  }
  
  public boolean markSupported()
  {
    return (this._buffer == null) && (this._in.markSupported());
  }
  
  public int read()
    throws IOException
  {
    if (this._buffer != null)
    {
      byte[] arrayOfByte = this._buffer;
      int i = this._ptr;
      this._ptr = (i + 1);
      i = arrayOfByte[i];
      if (this._ptr >= this._end) {
        freeMergedBuffer();
      }
      return i & 0xFF;
    }
    return this._in.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this._buffer != null)
    {
      int j = this._end - this._ptr;
      int i = paramInt2;
      if (paramInt2 > j) {
        i = j;
      }
      System.arraycopy(this._buffer, this._ptr, paramArrayOfByte, paramInt1, i);
      this._ptr += i;
      if (this._ptr >= this._end) {
        freeMergedBuffer();
      }
      return i;
    }
    return this._in.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
    throws IOException
  {
    if (this._buffer == null) {
      this._in.reset();
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l1 = 0L;
    long l2 = paramLong;
    if (this._buffer != null)
    {
      int i = this._end - this._ptr;
      if (i > paramLong)
      {
        this._ptr += (int)paramLong;
        return paramLong;
      }
      freeMergedBuffer();
      l1 = 0L + i;
      l2 = paramLong - i;
    }
    paramLong = l1;
    if (l2 > 0L) {
      paramLong = l1 + this._in.skip(l2);
    }
    return paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\io\MergedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */