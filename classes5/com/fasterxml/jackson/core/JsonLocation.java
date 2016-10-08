package com.fasterxml.jackson.core;

import java.io.Serializable;

public class JsonLocation
  implements Serializable
{
  public static final JsonLocation NA = new JsonLocation("N/A", -1L, -1L, -1, -1);
  private static final long serialVersionUID = 1L;
  final int _columnNr;
  final int _lineNr;
  final transient Object _sourceRef;
  final long _totalBytes;
  final long _totalChars;
  
  public JsonLocation(Object paramObject, long paramLong, int paramInt1, int paramInt2)
  {
    this(paramObject, -1L, paramLong, paramInt1, paramInt2);
  }
  
  public JsonLocation(Object paramObject, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this._sourceRef = paramObject;
    this._totalBytes = paramLong1;
    this._totalChars = paramLong2;
    this._lineNr = paramInt1;
    this._columnNr = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof JsonLocation)) {
        return false;
      }
      paramObject = (JsonLocation)paramObject;
      if (this._sourceRef == null)
      {
        if (((JsonLocation)paramObject)._sourceRef != null) {
          return false;
        }
      }
      else if (!this._sourceRef.equals(((JsonLocation)paramObject)._sourceRef)) {
        return false;
      }
    } while ((this._lineNr == ((JsonLocation)paramObject)._lineNr) && (this._columnNr == ((JsonLocation)paramObject)._columnNr) && (this._totalChars == ((JsonLocation)paramObject)._totalChars) && (getByteOffset() == ((JsonLocation)paramObject).getByteOffset()));
    return false;
  }
  
  public long getByteOffset()
  {
    return this._totalBytes;
  }
  
  public long getCharOffset()
  {
    return this._totalChars;
  }
  
  public int getColumnNr()
  {
    return this._columnNr;
  }
  
  public int getLineNr()
  {
    return this._lineNr;
  }
  
  public Object getSourceRef()
  {
    return this._sourceRef;
  }
  
  public int hashCode()
  {
    if (this._sourceRef == null) {}
    for (int i = 1;; i = this._sourceRef.hashCode()) {
      return ((i ^ this._lineNr) + this._columnNr ^ (int)this._totalChars) + (int)this._totalBytes;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[Source: ");
    if (this._sourceRef == null) {
      localStringBuilder.append("UNKNOWN");
    }
    for (;;)
    {
      localStringBuilder.append("; line: ");
      localStringBuilder.append(this._lineNr);
      localStringBuilder.append(", column: ");
      localStringBuilder.append(this._columnNr);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      localStringBuilder.append(this._sourceRef.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\JsonLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */