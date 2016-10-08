package com.tencent.view.raw;

import java.io.InputStream;

public class FilterRawGet
{
  private static GetInputStream mGetInputStream;
  
  public static void setGetInputStream(GetInputStream paramGetInputStream)
  {
    mGetInputStream = paramGetInputStream;
  }
  
  public InputStream getInpuStream(String paramString)
  {
    try
    {
      if (mGetInputStream != null) {
        paramString = mGetInputStream.getInputStream(paramString);
      } else {
        paramString = getClass().getResourceAsStream(paramString);
      }
    }
    catch (Exception paramString)
    {
      return null;
    }
    return paramString;
  }
  
  public static abstract interface GetInputStream
  {
    public abstract InputStream getInputStream(String paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\view\raw\FilterRawGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */