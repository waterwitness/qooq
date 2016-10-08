package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import javax.annotation.Nullable;

public class CatalystStylesDiffMap
{
  final ReadableMap mBackingMap;
  
  public CatalystStylesDiffMap(ReadableMap paramReadableMap)
  {
    this.mBackingMap = paramReadableMap;
  }
  
  @Nullable
  public ReadableArray getArray(String paramString)
  {
    return this.mBackingMap.getArray(paramString);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (this.mBackingMap.isNull(paramString)) {
      return paramBoolean;
    }
    return this.mBackingMap.getBoolean(paramString);
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    if (this.mBackingMap.isNull(paramString)) {
      return paramDouble;
    }
    return this.mBackingMap.getDouble(paramString);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    if (this.mBackingMap.isNull(paramString)) {
      return paramFloat;
    }
    return (float)this.mBackingMap.getDouble(paramString);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    if (this.mBackingMap.isNull(paramString)) {
      return paramInt;
    }
    return this.mBackingMap.getInt(paramString);
  }
  
  @Nullable
  public ReadableMap getMap(String paramString)
  {
    return this.mBackingMap.getMap(paramString);
  }
  
  @Nullable
  public String getString(String paramString)
  {
    return this.mBackingMap.getString(paramString);
  }
  
  public boolean hasKey(String paramString)
  {
    return this.mBackingMap.hasKey(paramString);
  }
  
  public boolean isNull(String paramString)
  {
    return this.mBackingMap.isNull(paramString);
  }
  
  public String toString()
  {
    return "{ " + getClass().getSimpleName() + ": " + this.mBackingMap.toString() + " }";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\CatalystStylesDiffMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */