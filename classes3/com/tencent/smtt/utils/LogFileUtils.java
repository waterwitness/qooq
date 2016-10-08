package com.tencent.smtt.utils;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogFileUtils
{
  private static final String LOG_TAG = "LOG_FILE";
  private static final int MAX_SIZE = 2097152;
  private static OutputStream outputStream = null;
  private static final String private_key = "%$%&*)f4";
  
  public static void closeOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      Log.e("LOG_FILE", "Couldn't close stream!", paramOutputStream);
    }
  }
  
  public static byte[] encrypt(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec("%$%&*)f4".getBytes("UTF-8"), "RC4"));
      paramString = localCipher.update(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("LOG_FILE", "encrypt exception:" + paramString.getMessage());
    }
    return null;
  }
  
  /* Error */
  public static void writeDataToStorage(java.io.File paramFile, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_1
    //   6: invokestatic 96	com/tencent/smtt/utils/LogFileUtils:encrypt	(Ljava/lang/String;)[B
    //   9: astore 4
    //   11: aload 4
    //   13: ifnull +8 -> 21
    //   16: aconst_null
    //   17: astore_1
    //   18: aload 4
    //   20: astore_3
    //   21: aload_0
    //   22: invokevirtual 102	java/io/File:getParentFile	()Ljava/io/File;
    //   25: invokevirtual 106	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: aload_0
    //   30: invokevirtual 109	java/io/File:isFile	()Z
    //   33: ifeq +31 -> 64
    //   36: aload_0
    //   37: invokevirtual 112	java/io/File:exists	()Z
    //   40: ifeq +24 -> 64
    //   43: aload_0
    //   44: invokevirtual 116	java/io/File:length	()J
    //   47: ldc2_w 117
    //   50: lcmp
    //   51: ifle +13 -> 64
    //   54: aload_0
    //   55: invokevirtual 121	java/io/File:delete	()Z
    //   58: pop
    //   59: aload_0
    //   60: invokevirtual 124	java/io/File:createNewFile	()Z
    //   63: pop
    //   64: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   67: ifnonnull +22 -> 89
    //   70: new 126	java/io/BufferedOutputStream
    //   73: dup
    //   74: new 128	java/io/FileOutputStream
    //   77: dup
    //   78: aload_0
    //   79: iload_2
    //   80: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   83: invokespecial 133	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: putstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   89: aload_1
    //   90: ifnull +29 -> 119
    //   93: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   96: aload_1
    //   97: invokevirtual 136	java/lang/String:getBytes	()[B
    //   100: invokevirtual 140	java/io/OutputStream:write	([B)V
    //   103: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   106: ifnull +9 -> 115
    //   109: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   112: invokevirtual 143	java/io/OutputStream:flush	()V
    //   115: ldc 2
    //   117: monitorexit
    //   118: return
    //   119: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   122: aload_3
    //   123: invokevirtual 140	java/io/OutputStream:write	([B)V
    //   126: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   129: iconst_2
    //   130: newarray <illegal type>
    //   132: dup
    //   133: iconst_0
    //   134: ldc -112
    //   136: bastore
    //   137: dup
    //   138: iconst_1
    //   139: ldc -112
    //   141: bastore
    //   142: invokevirtual 140	java/io/OutputStream:write	([B)V
    //   145: goto -42 -> 103
    //   148: astore_1
    //   149: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   152: ifnull +9 -> 161
    //   155: getstatic 20	com/tencent/smtt/utils/LogFileUtils:outputStream	Ljava/io/OutputStream;
    //   158: invokevirtual 143	java/io/OutputStream:flush	()V
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: ldc 8
    //   166: new 75	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   173: ldc -110
    //   175: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: invokevirtual 149	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   182: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc -105
    //   187: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_2
    //   191: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   194: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: aload_1
    //   198: invokestatic 41	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   201: pop
    //   202: goto -87 -> 115
    //   205: astore_0
    //   206: ldc 2
    //   208: monitorexit
    //   209: aload_0
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramFile	java.io.File
    //   0	211	1	paramString	String
    //   0	211	2	paramBoolean	boolean
    //   1	122	3	localObject	Object
    //   9	10	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	64	148	finally
    //   64	89	148	finally
    //   93	103	148	finally
    //   119	145	148	finally
    //   103	115	163	java/lang/Throwable
    //   149	161	163	java/lang/Throwable
    //   161	163	163	java/lang/Throwable
    //   5	11	205	finally
    //   103	115	205	finally
    //   149	161	205	finally
    //   161	163	205	finally
    //   164	202	205	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\LogFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */