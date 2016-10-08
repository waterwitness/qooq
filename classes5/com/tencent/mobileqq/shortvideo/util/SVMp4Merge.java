package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.List;

public class SVMp4Merge
{
  public static int a = 2;
  public static int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(List paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramList.size();
    if (k <= 1) {
      return -1;
    }
    int j = 0;
    int i = 0;
    label30:
    if (j < k)
    {
      localStringBuilder.append((String)paramList.get(j));
      if (j != k - 1) {
        localStringBuilder.append('#');
      }
      File localFile = new File((String)paramList.get(j));
      if (!localFile.exists()) {
        break label193;
      }
      i = (int)localFile.length() + i;
    }
    label193:
    for (;;)
    {
      j += 1;
      break label30;
      if (i <= 0) {
        break;
      }
      try
      {
        nativeSetDropStrategy(a, b);
      }
      catch (UnsatisfiedLinkError paramList)
      {
        try
        {
          for (;;)
          {
            i = nativeMergeMp4(localStringBuilder.toString().getBytes(), paramString, k, i);
            paramList = new File(paramString);
            if ((paramList.exists()) && (i < 0)) {
              paramList.delete();
            }
            return i;
            paramList = paramList;
            paramList.printStackTrace();
          }
        }
        catch (UnsatisfiedLinkError paramList)
        {
          for (;;)
          {
            paramList.printStackTrace();
            i = -1;
          }
        }
      }
    }
  }
  
  private static native int nativeMergeMp4(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeSetDropStrategy(int paramInt1, int paramInt2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\SVMp4Merge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */