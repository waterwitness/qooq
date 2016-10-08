package com.tencent.wstt.SSCM;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Utils
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  
  public Utils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final int a(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if ((localObject == null) || (!((NetworkInfo)localObject).isAvailable())) {
      return -1;
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return 0;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
    {
    case 3: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 2;
    }
    return 2;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 62	android/os/Process:myPid	()I
    //   5: istore 5
    //   7: new 64	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   14: ldc 67
    //   16: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload 5
    //   21: invokestatic 77	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 79
    //   29: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore_0
    //   36: ldc 84
    //   38: astore_3
    //   39: new 86	java/io/FileReader
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 89	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: new 91	java/io/BufferedReader
    //   51: dup
    //   52: aload_2
    //   53: sipush 8192
    //   56: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   59: astore 4
    //   61: aload 4
    //   63: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: pop
    //   67: aload 4
    //   69: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: pop
    //   73: aload 4
    //   75: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   78: astore_0
    //   79: aload_0
    //   80: astore_1
    //   81: aload_0
    //   82: ifnull +9 -> 91
    //   85: aload 4
    //   87: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   90: astore_1
    //   91: aload_3
    //   92: astore_0
    //   93: aload_1
    //   94: ifnull +22 -> 116
    //   97: aload_1
    //   98: ldc 99
    //   100: invokevirtual 103	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: astore_0
    //   104: aload_0
    //   105: arraylength
    //   106: bipush 9
    //   108: if_icmplt +32 -> 140
    //   111: aload_0
    //   112: bipush 8
    //   114: aaload
    //   115: astore_0
    //   116: aload_2
    //   117: ifnull +7 -> 124
    //   120: aload_2
    //   121: invokevirtual 106	java/io/FileReader:close	()V
    //   124: aload_0
    //   125: astore_3
    //   126: aload 4
    //   128: ifnull +10 -> 138
    //   131: aload 4
    //   133: invokevirtual 107	java/io/BufferedReader:close	()V
    //   136: aload_0
    //   137: astore_3
    //   138: aload_3
    //   139: areturn
    //   140: ldc 109
    //   142: astore_0
    //   143: goto -27 -> 116
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   151: aload_0
    //   152: areturn
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_0
    //   156: aload_2
    //   157: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 106	java/io/FileReader:close	()V
    //   168: aload_0
    //   169: ifnull -31 -> 138
    //   172: aload_0
    //   173: invokevirtual 107	java/io/BufferedReader:close	()V
    //   176: ldc 84
    //   178: areturn
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   184: ldc 84
    //   186: areturn
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 106	java/io/FileReader:close	()V
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 107	java/io/BufferedReader:close	()V
    //   208: aload_1
    //   209: athrow
    //   210: astore_0
    //   211: aload_0
    //   212: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   215: goto -7 -> 208
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_0
    //   221: goto -29 -> 192
    //   224: astore_1
    //   225: aload 4
    //   227: astore_0
    //   228: goto -36 -> 192
    //   231: astore_3
    //   232: aload_1
    //   233: astore_2
    //   234: aload_3
    //   235: astore_1
    //   236: goto -44 -> 192
    //   239: astore 4
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_2
    //   244: astore_1
    //   245: aload 4
    //   247: astore_2
    //   248: goto -92 -> 156
    //   251: astore_0
    //   252: aload_2
    //   253: astore_1
    //   254: aload_0
    //   255: astore_2
    //   256: aload 4
    //   258: astore_0
    //   259: goto -103 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	138	0	localObject1	Object
    //   179	2	0	localIOException1	java.io.IOException
    //   189	16	0	localObject2	Object
    //   210	2	0	localIOException2	java.io.IOException
    //   220	23	0	localObject3	Object
    //   251	4	0	localIOException3	java.io.IOException
    //   258	1	0	localObject4	Object
    //   1	97	1	localObject5	Object
    //   146	19	1	localIOException4	java.io.IOException
    //   187	22	1	localObject6	Object
    //   218	1	1	localObject7	Object
    //   224	9	1	localObject8	Object
    //   235	19	1	localObject9	Object
    //   47	74	2	localFileReader	java.io.FileReader
    //   153	4	2	localIOException5	java.io.IOException
    //   191	65	2	localObject10	Object
    //   38	101	3	localObject11	Object
    //   231	4	3	localObject12	Object
    //   59	167	4	localBufferedReader	java.io.BufferedReader
    //   239	18	4	localIOException6	java.io.IOException
    //   5	15	5	i	int
    // Exception table:
    //   from	to	target	type
    //   120	124	146	java/io/IOException
    //   131	136	146	java/io/IOException
    //   39	48	153	java/io/IOException
    //   164	168	179	java/io/IOException
    //   172	176	179	java/io/IOException
    //   39	48	187	finally
    //   196	200	210	java/io/IOException
    //   204	208	210	java/io/IOException
    //   48	61	218	finally
    //   61	79	224	finally
    //   85	91	224	finally
    //   97	111	224	finally
    //   156	160	231	finally
    //   48	61	239	java/io/IOException
    //   61	79	251	java/io/IOException
    //   85	91	251	java/io/IOException
    //   97	111	251	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\wstt\SSCM\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */