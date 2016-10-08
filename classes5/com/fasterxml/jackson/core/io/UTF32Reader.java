package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

public class UTF32Reader
  extends BaseReader
{
  protected final boolean _bigEndian;
  protected int _byteCount = 0;
  protected int _charCount = 0;
  protected final boolean _managedBuffers;
  protected char _surrogate = '\000';
  
  public UTF32Reader(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramIOContext, paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    this._bigEndian = paramBoolean;
    paramBoolean = bool;
    if (paramInputStream != null) {
      paramBoolean = true;
    }
    this._managedBuffers = paramBoolean;
  }
  
  private boolean loadMore(int paramInt)
    throws IOException
  {
    boolean bool = false;
    this._byteCount += this._length - paramInt;
    int i;
    if (paramInt > 0) {
      if (this._ptr > 0)
      {
        i = 0;
        if (i < paramInt) {
          break label57;
        }
        this._ptr = 0;
      }
    }
    for (this._length = paramInt;; this._length = paramInt)
    {
      if (this._length < 4) {
        break label149;
      }
      bool = true;
      return bool;
      label57:
      this._buffer[i] = this._buffer[(this._ptr + i)];
      i += 1;
      break;
      this._ptr = 0;
      if (this._in == null) {
        paramInt = -1;
      }
      for (;;)
      {
        if (paramInt < 1)
        {
          this._length = 0;
          if (paramInt < 0)
          {
            if (!this._managedBuffers) {
              break;
            }
            freeBuffers();
            return false;
            paramInt = this._in.read(this._buffer);
            continue;
          }
          reportStrangeStream();
        }
      }
    }
    label149:
    if (this._in == null) {}
    for (paramInt = -1;; paramInt = this._in.read(this._buffer, this._length, this._buffer.length - this._length))
    {
      if (paramInt < 1)
      {
        if (paramInt < 0)
        {
          if (this._managedBuffers) {
            freeBuffers();
          }
          reportUnexpectedEOF(this._length, 4);
        }
        reportStrangeStream();
      }
      this._length += paramInt;
      break;
    }
  }
  
  private void reportInvalid(int paramInt1, int paramInt2, String paramString)
    throws IOException
  {
    int i = this._byteCount;
    int j = this._ptr;
    int k = this._charCount;
    throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(paramInt1) + paramString + " at char #" + (k + paramInt2) + ", byte #" + (i + j - 1) + ")");
  }
  
  private void reportUnexpectedEOF(int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this._byteCount;
    int j = this._charCount;
    throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + paramInt1 + ", needed " + paramInt2 + ", at char #" + j + ", byte #" + (i + paramInt1) + ")");
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this._buffer == null) {
      return -1;
    }
    if (paramInt2 < 1) {
      return paramInt2;
    }
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
      reportBounds(paramArrayOfChar, paramInt1, paramInt2);
    }
    int m = paramInt2 + paramInt1;
    if (this._surrogate != 0)
    {
      paramInt2 = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = this._surrogate;
      this._surrogate = '\000';
      label63:
      if (paramInt2 < m) {
        break label113;
      }
    }
    for (;;)
    {
      paramInt1 = paramInt2 - paramInt1;
      this._charCount += paramInt1;
      return paramInt1;
      paramInt2 = this._length - this._ptr;
      if ((paramInt2 < 4) && (!loadMore(paramInt2))) {
        break;
      }
      paramInt2 = paramInt1;
      break label63;
      label113:
      int i = this._ptr;
      if (this._bigEndian) {}
      for (i = this._buffer[i] << 24 | (this._buffer[(i + 1)] & 0xFF) << 16 | (this._buffer[(i + 2)] & 0xFF) << 8 | this._buffer[(i + 3)] & 0xFF;; i = this._buffer[i] & 0xFF | (this._buffer[(i + 1)] & 0xFF) << 8 | (this._buffer[(i + 2)] & 0xFF) << 16 | this._buffer[(i + 3)] << 24)
      {
        this._ptr += 4;
        if (i <= 65535) {
          break label369;
        }
        if (i > 1114111) {
          reportInvalid(i, paramInt2 - paramInt1, "(above " + Integer.toHexString(1114111) + ") ");
        }
        j = i - 65536;
        i = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = ((char)(55296 + (j >> 10)));
        int k = 0xDC00 | j & 0x3FF;
        j = k;
        paramInt2 = i;
        if (i < m) {
          break label373;
        }
        this._surrogate = ((char)k);
        paramInt2 = i;
        break;
      }
      label369:
      int j = i;
      label373:
      i = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)j);
      paramInt2 = i;
      if (this._ptr < this._length) {
        break label63;
      }
      paramInt2 = i;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\io\UTF32Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */