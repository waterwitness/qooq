package com.facebook.stetho.common;

import java.io.FileInputStream;
import java.io.IOException;

public class ProcessUtil
{
  private static final int CMDLINE_BUFFER_SIZE = 64;
  private static String sProcessName;
  private static boolean sProcessNameRead;
  
  /* Error */
  @javax.annotation.Nullable
  public static String getProcessName()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 23	com/facebook/stetho/common/ProcessUtil:sProcessNameRead	Z
    //   6: ifne +13 -> 19
    //   9: iconst_1
    //   10: putstatic 23	com/facebook/stetho/common/ProcessUtil:sProcessNameRead	Z
    //   13: invokestatic 26	com/facebook/stetho/common/ProcessUtil:readProcessName	()Ljava/lang/String;
    //   16: putstatic 28	com/facebook/stetho/common/ProcessUtil:sProcessName	Ljava/lang/String;
    //   19: getstatic 28	com/facebook/stetho/common/ProcessUtil:sProcessName	Ljava/lang/String;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    //   34: astore_0
    //   35: goto -16 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	str	String
    //   28	5	0	localObject	Object
    //   34	1	0	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   3	13	28	finally
    //   13	19	28	finally
    //   19	23	28	finally
    //   13	19	34	java/io/IOException
  }
  
  private static int indexOf(byte[] paramArrayOfByte, int paramInt1, int paramInt2, byte paramByte)
  {
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 >= paramArrayOfByte.length) {
        paramInt2 = -1;
      }
      do
      {
        return paramInt2;
        paramInt2 = paramInt1;
      } while (paramArrayOfByte[paramInt1] == paramByte);
      paramInt1 += 1;
    }
  }
  
  private static String readProcessName()
    throws IOException
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1 = new byte[64];
    FileInputStream localFileInputStream = new FileInputStream("/proc/self/cmdline");
    int i = 0;
    try
    {
      int j = localFileInputStream.read((byte[])localObject1);
      int k = 1;
      i = k;
      int m = indexOf((byte[])localObject1, 0, j, (byte)0);
      if (m > 0)
      {
        j = m;
        i = k;
        localObject1 = new String((byte[])localObject1, 0, j);
        if (1 == 0) {
          break label81;
        }
      }
      for (;;)
      {
        Util.close(localFileInputStream, bool1);
        return (String)localObject1;
        break;
        label81:
        bool1 = true;
      }
      bool1 = bool2;
    }
    finally
    {
      if (i == 0) {}
    }
    for (;;)
    {
      Util.close(localFileInputStream, bool1);
      throw ((Throwable)localObject2);
      bool1 = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\ProcessUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */