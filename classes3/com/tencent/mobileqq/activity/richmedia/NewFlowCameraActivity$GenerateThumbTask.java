package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class NewFlowCameraActivity$GenerateThumbTask
  extends AsyncTask
{
  double jdField_a_of_type_Double;
  float jdField_a_of_type_Float;
  public final int a;
  NewFlowCameraActivity.VideoProcessListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener;
  RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  double jdField_b_of_type_Double;
  public final int b;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int d;
  int e;
  
  public NewFlowCameraActivity$GenerateThumbTask(Activity paramActivity, NewFlowCameraActivity.VideoProcessListener paramVideoProcessListener, RMVideoStateMgr paramRMVideoStateMgr, String paramString, float paramFloat, int paramInt, double paramDouble1, double paramDouble2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener = paramVideoProcessListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = paramRMVideoStateMgr;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.e = paramInt;
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
  }
  
  /* Error */
  private int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 45	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5: aload_0
    //   6: getfield 61	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_Int	I
    //   9: aload_0
    //   10: getfield 63	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:d	I
    //   13: aload_0
    //   14: getfield 49	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:e	I
    //   17: getstatic 69	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   20: invokestatic 74	com/tencent/mobileqq/shortvideo/cover/RecordThumbnailUtils:a	(Ljava/lang/String;IIILandroid/graphics/Bitmap$Config;)Ljava/lang/String;
    //   23: putfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: aload_0
    //   27: getfield 49	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:e	I
    //   30: bipush 90
    //   32: if_icmpeq +13 -> 45
    //   35: aload_0
    //   36: getfield 49	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:e	I
    //   39: sipush 270
    //   42: if_icmpne +23 -> 65
    //   45: aload_0
    //   46: getfield 61	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_Int	I
    //   49: istore 4
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 63	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:d	I
    //   56: putfield 61	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_Int	I
    //   59: aload_0
    //   60: iload 4
    //   62: putfield 63	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:d	I
    //   65: aload_0
    //   66: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifeq +19 -> 91
    //   75: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +11 -> 89
    //   81: ldc 90
    //   83: iconst_2
    //   84: ldc 92
    //   86: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: iconst_1
    //   90: ireturn
    //   91: aload_0
    //   92: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_0
    //   96: getfield 51	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_Double	D
    //   99: aload_0
    //   100: getfield 53	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_b_of_type_Double	D
    //   103: invokestatic 100	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   106: pop
    //   107: new 102	java/io/File
    //   110: dup
    //   111: aload_0
    //   112: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore_3
    //   119: aload_3
    //   120: invokevirtual 108	java/io/File:exists	()Z
    //   123: ifeq +421 -> 544
    //   126: new 110	java/io/FileInputStream
    //   129: dup
    //   130: aload_0
    //   131: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: aload_0
    //   141: aload_2
    //   142: aload_3
    //   143: invokevirtual 115	java/io/File:length	()J
    //   146: invokestatic 121	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   149: putfield 123	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_ArrayOfByte	[B
    //   152: aload_2
    //   153: astore_1
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 123	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_ArrayOfByte	[B
    //   159: invokestatic 129	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   162: putfield 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 134	java/io/FileInputStream:close	()V
    //   173: aload_0
    //   174: getfield 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   177: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifeq +27 -> 207
    //   183: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq -97 -> 89
    //   189: ldc 90
    //   191: iconst_2
    //   192: ldc -120
    //   194: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   204: goto -31 -> 173
    //   207: aload_0
    //   208: getfield 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   211: ldc -115
    //   213: invokestatic 146	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   216: astore_1
    //   217: aload_0
    //   218: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   221: aload_1
    //   222: invokestatic 151	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   225: ifeq +10 -> 235
    //   228: aload_0
    //   229: aload_1
    //   230: putfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   233: iconst_0
    //   234: ireturn
    //   235: aload_1
    //   236: invokestatic 154	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   239: ifne -6 -> 233
    //   242: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq -156 -> 89
    //   248: ldc 90
    //   250: iconst_2
    //   251: new 156	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   258: ldc -97
    //   260: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   267: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc -91
    //   272: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: iconst_1
    //   286: ireturn
    //   287: astore_3
    //   288: aconst_null
    //   289: astore_2
    //   290: aload_2
    //   291: astore_1
    //   292: aload_3
    //   293: invokevirtual 170	java/io/FileNotFoundException:printStackTrace	()V
    //   296: aload_2
    //   297: ifnull +7 -> 304
    //   300: aload_2
    //   301: invokevirtual 134	java/io/FileInputStream:close	()V
    //   304: aload_0
    //   305: getfield 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   308: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifeq +27 -> 338
    //   314: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq -228 -> 89
    //   320: ldc 90
    //   322: iconst_2
    //   323: ldc -120
    //   325: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   328: iconst_1
    //   329: ireturn
    //   330: astore_1
    //   331: aload_1
    //   332: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   335: goto -31 -> 304
    //   338: aload_0
    //   339: getfield 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   342: ldc -115
    //   344: invokestatic 146	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   347: astore_1
    //   348: aload_0
    //   349: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   352: aload_1
    //   353: invokestatic 151	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   356: ifeq +11 -> 367
    //   359: aload_0
    //   360: aload_1
    //   361: putfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   364: goto -131 -> 233
    //   367: aload_1
    //   368: invokestatic 154	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   371: ifne -138 -> 233
    //   374: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq -288 -> 89
    //   380: ldc 90
    //   382: iconst_2
    //   383: new 156	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   390: ldc -97
    //   392: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_0
    //   396: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   399: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc -91
    //   404: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_1
    //   408: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: iconst_1
    //   418: ireturn
    //   419: astore_2
    //   420: aconst_null
    //   421: astore_1
    //   422: aload_1
    //   423: ifnull +7 -> 430
    //   426: aload_1
    //   427: invokevirtual 134	java/io/FileInputStream:close	()V
    //   430: aload_0
    //   431: getfield 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   434: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   437: ifeq +27 -> 464
    //   440: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq -354 -> 89
    //   446: ldc 90
    //   448: iconst_2
    //   449: ldc -120
    //   451: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: iconst_1
    //   455: ireturn
    //   456: astore_1
    //   457: aload_1
    //   458: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   461: goto -31 -> 430
    //   464: aload_0
    //   465: getfield 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   468: ldc -115
    //   470: invokestatic 146	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   473: astore_1
    //   474: aload_0
    //   475: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   478: aload_1
    //   479: invokestatic 151	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   482: ifeq +10 -> 492
    //   485: aload_0
    //   486: aload_1
    //   487: putfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   490: aload_2
    //   491: athrow
    //   492: aload_1
    //   493: invokestatic 154	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   496: ifne -6 -> 490
    //   499: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   502: ifeq -413 -> 89
    //   505: ldc 90
    //   507: iconst_2
    //   508: new 156	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   515: ldc -97
    //   517: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_0
    //   521: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   524: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc -91
    //   529: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_1
    //   533: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: iconst_1
    //   543: ireturn
    //   544: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq -458 -> 89
    //   550: ldc 90
    //   552: iconst_2
    //   553: new 156	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   560: ldc -84
    //   562: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload_0
    //   566: getfield 76	com/tencent/mobileqq/activity/richmedia/NewFlowCameraActivity$GenerateThumbTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   569: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: iconst_1
    //   579: ireturn
    //   580: astore_2
    //   581: goto -159 -> 422
    //   584: astore_3
    //   585: goto -295 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	GenerateThumbTask
    //   139	15	1	localFileInputStream1	java.io.FileInputStream
    //   199	2	1	localIOException1	java.io.IOException
    //   216	76	1	localObject1	Object
    //   330	2	1	localIOException2	java.io.IOException
    //   347	80	1	str1	String
    //   456	2	1	localIOException3	java.io.IOException
    //   473	60	1	str2	String
    //   137	164	2	localFileInputStream2	java.io.FileInputStream
    //   419	72	2	localObject2	Object
    //   580	1	2	localObject3	Object
    //   118	25	3	localFile	java.io.File
    //   287	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   584	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   49	12	4	i	int
    // Exception table:
    //   from	to	target	type
    //   169	173	199	java/io/IOException
    //   126	138	287	java/io/FileNotFoundException
    //   300	304	330	java/io/IOException
    //   126	138	419	finally
    //   426	430	456	java/io/IOException
    //   140	152	580	finally
    //   154	165	580	finally
    //   292	296	580	finally
    //   140	152	584	java/io/FileNotFoundException
    //   154	165	584	java/io/FileNotFoundException
  }
  
  private void a()
  {
    this.jdField_c_of_type_Int = 320;
    this.d = ((int)(this.jdField_c_of_type_Int / this.jdField_a_of_type_Float));
    if (this.d % 2 > 0) {
      this.d -= 1;
    }
    RMVideoThumbGenMgr.ThumbGenItem localThumbGenItem = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.a();
    if ((localThumbGenItem != null) && (localThumbGenItem.jdField_c_of_type_JavaLangString != null) && (localThumbGenItem.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3))
    {
      this.jdField_c_of_type_Int = localThumbGenItem.jdField_a_of_type_Int;
      this.d = localThumbGenItem.jdField_b_of_type_Int;
      this.jdField_a_of_type_JavaLangString = localThumbGenItem.jdField_c_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = localThumbGenItem.d;
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "FlowSendTask():mFileDir:" + this.jdField_b_of_type_JavaLangString + ",mThumbWidth: " + this.jdField_c_of_type_Int + ", mThumbHeight:" + this.d + " mThumbOK:" + this.jdField_a_of_type_Boolean);
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    a();
    a();
    return Integer.valueOf(0);
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "generate thumb result= " + paramInteger);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    switch (paramInteger.intValue())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener.a(false, null, null, 0, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.d);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\NewFlowCameraActivity$GenerateThumbTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */