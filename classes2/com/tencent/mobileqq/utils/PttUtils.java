package com.tencent.mobileqq.utils;

import android.util.SparseIntArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.ByteArrayInputStream;

public class PttUtils
{
  private static final SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private static final String jdField_a_of_type_JavaLangString = "PttUtils";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new SparseIntArray(8);
    a.put(4, 13);
    a.put(12, 14);
    a.put(20, 16);
    a.put(28, 18);
    a.put(36, 20);
    a.put(44, 21);
    a.put(52, 27);
    a.put(60, 32);
  }
  
  private static final boolean a(ByteArrayInputStream paramByteArrayInputStream, int[] paramArrayOfInt)
  {
    paramByteArrayInputStream.read("#!AMR\n".getBytes());
    int j = paramByteArrayInputStream.read();
    int i = 0;
    if ((i >= paramArrayOfInt.length) || (j == paramArrayOfInt[i])) {
      if (i != paramArrayOfInt.length) {
        break label45;
      }
    }
    label45:
    do
    {
      return false;
      i += 1;
      break;
      i = a.get(j, -1);
    } while (i == -1);
    paramArrayOfInt = new byte[i - 1];
    paramByteArrayInputStream.read(paramArrayOfInt);
    for (;;)
    {
      i = paramByteArrayInputStream.read();
      if (i == -1) {
        break label95;
      }
      if (i != j) {
        break;
      }
      paramByteArrayInputStream.read(paramArrayOfInt);
    }
    label95:
    return true;
  }
  
  /* Error */
  public static final boolean a(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 61	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: iload 5
    //   14: istore 4
    //   16: aload_0
    //   17: invokevirtual 68	java/io/File:exists	()Z
    //   20: ifeq +16 -> 36
    //   23: aload_0
    //   24: invokevirtual 72	java/io/File:length	()J
    //   27: lconst_0
    //   28: lcmp
    //   29: ifne +10 -> 39
    //   32: iload 5
    //   34: istore 4
    //   36: iload 4
    //   38: ireturn
    //   39: new 43	java/io/ByteArrayInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokestatic 77	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   47: invokespecial 80	java/io/ByteArrayInputStream:<init>	([B)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_0
    //   53: aload_2
    //   54: aload_1
    //   55: invokestatic 82	com/tencent/mobileqq/utils/PttUtils:a	(Ljava/io/ByteArrayInputStream;[I)Z
    //   58: istore 4
    //   60: iload 4
    //   62: istore 5
    //   64: iload 5
    //   66: istore 4
    //   68: aload_2
    //   69: ifnull -33 -> 36
    //   72: aload_2
    //   73: invokevirtual 85	java/io/ByteArrayInputStream:close	()V
    //   76: iload 5
    //   78: ireturn
    //   79: astore_0
    //   80: iload 5
    //   82: ireturn
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +14 -> 105
    //   94: aload_1
    //   95: astore_0
    //   96: ldc 9
    //   98: iconst_2
    //   99: ldc 92
    //   101: aload_3
    //   102: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: iload 5
    //   107: istore 4
    //   109: aload_1
    //   110: ifnull -74 -> 36
    //   113: aload_1
    //   114: invokevirtual 85	java/io/ByteArrayInputStream:close	()V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_0
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 85	java/io/ByteArrayInputStream:close	()V
    //   133: aload_1
    //   134: athrow
    //   135: astore_0
    //   136: goto -3 -> 133
    //   139: astore_1
    //   140: goto -15 -> 125
    //   143: astore_3
    //   144: aload_2
    //   145: astore_1
    //   146: goto -60 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString	String
    //   0	149	1	paramArrayOfInt	int[]
    //   50	95	2	localByteArrayInputStream	ByteArrayInputStream
    //   83	19	3	localThrowable1	Throwable
    //   143	1	3	localThrowable2	Throwable
    //   14	94	4	bool1	boolean
    //   1	105	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   72	76	79	java/lang/Exception
    //   39	51	83	java/lang/Throwable
    //   113	117	119	java/lang/Exception
    //   39	51	122	finally
    //   129	133	135	java/lang/Exception
    //   53	60	139	finally
    //   88	94	139	finally
    //   96	105	139	finally
    //   53	60	143	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\PttUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */