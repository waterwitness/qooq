package com.tencent.mqp.app.dbfs;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;

public class DBSecurity
{
  public static final int a = 8;
  private static final String jdField_a_of_type_JavaLangString = "PBE_PWD";
  public static final int b = 100;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public DBSecurity(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(paramContext);
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 10
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 34	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)Z
    //   7: istore 6
    //   9: iload 6
    //   11: ifeq +60 -> 71
    //   14: aload_0
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 37	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)[B
    //   20: ldc 10
    //   22: invokevirtual 43	java/lang/String:getBytes	()[B
    //   25: invokestatic 46	com/tencent/mqp/app/dbfs/DBSecurity:b	([B[B)[B
    //   28: putfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   31: aload_0
    //   32: getfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   35: ifnull +13 -> 48
    //   38: aload_0
    //   39: getfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   42: arraylength
    //   43: bipush 8
    //   45: if_icmpge +26 -> 71
    //   48: ldc2_w 49
    //   51: invokestatic 56	java/lang/Thread:sleep	(J)V
    //   54: aload_0
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 37	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;)[B
    //   60: ldc 10
    //   62: invokevirtual 43	java/lang/String:getBytes	()[B
    //   65: invokestatic 46	com/tencent/mqp/app/dbfs/DBSecurity:b	([B[B)[B
    //   68: putfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   71: aload_0
    //   72: getfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   75: ifnull +17 -> 92
    //   78: aload_0
    //   79: getfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   82: arraylength
    //   83: istore 5
    //   85: iload 5
    //   87: bipush 8
    //   89: if_icmpge +81 -> 170
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_1
    //   95: ldc 58
    //   97: invokevirtual 64	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   100: checkcast 66	android/telephony/TelephonyManager
    //   103: invokevirtual 70	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   106: astore 4
    //   108: aload 4
    //   110: ifnull +19 -> 129
    //   113: aload 4
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: invokevirtual 74	java/lang/String:length	()I
    //   124: bipush 8
    //   126: if_icmpge +107 -> 233
    //   129: aload 4
    //   131: astore_2
    //   132: aload_1
    //   133: ldc 76
    //   135: invokevirtual 64	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   138: checkcast 78	android/net/wifi/WifiManager
    //   141: invokevirtual 82	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   144: invokevirtual 87	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   147: astore_3
    //   148: aload_3
    //   149: astore_2
    //   150: aload_2
    //   151: ifnull +12 -> 163
    //   154: aload_2
    //   155: invokevirtual 74	java/lang/String:length	()I
    //   158: bipush 8
    //   160: if_icmpge +54 -> 214
    //   163: aload_0
    //   164: invokestatic 89	com/tencent/mqp/app/dbfs/DBSecurity:a	()[B
    //   167: putfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   170: aload_1
    //   171: aload_0
    //   172: getfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   175: ldc 10
    //   177: invokevirtual 43	java/lang/String:getBytes	()[B
    //   180: invokestatic 91	com/tencent/mqp/app/dbfs/DBSecurity:a	([B[B)[B
    //   183: invokestatic 94	com/tencent/mqp/app/dbfs/DBSecurity:a	(Landroid/content/Context;[B)V
    //   186: ldc 10
    //   188: monitorexit
    //   189: return
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   195: goto -124 -> 71
    //   198: astore_1
    //   199: ldc 10
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    //   204: astore_3
    //   205: aload_3
    //   206: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   209: aload_2
    //   210: astore_3
    //   211: goto +22 -> 233
    //   214: aload_0
    //   215: aload_2
    //   216: invokevirtual 43	java/lang/String:getBytes	()[B
    //   219: putfield 48	com/tencent/mqp/app/dbfs/DBSecurity:a	[B
    //   222: goto -52 -> 170
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 98	java/io/IOException:printStackTrace	()V
    //   230: goto -44 -> 186
    //   233: aload_3
    //   234: astore_2
    //   235: goto -85 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	DBSecurity
    //   0	238	1	paramContext	Context
    //   93	62	2	localObject1	Object
    //   190	26	2	localException1	Exception
    //   234	1	2	localObject2	Object
    //   118	31	3	str1	String
    //   204	2	3	localException2	Exception
    //   210	24	3	localException3	Exception
    //   106	24	4	str2	String
    //   83	7	5	i	int
    //   7	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   14	48	190	java/lang/Exception
    //   48	71	190	java/lang/Exception
    //   3	9	198	finally
    //   14	48	198	finally
    //   48	71	198	finally
    //   71	85	198	finally
    //   94	108	198	finally
    //   119	129	198	finally
    //   132	148	198	finally
    //   154	163	198	finally
    //   163	170	198	finally
    //   170	186	198	finally
    //   186	189	198	finally
    //   191	195	198	finally
    //   199	202	198	finally
    //   205	209	198	finally
    //   214	222	198	finally
    //   226	230	198	finally
    //   94	108	204	java/lang/Exception
    //   119	129	204	java/lang/Exception
    //   132	148	204	java/lang/Exception
    //   170	186	225	java/io/IOException
  }
  
  private static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    paramContext = paramContext.openFileOutput("PBE_PWD", 0);
    paramContext.write(paramArrayOfByte);
    paramContext.close();
  }
  
  private static boolean a(Context paramContext)
  {
    return (paramContext.getFileStreamPath("PBE_PWD") != null) && (paramContext.getFileStreamPath("PBE_PWD").exists());
  }
  
  private static byte[] a()
  {
    return new SecureRandom().generateSeed(8);
  }
  
  private byte[] a(Context paramContext)
  {
    paramContext = paramContext.openFileInput("PBE_PWD");
    byte[] arrayOfByte = new byte[paramContext.available()];
    paramContext.read(arrayOfByte);
    paramContext.close();
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    return a(a(a(paramArrayOfByte1, true), a(paramArrayOfByte2, false)), false);
  }
  
  private static byte[] a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = paramArrayOfInt.length << 2;
    int i;
    if (paramBoolean)
    {
      int k = paramArrayOfInt[(paramArrayOfInt.length - 1)];
      i = k;
      if (k > j) {
        return null;
      }
    }
    else
    {
      i = j;
    }
    byte[] arrayOfByte = new byte[i];
    j = 0;
    while (j < i)
    {
      arrayOfByte[j] = ((byte)(paramArrayOfInt[(j >>> 2)] >>> ((j & 0x3) << 3) & 0xFF));
      j += 1;
    }
    return arrayOfByte;
  }
  
  private static int[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i;
    int[] arrayOfInt;
    if ((paramArrayOfByte.length & 0x3) == 0)
    {
      i = paramArrayOfByte.length >>> 2;
      if (!paramBoolean) {
        break label83;
      }
      arrayOfInt = new int[i + 1];
      arrayOfInt[i] = paramArrayOfByte.length;
    }
    for (;;)
    {
      int j = paramArrayOfByte.length;
      i = 0;
      while (i < j)
      {
        int k = i >>> 2;
        arrayOfInt[k] |= (paramArrayOfByte[i] & 0xFF) << ((i & 0x3) << 3);
        i += 1;
      }
      i = (paramArrayOfByte.length >>> 2) + 1;
      break;
      label83:
      arrayOfInt = new int[i];
    }
    return arrayOfInt;
  }
  
  private static final int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i1 = paramArrayOfInt1.length - 1;
    if (i1 < 1) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[i1];
      int j = paramArrayOfInt1[0];
      j = 52 / (i1 + 1);
      int k = 0;
      j += 6;
      while (j > 0)
      {
        int m = k - 1640531527;
        int i2 = m >>> 2 & 0x3;
        int n = 0;
        k = i;
        i = n;
        while (i < i1)
        {
          n = paramArrayOfInt1[(i + 1)];
          i3 = paramArrayOfInt1[i];
          k = ((k ^ arrayOfInt[(i & 0x3 ^ i2)]) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
          paramArrayOfInt1[i] = k;
          i += 1;
        }
        n = paramArrayOfInt1[0];
        int i3 = paramArrayOfInt1[i1];
        i = ((arrayOfInt[(i & 0x3 ^ i2)] ^ k) + (n ^ m) ^ (k >>> 5 ^ n << 2) + (n >>> 3 ^ k << 4)) + i3;
        paramArrayOfInt1[i1] = i;
        j -= 1;
        k = m;
      }
    }
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 0) {
      return paramArrayOfByte1;
    }
    return a(b(a(paramArrayOfByte1, false), a(paramArrayOfByte2, false)), true);
  }
  
  private static final int[] b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = paramArrayOfInt1.length - 1;
    if (m < 1) {}
    for (;;)
    {
      return paramArrayOfInt1;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < 4)
      {
        arrayOfInt = new int[4];
        System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, 0, paramArrayOfInt2.length);
      }
      int i = paramArrayOfInt1[m];
      i = paramArrayOfInt1[0];
      int j = (52 / (m + 1) + 6) * -1640531527;
      while (j != 0)
      {
        int n = j >>> 2 & 0x3;
        int k = i;
        i = m;
        while (i > 0)
        {
          i1 = paramArrayOfInt1[(i - 1)];
          k = paramArrayOfInt1[i] - ((k ^ j) + (i1 ^ arrayOfInt[(i & 0x3 ^ n)]) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
          paramArrayOfInt1[i] = k;
          i -= 1;
        }
        int i1 = paramArrayOfInt1[m];
        i = paramArrayOfInt1[0] - ((arrayOfInt[(i & 0x3 ^ n)] ^ i1) + (k ^ j) ^ (i1 >>> 5 ^ k << 2) + (k >>> 3 ^ i1 << 4));
        paramArrayOfInt1[0] = i;
        j += 1640531527;
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = a();
    if (this.a != null) {
      try
      {
        byte[] arrayOfByte2 = a(paramArrayOfByte, a(this.a, arrayOfByte1));
        byte[] arrayOfByte4 = new byte[arrayOfByte2.length + 8];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte4, 0, arrayOfByte2.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte4, arrayOfByte2.length, 8);
        return arrayOfByte4;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    byte[] arrayOfByte3 = new byte[paramArrayOfByte.length + 8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, 0, paramArrayOfByte.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, paramArrayOfByte.length, 8);
    return arrayOfByte3;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[8];
    System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 8, arrayOfByte1, 0, 8);
    try
    {
      if (this.a != null)
      {
        byte[] arrayOfByte3 = new byte[paramArrayOfByte.length - 8];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte3, 0, paramArrayOfByte.length - 8);
        arrayOfByte1 = b(arrayOfByte3, a(this.a, arrayOfByte1));
        return arrayOfByte1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - 8];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, paramArrayOfByte.length - 8);
      return arrayOfByte2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\dbfs\DBSecurity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */