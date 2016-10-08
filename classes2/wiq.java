import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

public class wiq
  implements Runnable
{
  public wiq(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 27	java/io/File
    //   3: dup
    //   4: getstatic 33	com/tencent/mobileqq/app/AppConstants:da	Ljava/lang/String;
    //   7: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 40	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 43	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: new 45	java/text/SimpleDateFormat
    //   26: dup
    //   27: ldc 47
    //   29: invokespecial 48	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   32: new 50	java/util/Date
    //   35: dup
    //   36: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   39: invokespecial 59	java/util/Date:<init>	(J)V
    //   42: invokevirtual 63	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   45: astore_1
    //   46: new 65	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   53: getstatic 33	com/tencent/mobileqq/app/AppConstants:da	Ljava/lang/String;
    //   56: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 72
    //   61: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 74
    //   70: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_3
    //   77: new 27	java/io/File
    //   80: dup
    //   81: aload_3
    //   82: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 40	java/io/File:exists	()Z
    //   90: ifne +52 -> 142
    //   93: new 80	java/io/FileOutputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore_2
    //   102: aload_2
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 12	wiq:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;
    //   108: invokestatic 88	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;)Landroid/graphics/Bitmap;
    //   111: getstatic 94	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   114: bipush 100
    //   116: aload_2
    //   117: invokevirtual 100	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   120: ifeq +14 -> 134
    //   123: aload_2
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 12	wiq:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;
    //   129: aload_3
    //   130: invokestatic 103	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;Ljava/lang/String;)Ljava/lang/String;
    //   133: pop
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 106	java/io/FileOutputStream:close	()V
    //   142: invokestatic 111	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   145: ifeq +30 -> 175
    //   148: ldc 113
    //   150: iconst_2
    //   151: new 65	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   158: ldc 115
    //   160: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   166: invokevirtual 118	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload_0
    //   176: getfield 12	wiq:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;
    //   179: iconst_0
    //   180: invokestatic 126	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:b	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;Z)Z
    //   183: pop
    //   184: aload_0
    //   185: getfield 12	wiq:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;
    //   188: invokestatic 129	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:b	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;)Z
    //   191: ifeq +24 -> 215
    //   194: aload_0
    //   195: getfield 12	wiq:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;
    //   198: iconst_0
    //   199: invokestatic 132	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:c	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;Z)Z
    //   202: pop
    //   203: aload_0
    //   204: getfield 12	wiq:a	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;
    //   207: invokestatic 135	com/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler:a	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserShareMenuHandler;)Landroid/os/Handler;
    //   210: iconst_3
    //   211: invokevirtual 141	android/os/Handler:sendEmptyMessage	(I)Z
    //   214: pop
    //   215: return
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   221: goto -79 -> 142
    //   224: astore_3
    //   225: aconst_null
    //   226: astore_2
    //   227: aload_2
    //   228: astore_1
    //   229: aload_3
    //   230: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   233: aload_2
    //   234: ifnull -92 -> 142
    //   237: aload_2
    //   238: invokevirtual 106	java/io/FileOutputStream:close	()V
    //   241: goto -99 -> 142
    //   244: astore_1
    //   245: aload_1
    //   246: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   249: goto -107 -> 142
    //   252: astore_2
    //   253: aconst_null
    //   254: astore_1
    //   255: aload_1
    //   256: ifnull +7 -> 263
    //   259: aload_1
    //   260: invokevirtual 106	java/io/FileOutputStream:close	()V
    //   263: aload_2
    //   264: athrow
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual 144	java/lang/Exception:printStackTrace	()V
    //   270: goto -7 -> 263
    //   273: astore_2
    //   274: goto -19 -> 255
    //   277: astore_3
    //   278: goto -51 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	wiq
    //   10	115	1	localObject1	Object
    //   216	2	1	localException1	Exception
    //   228	1	1	localObject2	Object
    //   244	2	1	localException2	Exception
    //   254	6	1	localObject3	Object
    //   265	2	1	localException3	Exception
    //   101	137	2	localFileOutputStream	java.io.FileOutputStream
    //   252	12	2	localObject4	Object
    //   273	1	2	localObject5	Object
    //   76	54	3	str	String
    //   224	6	3	localException4	Exception
    //   277	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   138	142	216	java/lang/Exception
    //   93	102	224	java/lang/Exception
    //   237	241	244	java/lang/Exception
    //   93	102	252	finally
    //   259	263	265	java/lang/Exception
    //   104	123	273	finally
    //   125	134	273	finally
    //   229	233	273	finally
    //   104	123	277	java/lang/Exception
    //   125	134	277	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wiq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */