package com.tencent.mfsdk.reporter;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observer;

public class StackObserver
  implements Observer
{
  private static final String a = "StackObserver";
  private static String b = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void update(java.util.Observable paramObservable, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 33	com/tencent/mfsdk/reporter/StackObservable
    //   4: astore_1
    //   5: aload_1
    //   6: getfield 36	com/tencent/mfsdk/reporter/StackObservable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   9: astore 5
    //   11: aload_1
    //   12: getfield 39	com/tencent/mfsdk/reporter/StackObservable:jdField_a_of_type_Int	I
    //   15: istore 7
    //   17: aload 5
    //   19: ldc 41
    //   21: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 49	java/lang/String
    //   27: astore_1
    //   28: aload 5
    //   30: ldc 51
    //   32: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 49	java/lang/String
    //   38: astore_3
    //   39: aload_1
    //   40: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifeq +4 -> 47
    //   46: return
    //   47: aload_1
    //   48: astore_2
    //   49: aload_3
    //   50: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +22 -> 75
    //   56: new 59	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   63: aload_1
    //   64: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_2
    //   75: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   78: ldc 76
    //   80: invokestatic 81	com/tencent/mobileqq/utils/TimeFormatterUtils:a	(JLjava/lang/String;)Ljava/lang/String;
    //   83: astore 4
    //   85: getstatic 23	com/tencent/mfsdk/reporter/StackObserver:b	Ljava/lang/String;
    //   88: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifeq +100 -> 191
    //   94: invokestatic 87	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   97: invokevirtual 92	java/io/File:getPath	()Ljava/lang/String;
    //   100: astore_3
    //   101: aload_3
    //   102: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +86 -> 191
    //   108: aload_3
    //   109: astore_1
    //   110: aload_3
    //   111: ldc 94
    //   113: invokevirtual 98	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +23 -> 139
    //   119: new 59	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   126: aload_3
    //   127: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 94
    //   132: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore_1
    //   139: new 59	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   146: aload_1
    //   147: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 100
    //   152: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: putstatic 23	com/tencent/mfsdk/reporter/StackObserver:b	Ljava/lang/String;
    //   161: new 89	java/io/File
    //   164: dup
    //   165: getstatic 23	com/tencent/mfsdk/reporter/StackObserver:b	Ljava/lang/String;
    //   168: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 107	java/io/File:exists	()Z
    //   176: ifeq +10 -> 186
    //   179: aload_1
    //   180: invokevirtual 110	java/io/File:isDirectory	()Z
    //   183: ifne +8 -> 191
    //   186: aload_1
    //   187: invokevirtual 113	java/io/File:mkdirs	()Z
    //   190: pop
    //   191: new 59	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   198: getstatic 23	com/tencent/mfsdk/reporter/StackObserver:b	Ljava/lang/String;
    //   201: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 115
    //   206: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 4
    //   211: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 117
    //   216: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore 6
    //   224: new 119	java/io/BufferedWriter
    //   227: dup
    //   228: new 121	java/io/FileWriter
    //   231: dup
    //   232: aload 6
    //   234: invokespecial 122	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   237: invokespecial 125	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   240: astore_3
    //   241: aload_3
    //   242: astore_1
    //   243: aload_3
    //   244: aload_2
    //   245: invokevirtual 128	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   248: aload_3
    //   249: astore_1
    //   250: aload_3
    //   251: invokevirtual 131	java/io/BufferedWriter:flush	()V
    //   254: aload_3
    //   255: ifnull +7 -> 262
    //   258: aload_3
    //   259: invokevirtual 134	java/io/BufferedWriter:close	()V
    //   262: new 136	java/util/concurrent/ConcurrentHashMap
    //   265: dup
    //   266: iconst_2
    //   267: invokespecial 139	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   270: astore_2
    //   271: new 43	java/util/HashMap
    //   274: dup
    //   275: iconst_1
    //   276: invokespecial 140	java/util/HashMap:<init>	(I)V
    //   279: astore_3
    //   280: aload_3
    //   281: ldc -114
    //   283: aload 6
    //   285: invokevirtual 146	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: pop
    //   289: new 43	java/util/HashMap
    //   292: dup
    //   293: bipush 10
    //   295: invokespecial 140	java/util/HashMap:<init>	(I)V
    //   298: astore 4
    //   300: aload 4
    //   302: ldc -108
    //   304: iconst_1
    //   305: invokestatic 152	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   308: invokevirtual 146	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   311: pop
    //   312: aload 5
    //   314: ldc -102
    //   316: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   319: checkcast 49	java/lang/String
    //   322: astore_1
    //   323: aload_1
    //   324: ifnull +130 -> 454
    //   327: aload 4
    //   329: ldc -100
    //   331: aload_1
    //   332: invokevirtual 146	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   335: pop
    //   336: aload 4
    //   338: ldc -98
    //   340: iload 7
    //   342: invokestatic 152	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   345: invokevirtual 146	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   348: pop
    //   349: aload 4
    //   351: ldc -96
    //   353: aload 5
    //   355: ldc -94
    //   357: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 49	java/lang/String
    //   363: invokevirtual 146	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: aload_2
    //   368: ldc -92
    //   370: aload_3
    //   371: invokevirtual 165	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: pop
    //   375: aload_2
    //   376: ldc -89
    //   378: aload 4
    //   380: invokevirtual 165	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aconst_null
    //   385: new 169	com/tencent/mfsdk/collector/ResultObject
    //   388: dup
    //   389: iconst_0
    //   390: ldc -85
    //   392: iconst_1
    //   393: lconst_1
    //   394: lconst_1
    //   395: aload_2
    //   396: iconst_1
    //   397: iconst_1
    //   398: getstatic 176	com/tencent/mfsdk/MagnifierSDK:a	J
    //   401: invokespecial 179	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLjava/util/concurrent/ConcurrentHashMap;ZZJ)V
    //   404: invokestatic 184	com/tencent/mfsdk/reporter/ReporterMachine:a	(Landroid/content/Context;Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   407: return
    //   408: astore 4
    //   410: aconst_null
    //   411: astore_2
    //   412: aload_2
    //   413: astore_1
    //   414: ldc 10
    //   416: iconst_2
    //   417: aload 4
    //   419: iconst_0
    //   420: anewarray 4	java/lang/Object
    //   423: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   426: aload_2
    //   427: ifnull -165 -> 262
    //   430: aload_2
    //   431: invokevirtual 134	java/io/BufferedWriter:close	()V
    //   434: goto -172 -> 262
    //   437: astore_1
    //   438: goto -176 -> 262
    //   441: astore_2
    //   442: aconst_null
    //   443: astore_1
    //   444: aload_1
    //   445: ifnull +7 -> 452
    //   448: aload_1
    //   449: invokevirtual 134	java/io/BufferedWriter:close	()V
    //   452: aload_2
    //   453: athrow
    //   454: ldc 21
    //   456: astore_1
    //   457: goto -130 -> 327
    //   460: astore_1
    //   461: goto -199 -> 262
    //   464: astore_1
    //   465: goto -13 -> 452
    //   468: astore_2
    //   469: goto -25 -> 444
    //   472: astore 4
    //   474: aload_3
    //   475: astore_2
    //   476: goto -64 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	StackObserver
    //   0	479	1	paramObservable	java.util.Observable
    //   0	479	2	paramObject	Object
    //   38	437	3	localObject1	Object
    //   83	296	4	localObject2	Object
    //   408	10	4	localIOException1	java.io.IOException
    //   472	1	4	localIOException2	java.io.IOException
    //   9	345	5	localHashMap	java.util.HashMap
    //   222	62	6	str	String
    //   15	326	7	i	int
    // Exception table:
    //   from	to	target	type
    //   224	241	408	java/io/IOException
    //   430	434	437	java/io/IOException
    //   224	241	441	finally
    //   258	262	460	java/io/IOException
    //   448	452	464	java/io/IOException
    //   243	248	468	finally
    //   250	254	468	finally
    //   414	426	468	finally
    //   243	248	472	java/io/IOException
    //   250	254	472	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\reporter\StackObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */