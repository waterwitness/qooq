package com.tencent.bitapp.compression;

import java.util.List;

public abstract interface ICompression
{
  public abstract boolean compress(String paramString1, String paramString2);
  
  public abstract boolean compress(List<String> paramList, String paramString);
  
  public abstract boolean decompress(String paramString1, String paramString2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\compression\ICompression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */