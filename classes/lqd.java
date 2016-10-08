import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqd
  extends AsyncTask
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public lqd(JumpActivity paramJumpActivity, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  /* Error */
  protected Uri a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_1
    //   16: iconst_0
    //   17: aaload
    //   18: checkcast 30	android/content/Context
    //   21: astore 12
    //   23: aload_1
    //   24: iconst_1
    //   25: aaload
    //   26: checkcast 32	android/net/Uri
    //   29: astore 13
    //   31: getstatic 38	com/tencent/mobileqq/app/AppConstants:bB	Ljava/lang/String;
    //   34: astore 11
    //   36: aload 12
    //   38: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload 13
    //   43: iconst_1
    //   44: anewarray 44	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc 46
    //   51: aastore
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 52	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +584 -> 644
    //   63: aload_2
    //   64: invokeinterface 58 1 0
    //   69: ifeq +575 -> 644
    //   72: aload_2
    //   73: iconst_0
    //   74: invokeinterface 62 2 0
    //   79: astore_1
    //   80: aload_1
    //   81: astore 4
    //   83: aload_1
    //   84: astore_3
    //   85: aload_2
    //   86: invokeinterface 65 1 0
    //   91: aload_1
    //   92: astore 4
    //   94: aload_1
    //   95: astore_3
    //   96: aload 11
    //   98: invokestatic 70	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   101: ifne +21 -> 122
    //   104: aload_1
    //   105: astore 4
    //   107: aload_1
    //   108: astore_3
    //   109: new 72	java/io/File
    //   112: dup
    //   113: aload 11
    //   115: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: invokevirtual 78	java/io/File:mkdirs	()Z
    //   121: pop
    //   122: aload_1
    //   123: astore 4
    //   125: aload_1
    //   126: astore_3
    //   127: new 80	java/io/FileOutputStream
    //   130: dup
    //   131: new 72	java/io/File
    //   134: dup
    //   135: new 82	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   142: aload 11
    //   144: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_1
    //   148: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   157: invokespecial 94	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   160: astore 7
    //   162: aload 6
    //   164: astore_3
    //   165: aload 9
    //   167: astore 4
    //   169: aload 12
    //   171: invokevirtual 42	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   174: aload 13
    //   176: ldc 96
    //   178: invokevirtual 100	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   181: astore 8
    //   183: aload 10
    //   185: astore 5
    //   187: aload 8
    //   189: ifnull +166 -> 355
    //   192: aload 6
    //   194: astore_3
    //   195: aload 9
    //   197: astore 4
    //   199: aload 8
    //   201: invokevirtual 106	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   204: astore 5
    //   206: aload 5
    //   208: astore_3
    //   209: aload 5
    //   211: astore 4
    //   213: sipush 1024
    //   216: newarray <illegal type>
    //   218: astore 6
    //   220: aload 5
    //   222: astore_3
    //   223: aload 5
    //   225: astore 4
    //   227: aload 5
    //   229: aload 6
    //   231: invokevirtual 112	java/io/InputStream:read	([B)I
    //   234: istore 14
    //   236: iload 14
    //   238: iconst_m1
    //   239: if_icmpeq +104 -> 343
    //   242: aload 5
    //   244: astore_3
    //   245: aload 5
    //   247: astore 4
    //   249: aload 7
    //   251: aload 6
    //   253: iconst_0
    //   254: iload 14
    //   256: invokevirtual 116	java/io/FileOutputStream:write	([BII)V
    //   259: goto -39 -> 220
    //   262: astore 6
    //   264: aload_2
    //   265: astore 4
    //   267: aload_3
    //   268: astore 5
    //   270: aload 7
    //   272: astore_3
    //   273: aload_1
    //   274: astore_2
    //   275: aload 4
    //   277: astore_1
    //   278: aload 6
    //   280: astore 4
    //   282: aload 4
    //   284: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   287: aload_1
    //   288: ifnull +9 -> 297
    //   291: aload_1
    //   292: invokeinterface 65 1 0
    //   297: aload 5
    //   299: ifnull +8 -> 307
    //   302: aload 5
    //   304: invokevirtual 120	java/io/InputStream:close	()V
    //   307: aload_3
    //   308: ifnull +7 -> 315
    //   311: aload_3
    //   312: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   315: new 82	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   322: ldc 123
    //   324: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 11
    //   329: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_2
    //   333: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 127	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   342: areturn
    //   343: aload 5
    //   345: astore_3
    //   346: aload 5
    //   348: astore 4
    //   350: aload 7
    //   352: invokevirtual 130	java/io/FileOutputStream:flush	()V
    //   355: aload_2
    //   356: ifnull +9 -> 365
    //   359: aload_2
    //   360: invokeinterface 65 1 0
    //   365: aload 5
    //   367: ifnull +8 -> 375
    //   370: aload 5
    //   372: invokevirtual 120	java/io/InputStream:close	()V
    //   375: aload 7
    //   377: ifnull +8 -> 385
    //   380: aload 7
    //   382: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   385: new 82	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   392: ldc 123
    //   394: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 11
    //   399: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_1
    //   403: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 127	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   412: areturn
    //   413: astore_2
    //   414: aload_2
    //   415: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   418: goto -43 -> 375
    //   421: astore_2
    //   422: aload_2
    //   423: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   426: goto -41 -> 385
    //   429: astore_1
    //   430: aload_1
    //   431: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   434: goto -127 -> 307
    //   437: astore_1
    //   438: aload_1
    //   439: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   442: goto -127 -> 315
    //   445: astore_3
    //   446: aconst_null
    //   447: astore 6
    //   449: ldc -123
    //   451: astore_1
    //   452: aconst_null
    //   453: astore_2
    //   454: aload 8
    //   456: astore 4
    //   458: aload 6
    //   460: ifnull +10 -> 470
    //   463: aload 6
    //   465: invokeinterface 65 1 0
    //   470: aload 4
    //   472: ifnull +8 -> 480
    //   475: aload 4
    //   477: invokevirtual 120	java/io/InputStream:close	()V
    //   480: aload_2
    //   481: ifnull +7 -> 488
    //   484: aload_2
    //   485: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   488: new 82	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   495: ldc 123
    //   497: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload 11
    //   502: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload_1
    //   506: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 127	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   515: pop
    //   516: aload_3
    //   517: athrow
    //   518: astore 4
    //   520: aload 4
    //   522: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   525: goto -45 -> 480
    //   528: astore_2
    //   529: aload_2
    //   530: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   533: goto -45 -> 488
    //   536: astore_3
    //   537: ldc -123
    //   539: astore_1
    //   540: aconst_null
    //   541: astore 4
    //   543: aload_2
    //   544: astore 6
    //   546: aload 4
    //   548: astore_2
    //   549: aload 8
    //   551: astore 4
    //   553: goto -95 -> 458
    //   556: astore_3
    //   557: aconst_null
    //   558: astore 5
    //   560: aload_2
    //   561: astore 6
    //   563: aload 4
    //   565: astore_1
    //   566: aload 5
    //   568: astore_2
    //   569: aload 8
    //   571: astore 4
    //   573: goto -115 -> 458
    //   576: astore_3
    //   577: aload_2
    //   578: astore 6
    //   580: aload 7
    //   582: astore_2
    //   583: goto -125 -> 458
    //   586: astore 6
    //   588: aload_3
    //   589: astore 4
    //   591: aload 6
    //   593: astore_3
    //   594: aload_1
    //   595: astore 6
    //   597: aload_2
    //   598: astore_1
    //   599: aload 4
    //   601: astore_2
    //   602: aload 5
    //   604: astore 4
    //   606: goto -148 -> 458
    //   609: astore 4
    //   611: aconst_null
    //   612: astore_1
    //   613: ldc -123
    //   615: astore_2
    //   616: aconst_null
    //   617: astore_3
    //   618: goto -336 -> 282
    //   621: astore 4
    //   623: aload_2
    //   624: astore_1
    //   625: aconst_null
    //   626: astore_3
    //   627: ldc -123
    //   629: astore_2
    //   630: goto -348 -> 282
    //   633: astore 4
    //   635: aload_2
    //   636: astore_1
    //   637: aload_3
    //   638: astore_2
    //   639: aconst_null
    //   640: astore_3
    //   641: goto -359 -> 282
    //   644: ldc -123
    //   646: astore_1
    //   647: goto -556 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	lqd
    //   0	650	1	paramVarArgs	Object[]
    //   58	302	2	localObject1	Object
    //   413	2	2	localIOException1	java.io.IOException
    //   421	2	2	localIOException2	java.io.IOException
    //   453	32	2	localObject2	Object
    //   528	16	2	localIOException3	java.io.IOException
    //   548	91	2	localObject3	Object
    //   84	262	3	localObject4	Object
    //   445	72	3	localObject5	Object
    //   536	1	3	localObject6	Object
    //   556	1	3	localObject7	Object
    //   576	13	3	localObject8	Object
    //   593	48	3	localObject9	Object
    //   81	395	4	localObject10	Object
    //   518	3	4	localIOException4	java.io.IOException
    //   541	64	4	localObject11	Object
    //   609	1	4	localException1	Exception
    //   621	1	4	localException2	Exception
    //   633	1	4	localException3	Exception
    //   1	602	5	localObject12	Object
    //   13	239	6	arrayOfByte	byte[]
    //   262	17	6	localException4	Exception
    //   447	132	6	localObject13	Object
    //   586	6	6	localObject14	Object
    //   595	1	6	arrayOfObject	Object[]
    //   160	421	7	localFileOutputStream	java.io.FileOutputStream
    //   7	563	8	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   10	186	9	localObject15	Object
    //   4	180	10	localObject16	Object
    //   34	467	11	str	String
    //   21	149	12	localContext	android.content.Context
    //   29	146	13	localUri	Uri
    //   234	21	14	i	int
    // Exception table:
    //   from	to	target	type
    //   169	183	262	java/lang/Exception
    //   199	206	262	java/lang/Exception
    //   213	220	262	java/lang/Exception
    //   227	236	262	java/lang/Exception
    //   249	259	262	java/lang/Exception
    //   350	355	262	java/lang/Exception
    //   370	375	413	java/io/IOException
    //   380	385	421	java/io/IOException
    //   302	307	429	java/io/IOException
    //   311	315	437	java/io/IOException
    //   36	59	445	finally
    //   475	480	518	java/io/IOException
    //   484	488	528	java/io/IOException
    //   63	80	536	finally
    //   85	91	556	finally
    //   96	104	556	finally
    //   109	122	556	finally
    //   127	162	556	finally
    //   169	183	576	finally
    //   199	206	576	finally
    //   213	220	576	finally
    //   227	236	576	finally
    //   249	259	576	finally
    //   350	355	576	finally
    //   282	287	586	finally
    //   36	59	609	java/lang/Exception
    //   63	80	621	java/lang/Exception
    //   85	91	633	java/lang/Exception
    //   96	104	633	java/lang/Exception
    //   109	122	633	java/lang/Exception
    //   127	162	633	java/lang/Exception
  }
  
  protected void a(Uri paramUri)
  {
    this.jdField_a_of_type_AndroidContentIntent.setData(paramUri);
    ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */