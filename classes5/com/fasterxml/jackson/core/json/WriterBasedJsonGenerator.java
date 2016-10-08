package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class WriterBasedJsonGenerator
  extends JsonGeneratorImpl
{
  protected static final char[] HEX_CHARS = ;
  protected static final int SHORT_WRITE = 32;
  protected SerializableString _currentEscape;
  protected char[] _entityBuffer;
  protected char[] _outputBuffer;
  protected int _outputEnd;
  protected int _outputHead = 0;
  protected int _outputTail = 0;
  protected final Writer _writer;
  
  public WriterBasedJsonGenerator(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec, Writer paramWriter)
  {
    super(paramIOContext, paramInt, paramObjectCodec);
    this._writer = paramWriter;
    this._outputBuffer = paramIOContext.allocConcatBuffer();
    this._outputEnd = this._outputBuffer.length;
  }
  
  private char[] _allocateEntityBuffer()
  {
    char[] arrayOfChar = new char[14];
    arrayOfChar[0] = '\\';
    arrayOfChar[2] = '\\';
    arrayOfChar[3] = 'u';
    arrayOfChar[4] = '0';
    arrayOfChar[5] = '0';
    arrayOfChar[8] = '\\';
    arrayOfChar[9] = 'u';
    this._entityBuffer = arrayOfChar;
    return arrayOfChar;
  }
  
  private void _appendCharacterEscape(char paramChar, int paramInt)
    throws IOException, JsonGenerationException
  {
    Object localObject;
    if (paramInt >= 0)
    {
      if (this._outputTail + 2 > this._outputEnd) {
        _flushBuffer();
      }
      localObject = this._outputBuffer;
      paramChar = this._outputTail;
      this._outputTail = (paramChar + '\001');
      localObject[paramChar] = 92;
      localObject = this._outputBuffer;
      paramChar = this._outputTail;
      this._outputTail = (paramChar + '\001');
      localObject[paramChar] = ((char)paramInt);
      return;
    }
    if (paramInt != -2)
    {
      if (this._outputTail + 2 > this._outputEnd) {
        _flushBuffer();
      }
      paramInt = this._outputTail;
      localObject = this._outputBuffer;
      int i = paramInt + 1;
      localObject[paramInt] = 92;
      paramInt = i + 1;
      localObject[i] = 117;
      if (paramChar > 'ÿ')
      {
        i = paramChar >> '\b' & 0xFF;
        int j = paramInt + 1;
        localObject[paramInt] = HEX_CHARS[(i >> 4)];
        paramInt = j + 1;
        localObject[j] = HEX_CHARS[(i & 0xF)];
        paramChar = (char)(paramChar & 0xFF);
      }
      for (;;)
      {
        i = paramInt + 1;
        localObject[paramInt] = HEX_CHARS[(paramChar >> '\004')];
        localObject[i] = HEX_CHARS[(paramChar & 0xF)];
        this._outputTail = i;
        return;
        i = paramInt + 1;
        localObject[paramInt] = 48;
        paramInt = i + 1;
        localObject[i] = 48;
      }
    }
    if (this._currentEscape == null) {
      localObject = this._characterEscapes.getEscapeSequence(paramChar).getValue();
    }
    for (;;)
    {
      paramChar = ((String)localObject).length();
      if (this._outputTail + paramChar <= this._outputEnd) {
        break;
      }
      _flushBuffer();
      if (paramChar <= this._outputEnd) {
        break;
      }
      this._writer.write((String)localObject);
      return;
      localObject = this._currentEscape.getValue();
      this._currentEscape = null;
    }
    ((String)localObject).getChars(0, paramChar, this._outputBuffer, this._outputTail);
    this._outputTail += paramChar;
  }
  
  private int _prependOrWriteCharacterEscape(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3)
    throws IOException, JsonGenerationException
  {
    Object localObject;
    if (paramInt3 >= 0)
    {
      if ((paramInt1 > 1) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 2;
        paramArrayOfChar[paramInt1] = '\\';
        paramArrayOfChar[(paramInt1 + 1)] = ((char)paramInt3);
      }
      for (;;)
      {
        return paramInt1;
        localObject = this._entityBuffer;
        paramArrayOfChar = (char[])localObject;
        if (localObject == null) {
          paramArrayOfChar = _allocateEntityBuffer();
        }
        paramArrayOfChar[1] = ((char)paramInt3);
        this._writer.write(paramArrayOfChar, 0, 2);
      }
    }
    if (paramInt3 != -2)
    {
      if ((paramInt1 > 5) && (paramInt1 < paramInt2))
      {
        paramInt1 -= 6;
        paramInt2 = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = '\\';
        paramInt1 = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = 'u';
        if (paramChar > 'ÿ')
        {
          paramInt2 = paramChar >> '\b' & 0xFF;
          paramInt3 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = HEX_CHARS[(paramInt2 >> 4)];
          paramInt1 = paramInt3 + 1;
          paramArrayOfChar[paramInt3] = HEX_CHARS[(paramInt2 & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
          paramInt2 = paramInt1 + 1;
          paramArrayOfChar[paramInt1] = HEX_CHARS[(paramChar >> '\004')];
          paramArrayOfChar[paramInt2] = HEX_CHARS[(paramChar & 0xF)];
          paramInt1 = paramInt2 - 5;
        }
      }
      for (;;)
      {
        return paramInt1;
        paramInt2 = paramInt1 + 1;
        paramArrayOfChar[paramInt1] = '0';
        paramInt1 = paramInt2 + 1;
        paramArrayOfChar[paramInt2] = '0';
        break;
        localObject = this._entityBuffer;
        paramArrayOfChar = (char[])localObject;
        if (localObject == null) {
          paramArrayOfChar = _allocateEntityBuffer();
        }
        this._outputHead = this._outputTail;
        if (paramChar > 'ÿ')
        {
          paramInt2 = paramChar >> '\b' & 0xFF;
          paramChar &= 0xFF;
          paramArrayOfChar[10] = HEX_CHARS[(paramInt2 >> 4)];
          paramArrayOfChar[11] = HEX_CHARS[(paramInt2 & 0xF)];
          paramArrayOfChar[12] = HEX_CHARS[(paramChar >> '\004')];
          paramArrayOfChar[13] = HEX_CHARS[(paramChar & 0xF)];
          this._writer.write(paramArrayOfChar, 8, 6);
        }
        else
        {
          paramArrayOfChar[6] = HEX_CHARS[(paramChar >> '\004')];
          paramArrayOfChar[7] = HEX_CHARS[(paramChar & 0xF)];
          this._writer.write(paramArrayOfChar, 2, 6);
        }
      }
    }
    if (this._currentEscape == null)
    {
      localObject = this._characterEscapes.getEscapeSequence(paramChar).getValue();
      paramChar = ((String)localObject).length();
      if ((paramInt1 < paramChar) || (paramInt1 >= paramInt2)) {
        break label457;
      }
      paramInt1 -= paramChar;
      ((String)localObject).getChars(0, paramChar, paramArrayOfChar, paramInt1);
    }
    for (;;)
    {
      return paramInt1;
      localObject = this._currentEscape.getValue();
      this._currentEscape = null;
      break;
      label457:
      this._writer.write((String)localObject);
    }
  }
  
  private void _prependOrWriteCharacterEscape(char paramChar, int paramInt)
    throws IOException, JsonGenerationException
  {
    char[] arrayOfChar;
    Object localObject;
    if (paramInt >= 0)
    {
      if (this._outputTail >= 2)
      {
        paramChar = this._outputTail - 2;
        this._outputHead = paramChar;
        this._outputBuffer[paramChar] = '\\';
        this._outputBuffer[(paramChar + '\001')] = ((char)paramInt);
        return;
      }
      arrayOfChar = this._entityBuffer;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = _allocateEntityBuffer();
      }
      this._outputHead = this._outputTail;
      localObject[1] = ((char)paramInt);
      this._writer.write((char[])localObject, 0, 2);
      return;
    }
    if (paramInt != -2)
    {
      if (this._outputTail >= 6)
      {
        localObject = this._outputBuffer;
        paramInt = this._outputTail - 6;
        this._outputHead = paramInt;
        localObject[paramInt] = 92;
        paramInt += 1;
        localObject[paramInt] = 117;
        if (paramChar > 'ÿ')
        {
          int i = paramChar >> '\b' & 0xFF;
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(i >> 4)];
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(i & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
        }
        for (;;)
        {
          paramInt += 1;
          localObject[paramInt] = HEX_CHARS[(paramChar >> '\004')];
          localObject[(paramInt + 1)] = HEX_CHARS[(paramChar & 0xF)];
          return;
          paramInt += 1;
          localObject[paramInt] = 48;
          paramInt += 1;
          localObject[paramInt] = 48;
        }
      }
      arrayOfChar = this._entityBuffer;
      localObject = arrayOfChar;
      if (arrayOfChar == null) {
        localObject = _allocateEntityBuffer();
      }
      this._outputHead = this._outputTail;
      if (paramChar > 'ÿ')
      {
        paramInt = paramChar >> '\b' & 0xFF;
        paramChar &= 0xFF;
        localObject[10] = HEX_CHARS[(paramInt >> 4)];
        localObject[11] = HEX_CHARS[(paramInt & 0xF)];
        localObject[12] = HEX_CHARS[(paramChar >> '\004')];
        localObject[13] = HEX_CHARS[(paramChar & 0xF)];
        this._writer.write((char[])localObject, 8, 6);
        return;
      }
      localObject[6] = HEX_CHARS[(paramChar >> '\004')];
      localObject[7] = HEX_CHARS[(paramChar & 0xF)];
      this._writer.write((char[])localObject, 2, 6);
      return;
    }
    if (this._currentEscape == null) {
      localObject = this._characterEscapes.getEscapeSequence(paramChar).getValue();
    }
    for (;;)
    {
      paramChar = ((String)localObject).length();
      if (this._outputTail < paramChar) {
        break;
      }
      paramInt = this._outputTail - paramChar;
      this._outputHead = paramInt;
      ((String)localObject).getChars(0, paramChar, this._outputBuffer, paramInt);
      return;
      localObject = this._currentEscape.getValue();
      this._currentEscape = null;
    }
    this._outputHead = this._outputTail;
    this._writer.write((String)localObject);
  }
  
  private int _readMore(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    if (i >= paramInt2)
    {
      paramInt3 = Math.min(paramInt3, paramArrayOfByte.length);
      label25:
      paramInt2 = paramInt3 - paramInt1;
      if (paramInt2 != 0) {
        break label58;
      }
    }
    for (;;)
    {
      return paramInt1;
      paramArrayOfByte[paramInt1] = paramArrayOfByte[i];
      paramInt1 += 1;
      i += 1;
      break;
      label58:
      paramInt2 = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 < 0) {
        return paramInt1;
      }
      paramInt2 = paramInt1 + paramInt2;
      paramInt1 = paramInt2;
      if (paramInt2 < 3) {
        break label25;
      }
      paramInt1 = paramInt2;
    }
  }
  
  private void _writeLongString(String paramString)
    throws IOException, JsonGenerationException
  {
    _flushBuffer();
    int k = paramString.length();
    int i = 0;
    int j = this._outputEnd;
    if (i + j > k)
    {
      j = k - i;
      label30:
      paramString.getChars(i, i + j, this._outputBuffer, 0);
      if (this._characterEscapes == null) {
        break label71;
      }
      _writeSegmentCustom(j);
    }
    for (;;)
    {
      j = i + j;
      i = j;
      if (j < k) {
        break;
      }
      return;
      break label30;
      label71:
      if (this._maximumNonEscapedChar != 0) {
        _writeSegmentASCII(j, this._maximumNonEscapedChar);
      } else {
        _writeSegment(j);
      }
    }
  }
  
  private void _writeNull()
    throws IOException
  {
    if (this._outputTail + 4 >= this._outputEnd) {
      _flushBuffer();
    }
    int i = this._outputTail;
    char[] arrayOfChar = this._outputBuffer;
    arrayOfChar[i] = 'n';
    i += 1;
    arrayOfChar[i] = 'u';
    i += 1;
    arrayOfChar[i] = 'l';
    i += 1;
    arrayOfChar[i] = 'l';
    this._outputTail = (i + 1);
  }
  
  private void _writeQuotedInt(int paramInt)
    throws IOException
  {
    if (this._outputTail + 13 >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    this._outputTail = NumberOutput.outputInt(paramInt, this._outputBuffer, this._outputTail);
    arrayOfChar = this._outputBuffer;
    paramInt = this._outputTail;
    this._outputTail = (paramInt + 1);
    arrayOfChar[paramInt] = '"';
  }
  
  private void _writeQuotedLong(long paramLong)
    throws IOException
  {
    if (this._outputTail + 23 >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    this._outputTail = NumberOutput.outputLong(paramLong, this._outputBuffer, this._outputTail);
    arrayOfChar = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
  }
  
  private void _writeQuotedRaw(Object paramObject)
    throws IOException
  {
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    writeRaw(paramObject.toString());
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramObject = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramObject[i] = 34;
  }
  
  private void _writeQuotedShort(short paramShort)
    throws IOException
  {
    if (this._outputTail + 8 >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    this._outputTail = NumberOutput.outputInt(paramShort, this._outputBuffer, this._outputTail);
    arrayOfChar = this._outputBuffer;
    paramShort = this._outputTail;
    this._outputTail = (paramShort + 1);
    arrayOfChar[paramShort] = '"';
  }
  
  private void _writeSegment(int paramInt)
    throws IOException, JsonGenerationException
  {
    int[] arrayOfInt = this._outputEscapes;
    int n = arrayOfInt.length;
    int j = 0;
    int m = 0;
    int k = j;
    if (j >= paramInt) {
      label25:
      return;
    }
    label26:
    int i = this._outputBuffer[k];
    if ((i < n) && (arrayOfInt[i] != 0)) {}
    for (;;)
    {
      j = k - m;
      if (j > 0)
      {
        this._writer.write(this._outputBuffer, m, j);
        if (k >= paramInt) {
          break label25;
        }
      }
      j = k + 1;
      m = _prependOrWriteCharacterEscape(this._outputBuffer, j, paramInt, i, arrayOfInt[i]);
      break;
      j = k + 1;
      k = j;
      if (j < paramInt) {
        break label26;
      }
      k = j;
    }
  }
  
  private void _writeSegmentASCII(int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int[] arrayOfInt = this._outputEscapes;
    int i2 = Math.min(arrayOfInt.length, paramInt2 + 1);
    int m = 0;
    int j = 0;
    int n = 0;
    int k = m;
    int i1 = j;
    if (m >= paramInt1) {
      label40:
      return;
    }
    label41:
    int i = this._outputBuffer[k];
    if (i < i2)
    {
      m = arrayOfInt[i];
      j = m;
      if (m == 0) {
        break label147;
      }
      j = m;
    }
    for (;;)
    {
      m = k - n;
      if (m > 0)
      {
        this._writer.write(this._outputBuffer, n, m);
        if (k >= paramInt1) {
          break label40;
        }
      }
      m = k + 1;
      n = _prependOrWriteCharacterEscape(this._outputBuffer, m, paramInt1, i, j);
      break;
      j = i1;
      if (i > paramInt2)
      {
        j = -1;
      }
      else
      {
        label147:
        m = k + 1;
        k = m;
        i1 = j;
        if (m < paramInt1) {
          break label41;
        }
        k = m;
      }
    }
  }
  
  private void _writeSegmentCustom(int paramInt)
    throws IOException, JsonGenerationException
  {
    int[] arrayOfInt = this._outputEscapes;
    if (this._maximumNonEscapedChar < 1) {}
    int i3;
    CharacterEscapes localCharacterEscapes;
    int m;
    int j;
    int i1;
    int k;
    int i2;
    for (int n = 65535;; n = this._maximumNonEscapedChar)
    {
      i3 = Math.min(arrayOfInt.length, n + 1);
      localCharacterEscapes = this._characterEscapes;
      m = 0;
      j = 0;
      i1 = 0;
      k = m;
      i2 = j;
      if (m < paramInt) {
        break;
      }
      label57:
      return;
    }
    label67:
    int i = this._outputBuffer[k];
    if (i < i3)
    {
      m = arrayOfInt[i];
      j = m;
      if (m == 0) {
        break label199;
      }
      j = m;
    }
    for (;;)
    {
      m = k - i1;
      if (m > 0)
      {
        this._writer.write(this._outputBuffer, i1, m);
        if (k >= paramInt) {
          break label57;
        }
      }
      m = k + 1;
      i1 = _prependOrWriteCharacterEscape(this._outputBuffer, m, paramInt, i, j);
      break;
      if (i > n)
      {
        j = -1;
      }
      else
      {
        SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
        this._currentEscape = localSerializableString;
        j = i2;
        if (localSerializableString != null)
        {
          j = -2;
        }
        else
        {
          label199:
          m = k + 1;
          k = m;
          i2 = j;
          if (m < paramInt) {
            break label67;
          }
          k = m;
        }
      }
    }
  }
  
  private void _writeString(String paramString)
    throws IOException, JsonGenerationException
  {
    int i = paramString.length();
    if (i > this._outputEnd)
    {
      _writeLongString(paramString);
      return;
    }
    if (this._outputTail + i > this._outputEnd) {
      _flushBuffer();
    }
    paramString.getChars(0, i, this._outputBuffer, this._outputTail);
    if (this._characterEscapes != null)
    {
      _writeStringCustom(i);
      return;
    }
    if (this._maximumNonEscapedChar != 0)
    {
      _writeStringASCII(i, this._maximumNonEscapedChar);
      return;
    }
    _writeString2(i);
  }
  
  private void _writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if (this._characterEscapes != null) {
      _writeStringCustom(paramArrayOfChar, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      if (this._maximumNonEscapedChar != 0)
      {
        _writeStringASCII(paramArrayOfChar, paramInt1, paramInt2, this._maximumNonEscapedChar);
        return;
      }
      int j = paramInt2 + paramInt1;
      int[] arrayOfInt = this._outputEscapes;
      int k = arrayOfInt.length;
      while (paramInt1 < j)
      {
        paramInt2 = paramInt1;
        int i = paramArrayOfChar[paramInt2];
        if ((i < k) && (arrayOfInt[i] != 0))
        {
          label78:
          i = paramInt2 - paramInt1;
          if (i >= 32) {
            break label167;
          }
          if (this._outputTail + i > this._outputEnd) {
            _flushBuffer();
          }
          if (i > 0)
          {
            System.arraycopy(paramArrayOfChar, paramInt1, this._outputBuffer, this._outputTail, i);
            this._outputTail += i;
          }
        }
        for (;;)
        {
          if (paramInt2 < j) {
            break label185;
          }
          return;
          i = paramInt2 + 1;
          paramInt2 = i;
          if (i < j) {
            break;
          }
          paramInt2 = i;
          break label78;
          label167:
          _flushBuffer();
          this._writer.write(paramArrayOfChar, paramInt1, i);
        }
        label185:
        paramInt1 = paramInt2 + 1;
        char c = paramArrayOfChar[paramInt2];
        _appendCharacterEscape(c, arrayOfInt[c]);
      }
    }
  }
  
  private void _writeString2(int paramInt)
    throws IOException, JsonGenerationException
  {
    paramInt = this._outputTail + paramInt;
    int[] arrayOfInt = this._outputEscapes;
    int i = arrayOfInt.length;
    if (this._outputTail >= paramInt) {
      return;
    }
    int j;
    do
    {
      j = this._outputBuffer[this._outputTail];
      if ((j < i) && (arrayOfInt[j] != 0))
      {
        j = this._outputTail - this._outputHead;
        if (j > 0) {
          this._writer.write(this._outputBuffer, this._outputHead, j);
        }
        char[] arrayOfChar = this._outputBuffer;
        j = this._outputTail;
        this._outputTail = (j + 1);
        char c = arrayOfChar[j];
        _prependOrWriteCharacterEscape(c, arrayOfInt[c]);
        break;
      }
      j = this._outputTail + 1;
      this._outputTail = j;
    } while (j < paramInt);
  }
  
  private void _writeStringASCII(int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int j = this._outputTail + paramInt1;
    int[] arrayOfInt = this._outputEscapes;
    int k = Math.min(arrayOfInt.length, paramInt2 + 1);
    if (this._outputTail >= j) {
      return;
    }
    label122:
    do
    {
      int i = this._outputBuffer[this._outputTail];
      if (i < k)
      {
        paramInt1 = arrayOfInt[i];
        if (paramInt1 == 0) {}
      }
      else
      {
        for (;;)
        {
          int m = this._outputTail - this._outputHead;
          if (m > 0) {
            this._writer.write(this._outputBuffer, this._outputHead, m);
          }
          this._outputTail += 1;
          _prependOrWriteCharacterEscape(i, paramInt1);
          break;
          if (i <= paramInt2) {
            break label122;
          }
          paramInt1 = -1;
        }
      }
      paramInt1 = this._outputTail + 1;
      this._outputTail = paramInt1;
    } while (paramInt1 < j);
  }
  
  private void _writeStringASCII(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    throws IOException, JsonGenerationException
  {
    int n = paramInt2 + paramInt1;
    int[] arrayOfInt = this._outputEscapes;
    int i1 = Math.min(arrayOfInt.length, paramInt3 + 1);
    int j = 0;
    paramInt2 = paramInt1;
    paramInt1 = j;
    if (paramInt2 >= n) {}
    label44:
    label75:
    label174:
    label201:
    label217:
    for (;;)
    {
      return;
      j = paramInt2;
      int k = paramInt1;
      int i = paramArrayOfChar[j];
      if (i < i1)
      {
        k = arrayOfInt[i];
        paramInt1 = k;
        if (k == 0) {
          break label174;
        }
        paramInt1 = k;
        k = j - paramInt2;
        if (k >= 32) {
          break label201;
        }
        if (this._outputTail + k > this._outputEnd) {
          _flushBuffer();
        }
        if (k > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt2, this._outputBuffer, this._outputTail, k);
          this._outputTail += k;
        }
      }
      for (;;)
      {
        if (j >= n) {
          break label217;
        }
        paramInt2 = j + 1;
        _appendCharacterEscape(i, paramInt1);
        break;
        paramInt1 = k;
        if (i > paramInt3)
        {
          paramInt1 = -1;
          break label75;
        }
        int m = j + 1;
        k = paramInt1;
        j = m;
        if (m < n) {
          break label44;
        }
        j = m;
        break label75;
        _flushBuffer();
        this._writer.write(paramArrayOfChar, paramInt2, k);
      }
    }
  }
  
  private void _writeStringCustom(int paramInt)
    throws IOException, JsonGenerationException
  {
    int k = this._outputTail + paramInt;
    int[] arrayOfInt = this._outputEscapes;
    if (this._maximumNonEscapedChar < 1) {}
    int m;
    CharacterEscapes localCharacterEscapes;
    for (int j = 65535;; j = this._maximumNonEscapedChar)
    {
      m = Math.min(arrayOfInt.length, j + 1);
      localCharacterEscapes = this._characterEscapes;
      if (this._outputTail < k) {
        break;
      }
      return;
    }
    label173:
    do
    {
      int i = this._outputBuffer[this._outputTail];
      if (i < m)
      {
        paramInt = arrayOfInt[i];
        if (paramInt == 0) {}
      }
      else
      {
        for (;;)
        {
          int n = this._outputTail - this._outputHead;
          if (n > 0) {
            this._writer.write(this._outputBuffer, this._outputHead, n);
          }
          this._outputTail += 1;
          _prependOrWriteCharacterEscape(i, paramInt);
          break;
          if (i > j)
          {
            paramInt = -1;
          }
          else
          {
            SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
            this._currentEscape = localSerializableString;
            if (localSerializableString == null) {
              break label173;
            }
            paramInt = -2;
          }
        }
      }
      paramInt = this._outputTail + 1;
      this._outputTail = paramInt;
    } while (paramInt < k);
  }
  
  private void _writeStringCustom(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int i1 = paramInt2 + paramInt1;
    int[] arrayOfInt = this._outputEscapes;
    int k;
    int i2;
    CharacterEscapes localCharacterEscapes;
    int j;
    if (this._maximumNonEscapedChar < 1)
    {
      k = 65535;
      i2 = Math.min(arrayOfInt.length, k + 1);
      localCharacterEscapes = this._characterEscapes;
      j = 0;
      paramInt2 = paramInt1;
      paramInt1 = j;
      if (paramInt2 < i1) {
        break label65;
      }
    }
    label65:
    label71:
    label102:
    label227:
    label254:
    label270:
    for (;;)
    {
      return;
      k = this._maximumNonEscapedChar;
      break;
      j = paramInt2;
      int m = paramInt1;
      int i = paramArrayOfChar[j];
      if (i < i2)
      {
        m = arrayOfInt[i];
        paramInt1 = m;
        if (m == 0) {
          break label227;
        }
        paramInt1 = m;
        m = j - paramInt2;
        if (m >= 32) {
          break label254;
        }
        if (this._outputTail + m > this._outputEnd) {
          _flushBuffer();
        }
        if (m > 0)
        {
          System.arraycopy(paramArrayOfChar, paramInt2, this._outputBuffer, this._outputTail, m);
          this._outputTail += m;
        }
      }
      for (;;)
      {
        if (j >= i1) {
          break label270;
        }
        paramInt2 = j + 1;
        _appendCharacterEscape(i, paramInt1);
        break;
        if (i > k)
        {
          paramInt1 = -1;
          break label102;
        }
        SerializableString localSerializableString = localCharacterEscapes.getEscapeSequence(i);
        this._currentEscape = localSerializableString;
        paramInt1 = m;
        if (localSerializableString != null)
        {
          paramInt1 = -2;
          break label102;
        }
        int n = j + 1;
        m = paramInt1;
        j = n;
        if (n < i1) {
          break label71;
        }
        j = n;
        break label102;
        _flushBuffer();
        this._writer.write(paramArrayOfChar, paramInt2, m);
      }
    }
  }
  
  private void writeRawLong(String paramString)
    throws IOException, JsonGenerationException
  {
    int i = this._outputEnd - this._outputTail;
    paramString.getChars(0, i, this._outputBuffer, this._outputTail);
    this._outputTail += i;
    _flushBuffer();
    int j = i;
    i = paramString.length() - i;
    for (;;)
    {
      if (i <= this._outputEnd)
      {
        paramString.getChars(j, j + i, this._outputBuffer, 0);
        this._outputHead = 0;
        this._outputTail = i;
        return;
      }
      int k = this._outputEnd;
      paramString.getChars(j, j + k, this._outputBuffer, 0);
      this._outputHead = 0;
      this._outputTail = k;
      _flushBuffer();
      j += k;
      i -= k;
    }
  }
  
  protected void _flushBuffer()
    throws IOException
  {
    int i = this._outputTail - this._outputHead;
    if (i > 0)
    {
      int j = this._outputHead;
      this._outputHead = 0;
      this._outputTail = 0;
      this._writer.write(this._outputBuffer, j, i);
    }
  }
  
  protected void _releaseBuffers()
  {
    char[] arrayOfChar = this._outputBuffer;
    if (arrayOfChar != null)
    {
      this._outputBuffer = null;
      this._ioContext.releaseConcatBuffer(arrayOfChar);
    }
  }
  
  protected void _verifyPrettyValueWrite(String paramString, int paramInt)
    throws IOException, JsonGenerationException
  {
    switch (paramInt)
    {
    default: 
      _throwInternal();
    }
    do
    {
      return;
      this._cfgPrettyPrinter.writeArrayValueSeparator(this);
      return;
      this._cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
      return;
      this._cfgPrettyPrinter.writeRootValueSeparator(this);
      return;
      if (this._writeContext.inArray())
      {
        this._cfgPrettyPrinter.beforeArrayValues(this);
        return;
      }
    } while (!this._writeContext.inObject());
    this._cfgPrettyPrinter.beforeObjectEntries(this);
  }
  
  protected void _verifyValueWrite(String paramString)
    throws IOException, JsonGenerationException
  {
    int j = this._writeContext.writeValue();
    if (j == 5) {
      _reportError("Can not " + paramString + ", expecting field name");
    }
    if (this._cfgPrettyPrinter == null)
    {
      switch (j)
      {
      }
      do
      {
        return;
        for (int i = 44;; i = 58)
        {
          if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
          }
          this._outputBuffer[this._outputTail] = i;
          this._outputTail += 1;
          return;
        }
      } while (this._rootValueSeparator == null);
      writeRaw(this._rootValueSeparator.getValue());
      return;
    }
    _verifyPrettyValueWrite(paramString, j);
  }
  
  protected int _writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException, JsonGenerationException
  {
    int i = 0;
    int i1 = 0;
    int i2 = -3;
    int j = 0;
    int i4 = this._outputEnd - 6;
    int k = paramBase64Variant.getMaxLineLength() >> 2;
    for (;;)
    {
      int i3 = i;
      int n = i1;
      int m = i2;
      if (i > i2)
      {
        n = _readMore(paramInputStream, paramArrayOfByte, i, i1, paramArrayOfByte.length);
        i3 = 0;
        if (n < 3)
        {
          i = j;
          if (n < 0)
          {
            if (this._outputTail > i4) {
              _flushBuffer();
            }
            i1 = 0 + 1;
            m = paramArrayOfByte[0] << 16;
            k = 1;
            i = m;
            if (i1 < n)
            {
              i = m | (paramArrayOfByte[i1] & 0xFF) << 8;
              k = 2;
            }
            j += k;
            this._outputTail = paramBase64Variant.encodeBase64Partial(i, k, this._outputBuffer, this._outputTail);
            i = j;
          }
          return i;
        }
        m = n - 3;
      }
      if (this._outputTail > i4) {
        _flushBuffer();
      }
      i = i3 + 1;
      i1 = paramArrayOfByte[i3];
      i3 = i + 1;
      i2 = paramArrayOfByte[i];
      i = i3 + 1;
      i3 = paramArrayOfByte[i3];
      j += 3;
      this._outputTail = paramBase64Variant.encodeBase64Chunk((i1 << 8 | i2 & 0xFF) << 8 | i3 & 0xFF, this._outputBuffer, this._outputTail);
      k -= 1;
      if (k <= 0)
      {
        char[] arrayOfChar = this._outputBuffer;
        k = this._outputTail;
        this._outputTail = (k + 1);
        arrayOfChar[k] = '\\';
        arrayOfChar = this._outputBuffer;
        k = this._outputTail;
        this._outputTail = (k + 1);
        arrayOfChar[k] = 'n';
        k = paramBase64Variant.getMaxLineLength() >> 2;
        i1 = n;
        i2 = m;
      }
      else
      {
        i1 = n;
        i2 = m;
      }
    }
  }
  
  protected int _writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
    throws IOException, JsonGenerationException
  {
    int m = 0;
    int k = 0;
    int i1 = -3;
    int i3 = this._outputEnd - 6;
    int j = paramBase64Variant.getMaxLineLength() >> 2;
    int i = paramInt;
    paramInt = m;
    for (;;)
    {
      if (i <= 2)
      {
        label41:
        j = i;
        if (i > 0)
        {
          paramInt = _readMore(paramInputStream, paramArrayOfByte, paramInt, k, i);
          j = i;
          if (paramInt > 0)
          {
            if (this._outputTail > i3) {
              _flushBuffer();
            }
            k = 0 + 1;
            j = paramArrayOfByte[0] << 16;
            if (k >= paramInt) {
              break label387;
            }
            j |= (paramArrayOfByte[k] & 0xFF) << 8;
          }
        }
      }
      int n;
      label387:
      for (paramInt = 2;; paramInt = 1)
      {
        this._outputTail = paramBase64Variant.encodeBase64Partial(j, paramInt, this._outputBuffer, this._outputTail);
        j = i - paramInt;
        return j;
        int i2 = paramInt;
        n = k;
        m = i1;
        if (paramInt > i1)
        {
          n = _readMore(paramInputStream, paramArrayOfByte, paramInt, k, i);
          i2 = 0;
          paramInt = 0;
          k = n;
          if (n < 3) {
            break label41;
          }
          m = n - 3;
        }
        if (this._outputTail > i3) {
          _flushBuffer();
        }
        paramInt = i2 + 1;
        k = paramArrayOfByte[i2];
        i2 = paramInt + 1;
        i1 = paramArrayOfByte[paramInt];
        paramInt = i2 + 1;
        i2 = paramArrayOfByte[i2];
        i -= 3;
        this._outputTail = paramBase64Variant.encodeBase64Chunk((k << 8 | i1 & 0xFF) << 8 | i2 & 0xFF, this._outputBuffer, this._outputTail);
        j -= 1;
        if (j > 0) {
          break label393;
        }
        char[] arrayOfChar = this._outputBuffer;
        j = this._outputTail;
        this._outputTail = (j + 1);
        arrayOfChar[j] = '\\';
        arrayOfChar = this._outputBuffer;
        j = this._outputTail;
        this._outputTail = (j + 1);
        arrayOfChar[j] = 'n';
        j = paramBase64Variant.getMaxLineLength() >> 2;
        k = n;
        i1 = m;
        break;
      }
      label393:
      k = n;
      i1 = m;
    }
  }
  
  protected void _writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int k = this._outputEnd - 6;
    int j = paramBase64Variant.getMaxLineLength() >> 2;
    int i = paramInt1;
    paramInt1 = j;
    label266:
    for (;;)
    {
      if (i > paramInt2 - 3)
      {
        j = paramInt2 - i;
        if (j > 0)
        {
          if (this._outputTail > k) {
            _flushBuffer();
          }
          k = i + 1;
          paramInt2 = paramArrayOfByte[i] << 16;
          paramInt1 = paramInt2;
          if (j == 2) {
            paramInt1 = paramInt2 | (paramArrayOfByte[k] & 0xFF) << 8;
          }
          this._outputTail = paramBase64Variant.encodeBase64Partial(paramInt1, j, this._outputBuffer, this._outputTail);
        }
      }
      else
      {
        if (this._outputTail > k) {
          _flushBuffer();
        }
        int n = i + 1;
        j = paramArrayOfByte[i];
        int m = n + 1;
        n = paramArrayOfByte[n];
        i = m + 1;
        this._outputTail = paramBase64Variant.encodeBase64Chunk((j << 8 | n & 0xFF) << 8 | paramArrayOfByte[m] & 0xFF, this._outputBuffer, this._outputTail);
        paramInt1 -= 1;
        if (paramInt1 > 0) {
          break label266;
        }
        char[] arrayOfChar = this._outputBuffer;
        paramInt1 = this._outputTail;
        this._outputTail = (paramInt1 + 1);
        arrayOfChar[paramInt1] = '\\';
        arrayOfChar = this._outputBuffer;
        paramInt1 = this._outputTail;
        this._outputTail = (paramInt1 + 1);
        arrayOfChar[paramInt1] = 'n';
        paramInt1 = paramBase64Variant.getMaxLineLength() >> 2;
        continue;
      }
      return;
    }
  }
  
  public void _writeFieldName(SerializableString paramSerializableString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (this._cfgPrettyPrinter != null)
    {
      _writePPFieldName(paramSerializableString, paramBoolean);
      return;
    }
    if (this._outputTail + 1 >= this._outputEnd) {
      _flushBuffer();
    }
    if (paramBoolean)
    {
      arrayOfChar = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = ',';
    }
    paramSerializableString = paramSerializableString.asQuotedChars();
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      writeRaw(paramSerializableString, 0, paramSerializableString.length);
      return;
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    i = paramSerializableString.length;
    if (this._outputTail + i + 1 >= this._outputEnd)
    {
      writeRaw(paramSerializableString, 0, i);
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
    }
    System.arraycopy(paramSerializableString, 0, this._outputBuffer, this._outputTail, i);
    this._outputTail += i;
    paramSerializableString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramSerializableString[i] = 34;
  }
  
  protected void _writeFieldName(String paramString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (this._cfgPrettyPrinter != null)
    {
      _writePPFieldName(paramString, paramBoolean);
      return;
    }
    if (this._outputTail + 1 >= this._outputEnd) {
      _flushBuffer();
    }
    if (paramBoolean)
    {
      arrayOfChar = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = ',';
    }
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      _writeString(paramString);
      return;
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramString);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  protected void _writePPFieldName(SerializableString paramSerializableString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (paramBoolean) {
      this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
    }
    for (;;)
    {
      paramSerializableString = paramSerializableString.asQuotedChars();
      if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
        break;
      }
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = this._outputBuffer;
      int i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = '"';
      writeRaw(paramSerializableString, 0, paramSerializableString.length);
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
      this._cfgPrettyPrinter.beforeObjectEntries(this);
    }
    writeRaw(paramSerializableString, 0, paramSerializableString.length);
  }
  
  protected void _writePPFieldName(String paramString, boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    if (paramBoolean) {
      this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
    }
    while (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = this._outputBuffer;
      int i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = '"';
      _writeString(paramString);
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramString[i] = 34;
      return;
      this._cfgPrettyPrinter.beforeObjectEntries(this);
    }
    _writeString(paramString);
  }
  
  public void close()
    throws IOException
  {
    super.close();
    if ((this._outputBuffer != null) && (isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT))) {
      for (;;)
      {
        JsonWriteContext localJsonWriteContext = getOutputContext();
        if (localJsonWriteContext.inArray())
        {
          writeEndArray();
        }
        else
        {
          if (!localJsonWriteContext.inObject()) {
            break;
          }
          writeEndObject();
        }
      }
    }
    _flushBuffer();
    if (this._writer != null)
    {
      if ((!this._ioContext.isResourceManaged()) && (!isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET))) {
        break label97;
      }
      this._writer.close();
    }
    for (;;)
    {
      _releaseBuffers();
      return;
      label97:
      if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
        this._writer.flush();
      }
    }
  }
  
  public void flush()
    throws IOException
  {
    _flushBuffer();
    if ((this._writer != null) && (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      this._writer.flush();
    }
  }
  
  public Object getOutputTarget()
  {
    return this._writer;
  }
  
  public int writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, int paramInt)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write binary value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    localObject = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    localObject[i] = 34;
    localObject = this._ioContext.allocBase64Buffer();
    if (paramInt < 0) {}
    for (;;)
    {
      try
      {
        paramInt = _writeBinary(paramBase64Variant, paramInputStream, (byte[])localObject);
        this._ioContext.releaseBase64Buffer((byte[])localObject);
        if (this._outputTail >= this._outputEnd) {
          _flushBuffer();
        }
        paramBase64Variant = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = (i + 1);
        paramBase64Variant[i] = 34;
        return paramInt;
      }
      finally
      {
        this._ioContext.releaseBase64Buffer((byte[])localObject);
      }
      i = _writeBinary(paramBase64Variant, paramInputStream, (byte[])localObject, paramInt);
      if (i > 0) {
        _reportError("Too few bytes available: missing " + i + " bytes (out of " + paramInt + ")");
      }
    }
  }
  
  public void writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write binary value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeBinary(paramBase64Variant, paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramBase64Variant = this._outputBuffer;
    paramInt1 = this._outputTail;
    this._outputTail = (paramInt1 + 1);
    paramBase64Variant[paramInt1] = 34;
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write boolean value");
    if (this._outputTail + 5 >= this._outputEnd) {
      _flushBuffer();
    }
    int i = this._outputTail;
    char[] arrayOfChar = this._outputBuffer;
    if (paramBoolean)
    {
      arrayOfChar[i] = 't';
      i += 1;
      arrayOfChar[i] = 'r';
      i += 1;
      arrayOfChar[i] = 'u';
      i += 1;
      arrayOfChar[i] = 'e';
    }
    for (;;)
    {
      this._outputTail = (i + 1);
      return;
      arrayOfChar[i] = 'f';
      i += 1;
      arrayOfChar[i] = 'a';
      i += 1;
      arrayOfChar[i] = 'l';
      i += 1;
      arrayOfChar[i] = 's';
      i += 1;
      arrayOfChar[i] = 'e';
    }
  }
  
  public void writeEndArray()
    throws IOException, JsonGenerationException
  {
    if (!this._writeContext.inArray()) {
      _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
    }
    if (this._cfgPrettyPrinter != null) {
      this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
    }
    for (;;)
    {
      this._writeContext = this._writeContext.getParent();
      return;
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = this._outputBuffer;
      int i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = ']';
    }
  }
  
  public void writeEndObject()
    throws IOException, JsonGenerationException
  {
    if (!this._writeContext.inObject()) {
      _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
    }
    if (this._cfgPrettyPrinter != null) {
      this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
    }
    for (;;)
    {
      this._writeContext = this._writeContext.getParent();
      return;
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      char[] arrayOfChar = this._outputBuffer;
      int i = this._outputTail;
      this._outputTail = (i + 1);
      arrayOfChar[i] = '}';
    }
  }
  
  public void writeFieldName(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    boolean bool = true;
    int i = this._writeContext.writeFieldName(paramSerializableString.getValue());
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (i == 1) {}
    for (;;)
    {
      _writeFieldName(paramSerializableString, bool);
      return;
      bool = false;
    }
  }
  
  public void writeFieldName(String paramString)
    throws IOException, JsonGenerationException
  {
    boolean bool = true;
    int i = this._writeContext.writeFieldName(paramString);
    if (i == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (i == 1) {}
    for (;;)
    {
      _writeFieldName(paramString, bool);
      return;
      bool = false;
    }
  }
  
  public void writeNull()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write null value");
    _writeNull();
  }
  
  public void writeNumber(double paramDouble)
    throws IOException, JsonGenerationException
  {
    if ((this._cfgNumbersAsStrings) || (((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) && (isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      writeString(String.valueOf(paramDouble));
      return;
    }
    _verifyValueWrite("write number");
    writeRaw(String.valueOf(paramDouble));
  }
  
  public void writeNumber(float paramFloat)
    throws IOException, JsonGenerationException
  {
    if ((this._cfgNumbersAsStrings) || (((Float.isNaN(paramFloat)) || (Float.isInfinite(paramFloat))) && (isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      writeString(String.valueOf(paramFloat));
      return;
    }
    _verifyValueWrite("write number");
    writeRaw(String.valueOf(paramFloat));
  }
  
  public void writeNumber(int paramInt)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedInt(paramInt);
      return;
    }
    if (this._outputTail + 11 >= this._outputEnd) {
      _flushBuffer();
    }
    this._outputTail = NumberOutput.outputInt(paramInt, this._outputBuffer, this._outputTail);
  }
  
  public void writeNumber(long paramLong)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedLong(paramLong);
      return;
    }
    if (this._outputTail + 21 >= this._outputEnd) {
      _flushBuffer();
    }
    this._outputTail = NumberOutput.outputLong(paramLong, this._outputBuffer, this._outputTail);
  }
  
  public void writeNumber(String paramString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramString);
      return;
    }
    writeRaw(paramString);
  }
  
  public void writeNumber(BigDecimal paramBigDecimal)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (paramBigDecimal == null)
    {
      _writeNull();
      return;
    }
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramBigDecimal);
      return;
    }
    writeRaw(paramBigDecimal.toString());
  }
  
  public void writeNumber(BigInteger paramBigInteger)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (paramBigInteger == null)
    {
      _writeNull();
      return;
    }
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedRaw(paramBigInteger);
      return;
    }
    writeRaw(paramBigInteger.toString());
  }
  
  public void writeNumber(short paramShort)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write number");
    if (this._cfgNumbersAsStrings)
    {
      _writeQuotedShort(paramShort);
      return;
    }
    if (this._outputTail + 6 >= this._outputEnd) {
      _flushBuffer();
    }
    this._outputTail = NumberOutput.outputInt(paramShort, this._outputBuffer, this._outputTail);
  }
  
  public void writeRaw(char paramChar)
    throws IOException, JsonGenerationException
  {
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = paramChar;
  }
  
  public void writeRaw(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    writeRaw(paramSerializableString.getValue());
  }
  
  public void writeRaw(String paramString)
    throws IOException, JsonGenerationException
  {
    int k = paramString.length();
    int j = this._outputEnd - this._outputTail;
    int i = j;
    if (j == 0)
    {
      _flushBuffer();
      i = this._outputEnd - this._outputTail;
    }
    if (i >= k)
    {
      paramString.getChars(0, k, this._outputBuffer, this._outputTail);
      this._outputTail += k;
      return;
    }
    writeRawLong(paramString);
  }
  
  public void writeRaw(String paramString, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    int j = this._outputEnd - this._outputTail;
    int i = j;
    if (j < paramInt2)
    {
      _flushBuffer();
      i = this._outputEnd - this._outputTail;
    }
    if (i >= paramInt2)
    {
      paramString.getChars(paramInt1, paramInt1 + paramInt2, this._outputBuffer, this._outputTail);
      this._outputTail += paramInt2;
      return;
    }
    writeRawLong(paramString.substring(paramInt1, paramInt1 + paramInt2));
  }
  
  public void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    if (paramInt2 < 32)
    {
      if (paramInt2 > this._outputEnd - this._outputTail) {
        _flushBuffer();
      }
      System.arraycopy(paramArrayOfChar, paramInt1, this._outputBuffer, this._outputTail, paramInt2);
      this._outputTail += paramInt2;
      return;
    }
    _flushBuffer();
    this._writer.write(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeStartArray()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("start an array");
    this._writeContext = this._writeContext.createChildArrayContext();
    if (this._cfgPrettyPrinter != null)
    {
      this._cfgPrettyPrinter.writeStartArray(this);
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '[';
  }
  
  public void writeStartObject()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("start an object");
    this._writeContext = this._writeContext.createChildObjectContext();
    if (this._cfgPrettyPrinter != null)
    {
      this._cfgPrettyPrinter.writeStartObject(this);
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '{';
  }
  
  public void writeString(SerializableString paramSerializableString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write text value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    paramSerializableString = paramSerializableString.asQuotedChars();
    i = paramSerializableString.length;
    if (i < 32)
    {
      if (i > this._outputEnd - this._outputTail) {
        _flushBuffer();
      }
      System.arraycopy(paramSerializableString, 0, this._outputBuffer, this._outputTail, i);
      this._outputTail += i;
    }
    for (;;)
    {
      if (this._outputTail >= this._outputEnd) {
        _flushBuffer();
      }
      paramSerializableString = this._outputBuffer;
      i = this._outputTail;
      this._outputTail = (i + 1);
      paramSerializableString[i] = 34;
      return;
      _flushBuffer();
      this._writer.write(paramSerializableString, 0, i);
    }
  }
  
  public void writeString(String paramString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write text value");
    if (paramString == null)
    {
      _writeNull();
      return;
    }
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramString);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramString = this._outputBuffer;
    i = this._outputTail;
    this._outputTail = (i + 1);
    paramString[i] = 34;
  }
  
  public void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write text value");
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    char[] arrayOfChar = this._outputBuffer;
    int i = this._outputTail;
    this._outputTail = (i + 1);
    arrayOfChar[i] = '"';
    _writeString(paramArrayOfChar, paramInt1, paramInt2);
    if (this._outputTail >= this._outputEnd) {
      _flushBuffer();
    }
    paramArrayOfChar = this._outputBuffer;
    paramInt1 = this._outputTail;
    this._outputTail = (paramInt1 + 1);
    paramArrayOfChar[paramInt1] = '"';
  }
  
  public void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _reportUnsupportedOperation();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\json\WriterBasedJsonGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */