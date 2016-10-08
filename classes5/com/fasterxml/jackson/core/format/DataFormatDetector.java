package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class DataFormatDetector
{
  public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;
  protected final JsonFactory[] _detectors;
  protected final int _maxInputLookahead;
  protected final MatchStrength _minimalMatch;
  protected final MatchStrength _optimalMatch;
  
  public DataFormatDetector(Collection<JsonFactory> paramCollection)
  {
    this((JsonFactory[])paramCollection.toArray(new JsonFactory[paramCollection.size()]));
  }
  
  public DataFormatDetector(JsonFactory... paramVarArgs)
  {
    this(paramVarArgs, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
  }
  
  private DataFormatDetector(JsonFactory[] paramArrayOfJsonFactory, MatchStrength paramMatchStrength1, MatchStrength paramMatchStrength2, int paramInt)
  {
    this._detectors = paramArrayOfJsonFactory;
    this._optimalMatch = paramMatchStrength1;
    this._minimalMatch = paramMatchStrength2;
    this._maxInputLookahead = paramInt;
  }
  
  private DataFormatMatcher _findFormat(InputAccessor.Std paramStd)
    throws IOException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    JsonFactory[] arrayOfJsonFactory = this._detectors;
    int j = arrayOfJsonFactory.length;
    int i = 0;
    Object localObject3;
    if (i >= j)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
    }
    for (;;)
    {
      return paramStd.createMatcher((JsonFactory)localObject2, (MatchStrength)localObject3);
      JsonFactory localJsonFactory = arrayOfJsonFactory[i];
      paramStd.reset();
      MatchStrength localMatchStrength = localJsonFactory.hasFormat(paramStd);
      localObject3 = localObject1;
      Object localObject4 = localObject2;
      if (localMatchStrength != null)
      {
        if (localMatchStrength.ordinal() >= this._minimalMatch.ordinal()) {
          break label104;
        }
        localObject4 = localObject2;
        localObject3 = localObject1;
      }
      label104:
      label126:
      do
      {
        do
        {
          i += 1;
          localObject1 = localObject3;
          localObject2 = localObject4;
          break;
          if (localObject1 == null) {
            break label126;
          }
          localObject3 = localObject1;
          localObject4 = localObject2;
        } while (((MatchStrength)localObject2).ordinal() >= localMatchStrength.ordinal());
        localObject2 = localJsonFactory;
        localObject1 = localMatchStrength;
        localObject3 = localObject2;
        localObject4 = localObject1;
      } while (localMatchStrength.ordinal() < this._optimalMatch.ordinal());
      localObject3 = localObject1;
    }
  }
  
  public DataFormatMatcher findFormat(InputStream paramInputStream)
    throws IOException
  {
    return _findFormat(new InputAccessor.Std(paramInputStream, new byte[this._maxInputLookahead]));
  }
  
  public DataFormatMatcher findFormat(byte[] paramArrayOfByte)
    throws IOException
  {
    return _findFormat(new InputAccessor.Std(paramArrayOfByte));
  }
  
  public DataFormatMatcher findFormat(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return _findFormat(new InputAccessor.Std(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    int j = this._detectors.length;
    int i;
    if (j > 0)
    {
      localStringBuilder.append(this._detectors[0].getFormatName());
      i = 1;
    }
    for (;;)
    {
      if (i >= j)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(this._detectors[i].getFormatName());
      i += 1;
    }
  }
  
  public DataFormatDetector withMaxInputLookahead(int paramInt)
  {
    if (paramInt == this._maxInputLookahead) {
      return this;
    }
    return new DataFormatDetector(this._detectors, this._optimalMatch, this._minimalMatch, paramInt);
  }
  
  public DataFormatDetector withMinimalMatch(MatchStrength paramMatchStrength)
  {
    if (paramMatchStrength == this._minimalMatch) {
      return this;
    }
    return new DataFormatDetector(this._detectors, this._optimalMatch, paramMatchStrength, this._maxInputLookahead);
  }
  
  public DataFormatDetector withOptimalMatch(MatchStrength paramMatchStrength)
  {
    if (paramMatchStrength == this._optimalMatch) {
      return this;
    }
    return new DataFormatDetector(this._detectors, paramMatchStrength, this._minimalMatch, this._maxInputLookahead);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\format\DataFormatDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */