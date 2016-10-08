package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.MergedStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataFormatMatcher
{
  protected final byte[] _bufferedData;
  protected final int _bufferedLength;
  protected final int _bufferedStart;
  protected final JsonFactory _match;
  protected final MatchStrength _matchStrength;
  protected final InputStream _originalStream;
  
  protected DataFormatMatcher(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, JsonFactory paramJsonFactory, MatchStrength paramMatchStrength)
  {
    this._originalStream = paramInputStream;
    this._bufferedData = paramArrayOfByte;
    this._bufferedStart = paramInt1;
    this._bufferedLength = paramInt2;
    this._match = paramJsonFactory;
    this._matchStrength = paramMatchStrength;
  }
  
  public JsonParser createParserWithMatch()
    throws IOException
  {
    if (this._match == null) {
      return null;
    }
    if (this._originalStream == null) {
      return this._match.createParser(this._bufferedData, this._bufferedStart, this._bufferedLength);
    }
    return this._match.createParser(getDataStream());
  }
  
  public InputStream getDataStream()
  {
    if (this._originalStream == null) {
      return new ByteArrayInputStream(this._bufferedData, this._bufferedStart, this._bufferedLength);
    }
    return new MergedStream(null, this._originalStream, this._bufferedData, this._bufferedStart, this._bufferedLength);
  }
  
  public JsonFactory getMatch()
  {
    return this._match;
  }
  
  public MatchStrength getMatchStrength()
  {
    if (this._matchStrength == null) {
      return MatchStrength.INCONCLUSIVE;
    }
    return this._matchStrength;
  }
  
  public String getMatchedFormatName()
  {
    return this._match.getFormatName();
  }
  
  public boolean hasMatch()
  {
    return this._match != null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\format\DataFormatMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */