package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class TLVHelper
{
  public static final String a = "Q.qqstoryTLVHelper";
  
  public TLVHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static HashMap a(ByteBuffer paramByteBuffer)
  {
    HashMap localHashMap = new HashMap();
    int m = paramByteBuffer.limit();
    int j = 0;
    Object localObject;
    for (;;)
    {
      int i = j;
      localObject = localHashMap;
      try
      {
        if (paramByteBuffer.hasRemaining())
        {
          i = j;
          k = paramByteBuffer.getInt();
          if (k > m)
          {
            i = k;
            SLog.e("Q.qqstoryTLVHelper", "size error:%d", new Object[] { Integer.valueOf(k) });
            return localHashMap;
          }
          i = k;
          localObject = new byte[k];
          j = 0;
          while (j < k)
          {
            i = k;
            localObject[j] = paramByteBuffer.get();
            j += 1;
          }
          i = k;
          localObject = new String((byte[])localObject);
          i = k;
          j = paramByteBuffer.getInt();
          i = j;
          arrayOfByte = new byte[j];
          if (j > m)
          {
            i = j;
            SLog.e("Q.qqstoryTLVHelper", "size error:%d", new Object[] { Integer.valueOf(j) });
            return localHashMap;
          }
        }
      }
      catch (Exception paramByteBuffer)
      {
        byte[] arrayOfByte;
        SLog.c("Q.qqstoryTLVHelper", "decode respond fail ", paramByteBuffer);
        return new HashMap();
        int k = 0;
        while (k < j)
        {
          i = j;
          arrayOfByte[k] = paramByteBuffer.get();
          k += 1;
        }
        i = j;
        localHashMap.put(localObject, ByteBuffer.wrap(arrayOfByte));
      }
      catch (OutOfMemoryError paramByteBuffer)
      {
        SLog.c("Q.qqstoryTLVHelper", "decode respond fail for allocate size " + i, paramByteBuffer);
        localObject = new HashMap();
      }
    }
    return (HashMap)localObject;
  }
  
  public static void a(ByteBuffer paramByteBuffer, String paramString1, String paramString2)
  {
    paramByteBuffer.putInt(paramString1.length());
    paramByteBuffer.put(paramString1.getBytes());
    paramByteBuffer.putInt(paramString2.length());
    paramByteBuffer.put(paramString2.getBytes());
  }
  
  public static void a(ByteBuffer paramByteBuffer, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramByteBuffer.putInt(paramString.length());
    paramByteBuffer.put(paramString.getBytes());
    paramByteBuffer.putInt(paramInt);
    paramByteBuffer.put(paramArrayOfByte, 0, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\TLVHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */