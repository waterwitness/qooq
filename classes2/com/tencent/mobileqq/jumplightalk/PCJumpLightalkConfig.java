package com.tencent.mobileqq.jumplightalk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PCJumpLightalkConfig
{
  private static PCJumpLightalkConfig a;
  public static final String a = "ProfileCardJumpLightalkConfig";
  public static final String b = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "jumplightalkfiles";
  public static final String c = b + File.separator + "profile_card_jump_lightalk_config";
  public static final String d = "__";
  public String e;
  public String f;
  public String g;
  public String h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static PCJumpLightalkConfig a(String paramString)
  {
    // Byte code:
    //   0: new 49	java/io/File
    //   3: dup
    //   4: new 28	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 67	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:c	Ljava/lang/String;
    //   14: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: getstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   31: ifnull +37 -> 68
    //   34: aload_0
    //   35: invokevirtual 81	java/io/File:exists	()Z
    //   38: ifeq +30 -> 68
    //   41: aload_0
    //   42: invokevirtual 85	java/io/File:length	()J
    //   45: lconst_0
    //   46: lcmp
    //   47: ifle +21 -> 68
    //   50: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +11 -> 64
    //   56: ldc 9
    //   58: iconst_2
    //   59: ldc 92
    //   61: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: getstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   67: areturn
    //   68: aconst_null
    //   69: putstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   72: aload_0
    //   73: invokevirtual 81	java/io/File:exists	()Z
    //   76: ifeq +203 -> 279
    //   79: aload_0
    //   80: invokevirtual 85	java/io/File:length	()J
    //   83: lconst_0
    //   84: lcmp
    //   85: ifle +194 -> 279
    //   88: new 97	java/io/FileInputStream
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: astore_1
    //   97: aload_1
    //   98: astore_0
    //   99: aload_1
    //   100: invokevirtual 104	java/io/FileInputStream:available	()I
    //   103: newarray <illegal type>
    //   105: astore_2
    //   106: aload_1
    //   107: astore_0
    //   108: aload_1
    //   109: aload_2
    //   110: invokevirtual 108	java/io/FileInputStream:read	([B)I
    //   113: pop
    //   114: aload_1
    //   115: astore_0
    //   116: new 110	java/lang/String
    //   119: dup
    //   120: aload_2
    //   121: ldc 112
    //   123: invokespecial 115	java/lang/String:<init>	([BLjava/lang/String;)V
    //   126: astore_2
    //   127: aload_2
    //   128: ifnull +76 -> 204
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: ldc 14
    //   136: invokevirtual 119	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   139: astore_2
    //   140: aload_1
    //   141: astore_0
    //   142: aload_2
    //   143: arraylength
    //   144: iconst_4
    //   145: if_icmpne +59 -> 204
    //   148: aload_1
    //   149: astore_0
    //   150: new 2	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig
    //   153: dup
    //   154: invokespecial 120	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:<init>	()V
    //   157: putstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   160: aload_1
    //   161: astore_0
    //   162: getstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   165: aload_2
    //   166: iconst_0
    //   167: aaload
    //   168: putfield 122	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:e	Ljava/lang/String;
    //   171: aload_1
    //   172: astore_0
    //   173: getstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   176: aload_2
    //   177: iconst_1
    //   178: aaload
    //   179: putfield 124	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:f	Ljava/lang/String;
    //   182: aload_1
    //   183: astore_0
    //   184: getstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   187: aload_2
    //   188: iconst_2
    //   189: aaload
    //   190: putfield 126	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:g	Ljava/lang/String;
    //   193: aload_1
    //   194: astore_0
    //   195: getstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   198: aload_2
    //   199: iconst_3
    //   200: aaload
    //   201: putfield 128	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:h	Ljava/lang/String;
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 131	java/io/FileInputStream:close	()V
    //   212: getstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   215: areturn
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   221: goto -9 -> 212
    //   224: astore_2
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: astore_0
    //   229: aload_2
    //   230: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   233: aload_1
    //   234: astore_0
    //   235: aconst_null
    //   236: putstatic 77	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:a	Lcom/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig;
    //   239: aload_1
    //   240: ifnull -28 -> 212
    //   243: aload_1
    //   244: invokevirtual 131	java/io/FileInputStream:close	()V
    //   247: goto -35 -> 212
    //   250: astore_0
    //   251: aload_0
    //   252: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   255: goto -43 -> 212
    //   258: astore_1
    //   259: aconst_null
    //   260: astore_0
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 131	java/io/FileInputStream:close	()V
    //   269: aload_1
    //   270: athrow
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   276: goto -7 -> 269
    //   279: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -70 -> 212
    //   285: ldc 9
    //   287: iconst_2
    //   288: ldc -120
    //   290: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto -81 -> 212
    //   296: astore_1
    //   297: goto -36 -> 261
    //   300: astore_2
    //   301: goto -74 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString	String
    //   96	148	1	localFileInputStream	java.io.FileInputStream
    //   258	12	1	localObject1	Object
    //   296	1	1	localObject2	Object
    //   105	94	2	localObject3	Object
    //   224	6	2	localIOException1	java.io.IOException
    //   300	1	2	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   208	212	216	java/io/IOException
    //   88	97	224	java/io/IOException
    //   243	247	250	java/io/IOException
    //   88	97	258	finally
    //   265	269	271	java/io/IOException
    //   99	106	296	finally
    //   108	114	296	finally
    //   116	127	296	finally
    //   133	140	296	finally
    //   142	148	296	finally
    //   150	160	296	finally
    //   162	171	296	finally
    //   173	182	296	finally
    //   184	193	296	finally
    //   195	204	296	finally
    //   229	233	296	finally
    //   235	239	296	finally
    //   99	106	300	java/io/IOException
    //   108	114	300	java/io/IOException
    //   116	127	300	java/io/IOException
    //   133	140	300	java/io/IOException
    //   142	148	300	java/io/IOException
    //   150	160	300	java/io/IOException
    //   162	171	300	java/io/IOException
    //   173	182	300	java/io/IOException
    //   184	193	300	java/io/IOException
    //   195	204	300	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    try
    {
      paramString = new File(c + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      a = null;
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ProfileCardJumpLightalkConfig", 2, "delete config error");
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 151	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   4: ifne +24 -> 28
    //   7: aload_1
    //   8: invokestatic 151	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   11: ifne +17 -> 28
    //   14: aload_2
    //   15: invokestatic 151	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   18: ifne +10 -> 28
    //   21: aload_3
    //   22: invokestatic 151	com/tencent/mobileqq/utils/StringUtil:b	(Ljava/lang/String;)Z
    //   25: ifeq +18 -> 43
    //   28: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 9
    //   36: iconst_2
    //   37: ldc -103
    //   39: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: new 49	java/io/File
    //   46: dup
    //   47: getstatic 63	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:b	Ljava/lang/String;
    //   50: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: invokevirtual 156	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: new 49	java/io/File
    //   60: dup
    //   61: new 28	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   68: getstatic 67	com/tencent/mobileqq/jumplightalk/PCJumpLightalkConfig:c	Ljava/lang/String;
    //   71: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 4
    //   76: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore 5
    //   87: aload 5
    //   89: invokevirtual 81	java/io/File:exists	()Z
    //   92: ifeq +9 -> 101
    //   95: aload 5
    //   97: invokevirtual 141	java/io/File:delete	()Z
    //   100: pop
    //   101: aconst_null
    //   102: astore 4
    //   104: aload 5
    //   106: invokevirtual 159	java/io/File:createNewFile	()Z
    //   109: pop
    //   110: new 28	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   117: astore 6
    //   119: aload 6
    //   121: aload_0
    //   122: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 6
    //   128: ldc 14
    //   130: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: aload_1
    //   137: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 6
    //   143: ldc 14
    //   145: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 6
    //   151: aload_2
    //   152: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 6
    //   158: ldc 14
    //   160: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 6
    //   166: aload_3
    //   167: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 6
    //   173: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: ldc 112
    //   178: invokevirtual 163	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   181: astore_2
    //   182: new 165	java/io/FileOutputStream
    //   185: dup
    //   186: aload 5
    //   188: invokespecial 166	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   191: astore_1
    //   192: aload_1
    //   193: astore_0
    //   194: aload_1
    //   195: aload_2
    //   196: invokevirtual 170	java/io/FileOutputStream:write	([B)V
    //   199: aload_1
    //   200: astore_0
    //   201: aload_1
    //   202: invokevirtual 173	java/io/FileOutputStream:flush	()V
    //   205: aload_1
    //   206: ifnull -164 -> 42
    //   209: aload_1
    //   210: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   213: return
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   219: return
    //   220: astore_2
    //   221: aconst_null
    //   222: astore_1
    //   223: aload_1
    //   224: astore_0
    //   225: aload_2
    //   226: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   229: aload_1
    //   230: ifnull -188 -> 42
    //   233: aload_1
    //   234: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   237: return
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   243: return
    //   244: astore_0
    //   245: aload 4
    //   247: astore_1
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   256: aload_0
    //   257: athrow
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   263: goto -7 -> 256
    //   266: astore_2
    //   267: aload_0
    //   268: astore_1
    //   269: aload_2
    //   270: astore_0
    //   271: goto -23 -> 248
    //   274: astore_2
    //   275: goto -52 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramString1	String
    //   0	278	1	paramString2	String
    //   0	278	2	paramString3	String
    //   0	278	3	paramString4	String
    //   0	278	4	paramString5	String
    //   85	102	5	localFile	File
    //   117	55	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   209	213	214	java/io/IOException
    //   104	192	220	java/io/IOException
    //   233	237	238	java/io/IOException
    //   104	192	244	finally
    //   252	256	258	java/io/IOException
    //   194	199	266	finally
    //   201	205	266	finally
    //   225	229	266	finally
    //   194	199	274	java/io/IOException
    //   201	205	274	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jumplightalk\PCJumpLightalkConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */