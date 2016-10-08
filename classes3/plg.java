import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;

public class plg
  extends AsyncTask
{
  Activity jdField_a_of_type_AndroidAppActivity;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public plg(ShortVideoPreviewActivity paramShortVideoPreviewActivity, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity);
  }
  
  /* Error */
  protected Integer a(String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: astore_2
    //   4: aload_2
    //   5: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +10 -> 18
    //   11: aload_0
    //   12: getfield 26	plg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   15: ifnonnull +8 -> 23
    //   18: iconst_m1
    //   19: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: areturn
    //   23: aload_0
    //   24: aload_2
    //   25: putfield 51	plg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   28: new 53	java/io/File
    //   31: dup
    //   32: new 55	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   39: getstatic 61	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   42: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 67
    //   47: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 78	java/io/File:exists	()Z
    //   61: ifne +8 -> 69
    //   64: aload_1
    //   65: invokevirtual 81	java/io/File:mkdirs	()Z
    //   68: pop
    //   69: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   72: lstore 9
    //   74: aload_0
    //   75: getfield 26	plg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   78: iconst_0
    //   79: iconst_0
    //   80: invokestatic 92	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Landroid/content/Context;II)Z
    //   83: istore 15
    //   85: aload_2
    //   86: ldc 94
    //   88: invokevirtual 100	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   91: istore 5
    //   93: iload 5
    //   95: iconst_m1
    //   96: if_icmpne +8 -> 104
    //   99: iconst_m1
    //   100: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: areturn
    //   104: aload_0
    //   105: aload_2
    //   106: aload_2
    //   107: iload 5
    //   109: iconst_1
    //   110: iadd
    //   111: invokevirtual 104	java/lang/String:substring	(I)Ljava/lang/String;
    //   114: invokestatic 109	com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 111	plg:b	Ljava/lang/String;
    //   120: iload 15
    //   122: ifeq +622 -> 744
    //   125: aload_2
    //   126: invokestatic 114	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;
    //   129: astore_3
    //   130: aload_3
    //   131: ifnull +503 -> 634
    //   134: aload_3
    //   135: getfield 118	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:jdField_a_of_type_Boolean	Z
    //   138: ifeq +496 -> 634
    //   141: getstatic 124	android/os/Build$VERSION:SDK_INT	I
    //   144: bipush 18
    //   146: if_icmplt +482 -> 628
    //   149: new 126	android/media/MediaMetadataRetriever
    //   152: dup
    //   153: invokespecial 127	android/media/MediaMetadataRetriever:<init>	()V
    //   156: astore 4
    //   158: aload 4
    //   160: aload_2
    //   161: invokevirtual 130	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   164: aload 4
    //   166: bipush 9
    //   168: invokevirtual 133	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   171: invokestatic 139	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   174: lstore 7
    //   176: aload_0
    //   177: getfield 26	plg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   180: invokestatic 144	com/tencent/mobileqq/shortvideo/mediacodec/ShortVideoCodec:b	(Landroid/content/Context;)I
    //   183: istore 5
    //   185: iload 5
    //   187: iconst_1
    //   188: iand
    //   189: ifle +419 -> 608
    //   192: iload 5
    //   194: iconst_2
    //   195: iand
    //   196: ifle +412 -> 608
    //   199: iconst_1
    //   200: istore 15
    //   202: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +29 -> 234
    //   208: ldc -105
    //   210: iconst_2
    //   211: new 55	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   218: ldc -103
    //   220: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 15
    //   225: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   228: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload 15
    //   236: ifeq +392 -> 628
    //   239: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +11 -> 253
    //   245: ldc -105
    //   247: iconst_2
    //   248: ldc -94
    //   250: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: new 53	java/io/File
    //   256: dup
    //   257: aload_2
    //   258: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: astore 4
    //   263: new 164	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$HWCompressProcessor
    //   266: dup
    //   267: aload_0
    //   268: getfield 111	plg:b	Ljava/lang/String;
    //   271: aload_3
    //   272: getfield 167	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:b	J
    //   275: ldc2_w 168
    //   278: lmul
    //   279: l2i
    //   280: aload_3
    //   281: getfield 171	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:jdField_a_of_type_Long	J
    //   284: l2i
    //   285: lconst_0
    //   286: lload 7
    //   288: invokespecial 174	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$HWCompressProcessor:<init>	(Ljava/lang/String;IIJJ)V
    //   291: astore_3
    //   292: new 176	com/tencent/mobileqq/shortvideo/util/videoconverter/VideoConverter
    //   295: dup
    //   296: invokespecial 177	com/tencent/mobileqq/shortvideo/util/videoconverter/VideoConverter:<init>	()V
    //   299: aload 4
    //   301: aload_3
    //   302: iconst_1
    //   303: invokevirtual 180	com/tencent/mobileqq/shortvideo/util/videoconverter/VideoConverter:a	(Ljava/io/File;Lcom/tencent/mobileqq/shortvideo/util/videoconverter/VideoConverter$Processor;Z)Z
    //   306: ifeq +308 -> 614
    //   309: aload_3
    //   310: getfield 183	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$HWCompressProcessor:a	Ljava/lang/Throwable;
    //   313: ifnonnull +301 -> 614
    //   316: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +11 -> 330
    //   322: ldc -105
    //   324: iconst_2
    //   325: ldc -71
    //   327: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: iconst_0
    //   331: istore 6
    //   333: iload 6
    //   335: istore 5
    //   337: iload 6
    //   339: ifeq +45 -> 384
    //   342: iload 6
    //   344: istore 5
    //   346: aload_0
    //   347: getfield 111	plg:b	Ljava/lang/String;
    //   350: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   353: ifne +31 -> 384
    //   356: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +11 -> 370
    //   362: ldc -105
    //   364: iconst_2
    //   365: ldc -69
    //   367: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_0
    //   371: getfield 26	plg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   374: aload_2
    //   375: aload_0
    //   376: getfield 111	plg:b	Ljava/lang/String;
    //   379: invokestatic 190	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    //   382: istore 5
    //   384: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   387: lstore 11
    //   389: new 53	java/io/File
    //   392: dup
    //   393: aload_2
    //   394: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   397: invokevirtual 193	java/io/File:length	()J
    //   400: lstore 13
    //   402: lconst_0
    //   403: lstore 7
    //   405: aload_0
    //   406: getfield 111	plg:b	Ljava/lang/String;
    //   409: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   412: ifne +19 -> 431
    //   415: new 53	java/io/File
    //   418: dup
    //   419: aload_0
    //   420: getfield 111	plg:b	Ljava/lang/String;
    //   423: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   426: invokevirtual 193	java/io/File:length	()J
    //   429: lstore 7
    //   431: iload 5
    //   433: istore 6
    //   435: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +71 -> 509
    //   441: ldc -105
    //   443: iconst_2
    //   444: new 55	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   451: ldc -61
    //   453: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 5
    //   458: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   461: ldc -56
    //   463: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: lload 11
    //   468: lload 9
    //   470: lsub
    //   471: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   474: ldc -51
    //   476: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: lload 13
    //   481: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: ldc -49
    //   486: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: lload 7
    //   491: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   494: ldc -47
    //   496: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: iload 5
    //   507: istore 6
    //   509: aload_0
    //   510: getfield 26	plg:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   513: aload_2
    //   514: invokestatic 212	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   517: astore_3
    //   518: aload_3
    //   519: ifnull +83 -> 602
    //   522: new 53	java/io/File
    //   525: dup
    //   526: aload_1
    //   527: new 55	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   534: lload 9
    //   536: invokestatic 215	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   539: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc -39
    //   544: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokespecial 220	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   553: astore_1
    //   554: aload_1
    //   555: invokevirtual 223	java/io/File:createNewFile	()Z
    //   558: ifeq +175 -> 733
    //   561: aload_0
    //   562: aload_1
    //   563: invokevirtual 226	java/io/File:getPath	()Ljava/lang/String;
    //   566: putfield 228	plg:c	Ljava/lang/String;
    //   569: new 230	java/io/FileOutputStream
    //   572: dup
    //   573: aload_1
    //   574: invokevirtual 226	java/io/File:getPath	()Ljava/lang/String;
    //   577: invokespecial 231	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   580: astore_2
    //   581: aload_2
    //   582: astore_1
    //   583: aload_3
    //   584: getstatic 237	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   587: bipush 100
    //   589: aload_2
    //   590: invokevirtual 243	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   593: pop
    //   594: aload_2
    //   595: ifnull +7 -> 602
    //   598: aload_2
    //   599: invokevirtual 246	java/io/FileOutputStream:close	()V
    //   602: iload 6
    //   604: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   607: areturn
    //   608: iconst_0
    //   609: istore 15
    //   611: goto -409 -> 202
    //   614: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq +11 -> 628
    //   620: ldc -105
    //   622: iconst_2
    //   623: ldc -8
    //   625: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: iconst_m1
    //   629: istore 6
    //   631: goto -298 -> 333
    //   634: aload_3
    //   635: ifnull +103 -> 738
    //   638: aload_3
    //   639: getfield 118	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig:jdField_a_of_type_Boolean	Z
    //   642: ifne +96 -> 738
    //   645: aload_0
    //   646: aload_0
    //   647: getfield 51	plg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   650: putfield 111	plg:b	Ljava/lang/String;
    //   653: iconst_0
    //   654: istore 5
    //   656: goto -272 -> 384
    //   659: astore_3
    //   660: aconst_null
    //   661: astore_2
    //   662: aload_2
    //   663: astore_1
    //   664: ldc -105
    //   666: iconst_1
    //   667: new 55	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   674: ldc -6
    //   676: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload_3
    //   680: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   683: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 256	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload_2
    //   690: ifnull -88 -> 602
    //   693: aload_2
    //   694: invokevirtual 246	java/io/FileOutputStream:close	()V
    //   697: goto -95 -> 602
    //   700: astore_1
    //   701: goto -99 -> 602
    //   704: astore_2
    //   705: aconst_null
    //   706: astore_1
    //   707: aload_1
    //   708: ifnull +7 -> 715
    //   711: aload_1
    //   712: invokevirtual 246	java/io/FileOutputStream:close	()V
    //   715: aload_2
    //   716: athrow
    //   717: astore_1
    //   718: goto -116 -> 602
    //   721: astore_1
    //   722: goto -7 -> 715
    //   725: astore_2
    //   726: goto -19 -> 707
    //   729: astore_3
    //   730: goto -68 -> 662
    //   733: aconst_null
    //   734: astore_2
    //   735: goto -141 -> 594
    //   738: iconst_m1
    //   739: istore 5
    //   741: goto -357 -> 384
    //   744: iconst_m1
    //   745: istore 6
    //   747: goto -238 -> 509
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	this	plg
    //   0	750	1	paramVarArgs	String[]
    //   3	691	2	localObject1	Object
    //   704	12	2	localObject2	Object
    //   725	1	2	localObject3	Object
    //   734	1	2	localObject4	Object
    //   129	510	3	localObject5	Object
    //   659	21	3	localException1	Exception
    //   729	1	3	localException2	Exception
    //   156	144	4	localObject6	Object
    //   91	649	5	i	int
    //   331	415	6	j	int
    //   174	316	7	l1	long
    //   72	463	9	l2	long
    //   387	80	11	l3	long
    //   400	80	13	l4	long
    //   83	527	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   554	581	659	java/lang/Exception
    //   693	697	700	java/lang/Exception
    //   554	581	704	finally
    //   598	602	717	java/lang/Exception
    //   711	715	721	java/lang/Exception
    //   583	594	725	finally
    //   664	689	725	finally
    //   583	594	729	java/lang/Exception
  }
  
  protected void a(Integer paramInteger)
  {
    int i = 10485760;
    super.onPostExecute(paramInteger);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    String str;
    if (TextUtils.isEmpty(this.b))
    {
      str = this.jdField_a_of_type_JavaLangString;
      long l = new File(str).length();
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("size_after_compress", 10485760);
      }
      if (l <= i) {
        break label144;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "文件过大，无法发送", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.getTitleBarHeight());
      this.jdField_a_of_type_AndroidAppActivity.setResult(0);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    label144:
    while ((this.jdField_a_of_type_AndroidAppActivity == null) || (paramInteger.intValue() != 0))
    {
      return;
      str = this.b;
      break;
    }
    paramInteger = new Intent();
    paramInteger.putExtra("video_dir", str);
    paramInteger.putExtra("thumb_dir", this.c);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramInteger);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在压缩");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\plg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */