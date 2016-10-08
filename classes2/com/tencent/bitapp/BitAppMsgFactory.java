package com.tencent.bitapp;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class BitAppMsgFactory
{
  public BitAppMsgFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static BitAppMsg a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "getBitAppMsgInstance load class: " + paramString);
    }
    BitAppMsg localBitAppMsg = null;
    if (!TextUtils.isEmpty(paramString)) {
      localBitAppMsg = (BitAppMsg)Class.forName(paramString, false, BitAppMsgFactory.class.getClassLoader()).newInstance();
    }
    return localBitAppMsg;
  }
  
  /* Error */
  public static BitAppMsg a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_2
    //   6: aload_0
    //   7: ifnonnull +7 -> 14
    //   10: aload_2
    //   11: astore_1
    //   12: aload_1
    //   13: areturn
    //   14: new 71	java/io/ObjectInputStream
    //   17: dup
    //   18: new 73	java/io/ByteArrayInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 76	java/io/ByteArrayInputStream:<init>	([B)V
    //   26: invokespecial 79	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_3
    //   33: astore_0
    //   34: aload_2
    //   35: invokevirtual 82	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   38: invokestatic 84	com/tencent/bitapp/BitAppMsgFactory:a	(Ljava/lang/String;)Lcom/tencent/bitapp/BitAppMsg;
    //   41: astore 4
    //   43: aload_2
    //   44: astore_1
    //   45: new 64	com/tencent/bitapp/BitAppMsg
    //   48: dup
    //   49: invokespecial 85	com/tencent/bitapp/BitAppMsg:<init>	()V
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +12 -> 66
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: astore_0
    //   61: aload_3
    //   62: aload_2
    //   63: invokevirtual 89	com/tencent/bitapp/BitAppMsg:readExternal	(Ljava/io/ObjectInput;)V
    //   66: aload_3
    //   67: astore_1
    //   68: aload_2
    //   69: ifnull -57 -> 12
    //   72: aload_2
    //   73: invokevirtual 92	java/io/ObjectInputStream:close	()V
    //   76: aload_3
    //   77: areturn
    //   78: astore_0
    //   79: aload_3
    //   80: astore_1
    //   81: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq -72 -> 12
    //   87: ldc 25
    //   89: iconst_2
    //   90: aload_0
    //   91: invokevirtual 95	java/io/IOException:getMessage	()Ljava/lang/String;
    //   94: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: aload_3
    //   98: areturn
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_1
    //   103: astore_0
    //   104: aload_2
    //   105: astore_1
    //   106: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +15 -> 124
    //   112: aload_2
    //   113: astore_1
    //   114: ldc 25
    //   116: iconst_2
    //   117: aload_3
    //   118: invokevirtual 96	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   121: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_0
    //   125: astore_1
    //   126: aload_2
    //   127: ifnull -115 -> 12
    //   130: aload_2
    //   131: invokevirtual 92	java/io/ObjectInputStream:close	()V
    //   134: aload_0
    //   135: areturn
    //   136: astore_2
    //   137: aload_0
    //   138: astore_1
    //   139: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq -130 -> 12
    //   145: ldc 25
    //   147: iconst_2
    //   148: aload_2
    //   149: invokevirtual 95	java/io/IOException:getMessage	()Ljava/lang/String;
    //   152: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: areturn
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 92	java/io/ObjectInputStream:close	()V
    //   168: aload_0
    //   169: athrow
    //   170: astore_1
    //   171: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -6 -> 168
    //   177: ldc 25
    //   179: iconst_2
    //   180: aload_1
    //   181: invokevirtual 95	java/io/IOException:getMessage	()Ljava/lang/String;
    //   184: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: goto -19 -> 168
    //   190: astore_0
    //   191: goto -31 -> 160
    //   194: astore_3
    //   195: goto -91 -> 104
    //   198: astore_3
    //   199: aload 4
    //   201: astore_0
    //   202: goto -98 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramArrayOfByte	byte[]
    //   1	164	1	localObject	Object
    //   170	11	1	localIOException1	java.io.IOException
    //   5	126	2	localObjectInputStream	java.io.ObjectInputStream
    //   136	13	2	localIOException2	java.io.IOException
    //   3	95	3	localBitAppMsg1	BitAppMsg
    //   99	19	3	localException1	Exception
    //   194	1	3	localException2	Exception
    //   198	1	3	localException3	Exception
    //   41	159	4	localBitAppMsg2	BitAppMsg
    // Exception table:
    //   from	to	target	type
    //   72	76	78	java/io/IOException
    //   14	30	99	java/lang/Exception
    //   130	134	136	java/io/IOException
    //   14	30	157	finally
    //   164	168	170	java/io/IOException
    //   34	43	190	finally
    //   45	53	190	finally
    //   61	66	190	finally
    //   106	112	190	finally
    //   114	124	190	finally
    //   34	43	194	java/lang/Exception
    //   61	66	194	java/lang/Exception
    //   45	53	198	java/lang/Exception
  }
  
  public static BitAppMsg a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new BitAppMsg(paramArrayOfByte, paramInt);
      return paramArrayOfByte;
    }
    catch (BitAppMsg.BitAppMsgCreateExcepton paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMsgFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */