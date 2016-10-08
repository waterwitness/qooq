package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MagicfaceResLoader
{
  public static final String a = "MagicfaceResLoader";
  public static final String b = "audio";
  public static final String c = "small";
  public static final String d = "big";
  public static final String e = "xbig";
  public static final String f = "sbig";
  public static final String g = "video";
  public static String h;
  public static String i;
  private String j;
  
  public MagicfaceResLoader(String paramString)
  {
    this(paramString, 1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MagicfaceResLoader(String paramString, int paramInt)
  {
    this.j = paramString;
    a(paramInt);
  }
  
  public static String a()
  {
    return a(1);
  }
  
  public static String a(int paramInt)
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceResLoader", 2, "func getVideoPath begins.");
    }
    if ((i != null) && (paramInt == 1))
    {
      h = i;
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[1]. videoPath:" + h);
      }
      return h;
    }
    if ((paramInt == 2) || (paramInt == 3))
    {
      h = "video";
      return h;
    }
    long l = Math.min(DeviceInfoUtil.f(), DeviceInfoUtil.g());
    boolean bool = DeviceInfoUtil.d();
    if (DeviceInfoUtil.b() >= 2)
    {
      paramInt = k;
      if (l < 852L) {
        break label199;
      }
      if (!bool) {
        break label179;
      }
      h = "sbig";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceResLoader", 2, "func getVideoPath ends[2]. videoPath:" + h);
      }
      i = h;
      return h;
      paramInt = 0;
      break;
      label179:
      if (paramInt != 0)
      {
        h = "xbig";
      }
      else
      {
        h = "big";
        continue;
        label199:
        if (l >= 640L)
        {
          if (paramInt != 0) {
            h = "xbig";
          } else {
            h = "big";
          }
        }
        else if (l >= 480L) {
          h = "big";
        } else {
          h = "small";
        }
      }
    }
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 108	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: astore_2
    //   15: aload 4
    //   17: invokevirtual 113	java/io/File:exists	()Z
    //   20: ifne +38 -> 58
    //   23: new 108	java/io/File
    //   26: dup
    //   27: aload_1
    //   28: ldc 20
    //   30: ldc 17
    //   32: invokevirtual 119	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   35: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_2
    //   39: aload_2
    //   40: invokevirtual 113	java/io/File:exists	()Z
    //   43: istore 7
    //   45: iload 7
    //   47: ifne +11 -> 58
    //   50: new 121	java/lang/NullPointerException
    //   53: dup
    //   54: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   57: athrow
    //   58: new 124	java/io/FileInputStream
    //   61: dup
    //   62: aload_2
    //   63: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 132	java/io/InputStream:available	()I
    //   71: istore 6
    //   73: iload 6
    //   75: newarray <illegal type>
    //   77: astore_2
    //   78: aload_1
    //   79: aload_2
    //   80: invokevirtual 136	java/io/InputStream:read	([B)I
    //   83: istore 5
    //   85: iload 5
    //   87: iload 6
    //   89: if_icmpeq +3 -> 92
    //   92: aload_1
    //   93: invokevirtual 139	java/io/InputStream:close	()V
    //   96: aload_2
    //   97: areturn
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 139	java/io/InputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_1
    //   108: aconst_null
    //   109: areturn
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_3
    //   114: astore_2
    //   115: aload_1
    //   116: invokevirtual 139	java/io/InputStream:close	()V
    //   119: aload_2
    //   120: areturn
    //   121: astore_1
    //   122: aload_2
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: goto -32 -> 96
    //   131: astore_2
    //   132: aload_3
    //   133: astore_2
    //   134: goto -19 -> 115
    //   137: astore_3
    //   138: goto -23 -> 115
    //   141: astore_2
    //   142: goto -41 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	MagicfaceResLoader
    //   0	145	1	paramString	String
    //   14	109	2	localObject1	Object
    //   131	1	2	localObject2	Object
    //   133	1	2	localObject3	Object
    //   141	1	2	localException	Exception
    //   1	132	3	localObject4	Object
    //   137	1	3	localObject5	Object
    //   10	6	4	localFile	File
    //   83	7	5	k	int
    //   71	19	6	m	int
    //   43	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	98	java/lang/Exception
    //   15	45	98	java/lang/Exception
    //   58	67	98	java/lang/Exception
    //   101	105	107	java/lang/Exception
    //   2	12	110	finally
    //   15	45	110	finally
    //   58	67	110	finally
    //   115	119	121	java/lang/Exception
    //   50	58	124	java/lang/Exception
    //   92	96	127	java/lang/Exception
    //   67	78	131	finally
    //   78	85	137	finally
    //   67	78	141	java/lang/Exception
    //   78	85	141	java/lang/Exception
  }
  
  public MagicfaceData a(String paramString1, String paramString2)
  {
    MagicfaceData localMagicfaceData = new MagicfaceData();
    localMagicfaceData.b = a(this.j + h + File.separator + paramString1);
    localMagicfaceData.a = a(this.j + h + File.separator + paramString2);
    return localMagicfaceData;
  }
  
  public String a(String paramString)
  {
    return c(this.j + h + File.separator + paramString);
  }
  
  public String b(String paramString)
  {
    return this.j + "audio" + File.separator + paramString;
  }
  
  /* Error */
  public String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 108	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: invokevirtual 113	java/io/File:exists	()Z
    //   18: ifne +38 -> 56
    //   21: new 108	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: ldc 20
    //   28: ldc 17
    //   30: invokevirtual 119	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   33: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 113	java/io/File:exists	()Z
    //   41: istore 5
    //   43: iload 5
    //   45: ifne +11 -> 56
    //   48: new 121	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: new 124	java/io/FileInputStream
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore_3
    //   65: aload_3
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 132	java/io/InputStream:available	()I
    //   71: newarray <illegal type>
    //   73: astore_2
    //   74: aload_3
    //   75: astore_1
    //   76: aload_3
    //   77: aload_2
    //   78: invokevirtual 136	java/io/InputStream:read	([B)I
    //   81: pop
    //   82: aload_3
    //   83: astore_1
    //   84: new 115	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: ldc -98
    //   91: invokespecial 161	java/lang/String:<init>	([BLjava/lang/String;)V
    //   94: astore_2
    //   95: aload_3
    //   96: astore_1
    //   97: aload_2
    //   98: ldc -93
    //   100: ldc -91
    //   102: invokevirtual 169	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 4
    //   107: aload_3
    //   108: invokevirtual 139	java/io/InputStream:close	()V
    //   111: aload 4
    //   113: areturn
    //   114: astore_1
    //   115: aload 4
    //   117: areturn
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_3
    //   121: aload_3
    //   122: astore_1
    //   123: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +33 -> 159
    //   129: aload_3
    //   130: astore_1
    //   131: ldc 8
    //   133: iconst_2
    //   134: new 67	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   141: ldc -85
    //   143: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_2
    //   147: invokevirtual 174	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   150: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_3
    //   160: invokevirtual 139	java/io/InputStream:close	()V
    //   163: aload 4
    //   165: areturn
    //   166: astore_1
    //   167: aload 4
    //   169: areturn
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 139	java/io/InputStream:close	()V
    //   177: aload_2
    //   178: athrow
    //   179: astore_1
    //   180: aconst_null
    //   181: areturn
    //   182: astore_1
    //   183: goto -6 -> 177
    //   186: astore_2
    //   187: goto -14 -> 173
    //   190: astore_2
    //   191: goto -70 -> 121
    //   194: astore_1
    //   195: aload_2
    //   196: astore 4
    //   198: aload_1
    //   199: astore_2
    //   200: goto -79 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	MagicfaceResLoader
    //   0	203	1	paramString	String
    //   13	85	2	localObject1	Object
    //   118	29	2	localException1	Exception
    //   170	8	2	localObject2	Object
    //   186	1	2	localObject3	Object
    //   190	6	2	localException2	Exception
    //   199	1	2	str	String
    //   11	149	3	localObject4	Object
    //   1	196	4	localObject5	Object
    //   41	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   107	111	114	java/lang/Exception
    //   3	12	118	java/lang/Exception
    //   14	43	118	java/lang/Exception
    //   56	65	118	java/lang/Exception
    //   159	163	166	java/lang/Exception
    //   3	12	170	finally
    //   14	43	170	finally
    //   56	65	170	finally
    //   48	56	179	java/lang/Exception
    //   173	177	182	java/lang/Exception
    //   67	74	186	finally
    //   76	82	186	finally
    //   84	95	186	finally
    //   97	107	186	finally
    //   123	129	186	finally
    //   131	159	186	finally
    //   67	74	190	java/lang/Exception
    //   76	82	190	java/lang/Exception
    //   84	95	190	java/lang/Exception
    //   97	107	194	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\model\MagicfaceResLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */