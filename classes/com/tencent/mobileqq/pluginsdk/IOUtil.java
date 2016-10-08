package com.tencent.mobileqq.pluginsdk;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

public class IOUtil
{
  public static final long CRC32_VALUE_INVALID = -1L;
  private static final String a = "IOUtil";
  
  public static void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static void closeZipFile(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {}
    try
    {
      paramZipFile.close();
      return;
    }
    catch (IOException paramZipFile)
    {
      paramZipFile.printStackTrace();
    }
  }
  
  /* Error */
  public static boolean contentEquals(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnull +14 -> 20
    //   9: aload_0
    //   10: invokevirtual 44	java/io/File:exists	()Z
    //   13: ifeq +7 -> 20
    //   16: aload_1
    //   17: ifnonnull +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: new 46	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: new 51	java/io/ByteArrayInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokevirtual 57	java/lang/String:getBytes	()[B
    //   39: invokespecial 60	java/io/ByteArrayInputStream:<init>	([B)V
    //   42: astore_0
    //   43: aload_2
    //   44: aload_0
    //   45: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   48: istore 5
    //   50: aload_2
    //   51: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   54: aload_0
    //   55: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   58: iload 5
    //   60: ireturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_0
    //   64: aload 4
    //   66: astore_1
    //   67: aload_2
    //   68: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   71: aload_1
    //   72: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   75: aload_0
    //   76: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   79: iconst_0
    //   80: ireturn
    //   81: astore_0
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_3
    //   85: astore_1
    //   86: aload_2
    //   87: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   90: aload_1
    //   91: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   94: aload_0
    //   95: athrow
    //   96: astore_0
    //   97: aload_3
    //   98: astore_1
    //   99: goto -13 -> 86
    //   102: astore_3
    //   103: aload_0
    //   104: astore_1
    //   105: aload_3
    //   106: astore_0
    //   107: goto -21 -> 86
    //   110: astore_3
    //   111: aload_1
    //   112: astore_2
    //   113: aload_0
    //   114: astore_1
    //   115: aload_3
    //   116: astore_0
    //   117: goto -31 -> 86
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_2
    //   124: astore_1
    //   125: aload_3
    //   126: astore_2
    //   127: goto -60 -> 67
    //   130: astore_3
    //   131: aload_2
    //   132: astore_1
    //   133: aload_3
    //   134: astore_2
    //   135: goto -68 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramFile	java.io.File
    //   0	138	1	paramString	String
    //   30	21	2	localFileInputStream	java.io.FileInputStream
    //   61	7	2	localException1	Exception
    //   83	52	2	localObject1	Object
    //   1	97	3	localObject2	Object
    //   102	4	3	localObject3	Object
    //   110	6	3	localObject4	Object
    //   120	6	3	localException2	Exception
    //   130	4	3	localException3	Exception
    //   3	62	4	localObject5	Object
    //   48	11	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   22	31	61	java/lang/Exception
    //   22	31	81	finally
    //   31	43	96	finally
    //   43	50	102	finally
    //   67	71	110	finally
    //   31	43	120	java/lang/Exception
    //   43	50	130	java/lang/Exception
  }
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
    throws IOException
  {
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    int i = ((InputStream)localObject).read();
    if (-1 != i) {
      if (i == paramInputStream1.read()) {}
    }
    while (paramInputStream1.read() != -1)
    {
      return false;
      i = ((InputStream)localObject).read();
      break;
    }
    return true;
  }
  
  /* Error */
  public static long getCRC32Value(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 44	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: ldc2_w 7
    //   14: lreturn
    //   15: new 46	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokestatic 83	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/InputStream;)J
    //   30: lstore_3
    //   31: aload_1
    //   32: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   35: lload_3
    //   36: lreturn
    //   37: astore_2
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   46: aload_1
    //   47: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   50: ldc2_w 7
    //   53: lreturn
    //   54: astore_1
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_0
    //   58: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   61: aload_1
    //   62: athrow
    //   63: astore_1
    //   64: goto -7 -> 57
    //   67: astore_2
    //   68: goto -28 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramFile	java.io.File
    //   23	24	1	localFileInputStream	java.io.FileInputStream
    //   54	8	1	localObject1	Object
    //   63	1	1	localObject2	Object
    //   37	6	2	localException1	Exception
    //   67	1	2	localException2	Exception
    //   30	6	3	l	long
    // Exception table:
    //   from	to	target	type
    //   15	24	37	java/lang/Exception
    //   15	24	54	finally
    //   26	31	63	finally
    //   42	46	63	finally
    //   26	31	67	java/lang/Exception
  }
  
  public static long getCRC32Value(InputStream paramInputStream)
    throws Exception
  {
    long l1 = System.currentTimeMillis();
    int i = paramInputStream.available();
    byte[] arrayOfByte = new byte[' '];
    CRC32 localCRC32 = new CRC32();
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, j);
    }
    long l2 = localCRC32.getValue();
    if (QLog.isColorLevel()) {
      QLog.d("IOUtil", 2, "getCRC32Value fileTotalSize = " + i + " takeTime = " + (System.currentTimeMillis() - l1));
    }
    return l2;
  }
  
  /* Error */
  public static byte[] readByte(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 40	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 44	java/io/File:exists	()Z
    //   22: ifeq -15 -> 7
    //   25: new 46	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 92	java/io/InputStream:available	()I
    //   40: newarray <illegal type>
    //   42: astore_2
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 98	java/io/InputStream:read	([B)I
    //   50: pop
    //   51: aload_1
    //   52: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   55: aload_2
    //   56: areturn
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   66: aload_1
    //   67: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: aload_2
    //   78: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_0
    //   85: astore_2
    //   86: goto -9 -> 77
    //   89: astore_2
    //   90: goto -30 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString	String
    //   33	49	1	localObject1	Object
    //   83	1	1	localObject2	Object
    //   42	14	2	arrayOfByte	byte[]
    //   57	6	2	localException1	Exception
    //   74	12	2	localObject3	Object
    //   89	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   25	34	57	java/lang/Exception
    //   25	34	72	finally
    //   36	43	83	finally
    //   45	51	83	finally
    //   62	66	83	finally
    //   36	43	89	java/lang/Exception
    //   45	51	89	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\IOUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */