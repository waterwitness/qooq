package com.tencent.smtt.sdk;

class X5CoreEngine
{
  private static final String TAG = "X5CoreEngine";
  private static X5CoreEngine mInstance;
  private boolean mCanUseX5;
  private boolean mIsInited;
  private X5CoreWizard mX5CoreWizard;
  
  public static X5CoreEngine getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new X5CoreEngine();
      }
      X5CoreEngine localX5CoreEngine = mInstance;
      return localX5CoreEngine;
    }
    finally {}
  }
  
  /* Error */
  public void init(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: invokestatic 36	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   6: astore_3
    //   7: aload_3
    //   8: aload_1
    //   9: invokevirtual 38	com/tencent/smtt/sdk/SDKEngine:init	(Landroid/content/Context;)V
    //   12: aload_3
    //   13: invokevirtual 42	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   16: ifeq +252 -> 268
    //   19: aload_0
    //   20: getfield 44	com/tencent/smtt/sdk/X5CoreEngine:mIsInited	Z
    //   23: ifeq +17 -> 40
    //   26: aload_1
    //   27: invokestatic 50	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   30: istore 4
    //   32: iload 4
    //   34: ifne +6 -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: new 52	com/tencent/smtt/sdk/X5CoreWizard
    //   44: dup
    //   45: aload_3
    //   46: invokevirtual 56	com/tencent/smtt/sdk/SDKEngine:wizard	()Lcom/tencent/smtt/sdk/TbsWizard;
    //   49: invokevirtual 62	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   52: invokespecial 65	com/tencent/smtt/sdk/X5CoreWizard:<init>	(Lcom/tencent/smtt/export/external/DexLoader;)V
    //   55: putfield 67	com/tencent/smtt/sdk/X5CoreEngine:mX5CoreWizard	Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 67	com/tencent/smtt/sdk/X5CoreEngine:mX5CoreWizard	Lcom/tencent/smtt/sdk/X5CoreWizard;
    //   63: invokevirtual 70	com/tencent/smtt/sdk/X5CoreWizard:canUseX5	()Z
    //   66: putfield 72	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   69: aconst_null
    //   70: astore_2
    //   71: aload_0
    //   72: getfield 72	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   75: ifne +160 -> 235
    //   78: ldc 8
    //   80: ldc 74
    //   82: invokestatic 80	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_3
    //   86: invokevirtual 42	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   89: istore 4
    //   91: iload 4
    //   93: ifeq +192 -> 285
    //   96: aload_2
    //   97: ifnonnull +188 -> 285
    //   100: aload_3
    //   101: invokevirtual 56	com/tencent/smtt/sdk/SDKEngine:wizard	()Lcom/tencent/smtt/sdk/TbsWizard;
    //   104: invokevirtual 62	com/tencent/smtt/sdk/TbsWizard:dexLoader	()Lcom/tencent/smtt/export/external/DexLoader;
    //   107: astore_2
    //   108: aload_2
    //   109: ifnull +239 -> 348
    //   112: aload_2
    //   113: ldc 82
    //   115: ldc 84
    //   117: iconst_0
    //   118: anewarray 86	java/lang/Class
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokevirtual 92	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   128: astore_3
    //   129: aload_3
    //   130: instanceof 31
    //   133: ifeq +210 -> 343
    //   136: aload_3
    //   137: checkcast 31	java/lang/Throwable
    //   140: astore_2
    //   141: new 94	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   148: ldc 97
    //   150: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_2
    //   154: invokevirtual 105	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 107
    //   162: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_2
    //   166: invokevirtual 111	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   169: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: ldc 116
    //   174: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_2
    //   178: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: astore_2
    //   185: aload_3
    //   186: instanceof 121
    //   189: ifeq +151 -> 340
    //   192: aload_3
    //   193: checkcast 121	java/lang/String
    //   196: astore_3
    //   197: aload_3
    //   198: astore_2
    //   199: invokestatic 126	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   202: aload_1
    //   203: sipush 407
    //   206: new 31	java/lang/Throwable
    //   209: dup
    //   210: new 94	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   217: ldc -128
    //   219: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_2
    //   223: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokespecial 131	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   232: invokevirtual 135	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   235: aload_0
    //   236: iconst_1
    //   237: putfield 44	com/tencent/smtt/sdk/X5CoreEngine:mIsInited	Z
    //   240: goto -203 -> 37
    //   243: astore_1
    //   244: aload_0
    //   245: monitorexit
    //   246: aload_1
    //   247: athrow
    //   248: astore_2
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield 72	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   254: aconst_null
    //   255: astore_2
    //   256: goto -185 -> 71
    //   259: astore_2
    //   260: aload_0
    //   261: iconst_0
    //   262: putfield 72	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   265: goto -194 -> 71
    //   268: aload_0
    //   269: iconst_0
    //   270: putfield 72	com/tencent/smtt/sdk/X5CoreEngine:mCanUseX5	Z
    //   273: aconst_null
    //   274: astore_2
    //   275: goto -204 -> 71
    //   278: aload_3
    //   279: invokevirtual 138	java/lang/Throwable:printStackTrace	()V
    //   282: goto -83 -> 199
    //   285: invokestatic 126	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   288: aload_1
    //   289: sipush 407
    //   292: new 31	java/lang/Throwable
    //   295: dup
    //   296: new 94	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   303: ldc -116
    //   305: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_3
    //   309: invokevirtual 42	com/tencent/smtt/sdk/SDKEngine:isTbsAvailable	()Z
    //   312: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   315: ldc -111
    //   317: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_2
    //   321: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokespecial 131	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   330: invokevirtual 135	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   333: goto -98 -> 235
    //   336: astore_3
    //   337: goto -59 -> 278
    //   340: goto -141 -> 199
    //   343: aconst_null
    //   344: astore_2
    //   345: goto -160 -> 185
    //   348: aconst_null
    //   349: astore_3
    //   350: goto -221 -> 129
    //   353: astore_3
    //   354: aconst_null
    //   355: astore_2
    //   356: goto -78 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	X5CoreEngine
    //   0	359	1	paramContext	android.content.Context
    //   70	153	2	localObject1	Object
    //   248	1	2	localNoSuchMethodException	NoSuchMethodException
    //   255	1	2	localObject2	Object
    //   259	1	2	localThrowable1	Throwable
    //   274	82	2	localObject3	Object
    //   6	303	3	localObject4	Object
    //   336	1	3	localThrowable2	Throwable
    //   349	1	3	localObject5	Object
    //   353	1	3	localThrowable3	Throwable
    //   30	62	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	32	243	finally
    //   40	58	243	finally
    //   58	69	243	finally
    //   71	91	243	finally
    //   100	108	243	finally
    //   112	129	243	finally
    //   129	185	243	finally
    //   185	197	243	finally
    //   199	235	243	finally
    //   235	240	243	finally
    //   249	254	243	finally
    //   260	265	243	finally
    //   268	273	243	finally
    //   278	282	243	finally
    //   285	333	243	finally
    //   58	69	248	java/lang/NoSuchMethodException
    //   58	69	259	java/lang/Throwable
    //   185	197	336	java/lang/Throwable
    //   100	108	353	java/lang/Throwable
    //   112	129	353	java/lang/Throwable
    //   129	185	353	java/lang/Throwable
  }
  
  public boolean isX5Core()
  {
    if (QbSdk.mIsSysWebViewForced) {
      return false;
    }
    return this.mCanUseX5;
  }
  
  public X5CoreWizard wizard()
  {
    if (QbSdk.mIsSysWebViewForced) {
      return null;
    }
    return this.mX5CoreWizard;
  }
  
  public X5CoreWizard wizardForCoreTypeConfirmed(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mX5CoreWizard;
    }
    return wizard();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\X5CoreEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */