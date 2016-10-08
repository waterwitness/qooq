package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ParserBase
  extends ParserMinimalBase
{
  static final BigDecimal BD_MAX_INT = new BigDecimal(BI_MAX_INT);
  static final BigDecimal BD_MAX_LONG;
  static final BigDecimal BD_MIN_INT;
  static final BigDecimal BD_MIN_LONG;
  static final BigInteger BI_MAX_INT;
  static final BigInteger BI_MAX_LONG;
  static final BigInteger BI_MIN_INT = BigInteger.valueOf(-2147483648L);
  static final BigInteger BI_MIN_LONG;
  protected static final char CHAR_NULL = '\000';
  protected static final int INT_0 = 48;
  protected static final int INT_1 = 49;
  protected static final int INT_2 = 50;
  protected static final int INT_3 = 51;
  protected static final int INT_4 = 52;
  protected static final int INT_5 = 53;
  protected static final int INT_6 = 54;
  protected static final int INT_7 = 55;
  protected static final int INT_8 = 56;
  protected static final int INT_9 = 57;
  protected static final int INT_DECIMAL_POINT = 46;
  protected static final int INT_E = 69;
  protected static final int INT_MINUS = 45;
  protected static final int INT_PLUS = 43;
  protected static final int INT_e = 101;
  static final double MAX_INT_D = 2.147483647E9D;
  static final long MAX_INT_L = 2147483647L;
  static final double MAX_LONG_D = 9.223372036854776E18D;
  static final double MIN_INT_D = -2.147483648E9D;
  static final long MIN_INT_L = -2147483648L;
  static final double MIN_LONG_D = -9.223372036854776E18D;
  protected static final int NR_BIGDECIMAL = 16;
  protected static final int NR_BIGINT = 4;
  protected static final int NR_DOUBLE = 8;
  protected static final int NR_INT = 1;
  protected static final int NR_LONG = 2;
  protected static final int NR_UNKNOWN = 0;
  protected byte[] _binaryValue;
  protected ByteArrayBuilder _byteArrayBuilder = null;
  protected boolean _closed;
  protected long _currInputProcessed = 0L;
  protected int _currInputRow = 1;
  protected int _currInputRowStart = 0;
  protected int _expLength;
  protected int _fractLength;
  protected int _inputEnd = 0;
  protected int _inputPtr = 0;
  protected int _intLength;
  protected final IOContext _ioContext;
  protected boolean _nameCopied = false;
  protected char[] _nameCopyBuffer = null;
  protected JsonToken _nextToken;
  protected int _numTypesValid = 0;
  protected BigDecimal _numberBigDecimal;
  protected BigInteger _numberBigInt;
  protected double _numberDouble;
  protected int _numberInt;
  protected long _numberLong;
  protected boolean _numberNegative;
  protected JsonReadContext _parsingContext;
  protected final TextBuffer _textBuffer;
  protected int _tokenInputCol = 0;
  protected int _tokenInputRow = 1;
  protected long _tokenInputTotal = 0L;
  
  static
  {
    BI_MAX_INT = BigInteger.valueOf(2147483647L);
    BI_MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    BI_MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    BD_MIN_LONG = new BigDecimal(BI_MIN_LONG);
    BD_MAX_LONG = new BigDecimal(BI_MAX_LONG);
    BD_MIN_INT = new BigDecimal(BI_MIN_INT);
  }
  
  protected ParserBase(IOContext paramIOContext, int paramInt)
  {
    this._features = paramInt;
    this._ioContext = paramIOContext;
    this._textBuffer = paramIOContext.constructTextBuffer();
    this._parsingContext = JsonReadContext.createRootContext();
  }
  
  private void _parseSlowFloatValue(int paramInt)
    throws IOException, JsonParseException
  {
    if (paramInt == 16) {}
    try
    {
      this._numberBigDecimal = this._textBuffer.contentsAsDecimal();
      this._numTypesValid = 16;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      _wrapError("Malformed numeric value '" + this._textBuffer.contentsAsString() + "'", localNumberFormatException);
    }
    this._numberDouble = this._textBuffer.contentsAsDouble();
    this._numTypesValid = 8;
    return;
  }
  
  private void _parseSlowIntValue(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException, JsonParseException
  {
    String str = this._textBuffer.contentsAsString();
    try
    {
      if (NumberInput.inLongRange(paramArrayOfChar, paramInt2, paramInt3, this._numberNegative))
      {
        this._numberLong = Long.parseLong(str);
        this._numTypesValid = 2;
        return;
      }
      this._numberBigInt = new BigInteger(str);
      this._numTypesValid = 4;
      return;
    }
    catch (NumberFormatException paramArrayOfChar)
    {
      _wrapError("Malformed numeric value '" + str + "'", paramArrayOfChar);
    }
  }
  
  protected abstract void _closeInput()
    throws IOException;
  
  protected final int _decodeBase64Escape(Base64Variant paramBase64Variant, char paramChar, int paramInt)
    throws IOException, JsonParseException
  {
    if (paramChar != '\\') {
      throw reportInvalidBase64Char(paramBase64Variant, paramChar, paramInt);
    }
    char c1 = _decodeEscaped();
    if ((c1 <= ' ') && (paramInt == 0)) {
      paramChar = '￿';
    }
    char c2;
    do
    {
      return paramChar;
      c2 = paramBase64Variant.decodeBase64Char(c1);
      paramChar = c2;
    } while (c2 >= 0);
    throw reportInvalidBase64Char(paramBase64Variant, c1, paramInt);
  }
  
  protected final int _decodeBase64Escape(Base64Variant paramBase64Variant, int paramInt1, int paramInt2)
    throws IOException, JsonParseException
  {
    if (paramInt1 != 92) {
      throw reportInvalidBase64Char(paramBase64Variant, paramInt1, paramInt2);
    }
    int j = _decodeEscaped();
    if ((j <= 32) && (paramInt2 == 0)) {
      paramInt1 = -1;
    }
    int i;
    do
    {
      return paramInt1;
      i = paramBase64Variant.decodeBase64Char(j);
      paramInt1 = i;
    } while (i >= 0);
    throw reportInvalidBase64Char(paramBase64Variant, j, paramInt2);
  }
  
  protected char _decodeEscaped()
    throws IOException, JsonParseException
  {
    throw new UnsupportedOperationException();
  }
  
  protected abstract void _finishString()
    throws IOException, JsonParseException;
  
  public ByteArrayBuilder _getByteArrayBuilder()
  {
    if (this._byteArrayBuilder == null) {
      this._byteArrayBuilder = new ByteArrayBuilder();
    }
    for (;;)
    {
      return this._byteArrayBuilder;
      this._byteArrayBuilder.reset();
    }
  }
  
  protected void _handleEOF()
    throws JsonParseException
  {
    if (!this._parsingContext.inRoot()) {
      _reportInvalidEOF(": expected close marker for " + this._parsingContext.getTypeDesc() + " (from " + this._parsingContext.getStartLocation(this._ioContext.getSourceReference()) + ")");
    }
  }
  
  protected void _parseNumericValue(int paramInt)
    throws IOException, JsonParseException
  {
    if (this._currToken == JsonToken.VALUE_NUMBER_INT)
    {
      char[] arrayOfChar = this._textBuffer.getTextBuffer();
      int j = this._textBuffer.getTextOffset();
      int k = this._intLength;
      int i = j;
      if (this._numberNegative) {
        i = j + 1;
      }
      if (k <= 9)
      {
        i = NumberInput.parseInt(arrayOfChar, i, k);
        paramInt = i;
        if (this._numberNegative) {
          paramInt = -i;
        }
        this._numberInt = paramInt;
        this._numTypesValid = 1;
        return;
      }
      if (k <= 18)
      {
        long l2 = NumberInput.parseLong(arrayOfChar, i, k);
        long l1 = l2;
        if (this._numberNegative) {
          l1 = -l2;
        }
        if (k == 10) {
          if (this._numberNegative)
          {
            if (l1 >= -2147483648L)
            {
              this._numberInt = ((int)l1);
              this._numTypesValid = 1;
            }
          }
          else if (l1 <= 2147483647L)
          {
            this._numberInt = ((int)l1);
            this._numTypesValid = 1;
            return;
          }
        }
        this._numberLong = l1;
        this._numTypesValid = 2;
        return;
      }
      _parseSlowIntValue(paramInt, arrayOfChar, i, k);
      return;
    }
    if (this._currToken == JsonToken.VALUE_NUMBER_FLOAT)
    {
      _parseSlowFloatValue(paramInt);
      return;
    }
    _reportError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
  }
  
  protected void _releaseBuffers()
    throws IOException
  {
    this._textBuffer.releaseBuffers();
    char[] arrayOfChar = this._nameCopyBuffer;
    if (arrayOfChar != null)
    {
      this._nameCopyBuffer = null;
      this._ioContext.releaseNameCopyBuffer(arrayOfChar);
    }
  }
  
  protected void _reportMismatchedEndMarker(int paramInt, char paramChar)
    throws JsonParseException
  {
    String str = this._parsingContext.getStartLocation(this._ioContext.getSourceReference());
    _reportError("Unexpected close marker '" + (char)paramInt + "': expected '" + paramChar + "' (for " + this._parsingContext.getTypeDesc() + " starting at " + str + ")");
  }
  
  public void close()
    throws IOException
  {
    if (!this._closed) {
      this._closed = true;
    }
    try
    {
      _closeInput();
      return;
    }
    finally
    {
      _releaseBuffers();
    }
  }
  
  protected void convertNumberToBigDecimal()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x8) != 0) {
      this._numberBigDecimal = new BigDecimal(getText());
    }
    for (;;)
    {
      this._numTypesValid |= 0x10;
      return;
      if ((this._numTypesValid & 0x4) != 0) {
        this._numberBigDecimal = new BigDecimal(this._numberBigInt);
      } else if ((this._numTypesValid & 0x2) != 0) {
        this._numberBigDecimal = BigDecimal.valueOf(this._numberLong);
      } else if ((this._numTypesValid & 0x1) != 0) {
        this._numberBigDecimal = BigDecimal.valueOf(this._numberInt);
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToBigInteger()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x10) != 0) {
      this._numberBigInt = this._numberBigDecimal.toBigInteger();
    }
    for (;;)
    {
      this._numTypesValid |= 0x4;
      return;
      if ((this._numTypesValid & 0x2) != 0) {
        this._numberBigInt = BigInteger.valueOf(this._numberLong);
      } else if ((this._numTypesValid & 0x1) != 0) {
        this._numberBigInt = BigInteger.valueOf(this._numberInt);
      } else if ((this._numTypesValid & 0x8) != 0) {
        this._numberBigInt = BigDecimal.valueOf(this._numberDouble).toBigInteger();
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToDouble()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x10) != 0) {
      this._numberDouble = this._numberBigDecimal.doubleValue();
    }
    for (;;)
    {
      this._numTypesValid |= 0x8;
      return;
      if ((this._numTypesValid & 0x4) != 0) {
        this._numberDouble = this._numberBigInt.doubleValue();
      } else if ((this._numTypesValid & 0x2) != 0) {
        this._numberDouble = this._numberLong;
      } else if ((this._numTypesValid & 0x1) != 0) {
        this._numberDouble = this._numberInt;
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToInt()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x2) != 0)
    {
      int i = (int)this._numberLong;
      if (i != this._numberLong) {
        _reportError("Numeric value (" + getText() + ") out of range of int");
      }
      this._numberInt = i;
    }
    for (;;)
    {
      this._numTypesValid |= 0x1;
      return;
      if ((this._numTypesValid & 0x4) != 0)
      {
        if ((BI_MIN_INT.compareTo(this._numberBigInt) > 0) || (BI_MAX_INT.compareTo(this._numberBigInt) < 0)) {
          reportOverflowInt();
        }
        this._numberInt = this._numberBigInt.intValue();
      }
      else if ((this._numTypesValid & 0x8) != 0)
      {
        if ((this._numberDouble < -2.147483648E9D) || (this._numberDouble > 2.147483647E9D)) {
          reportOverflowInt();
        }
        this._numberInt = ((int)this._numberDouble);
      }
      else if ((this._numTypesValid & 0x10) != 0)
      {
        if ((BD_MIN_INT.compareTo(this._numberBigDecimal) > 0) || (BD_MAX_INT.compareTo(this._numberBigDecimal) < 0)) {
          reportOverflowInt();
        }
        this._numberInt = this._numberBigDecimal.intValue();
      }
      else
      {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToLong()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x1) != 0) {
      this._numberLong = this._numberInt;
    }
    for (;;)
    {
      this._numTypesValid |= 0x2;
      return;
      if ((this._numTypesValid & 0x4) != 0)
      {
        if ((BI_MIN_LONG.compareTo(this._numberBigInt) > 0) || (BI_MAX_LONG.compareTo(this._numberBigInt) < 0)) {
          reportOverflowLong();
        }
        this._numberLong = this._numberBigInt.longValue();
      }
      else if ((this._numTypesValid & 0x8) != 0)
      {
        if ((this._numberDouble < -9.223372036854776E18D) || (this._numberDouble > 9.223372036854776E18D)) {
          reportOverflowLong();
        }
        this._numberLong = (this._numberDouble);
      }
      else if ((this._numTypesValid & 0x10) != 0)
      {
        if ((BD_MIN_LONG.compareTo(this._numberBigDecimal) > 0) || (BD_MAX_LONG.compareTo(this._numberBigDecimal) < 0)) {
          reportOverflowLong();
        }
        this._numberLong = this._numberBigDecimal.longValue();
      }
      else
      {
        _throwInternal();
      }
    }
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x4) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(4);
      }
      if ((this._numTypesValid & 0x4) == 0) {
        convertNumberToBigInteger();
      }
    }
    return this._numberBigInt;
  }
  
  public JsonLocation getCurrentLocation()
  {
    int i = this._inputPtr;
    int j = this._currInputRowStart;
    return new JsonLocation(this._ioContext.getSourceReference(), this._currInputProcessed + this._inputPtr - 1L, this._currInputRow, i - j + 1);
  }
  
  public String getCurrentName()
    throws IOException, JsonParseException
  {
    if ((this._currToken == JsonToken.START_OBJECT) || (this._currToken == JsonToken.START_ARRAY)) {
      return this._parsingContext.getParent().getCurrentName();
    }
    return this._parsingContext.getCurrentName();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x10) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(16);
      }
      if ((this._numTypesValid & 0x10) == 0) {
        convertNumberToBigDecimal();
      }
    }
    return this._numberBigDecimal;
  }
  
  public double getDoubleValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x8) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(8);
      }
      if ((this._numTypesValid & 0x8) == 0) {
        convertNumberToDouble();
      }
    }
    return this._numberDouble;
  }
  
  public Object getEmbeddedObject()
    throws IOException, JsonParseException
  {
    return null;
  }
  
  public float getFloatValue()
    throws IOException, JsonParseException
  {
    return (float)getDoubleValue();
  }
  
  public int getIntValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x1) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(1);
      }
      if ((this._numTypesValid & 0x1) == 0) {
        convertNumberToInt();
      }
    }
    return this._numberInt;
  }
  
  public long getLongValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x2) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(2);
      }
      if ((this._numTypesValid & 0x2) == 0) {
        convertNumberToLong();
      }
    }
    return this._numberLong;
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException, JsonParseException
  {
    if (this._numTypesValid == 0) {
      _parseNumericValue(0);
    }
    if (this._currToken == JsonToken.VALUE_NUMBER_INT)
    {
      if ((this._numTypesValid & 0x1) != 0) {
        return JsonParser.NumberType.INT;
      }
      if ((this._numTypesValid & 0x2) != 0) {
        return JsonParser.NumberType.LONG;
      }
      return JsonParser.NumberType.BIG_INTEGER;
    }
    if ((this._numTypesValid & 0x10) != 0) {
      return JsonParser.NumberType.BIG_DECIMAL;
    }
    return JsonParser.NumberType.DOUBLE;
  }
  
  public Number getNumberValue()
    throws IOException, JsonParseException
  {
    if (this._numTypesValid == 0) {
      _parseNumericValue(0);
    }
    if (this._currToken == JsonToken.VALUE_NUMBER_INT)
    {
      if ((this._numTypesValid & 0x1) != 0) {
        return Integer.valueOf(this._numberInt);
      }
      if ((this._numTypesValid & 0x2) != 0) {
        return Long.valueOf(this._numberLong);
      }
      if ((this._numTypesValid & 0x4) != 0) {
        return this._numberBigInt;
      }
      return this._numberBigDecimal;
    }
    if ((this._numTypesValid & 0x10) != 0) {
      return this._numberBigDecimal;
    }
    if ((this._numTypesValid & 0x8) == 0) {
      _throwInternal();
    }
    return Double.valueOf(this._numberDouble);
  }
  
  public JsonReadContext getParsingContext()
  {
    return this._parsingContext;
  }
  
  public long getTokenCharacterOffset()
  {
    return this._tokenInputTotal;
  }
  
  public int getTokenColumnNr()
  {
    int i = this._tokenInputCol;
    if (i < 0) {
      return i;
    }
    return i + 1;
  }
  
  public int getTokenLineNr()
  {
    return this._tokenInputRow;
  }
  
  public JsonLocation getTokenLocation()
  {
    return new JsonLocation(this._ioContext.getSourceReference(), getTokenCharacterOffset(), getTokenLineNr(), getTokenColumnNr());
  }
  
  public boolean hasTextCharacters()
  {
    if (this._currToken == JsonToken.VALUE_STRING) {
      return true;
    }
    if (this._currToken == JsonToken.FIELD_NAME) {
      return this._nameCopied;
    }
    return false;
  }
  
  public boolean isClosed()
  {
    return this._closed;
  }
  
  protected abstract boolean loadMore()
    throws IOException;
  
  protected final void loadMoreGuaranteed()
    throws IOException
  {
    if (!loadMore()) {
      _reportInvalidEOF();
    }
  }
  
  public void overrideCurrentName(String paramString)
  {
    JsonReadContext localJsonReadContext2 = this._parsingContext;
    JsonReadContext localJsonReadContext1;
    if (this._currToken != JsonToken.START_OBJECT)
    {
      localJsonReadContext1 = localJsonReadContext2;
      if (this._currToken != JsonToken.START_ARRAY) {}
    }
    else
    {
      localJsonReadContext1 = localJsonReadContext2.getParent();
    }
    localJsonReadContext1.setCurrentName(paramString);
  }
  
  protected IllegalArgumentException reportInvalidBase64Char(Base64Variant paramBase64Variant, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    return reportInvalidBase64Char(paramBase64Variant, paramInt1, paramInt2, null);
  }
  
  protected IllegalArgumentException reportInvalidBase64Char(Base64Variant paramBase64Variant, int paramInt1, int paramInt2, String paramString)
    throws IllegalArgumentException
  {
    if (paramInt1 <= 32) {
      paramBase64Variant = "Illegal white space character (code 0x" + Integer.toHexString(paramInt1) + ") as character #" + (paramInt2 + 1) + " of 4-char base64 unit: can only used between units";
    }
    for (;;)
    {
      Object localObject = paramBase64Variant;
      if (paramString != null) {
        localObject = paramBase64Variant + ": " + paramString;
      }
      return new IllegalArgumentException((String)localObject);
      if (paramBase64Variant.usesPaddingChar(paramInt1)) {
        paramBase64Variant = "Unexpected padding character ('" + paramBase64Variant.getPaddingChar() + "') as character #" + (paramInt2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramInt1)) || (Character.isISOControl(paramInt1))) {
        paramBase64Variant = "Illegal character (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
      } else {
        paramBase64Variant = "Illegal character '" + (char)paramInt1 + "' (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
      }
    }
  }
  
  protected void reportInvalidNumber(String paramString)
    throws JsonParseException
  {
    _reportError("Invalid numeric value: " + paramString);
  }
  
  protected void reportOverflowInt()
    throws IOException, JsonParseException
  {
    _reportError("Numeric value (" + getText() + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
  }
  
  protected void reportOverflowLong()
    throws IOException, JsonParseException
  {
    _reportError("Numeric value (" + getText() + ") out of range of long (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
  }
  
  protected void reportUnexpectedNumberChar(int paramInt, String paramString)
    throws JsonParseException
  {
    String str2 = "Unexpected character (" + _getCharDesc(paramInt) + ") in numeric value";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + ": " + paramString;
    }
    _reportError(str1);
  }
  
  protected final JsonToken reset(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < 1) && (paramInt3 < 1)) {
      return resetInt(paramBoolean, paramInt1);
    }
    return resetFloat(paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  protected final JsonToken resetAsNaN(String paramString, double paramDouble)
  {
    this._textBuffer.resetWithString(paramString);
    this._numberDouble = paramDouble;
    this._numTypesValid = 8;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  protected final JsonToken resetFloat(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this._numberNegative = paramBoolean;
    this._intLength = paramInt1;
    this._fractLength = paramInt2;
    this._expLength = paramInt3;
    this._numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  protected final JsonToken resetInt(boolean paramBoolean, int paramInt)
  {
    this._numberNegative = paramBoolean;
    this._intLength = paramInt;
    this._fractLength = 0;
    this._expLength = 0;
    this._numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\base\ParserBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */