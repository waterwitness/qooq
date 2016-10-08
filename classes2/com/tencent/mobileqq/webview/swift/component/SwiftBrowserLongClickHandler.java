package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageAnchorData;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import whw;
import whx;
import why;

public class SwiftBrowserLongClickHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  static final int jdField_a_of_type_Int = 1024;
  static final String jdField_a_of_type_JavaLangString = "SwiftBrowserLongClickHandler";
  public final Activity a;
  public QQProgressDialog a;
  public CookieManager a;
  public ActionSheet a;
  public int b;
  String b;
  public int c;
  public String c;
  
  public SwiftBrowserLongClickHandler(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 0;
    this.c = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
      this.jdField_b_of_type_Int = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();
    }
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    ThreadManager.a(new why(this, paramString), 5, null, false);
  }
  
  /* Error */
  public Boolean a(java.io.File paramFile)
  {
    // Byte code:
    //   0: iconst_2
    //   1: iconst_0
    //   2: ldc 69
    //   4: ldc 71
    //   6: invokestatic 77	com/tencent/qbar/QbarNative:Init	(IILjava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: iconst_2
    //   11: newarray <illegal type>
    //   13: astore_2
    //   14: aload_2
    //   15: iconst_0
    //   16: iconst_2
    //   17: iastore
    //   18: aload_2
    //   19: iconst_1
    //   20: iconst_0
    //   21: iastore
    //   22: aload_2
    //   23: aload_2
    //   24: arraylength
    //   25: invokestatic 81	com/tencent/qbar/QbarNative:SetReaders	([II)I
    //   28: pop
    //   29: new 83	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   36: ldc 86
    //   38: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 105	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   54: astore_1
    //   55: iconst_m1
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 33	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   62: invokevirtual 109	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   65: astore 4
    //   67: new 111	android/graphics/BitmapFactory$Options
    //   70: dup
    //   71: invokespecial 112	android/graphics/BitmapFactory$Options:<init>	()V
    //   74: astore_3
    //   75: aload_3
    //   76: iconst_1
    //   77: putfield 115	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 121	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   86: astore_2
    //   87: aload_2
    //   88: aconst_null
    //   89: aload_3
    //   90: invokestatic 127	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: pop
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 132	java/io/InputStream:close	()V
    //   102: aload_3
    //   103: getfield 135	android/graphics/BitmapFactory$Options:outWidth	I
    //   106: istore 6
    //   108: aload_3
    //   109: getfield 138	android/graphics/BitmapFactory$Options:outHeight	I
    //   112: istore 7
    //   114: aload_3
    //   115: iconst_0
    //   116: putfield 115	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   119: iload 6
    //   121: iload 7
    //   123: imul
    //   124: ldc -117
    //   126: if_icmple +168 -> 294
    //   129: aload_3
    //   130: iload 6
    //   132: iload 7
    //   134: imul
    //   135: i2d
    //   136: invokestatic 145	java/lang/Math:sqrt	(D)D
    //   139: ldc2_w 146
    //   142: ddiv
    //   143: invokestatic 150	java/lang/Math:ceil	(D)D
    //   146: d2i
    //   147: putfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   150: aload 4
    //   152: aload_1
    //   153: invokevirtual 121	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   156: astore_1
    //   157: aload_1
    //   158: aconst_null
    //   159: aload_3
    //   160: invokestatic 127	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   163: astore_3
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 132	java/io/InputStream:close	()V
    //   172: aload_3
    //   173: invokevirtual 158	android/graphics/Bitmap:getWidth	()I
    //   176: istore 6
    //   178: aload_3
    //   179: invokevirtual 161	android/graphics/Bitmap:getHeight	()I
    //   182: istore 7
    //   184: iload 6
    //   186: iload 7
    //   188: imul
    //   189: newarray <illegal type>
    //   191: astore_2
    //   192: aload_3
    //   193: aload_2
    //   194: iconst_0
    //   195: iload 6
    //   197: iconst_0
    //   198: iconst_0
    //   199: iload 6
    //   201: iload 7
    //   203: invokevirtual 165	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   206: aload_3
    //   207: invokevirtual 168	android/graphics/Bitmap:recycle	()V
    //   210: iload 6
    //   212: iload 7
    //   214: imul
    //   215: newarray <illegal type>
    //   217: astore_3
    //   218: aload_2
    //   219: aload_3
    //   220: iload 6
    //   222: iload 7
    //   224: invokestatic 173	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   227: pop
    //   228: aload_3
    //   229: iload 6
    //   231: iload 7
    //   233: iconst_0
    //   234: invokestatic 177	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   237: istore 6
    //   239: iload 6
    //   241: istore 5
    //   243: invokestatic 180	com/tencent/qbar/QbarNative:Release	()I
    //   246: pop
    //   247: iload 5
    //   249: iconst_1
    //   250: if_icmpne +111 -> 361
    //   253: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +11 -> 267
    //   259: ldc 10
    //   261: iconst_2
    //   262: ldc -69
    //   264: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: iconst_1
    //   268: invokestatic 196	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   271: areturn
    //   272: astore_1
    //   273: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +13 -> 289
    //   279: ldc 10
    //   281: iconst_2
    //   282: aload_1
    //   283: invokevirtual 197	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   286: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: iconst_0
    //   290: invokestatic 196	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   293: areturn
    //   294: aload_3
    //   295: iconst_1
    //   296: putfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   299: goto -149 -> 150
    //   302: astore_1
    //   303: ldc 10
    //   305: iconst_1
    //   306: aload_1
    //   307: invokevirtual 201	java/io/IOException:toString	()Ljava/lang/String;
    //   310: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: goto -70 -> 243
    //   316: astore_1
    //   317: aload_2
    //   318: astore_1
    //   319: aload_1
    //   320: ifnull +7 -> 327
    //   323: aload_1
    //   324: invokevirtual 132	java/io/InputStream:close	()V
    //   327: iconst_m1
    //   328: istore 5
    //   330: goto -87 -> 243
    //   333: astore_1
    //   334: ldc 10
    //   336: iconst_1
    //   337: aload_1
    //   338: invokevirtual 205	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   341: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: goto -101 -> 243
    //   347: astore_1
    //   348: ldc 10
    //   350: iconst_1
    //   351: aload_1
    //   352: invokevirtual 197	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   355: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: goto -115 -> 243
    //   361: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +11 -> 375
    //   367: ldc 10
    //   369: iconst_2
    //   370: ldc -49
    //   372: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: iconst_0
    //   376: invokestatic 196	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   379: areturn
    //   380: astore_2
    //   381: goto -62 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	SwiftBrowserLongClickHandler
    //   0	384	1	paramFile	java.io.File
    //   13	305	2	localObject1	Object
    //   380	1	2	localOutOfMemoryError	OutOfMemoryError
    //   74	221	3	localObject2	Object
    //   65	86	4	localContentResolver	android.content.ContentResolver
    //   56	273	5	i	int
    //   106	134	6	j	int
    //   112	120	7	k	int
    // Exception table:
    //   from	to	target	type
    //   0	14	272	java/lang/UnsatisfiedLinkError
    //   22	29	272	java/lang/UnsatisfiedLinkError
    //   58	94	302	java/io/IOException
    //   98	102	302	java/io/IOException
    //   102	119	302	java/io/IOException
    //   129	150	302	java/io/IOException
    //   150	157	302	java/io/IOException
    //   157	164	302	java/io/IOException
    //   168	172	302	java/io/IOException
    //   172	239	302	java/io/IOException
    //   294	299	302	java/io/IOException
    //   323	327	302	java/io/IOException
    //   150	157	316	java/lang/OutOfMemoryError
    //   58	94	333	java/lang/RuntimeException
    //   98	102	333	java/lang/RuntimeException
    //   102	119	333	java/lang/RuntimeException
    //   129	150	333	java/lang/RuntimeException
    //   150	157	333	java/lang/RuntimeException
    //   157	164	333	java/lang/RuntimeException
    //   168	172	333	java/lang/RuntimeException
    //   172	239	333	java/lang/RuntimeException
    //   294	299	333	java/lang/RuntimeException
    //   323	327	333	java/lang/RuntimeException
    //   58	94	347	java/lang/UnsatisfiedLinkError
    //   98	102	347	java/lang/UnsatisfiedLinkError
    //   102	119	347	java/lang/UnsatisfiedLinkError
    //   129	150	347	java/lang/UnsatisfiedLinkError
    //   150	157	347	java/lang/UnsatisfiedLinkError
    //   157	164	347	java/lang/UnsatisfiedLinkError
    //   168	172	347	java/lang/UnsatisfiedLinkError
    //   172	239	347	java/lang/UnsatisfiedLinkError
    //   294	299	347	java/lang/UnsatisfiedLinkError
    //   323	327	347	java/lang/UnsatisfiedLinkError
    //   157	164	380	java/lang/OutOfMemoryError
    //   168	172	380	java/lang/OutOfMemoryError
    //   172	239	380	java/lang/OutOfMemoryError
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 92	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 222	java/io/FileInputStream
    //   15: dup
    //   16: aload 5
    //   18: invokespecial 225	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 228	java/io/InputStream:read	()I
    //   26: istore 6
    //   28: aload_2
    //   29: invokevirtual 228	java/io/InputStream:read	()I
    //   32: istore 7
    //   34: aload_2
    //   35: invokevirtual 228	java/io/InputStream:read	()I
    //   38: istore 8
    //   40: iload 6
    //   42: bipush 66
    //   44: if_icmpne +175 -> 219
    //   47: iload 7
    //   49: bipush 77
    //   51: if_icmpne +168 -> 219
    //   54: ldc -26
    //   56: astore_1
    //   57: aload_2
    //   58: ifnull +317 -> 375
    //   61: aload_2
    //   62: invokevirtual 132	java/io/InputStream:close	()V
    //   65: aload_1
    //   66: ifnull +276 -> 342
    //   69: aload_0
    //   70: getfield 232	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   73: invokestatic 105	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   76: invokevirtual 235	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   79: astore_3
    //   80: aload_3
    //   81: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   84: ifeq +203 -> 287
    //   87: ldc -13
    //   89: astore_2
    //   90: new 92	java/io/File
    //   93: dup
    //   94: getstatic 248	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   97: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: invokevirtual 251	java/io/File:mkdirs	()Z
    //   103: pop
    //   104: new 83	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   111: getstatic 248	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   114: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore 4
    //   130: new 92	java/io/File
    //   133: dup
    //   134: aload 4
    //   136: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   139: astore_3
    //   140: iconst_2
    //   141: istore 6
    //   143: aload_3
    //   144: invokevirtual 254	java/io/File:exists	()Z
    //   147: ifeq +168 -> 315
    //   150: iload 6
    //   152: ldc -1
    //   154: if_icmpge +161 -> 315
    //   157: new 83	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   164: getstatic 248	com/tencent/mobileqq/app/AppConstants:bo	Ljava/lang/String;
    //   167: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_2
    //   171: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 257
    //   177: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 6
    //   182: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc_w 262
    //   188: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_1
    //   192: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore 4
    //   200: new 92	java/io/File
    //   203: dup
    //   204: aload 4
    //   206: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore_3
    //   210: iload 6
    //   212: iconst_1
    //   213: iadd
    //   214: istore 6
    //   216: goto -73 -> 143
    //   219: iload 6
    //   221: sipush 137
    //   224: if_icmpne +154 -> 378
    //   227: iload 7
    //   229: bipush 80
    //   231: if_icmpne +147 -> 378
    //   234: ldc_w 264
    //   237: astore_1
    //   238: goto -181 -> 57
    //   241: ldc_w 266
    //   244: astore_1
    //   245: goto -188 -> 57
    //   248: astore_2
    //   249: goto -184 -> 65
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_2
    //   255: aload_2
    //   256: ifnull +114 -> 370
    //   259: aload_2
    //   260: invokevirtual 132	java/io/InputStream:close	()V
    //   263: aconst_null
    //   264: astore_1
    //   265: goto -200 -> 65
    //   268: astore_1
    //   269: aconst_null
    //   270: astore_1
    //   271: goto -206 -> 65
    //   274: astore_1
    //   275: aload_3
    //   276: astore_2
    //   277: aload_2
    //   278: ifnull +7 -> 285
    //   281: aload_2
    //   282: invokevirtual 132	java/io/InputStream:close	()V
    //   285: aload_1
    //   286: athrow
    //   287: aload_3
    //   288: astore_2
    //   289: aload_3
    //   290: aload_1
    //   291: invokevirtual 272	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   294: ifeq -204 -> 90
    //   297: aload_3
    //   298: iconst_0
    //   299: aload_3
    //   300: invokevirtual 275	java/lang/String:length	()I
    //   303: aload_1
    //   304: invokevirtual 275	java/lang/String:length	()I
    //   307: isub
    //   308: invokevirtual 279	java/lang/String:substring	(II)Ljava/lang/String;
    //   311: astore_2
    //   312: goto -222 -> 90
    //   315: aload 5
    //   317: aload_3
    //   318: invokevirtual 283	java/io/File:renameTo	(Ljava/io/File;)Z
    //   321: ifeq +21 -> 342
    //   324: aload_0
    //   325: getfield 33	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   328: new 285	wic
    //   331: dup
    //   332: aload_0
    //   333: aload 4
    //   335: invokespecial 286	wic:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler;Ljava/lang/String;)V
    //   338: invokevirtual 290	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   341: return
    //   342: aload_0
    //   343: getfield 33	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   346: new 292	wid
    //   349: dup
    //   350: aload_0
    //   351: invokespecial 295	wid:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler;)V
    //   354: invokevirtual 290	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   357: return
    //   358: astore_2
    //   359: goto -74 -> 285
    //   362: astore_1
    //   363: goto -86 -> 277
    //   366: astore_1
    //   367: goto -112 -> 255
    //   370: aconst_null
    //   371: astore_1
    //   372: goto -307 -> 65
    //   375: goto -310 -> 65
    //   378: iload 6
    //   380: bipush 71
    //   382: if_icmpne +17 -> 399
    //   385: iload 7
    //   387: bipush 73
    //   389: if_icmpne +10 -> 399
    //   392: ldc_w 297
    //   395: astore_1
    //   396: goto -339 -> 57
    //   399: iload 6
    //   401: sipush 255
    //   404: if_icmpne +18 -> 422
    //   407: iload 7
    //   409: sipush 216
    //   412: if_icmpne +10 -> 422
    //   415: ldc_w 299
    //   418: astore_1
    //   419: goto -362 -> 57
    //   422: bipush 82
    //   424: iload 6
    //   426: if_icmpne -185 -> 241
    //   429: bipush 73
    //   431: iload 7
    //   433: if_icmpne -192 -> 241
    //   436: bipush 70
    //   438: iload 8
    //   440: if_icmpne -199 -> 241
    //   443: ldc_w 301
    //   446: astore_1
    //   447: goto -390 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	SwiftBrowserLongClickHandler
    //   0	450	1	paramString	String
    //   21	150	2	localObject1	Object
    //   248	1	2	localIOException1	java.io.IOException
    //   254	58	2	localObject2	Object
    //   358	1	2	localIOException2	java.io.IOException
    //   1	317	3	localObject3	Object
    //   128	206	4	str	String
    //   10	306	5	localFile	java.io.File
    //   26	401	6	i	int
    //   32	402	7	j	int
    //   38	403	8	k	int
    // Exception table:
    //   from	to	target	type
    //   61	65	248	java/io/IOException
    //   12	22	252	java/io/IOException
    //   259	263	268	java/io/IOException
    //   12	22	274	finally
    //   281	285	358	java/io/IOException
    //   22	40	362	finally
    //   22	40	366	java/io/IOException
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return true;
    }
    String str = "";
    int i;
    if ((paramView instanceof IX5WebViewBase))
    {
      paramView = ((IX5WebViewBase)paramView).getHitTestResult();
      if (paramView != null)
      {
        i = paramView.getType();
        if (i == 8) {
          paramView = ((IX5WebViewBase.HitTestResult.ImageAnchorData)paramView.getData()).mPicUrl;
        }
      }
    }
    for (;;)
    {
      if ((i != 8) && (i != 5))
      {
        return false;
        paramView = paramView.getExtra();
        continue;
        return false;
        if ((paramView instanceof WebView))
        {
          paramView = ((WebView)paramView).getHitTestResult();
          if (paramView != null)
          {
            i = paramView.getType();
            paramView = paramView.getExtra();
            continue;
          }
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserLongClickHandler", 2, "showActionSheet");
        }
        this.jdField_b_of_type_JavaLangString = paramView;
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369814);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369914);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
        d(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new whw(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new whx(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setCanceledOnTouchOutside(true);
        try
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return true;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
          }
        }
      }
      i = 0;
      paramView = str;
    }
  }
  
  public void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_extra", paramString);
    localBundle.putBoolean("not_forward", true);
    localBundle.putString("forward_thumb", paramString);
    localBundle.putBoolean("isFromShare", true);
    localBundle.putBoolean("isJumpAIO", true);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 21);
  }
  
  public void c(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserLongClickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */