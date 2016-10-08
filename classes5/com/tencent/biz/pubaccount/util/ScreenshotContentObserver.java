package com.tencent.biz.pubaccount.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.FileObserver;
import android.provider.MediaStore.Images.Media;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ign;

public class ScreenshotContentObserver
  extends ContentObserver
{
  private static final long jdField_a_of_type_Long = 1500L;
  private static final String jdField_a_of_type_JavaLangString = "ScreenshotContentObserver";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "_data", "date_added" };
  private static final String jdField_b_of_type_JavaLangString;
  private static final String c = "date_added DESC";
  private static final String d = "screenshot";
  private static final String e = "截屏";
  private int jdField_a_of_type_Int;
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  private FileObserver jdField_a_of_type_AndroidOsFileObserver;
  private ScreenshotContentObserver.Listener jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener;
  private int jdField_b_of_type_Int;
  private String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  }
  
  public ScreenshotContentObserver(Context paramContext, int paramInt1, int paramInt2)
  {
    super(null);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (Build.VERSION.SDK_INT < 23) {
      if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        paramContext = ScreenshotContentObserver.ScreenShotPath.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidOsFileObserver = new ign(this, paramContext, 256, paramContext);
      }
    }
    for (;;)
    {
      b();
      return;
      if (Build.MANUFACTURER.equalsIgnoreCase("vivo"))
      {
        paramContext = ScreenshotContentObserver.ScreenShotPath.c;
        break;
      }
      paramContext = ScreenshotContentObserver.ScreenShotPath.a;
      break;
      this.jdField_a_of_type_AndroidContentContentResolver = paramContext.getContentResolver();
    }
  }
  
  private boolean a(long paramLong)
  {
    return System.currentTimeMillis() - 1000L * paramLong < 1500L;
  }
  
  private boolean a(String paramString)
  {
    paramString = paramString.toLowerCase();
    return (paramString.contains("screenshot")) || (paramString.contains("截屏"));
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_a_of_type_AndroidOsFileObserver.startWatching();
      return;
    }
    this.jdField_a_of_type_AndroidContentContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
  }
  
  private boolean b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return (this.jdField_a_of_type_Int >= localOptions.outWidth) && (this.jdField_b_of_type_Int >= localOptions.outHeight);
  }
  
  private void c()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_a_of_type_AndroidOsFileObserver.stopWatching();
      return;
    }
    this.jdField_a_of_type_AndroidContentContentResolver.unregisterContentObserver(this);
  }
  
  public void a()
  {
    c();
    this.jdField_a_of_type_AndroidOsFileObserver = null;
    this.jdField_a_of_type_AndroidContentContentResolver = null;
    this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener = null;
  }
  
  public void a(ScreenshotContentObserver.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener = paramListener;
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    onChange(paramBoolean, null);
  }
  
  /* Error */
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: invokestatic 187	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12: ifeq +30 -> 42
    //   15: ldc 11
    //   17: iconst_2
    //   18: new 189	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   25: ldc -64
    //   27: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   33: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_2
    //   43: ifnonnull +300 -> 343
    //   46: aload_0
    //   47: getfield 109	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_AndroidContentContentResolver	Landroid/content/ContentResolver;
    //   50: getstatic 41	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: getstatic 57	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   56: aconst_null
    //   57: aconst_null
    //   58: ldc 16
    //   60: invokevirtual 207	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull +204 -> 271
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 213 1 0
    //   80: ifle +191 -> 271
    //   83: aload 4
    //   85: astore_3
    //   86: aload 4
    //   88: invokeinterface 216 1 0
    //   93: pop
    //   94: aload 4
    //   96: astore_3
    //   97: aload 4
    //   99: aload 4
    //   101: ldc 53
    //   103: invokeinterface 220 2 0
    //   108: invokeinterface 224 2 0
    //   113: astore 5
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: aload 4
    //   121: aload 4
    //   123: ldc 55
    //   125: invokeinterface 220 2 0
    //   130: invokeinterface 228 2 0
    //   135: invokespecial 230	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:a	(J)Z
    //   138: ifeq +133 -> 271
    //   141: aload 4
    //   143: astore_3
    //   144: aload_0
    //   145: aload 5
    //   147: invokespecial 232	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:a	(Ljava/lang/String;)Z
    //   150: ifeq +121 -> 271
    //   153: aload 4
    //   155: astore_3
    //   156: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +37 -> 196
    //   162: aload 4
    //   164: astore_3
    //   165: ldc 11
    //   167: iconst_2
    //   168: new 189	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   175: ldc -19
    //   177: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc -17
    //   187: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload 5
    //   198: ifnull +48 -> 246
    //   201: aload 4
    //   203: astore_3
    //   204: aload 5
    //   206: aload_0
    //   207: getfield 115	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:f	Ljava/lang/String;
    //   210: invokevirtual 83	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: istore_1
    //   214: iload_1
    //   215: ifeq +22 -> 237
    //   218: aload 4
    //   220: ifnull +10 -> 230
    //   223: aload 4
    //   225: invokeinterface 242 1 0
    //   230: return
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   236: return
    //   237: aload 4
    //   239: astore_3
    //   240: aload_0
    //   241: aload 5
    //   243: putfield 115	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:f	Ljava/lang/String;
    //   246: aload 4
    //   248: astore_3
    //   249: aload_0
    //   250: getfield 112	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener	Lcom/tencent/biz/pubaccount/util/ScreenshotContentObserver$Listener;
    //   253: ifnull +18 -> 271
    //   256: aload 4
    //   258: astore_3
    //   259: aload_0
    //   260: getfield 112	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener	Lcom/tencent/biz/pubaccount/util/ScreenshotContentObserver$Listener;
    //   263: aload_2
    //   264: aload 5
    //   266: invokeinterface 250 3 0
    //   271: aload 4
    //   273: ifnull -43 -> 230
    //   276: aload 4
    //   278: invokeinterface 242 1 0
    //   283: return
    //   284: astore_2
    //   285: aload_2
    //   286: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   289: return
    //   290: astore_2
    //   291: aconst_null
    //   292: astore 4
    //   294: aload 4
    //   296: astore_3
    //   297: aload_2
    //   298: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   301: aload 4
    //   303: ifnull -73 -> 230
    //   306: aload 4
    //   308: invokeinterface 242 1 0
    //   313: return
    //   314: astore_2
    //   315: aload_2
    //   316: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   319: return
    //   320: astore_2
    //   321: aconst_null
    //   322: astore_3
    //   323: aload_3
    //   324: ifnull +9 -> 333
    //   327: aload_3
    //   328: invokeinterface 242 1 0
    //   333: aload_2
    //   334: athrow
    //   335: astore_3
    //   336: aload_3
    //   337: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   340: goto -7 -> 333
    //   343: aload 5
    //   345: astore 4
    //   347: aload 7
    //   349: astore_3
    //   350: aload_2
    //   351: invokevirtual 47	android/net/Uri:toString	()Ljava/lang/String;
    //   354: getstatic 49	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   357: invokevirtual 253	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   360: ifeq +305 -> 665
    //   363: aload 5
    //   365: astore 4
    //   367: aload 7
    //   369: astore_3
    //   370: aload_0
    //   371: getfield 109	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_AndroidContentContentResolver	Landroid/content/ContentResolver;
    //   374: aload_2
    //   375: getstatic 57	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   378: aconst_null
    //   379: aconst_null
    //   380: ldc 16
    //   382: invokevirtual 207	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   385: astore 5
    //   387: aload 5
    //   389: astore 6
    //   391: aload 5
    //   393: ifnull +272 -> 665
    //   396: aload 5
    //   398: astore 6
    //   400: aload 5
    //   402: astore 4
    //   404: aload 5
    //   406: astore_3
    //   407: aload 5
    //   409: invokeinterface 213 1 0
    //   414: ifle +251 -> 665
    //   417: aload 5
    //   419: astore 4
    //   421: aload 5
    //   423: astore_3
    //   424: aload 5
    //   426: invokeinterface 216 1 0
    //   431: pop
    //   432: aload 5
    //   434: astore 4
    //   436: aload 5
    //   438: astore_3
    //   439: aload 5
    //   441: aload 5
    //   443: ldc 53
    //   445: invokeinterface 220 2 0
    //   450: invokeinterface 224 2 0
    //   455: astore 7
    //   457: aload 5
    //   459: astore 6
    //   461: aload 5
    //   463: astore 4
    //   465: aload 5
    //   467: astore_3
    //   468: aload_0
    //   469: aload 5
    //   471: aload 5
    //   473: ldc 55
    //   475: invokeinterface 220 2 0
    //   480: invokeinterface 228 2 0
    //   485: invokespecial 230	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:a	(J)Z
    //   488: ifeq +177 -> 665
    //   491: aload 5
    //   493: astore 6
    //   495: aload 5
    //   497: astore 4
    //   499: aload 5
    //   501: astore_3
    //   502: aload_0
    //   503: aload 7
    //   505: invokespecial 232	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:a	(Ljava/lang/String;)Z
    //   508: ifeq +157 -> 665
    //   511: aload 5
    //   513: astore 4
    //   515: aload 5
    //   517: astore_3
    //   518: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +45 -> 566
    //   524: aload 5
    //   526: astore 4
    //   528: aload 5
    //   530: astore_3
    //   531: ldc 11
    //   533: iconst_2
    //   534: new 189	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   541: ldc -19
    //   543: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 7
    //   548: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc -1
    //   553: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_2
    //   557: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload 7
    //   568: ifnull +56 -> 624
    //   571: aload 5
    //   573: astore 4
    //   575: aload 5
    //   577: astore_3
    //   578: aload 7
    //   580: aload_0
    //   581: getfield 115	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:f	Ljava/lang/String;
    //   584: invokevirtual 83	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   587: istore_1
    //   588: iload_1
    //   589: ifeq +22 -> 611
    //   592: aload 5
    //   594: ifnull -364 -> 230
    //   597: aload 5
    //   599: invokeinterface 242 1 0
    //   604: return
    //   605: astore_2
    //   606: aload_2
    //   607: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   610: return
    //   611: aload 5
    //   613: astore 4
    //   615: aload 5
    //   617: astore_3
    //   618: aload_0
    //   619: aload 7
    //   621: putfield 115	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:f	Ljava/lang/String;
    //   624: aload 5
    //   626: astore 6
    //   628: aload 5
    //   630: astore 4
    //   632: aload 5
    //   634: astore_3
    //   635: aload_0
    //   636: getfield 112	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener	Lcom/tencent/biz/pubaccount/util/ScreenshotContentObserver$Listener;
    //   639: ifnull +26 -> 665
    //   642: aload 5
    //   644: astore 4
    //   646: aload 5
    //   648: astore_3
    //   649: aload_0
    //   650: getfield 112	com/tencent/biz/pubaccount/util/ScreenshotContentObserver:jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver$Listener	Lcom/tencent/biz/pubaccount/util/ScreenshotContentObserver$Listener;
    //   653: aload_2
    //   654: aload 7
    //   656: invokeinterface 250 3 0
    //   661: aload 5
    //   663: astore 6
    //   665: aload 6
    //   667: ifnull -437 -> 230
    //   670: aload 6
    //   672: invokeinterface 242 1 0
    //   677: return
    //   678: astore_2
    //   679: aload_2
    //   680: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   683: return
    //   684: astore_2
    //   685: aload 4
    //   687: astore_3
    //   688: aload_2
    //   689: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   692: aload 4
    //   694: ifnull -464 -> 230
    //   697: aload 4
    //   699: invokeinterface 242 1 0
    //   704: return
    //   705: astore_2
    //   706: aload_2
    //   707: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   710: return
    //   711: astore_2
    //   712: aload_3
    //   713: ifnull +9 -> 722
    //   716: aload_3
    //   717: invokeinterface 242 1 0
    //   722: aload_2
    //   723: athrow
    //   724: astore_3
    //   725: aload_3
    //   726: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   729: goto -7 -> 722
    //   732: astore_2
    //   733: goto -410 -> 323
    //   736: astore_2
    //   737: goto -443 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	this	ScreenshotContentObserver
    //   0	740	1	paramBoolean	boolean
    //   0	740	2	paramUri	Uri
    //   72	256	3	localObject1	Object
    //   335	2	3	localException1	Exception
    //   349	368	3	localObject2	Object
    //   724	2	3	localException2	Exception
    //   63	635	4	localObject3	Object
    //   1	661	5	localObject4	Object
    //   7	664	6	localObject5	Object
    //   4	651	7	str	String
    // Exception table:
    //   from	to	target	type
    //   223	230	231	java/lang/Exception
    //   276	283	284	java/lang/Exception
    //   46	65	290	java/lang/Exception
    //   306	313	314	java/lang/Exception
    //   46	65	320	finally
    //   327	333	335	java/lang/Exception
    //   597	604	605	java/lang/Exception
    //   670	677	678	java/lang/Exception
    //   350	363	684	java/lang/Exception
    //   370	387	684	java/lang/Exception
    //   407	417	684	java/lang/Exception
    //   424	432	684	java/lang/Exception
    //   439	457	684	java/lang/Exception
    //   468	491	684	java/lang/Exception
    //   502	511	684	java/lang/Exception
    //   518	524	684	java/lang/Exception
    //   531	566	684	java/lang/Exception
    //   578	588	684	java/lang/Exception
    //   618	624	684	java/lang/Exception
    //   635	642	684	java/lang/Exception
    //   649	661	684	java/lang/Exception
    //   697	704	705	java/lang/Exception
    //   350	363	711	finally
    //   370	387	711	finally
    //   407	417	711	finally
    //   424	432	711	finally
    //   439	457	711	finally
    //   468	491	711	finally
    //   502	511	711	finally
    //   518	524	711	finally
    //   531	566	711	finally
    //   578	588	711	finally
    //   618	624	711	finally
    //   635	642	711	finally
    //   649	661	711	finally
    //   688	692	711	finally
    //   716	722	724	java/lang/Exception
    //   73	83	732	finally
    //   86	94	732	finally
    //   97	115	732	finally
    //   118	141	732	finally
    //   144	153	732	finally
    //   156	162	732	finally
    //   165	196	732	finally
    //   204	214	732	finally
    //   240	246	732	finally
    //   249	256	732	finally
    //   259	271	732	finally
    //   297	301	732	finally
    //   73	83	736	java/lang/Exception
    //   86	94	736	java/lang/Exception
    //   97	115	736	java/lang/Exception
    //   118	141	736	java/lang/Exception
    //   144	153	736	java/lang/Exception
    //   156	162	736	java/lang/Exception
    //   165	196	736	java/lang/Exception
    //   204	214	736	java/lang/Exception
    //   240	246	736	java/lang/Exception
    //   249	256	736	java/lang/Exception
    //   259	271	736	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\ScreenshotContentObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */