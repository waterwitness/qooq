package com.tencent.mobileqq.vas;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LzmaUtils
{
  public LzmaUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static native int DecodeEx(String paramString1, String paramString2);
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    int j = -1;
    int i;
    if ((paramString1 == null) || (paramString2 == null))
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("LzmaUtils", 2, "path is null.");
        i = j;
      }
    }
    do
    {
      do
      {
        return i;
        if (new File(paramString1).exists()) {
          break;
        }
        i = j;
      } while (!QLog.isColorLevel());
      QLog.d("LzmaUtils", 2, "lzma File not exists.");
      return -1;
      File localFile = new File(paramString2);
      if ((localFile.exists()) || (localFile.mkdirs())) {
        break;
      }
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("LzmaUtils", 2, "cannot create dirs.");
    return -1;
    for (;;)
    {
      try
      {
        SoLoadUtil.a(paramContext, "DecodeSoEx", 0, false, false);
        k = 0;
        i = 0;
        j = i;
        if (k > 3) {}
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        try
        {
          int k;
          j = DecodeEx(paramString1, paramString2);
          i = j;
          if (i == 0)
          {
            j = i;
            if (j == 0) {
              break label257;
            }
            i = j;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("LzmaUtils", 2, "decode file, result:" + j);
            return j;
          }
          k += 1;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          for (;;) {}
        }
        paramContext = paramContext;
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LzmaUtils", 2, "Unsatisfied Link error: " + paramContext.toString());
      }
      j = i;
    }
    label257:
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\LzmaUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */