package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;
import ntg;
import nth;
import nti;
import ntl;
import ntn;
import ntp;
import ntq;
import ntr;
import ntt;

public class AIOGalleryScene
  extends AbstractGalleryScene
  implements View.OnClickListener
{
  public static final String a = "AIOGalleryScene";
  public static final String b = "NeedReportForwardShortVideo";
  static final int f = 0;
  static final int jdField_j_of_type_Int = 250;
  static final int jdField_k_of_type_Int = 1024;
  private static final int jdField_l_of_type_Int = 25;
  final int jdField_a_of_type_Int;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  View jdField_a_of_type_AndroidViewView;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public AIOGalleryAdapter a;
  public AIOImageListModel a;
  public IAIOImageProvider a;
  public final MqqHandler a;
  public ntt a;
  boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  public String c;
  boolean jdField_c_of_type_Boolean;
  final int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  int e;
  public String e;
  public boolean e;
  public String f;
  public int g;
  public String g;
  boolean g;
  public int h;
  public String h;
  boolean h;
  public int i;
  boolean i;
  boolean jdField_j_of_type_Boolean;
  boolean jdField_k_of_type_Boolean;
  boolean jdField_l_of_type_Boolean;
  private int m;
  
  public AIOGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 62215;
    this.jdField_d_of_type_Int = Integer.MIN_VALUE;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 1;
    this.jdField_i_of_type_Boolean = false;
    this.j = false;
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new ntg(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new nti(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_c_of_type_JavaLangString = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.jdField_c_of_type_JavaLangString = ((PeakActivity)paramActivity).a.a();
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130904284, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    int n;
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.IS_FROM_CHAT_FILE_HISTORY", false))
    {
      n = 1;
      if (!this.jdField_d_of_type_Boolean) {
        break label79;
      }
    }
    label79:
    for (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, true, n);; this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter = new AIOGalleryAdapter(paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, false, n))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a = new ntr(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
      n = 0;
      break;
    }
  }
  
  /* Error */
  public Boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iconst_2
    //   7: iconst_0
    //   8: ldc -49
    //   10: ldc -47
    //   12: invokestatic 215	com/tencent/qbar/QbarNative:Init	(IILjava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: iconst_2
    //   17: newarray <illegal type>
    //   19: astore_2
    //   20: aload_2
    //   21: iconst_0
    //   22: iconst_2
    //   23: iastore
    //   24: aload_2
    //   25: iconst_1
    //   26: iconst_0
    //   27: iastore
    //   28: aload_2
    //   29: aload_2
    //   30: arraylength
    //   31: invokestatic 219	com/tencent/qbar/QbarNative:SetReaders	([II)I
    //   34: pop
    //   35: new 221	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   42: ldc -30
    //   44: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 235	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 244	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   60: astore 6
    //   62: aload 4
    //   64: astore_2
    //   65: aload 5
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 113	com/tencent/mobileqq/activity/aio/photo/AIOGalleryScene:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   72: invokevirtual 248	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   75: astore 8
    //   77: aload 4
    //   79: astore_2
    //   80: aload 5
    //   82: astore_3
    //   83: new 250	android/graphics/BitmapFactory$Options
    //   86: dup
    //   87: invokespecial 251	android/graphics/BitmapFactory$Options:<init>	()V
    //   90: astore 7
    //   92: aload 4
    //   94: astore_2
    //   95: aload 5
    //   97: astore_3
    //   98: aload 7
    //   100: iconst_1
    //   101: putfield 254	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   104: aload 4
    //   106: astore_2
    //   107: aload 5
    //   109: astore_3
    //   110: aload 8
    //   112: aload 6
    //   114: invokevirtual 260	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   117: astore_1
    //   118: aload_1
    //   119: astore_2
    //   120: aload_1
    //   121: astore_3
    //   122: aload_1
    //   123: aconst_null
    //   124: aload 7
    //   126: invokestatic 266	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   129: pop
    //   130: aload_1
    //   131: ifnull +11 -> 142
    //   134: aload_1
    //   135: astore_2
    //   136: aload_1
    //   137: astore_3
    //   138: aload_1
    //   139: invokevirtual 271	java/io/InputStream:close	()V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_1
    //   145: astore_3
    //   146: aload 7
    //   148: getfield 274	android/graphics/BitmapFactory$Options:outWidth	I
    //   151: istore 9
    //   153: aload_1
    //   154: astore_2
    //   155: aload_1
    //   156: astore_3
    //   157: aload 7
    //   159: getfield 277	android/graphics/BitmapFactory$Options:outHeight	I
    //   162: istore 10
    //   164: aload_1
    //   165: astore_2
    //   166: aload_1
    //   167: astore_3
    //   168: aload 7
    //   170: iconst_0
    //   171: putfield 254	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   174: iload 9
    //   176: iload 10
    //   178: imul
    //   179: ldc_w 278
    //   182: if_icmple +241 -> 423
    //   185: aload_1
    //   186: astore_2
    //   187: aload_1
    //   188: astore_3
    //   189: aload 7
    //   191: iload 9
    //   193: iload 10
    //   195: imul
    //   196: i2d
    //   197: invokestatic 284	java/lang/Math:sqrt	(D)D
    //   200: ldc2_w 285
    //   203: ddiv
    //   204: invokestatic 289	java/lang/Math:ceil	(D)D
    //   207: d2i
    //   208: putfield 292	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   211: aload_1
    //   212: astore_2
    //   213: aload_1
    //   214: astore_3
    //   215: aload 8
    //   217: aload 6
    //   219: invokevirtual 260	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   222: astore 4
    //   224: aload 4
    //   226: astore_1
    //   227: aload_1
    //   228: astore_2
    //   229: aload_1
    //   230: astore_3
    //   231: aload_1
    //   232: aconst_null
    //   233: aload 7
    //   235: invokestatic 266	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   238: astore 5
    //   240: aload_1
    //   241: ifnull +11 -> 252
    //   244: aload_1
    //   245: astore_2
    //   246: aload_1
    //   247: astore_3
    //   248: aload_1
    //   249: invokevirtual 271	java/io/InputStream:close	()V
    //   252: aload_1
    //   253: astore_2
    //   254: aload_1
    //   255: astore_3
    //   256: aload 5
    //   258: invokevirtual 298	android/graphics/Bitmap:getWidth	()I
    //   261: istore 9
    //   263: aload_1
    //   264: astore_2
    //   265: aload_1
    //   266: astore_3
    //   267: aload 5
    //   269: invokevirtual 301	android/graphics/Bitmap:getHeight	()I
    //   272: istore 10
    //   274: aload_1
    //   275: astore_2
    //   276: aload_1
    //   277: astore_3
    //   278: iload 9
    //   280: iload 10
    //   282: imul
    //   283: newarray <illegal type>
    //   285: astore 4
    //   287: aload_1
    //   288: astore_2
    //   289: aload_1
    //   290: astore_3
    //   291: aload 5
    //   293: aload 4
    //   295: iconst_0
    //   296: iload 9
    //   298: iconst_0
    //   299: iconst_0
    //   300: iload 9
    //   302: iload 10
    //   304: invokevirtual 305	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   307: aload_1
    //   308: astore_2
    //   309: aload_1
    //   310: astore_3
    //   311: aload 5
    //   313: invokevirtual 308	android/graphics/Bitmap:recycle	()V
    //   316: aload_1
    //   317: astore_2
    //   318: aload_1
    //   319: astore_3
    //   320: iload 9
    //   322: iload 10
    //   324: imul
    //   325: newarray <illegal type>
    //   327: astore 5
    //   329: aload_1
    //   330: astore_2
    //   331: aload_1
    //   332: astore_3
    //   333: aload 4
    //   335: aload 5
    //   337: iload 9
    //   339: iload 10
    //   341: invokestatic 313	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   344: pop
    //   345: aload_1
    //   346: astore_2
    //   347: aload_1
    //   348: astore_3
    //   349: aload 5
    //   351: iload 9
    //   353: iload 10
    //   355: iconst_0
    //   356: invokestatic 317	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   359: istore 10
    //   361: iload 10
    //   363: istore 9
    //   365: aload_1
    //   366: ifnull +11 -> 377
    //   369: aload_1
    //   370: invokevirtual 271	java/io/InputStream:close	()V
    //   373: iload 10
    //   375: istore 9
    //   377: invokestatic 320	com/tencent/qbar/QbarNative:Release	()I
    //   380: pop
    //   381: iload 9
    //   383: iconst_1
    //   384: if_icmpne +126 -> 510
    //   387: aload_0
    //   388: aload 6
    //   390: invokevirtual 323	android/net/Uri:getPath	()Ljava/lang/String;
    //   393: putfield 325	com/tencent/mobileqq/activity/aio/photo/AIOGalleryScene:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   396: iconst_1
    //   397: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   400: areturn
    //   401: astore_1
    //   402: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +13 -> 418
    //   408: ldc 10
    //   410: iconst_2
    //   411: aload_1
    //   412: invokevirtual 338	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   415: invokestatic 341	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iconst_0
    //   419: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   422: areturn
    //   423: aload_1
    //   424: astore_2
    //   425: aload_1
    //   426: astore_3
    //   427: aload 7
    //   429: iconst_1
    //   430: putfield 292	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   433: goto -222 -> 211
    //   436: astore_1
    //   437: aload_2
    //   438: astore_3
    //   439: aload_3
    //   440: astore_2
    //   441: invokestatic 337	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   444: ifeq +15 -> 459
    //   447: aload_3
    //   448: astore_2
    //   449: ldc 10
    //   451: iconst_2
    //   452: ldc_w 343
    //   455: aload_1
    //   456: invokestatic 346	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: aload_3
    //   460: ifnull +81 -> 541
    //   463: aload_3
    //   464: invokevirtual 271	java/io/InputStream:close	()V
    //   467: iconst_m1
    //   468: istore 9
    //   470: goto -93 -> 377
    //   473: astore_2
    //   474: aload_1
    //   475: ifnull +11 -> 486
    //   478: aload_1
    //   479: astore_2
    //   480: aload_1
    //   481: astore_3
    //   482: aload_1
    //   483: invokevirtual 271	java/io/InputStream:close	()V
    //   486: iconst_m1
    //   487: istore 10
    //   489: goto -128 -> 361
    //   492: astore_1
    //   493: iconst_m1
    //   494: istore 9
    //   496: goto -119 -> 377
    //   499: astore_1
    //   500: aload_2
    //   501: ifnull +7 -> 508
    //   504: aload_2
    //   505: invokevirtual 271	java/io/InputStream:close	()V
    //   508: aload_1
    //   509: athrow
    //   510: iconst_0
    //   511: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   514: areturn
    //   515: astore_1
    //   516: iload 10
    //   518: istore 9
    //   520: goto -143 -> 377
    //   523: astore_2
    //   524: goto -16 -> 508
    //   527: astore_1
    //   528: aload_3
    //   529: astore_2
    //   530: goto -30 -> 500
    //   533: astore_1
    //   534: goto -95 -> 439
    //   537: astore_2
    //   538: goto -64 -> 474
    //   541: iconst_m1
    //   542: istore 9
    //   544: goto -167 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	this	AIOGalleryScene
    //   0	547	1	paramFile	File
    //   19	430	2	localObject1	Object
    //   473	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   479	26	2	localFile	File
    //   523	1	2	localIOException	java.io.IOException
    //   529	1	2	localObject2	Object
    //   537	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   67	462	3	localObject3	Object
    //   4	330	4	localObject4	Object
    //   1	349	5	localObject5	Object
    //   60	329	6	localUri	android.net.Uri
    //   90	338	7	localOptions	android.graphics.BitmapFactory.Options
    //   75	141	8	localContentResolver	android.content.ContentResolver
    //   151	392	9	n	int
    //   162	355	10	i1	int
    // Exception table:
    //   from	to	target	type
    //   6	20	401	java/lang/UnsatisfiedLinkError
    //   28	35	401	java/lang/UnsatisfiedLinkError
    //   122	130	436	java/lang/Exception
    //   138	142	436	java/lang/Exception
    //   146	153	436	java/lang/Exception
    //   157	164	436	java/lang/Exception
    //   168	174	436	java/lang/Exception
    //   189	211	436	java/lang/Exception
    //   215	224	436	java/lang/Exception
    //   427	433	436	java/lang/Exception
    //   482	486	436	java/lang/Exception
    //   215	224	473	java/lang/OutOfMemoryError
    //   463	467	492	java/io/IOException
    //   68	77	499	finally
    //   83	92	499	finally
    //   98	104	499	finally
    //   110	118	499	finally
    //   231	240	499	finally
    //   248	252	499	finally
    //   256	263	499	finally
    //   267	274	499	finally
    //   278	287	499	finally
    //   291	307	499	finally
    //   311	316	499	finally
    //   320	329	499	finally
    //   333	345	499	finally
    //   349	361	499	finally
    //   441	447	499	finally
    //   449	459	499	finally
    //   369	373	515	java/io/IOException
    //   504	508	523	java/io/IOException
    //   122	130	527	finally
    //   138	142	527	finally
    //   146	153	527	finally
    //   157	164	527	finally
    //   168	174	527	finally
    //   189	211	527	finally
    //   215	224	527	finally
    //   427	433	527	finally
    //   482	486	527	finally
    //   68	77	533	java/lang/Exception
    //   83	92	533	java/lang/Exception
    //   98	104	533	java/lang/Exception
    //   110	118	533	java/lang/Exception
    //   231	240	533	java/lang/Exception
    //   248	252	533	java/lang/Exception
    //   256	263	533	java/lang/Exception
    //   267	274	533	java/lang/Exception
    //   278	287	533	java/lang/Exception
    //   291	307	533	java/lang/Exception
    //   311	316	533	java/lang/Exception
    //   320	329	533	java/lang/Exception
    //   333	345	533	java/lang/Exception
    //   349	361	533	java/lang/Exception
    //   231	240	537	java/lang/OutOfMemoryError
    //   248	252	537	java/lang/OutOfMemoryError
    //   256	263	537	java/lang/OutOfMemoryError
    //   267	274	537	java/lang/OutOfMemoryError
    //   278	287	537	java/lang/OutOfMemoryError
    //   291	307	537	java/lang/OutOfMemoryError
    //   311	316	537	java/lang/OutOfMemoryError
    //   320	329	537	java/lang/OutOfMemoryError
    //   333	345	537	java/lang/OutOfMemoryError
    //   349	361	537	java/lang/OutOfMemoryError
  }
  
  public void a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    AIORichMediaInfo localAIORichMediaInfo = new AIORichMediaInfo((AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(localAIORichMediaInfo);
    localAIORichMediaInfo.jdField_b_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.j = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.jdField_c_of_type_Int = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", 62215);
    this.jdField_e_of_type_Int = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", Integer.MIN_VALUE);
    this.jdField_e_of_type_Boolean = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
      this.f = localBundle.getString("extra.GROUP_CODE");
      if (((this.jdField_e_of_type_JavaLangString == null) || (this.f == null) || (this.jdField_c_of_type_JavaLangString == null)) && (QLog.isColorLevel())) {
        QLog.i("AIOGalleryScene", 2, "mGroupUin=" + this.jdField_e_of_type_JavaLangString + ", mGroupCode=" + this.f + ", mMyUin=" + this.jdField_c_of_type_JavaLangString);
      }
    }
    this.jdField_g_of_type_Int = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_d_of_type_Boolean = localBundle.getBoolean("extra.IS_APOLLO");
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
    this.jdField_h_of_type_Int = localBundle.getInt("forward_source_uin_type", -1);
    this.jdField_d_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_g_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", false);
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(true);
      this.jdField_h_of_type_Boolean = true;
      return;
    }
    localAIORichMediaInfo.jdField_c_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      paramInt2 = 0;
      if (paramInt2 < ((List)localObject1).size())
      {
        localObject2 = (AIORichMediaInfo)((List)localObject1).get(paramInt2);
        if ((((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f != paramLong1) || (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.k != paramInt1)) {
          break label156;
        }
        ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int = paramInt3;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramInt3 / 100);
        if (paramBoolean)
        {
          paramInt1 = this.jdField_a_of_type_ComTencentWidgetGallery.s();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt2 >= paramInt1) && (paramInt2 <= paramInt3 + paramInt1 - 1))
          {
            localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - paramInt1);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt2, (View)localObject1, paramBoolean);
          }
        }
      }
    }
    label156:
    label597:
    label599:
    do
    {
      for (;;)
      {
        return;
        paramInt2 += 1;
        break;
        if (paramInt2 == 4)
        {
          if ((this.jdField_a_of_type_Ntt != null) && (this.jdField_a_of_type_Ntt.jdField_a_of_type_Long == paramLong1) && (this.jdField_a_of_type_Ntt.jdField_a_of_type_Int == paramInt1) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
          {
            if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
            {
              this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
            if (paramLong2 > 0L)
            {
              localObject1 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)paramLong2);
              localObject2 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)(paramInt3 * paramLong2) / 10000.0F);
              localObject1 = (String)localObject2 + "/" + (String)localObject1;
              this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
              return;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt3 / 100 + "%");
          }
        }
        else if (paramInt2 == 1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
          paramInt1 = 0;
          while (paramInt1 < ((List)localObject1).size())
          {
            localObject2 = (AIORichMediaInfo)((List)localObject1).get(paramInt1);
            if (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f == paramLong1)
            {
              ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int = paramInt3;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramInt3 / 100);
              return;
            }
            paramInt1 += 1;
          }
        }
        else
        {
          if (paramInt2 != 18) {
            break label599;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= ((List)localObject1).size()) {
              break label597;
            }
            localObject2 = (AIORichMediaInfo)((List)localObject1).get(paramInt1);
            if (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f == paramLong1)
            {
              ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int = paramInt3;
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramInt3 / 100);
              if (!paramBoolean) {
                break;
              }
              paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.s();
              paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
              if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1)) {
                break;
              }
              localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1, (View)localObject1, paramBoolean);
              return;
            }
            paramInt1 += 1;
          }
        }
      }
    } while ((paramInt2 != 20) || (this.jdField_a_of_type_Ntt == null) || (this.jdField_a_of_type_Ntt.jdField_a_of_type_Long != paramLong1) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null));
    if ((this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt3);
    if (paramLong2 > 0L)
    {
      localObject1 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)paramLong2);
      localObject2 = PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, (float)(paramInt3 * paramLong2) / 10000.0F);
      localObject1 = (String)localObject2 + "/" + (String)localObject1;
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt3 / 100 + "%");
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt2 == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
      if (paramInt3 == 1)
      {
        paramInt2 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
        int n = this.jdField_a_of_type_ComTencentWidgetGallery.s();
        int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        if ((paramInt2 >= n) && (paramInt2 <= i1 + n - 1))
        {
          paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - n);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramString, paramBoolean);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt2);
        }
        paramInt2 = 0;
        label132:
        if (paramInt2 >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a()) {
          break label472;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt2);
        if (paramString != null) {
          break label177;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label132;
        paramString = "I:E";
        break;
        label177:
        if ((paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f == paramLong) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.k == paramInt1) && (paramInt3 == 1) && (AIOImageData.class.isInstance(paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
        {
          paramString = (AIOImageData)paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if ((!paramString.jdField_g_of_type_Boolean) && (new File(paramString.a + "_hd").exists())) {
            paramString.a += "_hd";
          }
        }
      }
    }
    else
    {
      if ((paramInt2 != 4) || (this.jdField_a_of_type_Ntt == null) || (this.jdField_a_of_type_Ntt.jdField_a_of_type_Long != paramLong) || (this.jdField_a_of_type_Ntt.jdField_a_of_type_Int != paramInt1)) {
        break label552;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
      if (paramInt3 != 1) {
        break label473;
      }
      ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
      if (paramInt3 != 1) {
        break label514;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mUseExifOrientation = false;
      paramString = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), paramString);
      switch (paramString.getStatus())
      {
      default: 
        label440:
        paramString.setTag(Integer.valueOf(1));
        paramString.setURLDrawableListener(this.jdField_a_of_type_Ntt);
        paramString.startDownload();
        this.jdField_a_of_type_Ntt.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
      }
    }
    label472:
    label473:
    label514:
    label552:
    do
    {
      return;
      paramString = "I:E";
      break;
      this.jdField_a_of_type_Ntt.onLoadSuccessed(paramString);
      return;
      this.jdField_a_of_type_Ntt.onLoadFialed(paramString, null);
      return;
      this.jdField_a_of_type_Ntt.onLoadCanceled(paramString);
      break label440;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131370320), 0).a();
      c(true);
      a(false);
      this.jdField_a_of_type_Ntt = null;
      return;
      if ((paramInt2 == 1) || (paramInt2 == 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 == 1) {}
        for (;;)
        {
          paramInt1 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.s();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
          {
            paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
          return;
          paramString = "I:E";
        }
      }
      if (paramInt2 == 18)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
        if (paramInt3 == 1) {}
        for (;;)
        {
          paramInt1 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.s();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
          {
            paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("AIOGalleryScene", 4, "notifyImageResult(): Gallery position is " + paramInt1);
          return;
          paramString = "I:E";
        }
      }
    } while ((paramInt2 != 20) || (this.jdField_a_of_type_Ntt == null) || (this.jdField_a_of_type_Ntt.jdField_a_of_type_Long != paramLong));
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 == 1)
    {
      localObject = paramString;
      localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
      QLog.d("AIOGalleryScene", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
      if (paramInt3 != 1) {
        break label1066;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mPlayGifImage = true;
      paramString.mUseExifOrientation = false;
      paramString = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20), paramString);
      switch (paramString.getStatus())
      {
      }
    }
    for (;;)
    {
      paramString.setTag(Integer.valueOf(1));
      paramString.setURLDrawableListener(this.jdField_a_of_type_Ntt);
      paramString.startDownload();
      this.jdField_a_of_type_Ntt.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
      return;
      localObject = "I:E";
      break;
      this.jdField_a_of_type_Ntt.onLoadSuccessed(paramString);
      return;
      this.jdField_a_of_type_Ntt.onLoadFialed(paramString, null);
      return;
      this.jdField_a_of_type_Ntt.onLoadCanceled(paramString);
    }
    label1066:
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131370320), 0).a();
    c(true);
    a(false);
    this.jdField_a_of_type_Ntt = null;
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    paramIntent.putExtra("filepictest", true);
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    String str1 = paramIntent.getStringExtra("forward_filepath");
    boolean bool1 = paramIntent.getBooleanExtra("k_favorites", false);
    String str2 = paramIntent.getStringExtra("forward_text");
    boolean bool2 = paramIntent.getBooleanExtra("isFromShare", false);
    int n = paramIntent.getIntExtra("forward_type", 0);
    paramIntent = new Intent();
    paramIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", n);
    localBundle.putParcelable("fileinfo", localForwardFileInfo);
    localBundle.putBoolean("not_forward", true);
    paramIntent.putExtras(localBundle);
    paramIntent.putExtra("forward_filepath", str1);
    paramIntent.putExtra("forward_text", str2);
    paramIntent.putExtra("k_favorites", bool1);
    paramIntent.putExtra("isFromShare", bool2);
    paramIntent.putExtra("isPic", true);
    paramIntent.putExtra("direct_send_if_dataline_forward", true);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramIntent, 103);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramConfiguration);
  }
  
  void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
    paramBundle = new Bundle(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    String str = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    int n = paramBundle.getInt("PhotoConst.SEND_SIZE_SPEC", 0);
    if (this.jdField_h_of_type_Int == 9501)
    {
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    PhotoUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, localArrayList, n, true);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    int n = 1;
    if (paramView == null) {}
    do
    {
      return;
      paramView = (URLDrawable)((ImageView)paramView).getDrawable();
    } while (paramView.getStatus() != 1);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
      if (localAIORichMediaInfo != null) {
        localAIORichMediaInfo.jdField_b_of_type_Int = n;
      }
      paramView = new File(paramView.getURL().getFile());
      if (!paramView.exists()) {
        break;
      }
      new nth(this, paramView, paramInt2).execute(new Void[0]);
      return;
      n = 3;
      continue;
      n = 8;
      continue;
      n = 6;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    paramViewGroup = (RelativeLayout)a();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 25.0F, (DisplayMetrics)localObject));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, (DisplayMetrics)localObject));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296643);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131428132));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427651));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370312);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131370312));
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription("更多操作");
    this.jdField_a_of_type_AndroidWidgetImageButton.setId(2131296644);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837563);
    this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.bottomMargin = ((int)TypedValue.applyDimension(1, 13.0F, (DisplayMetrics)localObject));
    localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 18.0F, (DisplayMetrics)localObject));
    if (!((AIORichMediaData)this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)) {
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageButton, localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130904287, null);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131297446));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302177));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if ((ProGallery.OnProGalleryListener.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
      ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
    }
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (!AIOImageData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    File localFile = localAIOImageData.a(4);
    if (localFile == null) {
      localFile = localAIOImageData.a(2);
    }
    for (int n = 0;; n = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.a(1));
      paramAIORichMediaInfo = paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (n != 0) {}
      for (int i1 = 4;; i1 = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", paramAIORichMediaInfo.a(i1));
        try
        {
          localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (n != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
          paramAIORichMediaInfo = new Intent();
          paramAIORichMediaInfo.putExtras(localBundle);
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramAIORichMediaInfo, 0);
          return;
        }
        catch (NullPointerException paramAIORichMediaInfo) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,NullPointerException: " + paramAIORichMediaInfo);
      return;
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramString, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(false);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryScene", 2, "notifyImageListChanged list size " + paramArrayOfAIORichMediaData.length + ", selected " + paramInt);
    }
    u();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {
      try
      {
        if (!AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          r();
        }
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
          }
        }
      }
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    return false;
  }
  
  boolean a(ActionSheet paramActionSheet, AIOFilePicData paramAIOFilePicData)
  {
    return false;
  }
  
  boolean a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData)
  {
    return false;
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    try
    {
      if (!AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        r();
      }
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
        }
      }
    }
  }
  
  public boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    return false;
  }
  
  public void b()
  {
    q();
    this.l = true;
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = true;
    }
    if (!f()) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.b(paramAdapterView, paramView, paramInt, paramLong);
    Object localObject;
    if (!this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a()) {
        u();
      }
    }
    else
    {
      c(false);
      if (AIOGalleryAdapter.GalleryURLImageView.class.isInstance(paramView))
      {
        localObject = (AIOGalleryAdapter.GalleryURLImageView)paramView;
        Drawable localDrawable = ((AIOGalleryAdapter.GalleryURLImageView)localObject).getDrawable();
        if ((!((AIOGalleryAdapter.GalleryURLImageView)localObject).jdField_b_of_type_Boolean) && (localDrawable != null) && ((localDrawable instanceof URLDrawable)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
          if (localObject != null)
          {
            a((AIORichMediaInfo)localObject);
            if ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4)) || (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20)))
            {
              if (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.h <= 0L) {
                break label460;
              }
              this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131370313), new Object[] { ShortVideoUtils.a(this.jdField_a_of_type_AndroidAppActivity, ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.h) }));
            }
          }
        }
      }
    }
    for (;;)
    {
      c(true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
        localObject = a().findViewById(2131302166);
        if (localObject != null)
        {
          if (((View)localObject).getAnimation() != null)
          {
            ((View)localObject).getAnimation().cancel();
            ((View)localObject).setAnimation(null);
          }
          ((View)localObject).setVisibility(4);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramAdapterView, paramView, paramInt, paramLong);
        paramAdapterView = a().findViewById(2131302166);
        if (paramAdapterView != null)
        {
          if (paramAdapterView.getAnimation() != null)
          {
            paramAdapterView.getAnimation().cancel();
            paramAdapterView.setAnimation(null);
          }
          paramAdapterView.setVisibility(4);
        }
      }
      return;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      int n = 0;
      if (this.jdField_h_of_type_Boolean) {
        if (i1 - paramInt > 0)
        {
          if (paramInt <= i1 - 25) {
            break label436;
          }
          n = 1;
        }
      }
      for (;;)
      {
        if ((i1 == 1) || (n == 0) || (this.jdField_a_of_type_Boolean) || (this.m == i1)) {
          break label458;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "[onItemSelected] loadMedias: mLastLoadCount=" + this.m);
        }
        this.m = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(0);
        break;
        label436:
        n = 0;
        continue;
        if (paramInt < 25) {
          n = 1;
        } else {
          n = 0;
        }
      }
      label458:
      break;
      label460:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370312);
    }
  }
  
  protected boolean b()
  {
    boolean bool = true;
    if (this.jdField_c_of_type_Int == 1) {
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    this.l = false;
    c(this.k);
    if (!g()) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((this.k) && (this.l)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected boolean c()
  {
    if (((this.jdField_c_of_type_Int == 62215) || (this.jdField_c_of_type_Int == 1)) && (!this.jdField_g_of_type_Boolean)) {
      return false;
    }
    if (this.jdField_e_of_type_Int == Integer.MIN_VALUE) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    for (int n = localRunningAppProcessInfo.pid;; n = Integer.MIN_VALUE) {
      return n == this.jdField_e_of_type_Int;
    }
  }
  
  public void d()
  {
    if (!g()) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  public void e()
  {
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryFileActivity.class);
      localIntent.addFlags(603979776);
      AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if (localAIORichMediaInfo != null) {
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      localIntent.putExtra("tab_tab_type", 0);
      localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_h_of_type_Int);
      localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131369134));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Ntt != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_Ntt.jdField_a_of_type_Long, this.jdField_a_of_type_Ntt.jdField_a_of_type_Int, 4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_Ntt.jdField_a_of_type_Long, this.jdField_a_of_type_Ntt.jdField_a_of_type_Int, 20);
      this.jdField_a_of_type_Ntt = null;
      a(false);
      c(true);
      return true;
    }
    c(false);
    boolean bool = super.e();
    int n = this.jdField_a_of_type_ComTencentWidgetGallery.s();
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if ((i2 >= n) && (i2 <= i1 + n - 1))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i2 - n);
      if (ImageView.class.isInstance(localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i2, (ImageView)localObject);
      }
    }
    Object localObject = a().findViewById(2131302166);
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    if (this.jdField_g_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if (localObject != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      }
    }
    return bool;
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_i_of_type_Int > 0) {
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, "" + this.jdField_i_of_type_Int, "", "", "");
    }
  }
  
  boolean f()
  {
    return false;
  }
  
  boolean g()
  {
    return false;
  }
  
  public void l()
  {
    super.l();
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void m()
  {
    super.m();
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131296643: 
      do
      {
        do
        {
          return;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
        } while ((paramView == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()));
        a(true);
        this.jdField_a_of_type_Ntt = new ntt(this);
        this.jdField_a_of_type_Ntt.jdField_a_of_type_Long = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f;
        this.jdField_a_of_type_Ntt.jdField_a_of_type_Int = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.k;
        if (AIOImageData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Ntt.jdField_a_of_type_Long, this.jdField_a_of_type_Ntt.jdField_a_of_type_Int, 4);
          return;
        }
      } while (!AIOFilePicData.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_Ntt.jdField_a_of_type_Long, this.jdField_a_of_type_Ntt.jdField_a_of_type_Int, 20);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    r();
  }
  
  public void q()
  {
    if ((this.j) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
    }
  }
  
  public void r()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    AIOImageData localAIOImageData;
    Object localObject2;
    if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localObject2 = localAIOImageData.a(4);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOImageData.a(2);
      }
      if ((localObject1 != null) || (!this.j)) {}
    }
    label283:
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
          if (localObject1 != null) {
            this.jdField_h_of_type_JavaLangString = ((File)localObject1).getPath();
          }
          if (!a((ActionSheet)localObject2, localAIOImageData)) {
            if (localObject1 != null)
            {
              if (this.jdField_c_of_type_Boolean) {
                break label283;
              }
              ((ActionSheet)localObject2).c(2131370093);
              if (localAIOImageData.jdField_e_of_type_JavaLangString != null) {
                ((ActionSheet)localObject2).c(2131370103);
              }
              if ((this.jdField_e_of_type_Boolean) && (localAIOImageData.jdField_e_of_type_JavaLangString != null)) {
                ((ActionSheet)localObject2).c(2131370112);
              }
              ((ActionSheet)localObject2).c(2131370099);
              ThreadManager.a().post(new ntl(this, (File)localObject1, (ActionSheet)localObject2));
              ((ActionSheet)localObject2).c(2131370097);
            }
          }
          for (;;)
          {
            if ((!this.j) && (!this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int != 3000) && (this.jdField_h_of_type_Int != 0)) {
              ((ActionSheet)localObject2).c(2131370104);
            }
            if ((!this.j) && (!this.jdField_c_of_type_Boolean) && ((this.jdField_h_of_type_Int == 3000) || (this.jdField_h_of_type_Int == 0))) {
              ((ActionSheet)localObject2).c(2131370105);
            }
            ((ActionSheet)localObject2).d(2131367262);
            ((ActionSheet)localObject2).a(new ntn(this, (ActionSheet)localObject2, localAIOImageData, (File)localObject1, (AIORichMediaInfo)localObject3));
            ((ActionSheet)localObject2).show();
            return;
            if (this.jdField_d_of_type_Boolean) {
              ((ActionSheet)localObject2).c(2131370093);
            }
            ((ActionSheet)localObject2).c(2131370099);
          }
          if (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            break;
          }
          localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          localObject2 = ((AIOShortVideoData)localObject1).a(1);
        } while ((localObject2 == null) || (!((File)localObject2).exists()));
        localObject3 = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
        ((ActionSheet)localObject3).c(2131370093);
        ((ActionSheet)localObject3).c(2131370097);
        if ((this.jdField_h_of_type_Int != 3000) && (this.jdField_h_of_type_Int != 0)) {
          ((ActionSheet)localObject3).c(2131370104);
        }
        if ((this.jdField_h_of_type_Int == 3000) || (this.jdField_h_of_type_Int == 0)) {
          ((ActionSheet)localObject3).c(2131370105);
        }
        ((ActionSheet)localObject3).d(2131367262);
        ((ActionSheet)localObject3).a(new ntp(this, (ActionSheet)localObject3, (AIOShortVideoData)localObject1, (File)localObject2));
        ((ActionSheet)localObject3).show();
        return;
      } while (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      localObject3 = (AIOFilePicData)((AIORichMediaInfo)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localObject2 = ((AIOFilePicData)localObject3).a(20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((AIOFilePicData)localObject3).a(18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((AIOFilePicData)localObject3).a(16);
      }
    } while ((localObject2 == null) && (this.j));
    Object localObject1 = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
    if (localObject2 != null) {
      this.jdField_h_of_type_JavaLangString = ((File)localObject2).getPath();
    }
    if (!a((ActionSheet)localObject1, (AIOFilePicData)localObject3)) {
      if (localObject2 != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          break label678;
        }
        ((ActionSheet)localObject1).c(2131370093);
        ((ActionSheet)localObject1).c(2131362909);
        ((ActionSheet)localObject1).c(2131370099);
        ((ActionSheet)localObject1).c(2131370097);
      }
    }
    for (;;)
    {
      if ((!this.j) && (!this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int != 3000) && (this.jdField_h_of_type_Int != 0)) {
        ((ActionSheet)localObject1).c(2131370104);
      }
      if ((!this.j) && (!this.jdField_c_of_type_Boolean) && ((this.jdField_h_of_type_Int == 3000) || (this.jdField_h_of_type_Int == 0))) {
        ((ActionSheet)localObject1).c(2131370105);
      }
      ((ActionSheet)localObject1).d(2131367262);
      ((ActionSheet)localObject1).a(new ntq(this, (ActionSheet)localObject1, (AIOFilePicData)localObject3, (File)localObject2));
      ((ActionSheet)localObject1).show();
      return;
      label678:
      ((ActionSheet)localObject1).c(2131370099);
    }
  }
  
  public void s()
  {
    if (!this.j)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        int n = this.jdField_a_of_type_ComTencentWidgetGallery.s();
        int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
        if ((i2 >= n) && (i2 <= i1 + n - 1))
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i2 - n);
          if (ImageView.class.isInstance(localObject)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i2, (ImageView)localObject);
          }
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
        if (localObject != null) {
          ((AIORichMediaInfo)localObject).jdField_c_of_type_Boolean = true;
        }
        p();
        a("Pic_view", 0);
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131368693, 0).a();
  }
  
  public void t()
  {
    ReportController.b(null, "dc00898", "", "", "0X8007123", "0X8007123", 0, 0, "", "", "", "");
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAppActivity.onBackPressed();
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryFileActivity.class);
    localIntent.addFlags(603979776);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_h_of_type_Int);
    localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
    localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((AIORichMediaInfo)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a()).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131369134));
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130968787, 2130968744);
  }
  
  public void u()
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == 0)
    {
      PicReporter.b(false);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131370110, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
      if (n == this.jdField_a_of_type_ComTencentWidgetGallery.r()) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(n);
      return;
      PicReporter.b(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOGalleryScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */