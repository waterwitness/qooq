package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.BufferRecycler.ByteBufferType;
import com.fasterxml.jackson.core.util.BufferRecycler.CharBufferType;
import com.fasterxml.jackson.core.util.TextBuffer;

public final class IOContext
{
  protected byte[] _base64Buffer = null;
  protected final BufferRecycler _bufferRecycler;
  protected char[] _concatCBuffer = null;
  protected JsonEncoding _encoding;
  protected final boolean _managedResource;
  protected char[] _nameCopyBuffer = null;
  protected byte[] _readIOBuffer = null;
  protected final Object _sourceRef;
  protected char[] _tokenCBuffer = null;
  protected byte[] _writeEncodingBuffer = null;
  
  public IOContext(BufferRecycler paramBufferRecycler, Object paramObject, boolean paramBoolean)
  {
    this._bufferRecycler = paramBufferRecycler;
    this._sourceRef = paramObject;
    this._managedResource = paramBoolean;
  }
  
  private final void _verifyAlloc(Object paramObject)
  {
    if (paramObject != null) {
      throw new IllegalStateException("Trying to call same allocXxx() method second time");
    }
  }
  
  private final void _verifyRelease(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != paramObject2) {
      throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
  }
  
  public byte[] allocBase64Buffer()
  {
    _verifyAlloc(this._base64Buffer);
    byte[] arrayOfByte = this._bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.BASE64_CODEC_BUFFER);
    this._base64Buffer = arrayOfByte;
    return arrayOfByte;
  }
  
  public char[] allocConcatBuffer()
  {
    _verifyAlloc(this._concatCBuffer);
    char[] arrayOfChar = this._bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.CONCAT_BUFFER);
    this._concatCBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  public char[] allocNameCopyBuffer(int paramInt)
  {
    _verifyAlloc(this._nameCopyBuffer);
    char[] arrayOfChar = this._bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, paramInt);
    this._nameCopyBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  public byte[] allocReadIOBuffer()
  {
    _verifyAlloc(this._readIOBuffer);
    byte[] arrayOfByte = this._bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.READ_IO_BUFFER);
    this._readIOBuffer = arrayOfByte;
    return arrayOfByte;
  }
  
  public char[] allocTokenBuffer()
  {
    _verifyAlloc(this._tokenCBuffer);
    char[] arrayOfChar = this._bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.TOKEN_BUFFER);
    this._tokenCBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  public byte[] allocWriteEncodingBuffer()
  {
    _verifyAlloc(this._writeEncodingBuffer);
    byte[] arrayOfByte = this._bufferRecycler.allocByteBuffer(BufferRecycler.ByteBufferType.WRITE_ENCODING_BUFFER);
    this._writeEncodingBuffer = arrayOfByte;
    return arrayOfByte;
  }
  
  public TextBuffer constructTextBuffer()
  {
    return new TextBuffer(this._bufferRecycler);
  }
  
  public JsonEncoding getEncoding()
  {
    return this._encoding;
  }
  
  public Object getSourceReference()
  {
    return this._sourceRef;
  }
  
  public boolean isResourceManaged()
  {
    return this._managedResource;
  }
  
  public void releaseBase64Buffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _verifyRelease(paramArrayOfByte, this._base64Buffer);
      this._base64Buffer = null;
      this._bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.BASE64_CODEC_BUFFER, paramArrayOfByte);
    }
  }
  
  public void releaseConcatBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      _verifyRelease(paramArrayOfChar, this._concatCBuffer);
      this._concatCBuffer = null;
      this._bufferRecycler.releaseCharBuffer(BufferRecycler.CharBufferType.CONCAT_BUFFER, paramArrayOfChar);
    }
  }
  
  public void releaseNameCopyBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      _verifyRelease(paramArrayOfChar, this._nameCopyBuffer);
      this._nameCopyBuffer = null;
      this._bufferRecycler.releaseCharBuffer(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, paramArrayOfChar);
    }
  }
  
  public void releaseReadIOBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _verifyRelease(paramArrayOfByte, this._readIOBuffer);
      this._readIOBuffer = null;
      this._bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.READ_IO_BUFFER, paramArrayOfByte);
    }
  }
  
  public void releaseTokenBuffer(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar != null)
    {
      _verifyRelease(paramArrayOfChar, this._tokenCBuffer);
      this._tokenCBuffer = null;
      this._bufferRecycler.releaseCharBuffer(BufferRecycler.CharBufferType.TOKEN_BUFFER, paramArrayOfChar);
    }
  }
  
  public void releaseWriteEncodingBuffer(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      _verifyRelease(paramArrayOfByte, this._writeEncodingBuffer);
      this._writeEncodingBuffer = null;
      this._bufferRecycler.releaseByteBuffer(BufferRecycler.ByteBufferType.WRITE_ENCODING_BUFFER, paramArrayOfByte);
    }
  }
  
  public void setEncoding(JsonEncoding paramJsonEncoding)
  {
    this._encoding = paramJsonEncoding;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\io\IOContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */