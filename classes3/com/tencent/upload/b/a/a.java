package com.tencent.upload.b.a;

import com.qq.jce.wup.UniPacket;
import com.tencent.upload.a.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.PatternSyntaxException;

public class a
{
  private static final AtomicInteger a = new AtomicInteger(0);
  
  public static final int a()
  {
    return a.incrementAndGet();
  }
  
  public static final Object a(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("UTF-8");
    localUniPacket.decode(paramArrayOfByte);
    paramString = localUniPacket.get(paramString);
    localUniPacket.clearCacheData();
    return paramString;
  }
  
  public static final String a(int paramInt1, int paramInt2)
  {
    return paramInt1 + "|" + paramInt2;
  }
  
  public static final byte[] a(String paramString, Object paramObject)
    throws Exception
  {
    if ((paramString == null) || (paramObject == null)) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setEncodeName("UTF-8");
    localUniPacket.setRequestId(0);
    localUniPacket.setFuncName("FuncName");
    localUniPacket.setServantName("ServantName");
    localUniPacket.put(paramString, paramObject);
    paramString = localUniPacket.encode();
    localUniPacket.clearCacheData();
    return paramString;
  }
  
  public static final int[] a(String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if ((paramString == null) || (paramString.length() == 0))
    {
      b.d(a.class.getSimpleName(), "fromProtocolSequence protocolSequence == null || len == 0");
      return arrayOfInt;
    }
    try
    {
      String[] arrayOfString = paramString.split("\\|");
      if ((arrayOfString == null) || (arrayOfString.length != 2))
      {
        b.d(a.class.getSimpleName(), "fromProtocolSequence:" + paramString + " results == null || results.length != 2" + paramString);
        return arrayOfInt;
      }
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
      b.d(a.class.getSimpleName(), "fromProtocolSequence:" + paramString + " " + localPatternSyntaxException);
      return arrayOfInt;
    }
    try
    {
      arrayOfInt[0] = Integer.parseInt(localPatternSyntaxException[0]);
      arrayOfInt[1] = Integer.parseInt(localPatternSyntaxException[1]);
      return arrayOfInt;
    }
    catch (NumberFormatException paramString)
    {
      b.d(a.class.getSimpleName(), "toProtocolSequence " + paramString);
    }
    return arrayOfInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */