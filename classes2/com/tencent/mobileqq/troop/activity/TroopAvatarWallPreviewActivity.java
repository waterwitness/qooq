package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ImagePreviewAnimationUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Gallery;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import vgk;
import vgp;
import vgq;
import vgr;
import vgs;
import vgt;
import vgu;
import vgv;
import vgw;
import vgy;
import vha;
import vhc;
import vhd;
import vhf;
import vhg;
import vhh;
import vhi;

public class TroopAvatarWallPreviewActivity
  extends BaseActivity
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "TroopAvatarWallPreviewActivity";
  public static final String b = "curType";
  static final int c = 1024;
  public static final String c = "url";
  public static final String d = "_id";
  public static final String e = "friendUin";
  public static final String f = "requestTypeKey";
  public static final String g = "faceid";
  public static final String h = "index";
  static boolean h = false;
  public static final String i = "KEY_THUMBNAL_BOUND";
  public static final String j = "default_avator_index";
  public static final String k = "delete_ability";
  public static final String l = "2000";
  public int a;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new vgv(this);
  protected View.OnClickListener a;
  protected View a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  protected FrameLayout a;
  protected ImageButton a;
  protected ImageView a;
  protected RelativeLayout a;
  public TextView a;
  private PublicAccountShowPictureReport jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport = new PublicAccountShowPictureReport();
  public TroopAvatarBigPhotoAdapter a;
  public ImageAnimationView a;
  public CookieManager a;
  public Gallery a;
  protected ArrayList a;
  public List a;
  public boolean a;
  protected boolean[] a;
  public int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new vhc(this);
  public View b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  protected ImageView b;
  public TextView b;
  public ArrayList b;
  protected List b;
  public boolean b;
  protected View c;
  protected ImageView c;
  protected TextView c;
  public ArrayList c;
  public boolean c;
  protected ArrayList d;
  public boolean d;
  public boolean e;
  protected boolean f;
  protected boolean g;
  public boolean i = false;
  private boolean j = true;
  public String m;
  public String n;
  public String o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopAvatarWallPreviewActivity()
  {
    this.jdField_a_of_type_Long = 300L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vgw(this);
  }
  
  private Bitmap a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, Drawable paramDrawable, boolean paramBoolean)
  {
    Rect localRect;
    if (this.jdField_d_of_type_JavaUtilArrayList != null)
    {
      localRect = (Rect)this.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      localObject = a(paramBoolean);
      if ((localObject == null) || (localRect == null)) {
        return null;
      }
    }
    else
    {
      return null;
    }
    String str = b(paramBoolean);
    if (((String)localObject).equals(AvatarWallAdapter.AvatarInfo.a)) {}
    for (Object localObject = paramDrawable; localObject == null; localObject = a(paramBoolean, (String)localObject)) {
      return null;
    }
    if ((paramDrawable == null) && ((!paramBoolean) || (localObject == null))) {
      return null;
    }
    int i5;
    int i6;
    int i1;
    label186:
    int i2;
    label197:
    int i4;
    label261:
    int i3;
    if (paramDrawable == null)
    {
      if ((TextUtils.isEmpty(str)) || (str.equals(AvatarWallAdapter.AvatarInfo.a))) {
        return null;
      }
      paramDrawable = a(paramBoolean, str);
      if (paramDrawable == null) {
        return null;
      }
      ((URLDrawable)paramDrawable).setAutoDownload(true);
      i5 = this.jdField_a_of_type_ComTencentWidgetGallery.getWidth();
      i6 = this.jdField_a_of_type_ComTencentWidgetGallery.getHeight();
      if (((Drawable)localObject).getIntrinsicWidth() != 0) {
        break label430;
      }
      i1 = 1;
      if (((Drawable)localObject).getIntrinsicHeight() != 0) {
        break label440;
      }
      i2 = 1;
      localObject = com.tencent.common.galleryactivity.AnimationUtils.a(this.jdField_a_of_type_ComTencentWidgetGallery);
      if (localObject != null) {
        localRect.offset(((Rect)localObject).left, -((Rect)localObject).top);
      }
      paramRect3.set(localRect);
      if ((!paramBoolean) || (((URLDrawable)paramDrawable).getStatus() != 1)) {
        break label470;
      }
      if (paramDrawable.getIntrinsicWidth() != 0) {
        break label450;
      }
      i4 = 1;
      if (paramDrawable.getIntrinsicHeight() != 0) {
        break label460;
      }
      i3 = 1;
    }
    for (;;)
    {
      float f1 = ImagePreviewAnimationUtil.a(i4, i3);
      paramRect1.set(ImagePreviewAnimationUtil.a(i1, i2, i4, i3));
      paramRect2.set(ImagePreviewAnimationUtil.b(i4, i3, i5, i6));
      paramRect4.set(ImagePreviewAnimationUtil.c(i4, i3, i5, i6));
      ImagePreviewAnimationUtil.a(paramRect1, f1);
      ImagePreviewAnimationUtil.a(paramRect2, f1);
      i1 = (int)(i4 * f1);
      i2 = (int)(i3 * f1);
      try
      {
        paramRect3 = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_4444);
        paramRect4 = new Canvas(paramRect3);
        localObject = new Rect(0, 0, i4, i3);
        ImagePreviewAnimationUtil.a((Rect)localObject, f1);
        paramDrawable.setBounds((Rect)localObject);
        paramRect4.clipRect(ImagePreviewAnimationUtil.a(paramRect1, paramRect2));
        paramDrawable.draw(paramRect4);
        return paramRect3;
      }
      catch (Throwable paramRect1)
      {
        if (!QLog.isColorLevel()) {
          break label518;
        }
        QLog.e("ImagePreveiew", 2, "makeAnimationRect " + paramRect1.getMessage());
      }
      break;
      label430:
      i1 = ((Drawable)localObject).getIntrinsicWidth();
      break label186;
      label440:
      i2 = ((Drawable)localObject).getIntrinsicHeight();
      break label197;
      label450:
      i4 = paramDrawable.getIntrinsicWidth();
      break label261;
      label460:
      i3 = paramDrawable.getIntrinsicHeight();
      continue;
      label470:
      i3 = i2;
      i4 = i1;
    }
    label518:
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (getIntent().getBooleanExtra("from_photo_wall", false))
    {
      if (getIntent().getBooleanExtra("delete_ability", false)) {
        ReportController.b(this.app, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_AndroidViewView.getHeight());
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new vgy(this));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidViewView.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new vha(this));
  }
  
  private boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.a();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((ImageView)((View)localObject1).findViewById(2131296303)).getDrawable();
    if ((localObject2 != null) && ((localObject2 instanceof URLDrawable)))
    {
      if (((URLDrawable)localObject2).getStatus() != 1) {
        return false;
      }
    }
    else if (localObject2 == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setVisibility(0);
    localObject1 = new Rect();
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    localObject2 = a(localRect2, localRect3, (Rect)localObject1, localRect1, (Drawable)localObject2, localObject2 instanceof URLDrawable);
    if (localObject2 == null) {
      return false;
    }
    this.i = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a((Bitmap)localObject2, localRect3, localRect2, localRect1, (Rect)localObject1, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setAnimationListener(new vgr(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new vgs(this), this.jdField_a_of_type_Long);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: iconst_2
    //   1: iconst_0
    //   2: ldc_w 450
    //   5: ldc_w 452
    //   8: invokestatic 458	com/tencent/qbar/QbarNative:Init	(IILjava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: iconst_2
    //   13: newarray <illegal type>
    //   15: astore_2
    //   16: aload_2
    //   17: iconst_0
    //   18: iconst_2
    //   19: iastore
    //   20: aload_2
    //   21: iconst_1
    //   22: iconst_0
    //   23: iastore
    //   24: aload_2
    //   25: aload_2
    //   26: arraylength
    //   27: invokestatic 462	com/tencent/qbar/QbarNative:SetReaders	([II)I
    //   30: pop
    //   31: new 258	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 464
    //   41: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 469	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 475	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   57: astore_1
    //   58: iconst_m1
    //   59: istore 6
    //   61: aload_0
    //   62: invokevirtual 479	com/tencent/mobileqq/troop/activity/TroopAvatarWallPreviewActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   65: astore 4
    //   67: new 481	android/graphics/BitmapFactory$Options
    //   70: dup
    //   71: invokespecial 482	android/graphics/BitmapFactory$Options:<init>	()V
    //   74: astore_3
    //   75: aload_3
    //   76: iconst_1
    //   77: putfield 485	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 491	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   86: astore_2
    //   87: aload_2
    //   88: aconst_null
    //   89: aload_3
    //   90: invokestatic 497	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: pop
    //   94: aload_2
    //   95: invokevirtual 502	java/io/InputStream:close	()V
    //   98: aload_3
    //   99: getfield 505	android/graphics/BitmapFactory$Options:outWidth	I
    //   102: istore 5
    //   104: aload_3
    //   105: getfield 508	android/graphics/BitmapFactory$Options:outHeight	I
    //   108: istore 7
    //   110: aload_3
    //   111: iconst_0
    //   112: putfield 485	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   115: iload 5
    //   117: iload 7
    //   119: imul
    //   120: ldc_w 509
    //   123: if_icmple +155 -> 278
    //   126: aload_3
    //   127: iload 5
    //   129: iload 7
    //   131: imul
    //   132: i2d
    //   133: invokestatic 515	java/lang/Math:sqrt	(D)D
    //   136: ldc2_w 516
    //   139: ddiv
    //   140: invokestatic 520	java/lang/Math:ceil	(D)D
    //   143: d2i
    //   144: putfield 523	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   147: aload 4
    //   149: aload_1
    //   150: invokevirtual 491	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   153: astore_1
    //   154: aload_1
    //   155: aconst_null
    //   156: aload_3
    //   157: invokestatic 497	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: astore_3
    //   161: aload_1
    //   162: invokevirtual 502	java/io/InputStream:close	()V
    //   165: aload_3
    //   166: invokevirtual 524	android/graphics/Bitmap:getWidth	()I
    //   169: istore 5
    //   171: aload_3
    //   172: invokevirtual 525	android/graphics/Bitmap:getHeight	()I
    //   175: istore 7
    //   177: iload 5
    //   179: iload 7
    //   181: imul
    //   182: newarray <illegal type>
    //   184: astore_2
    //   185: aload_3
    //   186: aload_2
    //   187: iconst_0
    //   188: iload 5
    //   190: iconst_0
    //   191: iconst_0
    //   192: iload 5
    //   194: iload 7
    //   196: invokevirtual 529	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   199: aload_3
    //   200: invokevirtual 532	android/graphics/Bitmap:recycle	()V
    //   203: iload 5
    //   205: iload 7
    //   207: imul
    //   208: newarray <illegal type>
    //   210: astore_3
    //   211: aload_2
    //   212: aload_3
    //   213: iload 5
    //   215: iload 7
    //   217: invokestatic 537	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   220: pop
    //   221: aload_3
    //   222: iload 5
    //   224: iload 7
    //   226: iconst_0
    //   227: invokestatic 541	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   230: istore 5
    //   232: invokestatic 544	com/tencent/qbar/QbarNative:Release	()I
    //   235: pop
    //   236: iload 5
    //   238: iconst_1
    //   239: if_icmpne +144 -> 383
    //   242: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +12 -> 257
    //   248: ldc 9
    //   250: iconst_2
    //   251: ldc_w 546
    //   254: invokestatic 548	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: iconst_1
    //   258: ireturn
    //   259: astore_1
    //   260: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +13 -> 276
    //   266: ldc 9
    //   268: iconst_2
    //   269: aload_1
    //   270: invokevirtual 549	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   273: invokestatic 552	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: iconst_0
    //   277: ireturn
    //   278: aload_3
    //   279: iconst_1
    //   280: putfield 523	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   283: goto -136 -> 147
    //   286: astore_1
    //   287: iload 6
    //   289: istore 5
    //   291: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq -62 -> 232
    //   297: ldc 9
    //   299: iconst_2
    //   300: aload_1
    //   301: invokevirtual 553	java/io/IOException:toString	()Ljava/lang/String;
    //   304: invokestatic 552	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: iload 6
    //   309: istore 5
    //   311: goto -79 -> 232
    //   314: astore_1
    //   315: aload_2
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 502	java/io/InputStream:close	()V
    //   321: iconst_m1
    //   322: istore 5
    //   324: goto -92 -> 232
    //   327: astore_1
    //   328: iload 6
    //   330: istore 5
    //   332: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -103 -> 232
    //   338: ldc 9
    //   340: iconst_2
    //   341: aload_1
    //   342: invokevirtual 554	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   345: invokestatic 552	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: iload 6
    //   350: istore 5
    //   352: goto -120 -> 232
    //   355: astore_1
    //   356: iload 6
    //   358: istore 5
    //   360: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq -131 -> 232
    //   366: ldc 9
    //   368: iconst_2
    //   369: aload_1
    //   370: invokevirtual 549	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   373: invokestatic 552	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: iload 6
    //   378: istore 5
    //   380: goto -148 -> 232
    //   383: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +12 -> 398
    //   389: ldc 9
    //   391: iconst_2
    //   392: ldc_w 556
    //   395: invokestatic 548	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: iconst_0
    //   399: ireturn
    //   400: astore_2
    //   401: goto -84 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	TroopAvatarWallPreviewActivity
    //   0	404	1	paramFile	File
    //   15	301	2	localObject1	Object
    //   400	1	2	localOutOfMemoryError	OutOfMemoryError
    //   74	205	3	localObject2	Object
    //   65	83	4	localContentResolver	android.content.ContentResolver
    //   102	277	5	i1	int
    //   59	318	6	i2	int
    //   108	117	7	i3	int
    // Exception table:
    //   from	to	target	type
    //   0	16	259	java/lang/UnsatisfiedLinkError
    //   24	31	259	java/lang/UnsatisfiedLinkError
    //   61	115	286	java/io/IOException
    //   126	147	286	java/io/IOException
    //   147	154	286	java/io/IOException
    //   154	232	286	java/io/IOException
    //   278	283	286	java/io/IOException
    //   317	321	286	java/io/IOException
    //   147	154	314	java/lang/OutOfMemoryError
    //   61	115	327	java/lang/RuntimeException
    //   126	147	327	java/lang/RuntimeException
    //   147	154	327	java/lang/RuntimeException
    //   154	232	327	java/lang/RuntimeException
    //   278	283	327	java/lang/RuntimeException
    //   317	321	327	java/lang/RuntimeException
    //   61	115	355	java/lang/UnsatisfiedLinkError
    //   126	147	355	java/lang/UnsatisfiedLinkError
    //   147	154	355	java/lang/UnsatisfiedLinkError
    //   154	232	355	java/lang/UnsatisfiedLinkError
    //   278	283	355	java/lang/UnsatisfiedLinkError
    //   317	321	355	java/lang/UnsatisfiedLinkError
    //   154	232	400	java/lang/OutOfMemoryError
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new vhi(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
    {
      ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130842487);
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null) {
        a(true);
      }
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
      this.j = false;
      return;
    }
    ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130842488);
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null) {
      a(false);
    }
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.j = true;
  }
  
  private void d()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    localIntent.putExtra("callback", "{op:3,index:" + this.jdField_a_of_type_Int + "}");
    sendBroadcast(localIntent);
  }
  
  private void d(int paramInt)
  {
    TextView localTextView;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(3);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130843570);
        i1 = getResources().getDimensionPixelOffset(2131492902);
        this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, 0, i1, 0);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131298354);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      }
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(QzoneContactsFeedUtils.a((String)localObject, this.app));
        localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label177;
        }
      }
    }
    label177:
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      if ((this.jdField_a_of_type_ArrayOfBoolean != null) && (this.jdField_a_of_type_ArrayOfBoolean.length > paramInt)) {
        break;
      }
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (this.jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {}
    for (paramInt = 2130842494;; paramInt = 2130842497)
    {
      ((ImageView)localObject).setImageResource(paramInt);
      this.j = LocalMultiProcConfig.a("BasePictureViewController#mIsBottomBarUp", true);
      if (!this.j) {
        break;
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130842488);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130842487);
  }
  
  private void e()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    localIntent.putExtra("callback", "{op:1,index:" + this.jdField_a_of_type_Int + "}");
    sendBroadcast(localIntent);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ArrayOfBoolean == null) || (this.jdField_a_of_type_ArrayOfBoolean.length <= this.jdField_a_of_type_Int)) {
      return;
    }
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842494);
      localObject = android.view.animation.AnimationUtils.loadAnimation(this, 2130968788);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      localObject = this.jdField_a_of_type_ArrayOfBoolean;
      i1 = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] != 0) {
        break label153;
      }
    }
    label153:
    for (int i2 = 1;; i2 = 0)
    {
      localObject[i1] = i2;
      localObject = new Intent("android.intent.action.WEBJSCALL");
      ((Intent)localObject).putExtra("callback", "{op:2,index:" + this.jdField_a_of_type_Int + "}");
      sendBroadcast((Intent)localObject);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842497);
      break;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      QQToast.a(this, getString(2131369761), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.a();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131369761), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131296303)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131369761), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131369761), 0).a();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (this.e)
    {
      localActionSheet.a(2131370093, 1);
      localActionSheet.a(2131370099, 1);
      if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
        ThreadManager.a(new vhd(this, (URLDrawable)localObject, localActionSheet), 8, null, false);
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (a(this.jdField_a_of_type_Int))) {
      localActionSheet.a(2131370107, 1);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localActionSheet.a(2131364683, 5);
      localActionSheet.a(2131370107, 3);
    }
    localActionSheet.d(2131367262);
    localActionSheet.a(new vhf(this, localActionSheet, (URLDrawable)localObject));
    localActionSheet.show();
  }
  
  Drawable a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      paramString = URLDrawable.getDrawable(NearbyImgDownloader.a(paramString));
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    BitmapFactory.Options localOptions = ImageUtil.a(paramString, 100);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return new BitmapDrawable(paramString);
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "getDrawable out off memory");
      }
      System.gc();
      return null;
    }
    return null;
  }
  
  public String a(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "picIndex" + this.jdField_a_of_type_Int + "," + "mSeqNumList.size()" + this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return (String)localObject;
      str = (String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals(AvatarWallAdapter.AvatarInfo.a))) {
      return AvatarWallAdapter.AvatarInfo.a;
    }
    return AvatarTroopUtil.a(AvatarTroopUtil.a(str, this.m, 1));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.leave_mode = 1;
    if ((!this.i) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      if ((this.jdField_d_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentWidgetGallery.a() != this.jdField_a_of_type_Int)) {
        break label61;
      }
      if (!a()) {
        b();
      }
    }
    return;
    label61:
    b();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(0).equals(AvatarWallAdapter.AvatarInfo.a)))
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() > 1)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_b_of_type_JavaUtilList.add("" + paramInt);
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        getIntent().putStringArrayListExtra("del_list", (ArrayList)this.jdField_b_of_type_JavaUtilList);
        setResult(-1, getIntent());
      }
      finish();
      return;
    }
    QQToast.a(this, getString(2131364669), 1).b(getTitleBarHeight());
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (this.n != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.n, "", "", "");
    }
    if (this.g) {
      ReportController.b(this.app, "dc00899", "Grp_talk", "", "obj", "aio_save", 0, 0, this.m + "", "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(AppConstants.bo).mkdirs();
    String str = AppConstants.bo + this.m + Utils.Crc64String(paramURLDrawable.getURL().toString());
    File localFile = new File(str);
    if (!localFile.exists()) {}
    for (;;)
    {
      try
      {
        if (localFile.createNewFile()) {
          b(paramURLDrawable, localFile.getPath());
        }
        a("0X8006A82", "0X8006A96");
        return;
      }
      catch (IOException paramURLDrawable)
      {
        QQToast.a(this, getString(2131368778), 0).a();
        continue;
      }
      DialogUtil.a(this, 230).setTitle(getString(2131368781)).setMessage(getString(2131368783)).setPositiveButton(getString(2131368782), new vhh(this, paramURLDrawable, str)).setNegativeButton(getString(2131367259), new vhg(this)).show();
    }
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.n != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.n, "", "", "");
    }
    if (this.g) {
      ReportController.b(this.app, "dc00899", "Grp_talk", "", "obj", "aio_repost", 0, 0, this.m + "", "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    Object localObject = new File(AppConstants.cb);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    String str = AppConstants.cb + this.m + Utils.Crc64String(paramURLDrawable.getURL().toString());
    localObject = str;
    if (!new File(str).exists()) {}
    try
    {
      localObject = paramURLDrawable.saveTo(str);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", paramString);
      localBundle.putString("forward_filepath", (String)localObject);
      localBundle.putString("forward_urldrawable_big_url", paramURLDrawable.getURL().toString());
      localBundle.putString("forward_extra", (String)localObject);
      paramURLDrawable = new Intent();
      paramURLDrawable.putExtras(localBundle);
      ForwardBaseOption.a(this, paramURLDrawable, 21);
      a("0X8006A81", "0X8006A95");
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", localIOException);
          localObject = str;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    startActivity(localIntent);
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_b_of_type_JavaUtilArrayList.size() - 1) || (paramInt > this.jdField_c_of_type_JavaUtilArrayList.size() - 1)) {
      return false;
    }
    return !TextUtils.isEmpty((String)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public String b(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "picIndex" + this.jdField_a_of_type_Int + "," + "mSeqNumList.size()" + this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return (String)localObject;
      str = (String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals(AvatarWallAdapter.AvatarInfo.a))) {
      return AvatarWallAdapter.AvatarInfo.a;
    }
    return AvatarTroopUtil.b(AvatarTroopUtil.a(str, this.m, 1));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.i = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new vgt(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(new vgu(this), 500L);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {}
    while ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_b_of_type_JavaUtilArrayList.size() - 1) || (paramInt > this.jdField_c_of_type_JavaUtilArrayList.size() - 1)) {
      return;
    }
    DialogUtil.a(this, 230).setTitle(getString(2131371316)).setPositiveButton(getString(2131367263), new vgq(this, paramInt)).setNegativeButton(getString(2131367262), new vgp(this)).show();
    a("0X8006A83", "");
  }
  
  public void c(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {
      return;
    }
    getIntent().putExtra("default_avator_index", paramInt);
    setResult(-1, getIntent());
    finish();
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_Boolean) {
      LocalMultiProcConfig.b("BasePictureViewController#mIsBottomBarUp", this.j);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.showEnd();
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.report(this.app);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void onBackPressed()
  {
    a();
  }
  
  protected void onCreate(Bundle arg1)
  {
    this.mActNeedImmersive = false;
    super.onCreate(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (h)
      {
        super.finish();
        return;
      }
      h = true;
      if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
      {
        finish();
        return;
      }
    }
    setContentView(2130903378);
    ??? = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.parse(???.getString("PublicAccountShowPictureReport"));
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport) {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.showStart();
    }
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131298351));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296792));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296895));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296820);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298350));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131296815));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView = ((ImageAnimationView)findViewById(2131298352));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298353));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298354);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298355));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298356));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298357));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131298358);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843570);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    ((ImageView)findViewById(2131298353)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_d_of_type_Boolean = ???.getBoolean("IS_EDIT");
    int i1;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!???.getBoolean("SHOW_MENU")) {
        break label792;
      }
      i1 = 0;
      label444:
      ((ImageView)localObject2).setVisibility(i1);
      this.jdField_d_of_type_JavaUtilArrayList = ???.getParcelableArrayList("KEY_THUMBNAL_BOUND");
      this.e = ???.getBoolean("is_show_action", true);
      this.jdField_b_of_type_Boolean = ???.getBoolean("needBottomBar");
      localObject2 = this.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_b_of_type_Boolean) {
        break label797;
      }
      i1 = 0;
      label496:
      ((View)localObject2).setVisibility(i1);
      localObject2 = this.jdField_c_of_type_AndroidViewView;
      if (!this.jdField_b_of_type_Boolean) {
        break label803;
      }
      i1 = 0;
      label515:
      ((View)localObject2).setVisibility(i1);
      if (this.jdField_b_of_type_Boolean)
      {
        localObject2 = new IntentFilter("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      }
      this.jdField_a_of_type_ArrayOfBoolean = ???.getBooleanArray("likes");
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter = new TroopAvatarBigPhotoAdapter(this, this.app);
      this.m = ???.getString("troop_uin");
      this.jdField_c_of_type_Boolean = ???.getBoolean("troop_info_is_member");
      this.jdField_a_of_type_JavaUtilList = ???.getStringArrayList("seqNum");
      this.jdField_a_of_type_JavaUtilArrayList = ???.getStringArrayList("descs");
      this.jdField_b_of_type_JavaUtilArrayList = ???.getStringArrayList("photoIds");
      this.jdField_c_of_type_JavaUtilArrayList = ???.getStringArrayList("photoTimes");
      this.jdField_a_of_type_Boolean = ???.getBoolean("delete_ability");
      this.g = ???.getBoolean("is_from_troop_topic");
      this.f = ???.getBoolean("is_not_show_index", true);
      this.n = ???.getString("src_id");
      if (this.n != null) {
        ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer", "open", 0, 0, this.n, "", "", "");
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      }
      if (!this.f) {
        break label809;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      ThreadManager.a(new vgk(this, ???), 8, null, true);
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      break;
      label792:
      i1 = 4;
      break label444;
      label797:
      i1 = 8;
      break label496;
      label803:
      i1 = 8;
      break label515;
      label809:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      h = false;
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      g();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopAvatarWallPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */