package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public abstract class RecordParams
{
  public static final byte a = 2;
  public static final int a = 0;
  private static QQRecorder.RecorderParam a;
  public static final String a = "RecordParams";
  public static final boolean a = false;
  public static final int[] a;
  public static final int b = 1;
  private static QQRecorder.RecorderParam b = new QQRecorder.RecorderParam(i, 16000, 1);
  public static final String b = "SPD";
  public static final boolean b = true;
  public static final int c = 8;
  public static final String c = "#!SILK_V3";
  private static boolean c = false;
  public static final int d = 9;
  public static final String d = "#!SILK_V";
  private static final boolean d = true;
  public static final int e = 10;
  public static final String e = "#!AMR\n";
  public static final int f;
  public static final int g = 0;
  public static final int h = 16000;
  public static final int i;
  public static final int j = 10;
  public static final int k = 2;
  public static final int l = 20;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 8000, 12000, 16000, 24000, 36000, 44100, 48000 };
    f = jdField_a_of_type_ArrayOfInt[0];
    i = jdField_a_of_type_ArrayOfInt[2];
    jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(f, 8000, 0);
  }
  
  public static byte a(int paramInt)
  {
    int n;
    for (int m = 0; m < jdField_a_of_type_ArrayOfInt.length; n = (byte)(m + 1)) {
      if (paramInt == jdField_a_of_type_ArrayOfInt[m]) {
        return m;
      }
    }
    return -1;
  }
  
  public static byte a(InputStream paramInputStream)
  {
    byte b1 = -1;
    byte[] arrayOfByte = new byte[10];
    paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (a(arrayOfByte)) {
      b1 = arrayOfByte[0];
    }
    return b1;
  }
  
  public static int a()
  {
    return a().length;
  }
  
  public static int a(byte paramByte)
  {
    int n = 0;
    int m = n;
    if (paramByte >= 0)
    {
      m = n;
      if (paramByte < jdField_a_of_type_ArrayOfInt.length) {
        m = jdField_a_of_type_ArrayOfInt[paramByte];
      }
    }
    return m;
  }
  
  public static int a(double paramDouble)
  {
    return QQRecorder.a(paramDouble);
  }
  
  public static int a(int paramInt)
  {
    return paramInt * 20 * 2 / 1000;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 6
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore 4
    //   16: new 96	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: new 101	java/io/DataInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 104	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_1
    //   34: iload 8
    //   36: istore 7
    //   38: bipush 10
    //   40: newarray <illegal type>
    //   42: astore 5
    //   44: iload 8
    //   46: istore 7
    //   48: aload_1
    //   49: aload 5
    //   51: invokevirtual 107	java/io/DataInputStream:read	([B)I
    //   54: aload 5
    //   56: arraylength
    //   57: if_icmpne +172 -> 229
    //   60: iload 8
    //   62: istore 7
    //   64: aload 5
    //   66: invokestatic 80	com/tencent/mobileqq/utils/RecordParams:a	([B)Z
    //   69: ifeq +6 -> 75
    //   72: iconst_1
    //   73: istore 6
    //   75: iload 6
    //   77: istore 7
    //   79: aload_1
    //   80: invokevirtual 110	java/io/DataInputStream:close	()V
    //   83: iload 6
    //   85: istore 7
    //   87: aload_0
    //   88: invokevirtual 111	java/io/FileInputStream:close	()V
    //   91: aconst_null
    //   92: astore_0
    //   93: aload 4
    //   95: astore_1
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 111	java/io/FileInputStream:close	()V
    //   104: iload 6
    //   106: istore 7
    //   108: aload_1
    //   109: ifnull +11 -> 120
    //   112: aload_1
    //   113: invokevirtual 110	java/io/DataInputStream:close	()V
    //   116: iload 6
    //   118: istore 7
    //   120: iload 7
    //   122: ireturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_0
    //   126: iconst_0
    //   127: istore 6
    //   129: aload_1
    //   130: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 111	java/io/FileInputStream:close	()V
    //   141: iload 6
    //   143: istore 7
    //   145: aload_2
    //   146: ifnull -26 -> 120
    //   149: aload_2
    //   150: invokevirtual 110	java/io/DataInputStream:close	()V
    //   153: iload 6
    //   155: ireturn
    //   156: astore_0
    //   157: iload 6
    //   159: ireturn
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_0
    //   163: aload_3
    //   164: astore_2
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 111	java/io/FileInputStream:close	()V
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 110	java/io/DataInputStream:close	()V
    //   181: aload_1
    //   182: athrow
    //   183: astore_0
    //   184: goto -3 -> 181
    //   187: astore_1
    //   188: aload_3
    //   189: astore_2
    //   190: goto -25 -> 165
    //   193: astore_3
    //   194: aload_1
    //   195: astore_2
    //   196: aload_3
    //   197: astore_1
    //   198: goto -33 -> 165
    //   201: astore_1
    //   202: goto -37 -> 165
    //   205: astore_1
    //   206: iload 7
    //   208: istore 6
    //   210: goto -81 -> 129
    //   213: astore_3
    //   214: aload_1
    //   215: astore_2
    //   216: iload 7
    //   218: istore 6
    //   220: aload_3
    //   221: astore_1
    //   222: goto -93 -> 129
    //   225: astore_0
    //   226: iload 6
    //   228: ireturn
    //   229: iconst_0
    //   230: istore 6
    //   232: goto -136 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramString	String
    //   33	80	1	localObject1	Object
    //   123	7	1	localException1	Exception
    //   160	22	1	localObject2	Object
    //   187	8	1	localObject3	Object
    //   197	1	1	localObject4	Object
    //   201	1	1	localObject5	Object
    //   205	10	1	localException2	Exception
    //   221	1	1	localException3	Exception
    //   10	206	2	localObject6	Object
    //   12	177	3	localObject7	Object
    //   193	4	3	localObject8	Object
    //   213	8	3	localException4	Exception
    //   14	80	4	localObject9	Object
    //   42	23	5	arrayOfByte	byte[]
    //   7	224	6	m	int
    //   1	216	7	n	int
    //   4	57	8	i1	int
    // Exception table:
    //   from	to	target	type
    //   16	25	123	java/lang/Exception
    //   137	141	156	java/lang/Exception
    //   149	153	156	java/lang/Exception
    //   16	25	160	finally
    //   169	173	183	java/lang/Exception
    //   177	181	183	java/lang/Exception
    //   25	34	187	finally
    //   87	91	187	finally
    //   38	44	193	finally
    //   48	60	193	finally
    //   64	72	193	finally
    //   79	83	193	finally
    //   129	133	201	finally
    //   25	34	205	java/lang/Exception
    //   87	91	205	java/lang/Exception
    //   38	44	213	java/lang/Exception
    //   48	60	213	java/lang/Exception
    //   64	72	213	java/lang/Exception
    //   79	83	213	java/lang/Exception
    //   100	104	225	java/lang/Exception
    //   112	116	225	java/lang/Exception
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);
  }
  
  public static QQRecorder.RecorderParam a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    a(paramQQAppInterface, false);
    if (paramBoolean) {}
    for (paramQQAppInterface = b;; paramQQAppInterface = jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam) {
      return new QQRecorder.RecorderParam(paramQQAppInterface.a, paramQQAppInterface.b, paramQQAppInterface.c);
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).getString("SilkCfg", null);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "getSavedSilkCfg: " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static void a()
  {
    c = false;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    BaseApplicationImpl.a.getSharedPreferences("RecordParams_" + paramQQAppInterface.a(), 0).edit().putString("SilkCfg", paramString).commit();
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, " " + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((c) && (!paramBoolean)) {
      return;
    }
    c = true;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "init: false");
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = a(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "init from sp:" + paramQQAppInterface);
        }
        if (paramQQAppInterface != null)
        {
          m = paramQQAppInterface.length();
          if (m != 0) {
            continue;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int m;
        int n;
        int i1;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecordParams", 2, "init params: " + jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c + "-" + jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a + "-" + jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b);
      QLog.d("RecordParams", 2, "init changer params: " + b.c + "-" + b.a + "-" + b.b);
      return;
      paramQQAppInterface = paramQQAppInterface.split("\\|");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length >= 3))
      {
        m = Integer.valueOf(paramQQAppInterface[0]).intValue();
        n = Integer.valueOf(paramQQAppInterface[1]).intValue();
        i1 = Integer.valueOf(paramQQAppInterface[2]).intValue();
        jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(jdField_a_of_type_ArrayOfInt[n], i1, m);
        if (paramQQAppInterface.length >= 6)
        {
          m = Integer.valueOf(paramQQAppInterface[3]).intValue();
          n = Integer.valueOf(paramQQAppInterface[4]).intValue();
          i1 = Integer.valueOf(paramQQAppInterface[5]).intValue();
          b = new QQRecorder.RecorderParam(jdField_a_of_type_ArrayOfInt[n], i1, m);
        }
      }
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 10)) {
      bool = false;
    }
    String str;
    do
    {
      return bool;
      str = PkgTools.c(paramArrayOfByte, 1, 9);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "getSilkFs " + paramArrayOfByte[0] + str);
      }
    } while (str.startsWith("#!SILK_V"));
    return false;
  }
  
  public static byte[] a()
  {
    return a(0, f);
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[0] = a(paramInt);
    System.arraycopy("#!SILK_V3".getBytes(), 0, arrayOfByte, 1, 9);
    return arrayOfByte;
  }
  
  public static byte[] a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return a(paramInt2);
    }
    return "#!AMR\n".getBytes();
  }
  
  public static byte[] a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
    return paramArrayOfByte;
  }
  
  public static int b(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\RecordParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */