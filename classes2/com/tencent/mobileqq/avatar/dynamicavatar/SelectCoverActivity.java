package com.tencent.mobileqq.avatar.dynamicavatar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar.OnProgressChangedListener;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler.OnGetFrameListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import qtd;
import qte;
import qtf;
import qtg;
import qtj;
import qtk;

public class SelectCoverActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, DrawableSeekbar.OnProgressChangedListener, VideoDrawableHandler.OnGetFrameListener
{
  public static final int d = 0;
  public static final int e = 1;
  private static final String e = SelectCoverActivity.class.getSimpleName();
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  float jdField_a_of_type_Float = 0.0F;
  public int a;
  public Animator a;
  Rect jdField_a_of_type_AndroidGraphicsRect = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.a(), this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public DynamicAvatarManager a;
  DrawableSeekbar jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar;
  VideoDrawable jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable;
  VideoDrawableHandler jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new qtg(this);
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  public String a;
  public boolean a;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = null;
  public Handler b;
  View jdField_b_of_type_AndroidViewView;
  VideoDrawable jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable;
  public String b;
  public volatile boolean b;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  VideoDrawable jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable;
  public String c;
  View d;
  public String d;
  public int m;
  public int n;
  public int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SelectCoverActivity()
  {
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidAnimationAnimator = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private int a()
  {
    int i1 = 1;
    if (this.m == 1) {
      i1 = 0;
    }
    return i1;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(7, paramInt1, paramInt2, paramString).sendToTarget();
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable = new VideoDrawable(paramBitmap, getResources());
    this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable = new VideoDrawable(paramBitmap, getResources());
    this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable = new VideoDrawable(paramBitmap, getResources());
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
    this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable.a(true);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setOnProgressChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumb(a(this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setMax((int)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a());
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumbSize(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  private void c(View paramView1, View paramView2)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    Point localPoint = new Point();
    paramView1.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_c_of_type_AndroidViewView.getGlobalVisibleRect(this.jdField_b_of_type_AndroidGraphicsRect, localPoint);
    paramView2.getGlobalVisibleRect(this.jdField_b_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsRect.offset(-localPoint.x, -localPoint.y);
    this.jdField_b_of_type_AndroidGraphicsRect.offset(-localPoint.x, -localPoint.y);
    if (this.jdField_b_of_type_AndroidGraphicsRect.width() / this.jdField_b_of_type_AndroidGraphicsRect.height() > this.jdField_a_of_type_AndroidGraphicsRect.width() / this.jdField_a_of_type_AndroidGraphicsRect.height())
    {
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.height() / this.jdField_b_of_type_AndroidGraphicsRect.height());
      f1 = (this.jdField_a_of_type_Float * this.jdField_b_of_type_AndroidGraphicsRect.width() - this.jdField_a_of_type_AndroidGraphicsRect.width()) / 2.0F;
      paramView1 = this.jdField_a_of_type_AndroidGraphicsRect;
      paramView1.left = ((int)(paramView1.left - f1));
      paramView1 = this.jdField_a_of_type_AndroidGraphicsRect;
      paramView1.right = ((int)(f1 + paramView1.right));
      return;
    }
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.width() / this.jdField_b_of_type_AndroidGraphicsRect.width());
    float f1 = (this.jdField_a_of_type_Float * this.jdField_b_of_type_AndroidGraphicsRect.height() - this.jdField_a_of_type_AndroidGraphicsRect.height()) / 2.0F;
    paramView1 = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView1.top = ((int)(paramView1.top - f1));
    paramView1 = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView1.bottom = ((int)(f1 + paramView1.bottom));
  }
  
  private void d()
  {
    int i1 = 0;
    ImmersiveUtils.a(this);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)findViewById(2131300974));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297019);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131297886);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131302296);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar = ((DrawableSeekbar)findViewById(2131298795));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302298));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131302295);
    findViewById(2131302293).setOnClickListener(this);
    findViewById(2131302294).setOnClickListener(this);
    int i4 = ImmersiveUtils.a();
    int i2 = ImmersiveUtils.b();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = i4;
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int i3 = (int)(0.125F * i4);
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i3;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = i3;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (Build.VERSION.SDK_INT <= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setVisibility(8);
      findViewById(2131302297).setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin += i3;
      ((RelativeLayout.LayoutParams)localObject).topMargin = (i1 + ((RelativeLayout.LayoutParams)localObject).topMargin);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      this.jdField_b_of_type_Int = ((int)getResources().getDimension(2131493693));
      this.jdField_c_of_type_Int = ((int)getResources().getDimension(2131493692));
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      i2 = (int)(0.15D * i2);
      ((RelativeLayout.LayoutParams)localObject).height = i2;
      this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i1 = (int)getResources().getDimension(2131493695);
      this.jdField_a_of_type_Int = ((i4 - i1 * 2) / this.jdField_b_of_type_Int);
      if ((i4 - i1 * 2) % this.jdField_b_of_type_Int != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      localObject = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Integer.MIN_VALUE);
      }
      i1 = 0;
      while (i1 < this.jdField_a_of_type_Int)
      {
        CustomImgView localCustomImgView = new CustomImgView(this);
        localCustomImgView.a.setScaleType(ImageView.ScaleType.FIT_XY);
        localCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject);
        i1 += 1;
      }
      i1 = i2;
    }
  }
  
  private void e()
  {
    String str = DynamicUtils.a(this.jdField_a_of_type_JavaLangString, 200);
    DynamicUtils.a(this.jdField_a_of_type_JavaLangString, str, 200, this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_a_of_type_JavaLangString = str;
    str = DynamicUtils.a(this.jdField_a_of_type_JavaLangString, 100);
    DynamicUtils.a(this.jdField_a_of_type_JavaLangString, str, 100, this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b = str;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a())) {
      h();
    }
  }
  
  private void f()
  {
    if (VersionUtils.d())
    {
      a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentWidgetCustomImgView);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void g()
  {
    if (VersionUtils.d())
    {
      b(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentWidgetCustomImgView);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.n = ((int)(System.currentTimeMillis() / 1000L));
    DynamicUtils.a(this.app, this.jdField_a_of_type_JavaLangString, 36, this.n, 640);
  }
  
  Drawable a(Drawable paramDrawable)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { paramDrawable, (GradientDrawable)getResources().getDrawable(2130841106) });
    int i1 = (int)(1.0F * ImmersiveUtils.a());
    paramDrawable.setLayerInset(0, i1, i1, i1, i1);
    return paramDrawable;
  }
  
  /* Error */
  public String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 451	java/io/File
    //   6: dup
    //   7: getstatic 456	com/tencent/mobileqq/app/AppConstants:cq	Ljava/lang/String;
    //   10: invokespecial 459	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 462	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: new 451	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: new 464	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 465	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 467
    //   34: invokevirtual 471	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   40: invokevirtual 474	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: invokevirtual 477	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 480	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore 5
    //   51: aload 5
    //   53: invokevirtual 483	java/io/File:exists	()Z
    //   56: ifeq +9 -> 65
    //   59: aload 5
    //   61: invokevirtual 486	java/io/File:delete	()Z
    //   64: pop
    //   65: new 488	java/io/FileOutputStream
    //   68: dup
    //   69: aload 5
    //   71: invokespecial 491	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_3
    //   75: aload_3
    //   76: astore_2
    //   77: aload_1
    //   78: getstatic 497	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload_3
    //   84: invokevirtual 503	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   87: pop
    //   88: aload_3
    //   89: astore_2
    //   90: aload_3
    //   91: invokevirtual 506	java/io/FileOutputStream:flush	()V
    //   94: aload_3
    //   95: astore_2
    //   96: aload 5
    //   98: invokevirtual 509	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   101: astore_1
    //   102: aload_1
    //   103: astore_2
    //   104: aload_2
    //   105: astore_1
    //   106: aload_3
    //   107: ifnull +9 -> 116
    //   110: aload_3
    //   111: invokevirtual 512	java/io/FileOutputStream:close	()V
    //   114: aload_2
    //   115: astore_1
    //   116: invokestatic 517	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +30 -> 149
    //   122: getstatic 70	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:e	Ljava/lang/String;
    //   125: iconst_2
    //   126: new 464	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 465	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 519
    //   136: invokevirtual 471	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: invokevirtual 471	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 477	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 522	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_1
    //   150: areturn
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   156: aload_2
    //   157: astore_1
    //   158: goto -42 -> 116
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_3
    //   164: aload_3
    //   165: astore_2
    //   166: aload_1
    //   167: invokevirtual 526	java/io/FileNotFoundException:printStackTrace	()V
    //   170: aload 4
    //   172: astore_1
    //   173: aload_3
    //   174: ifnull -58 -> 116
    //   177: aload_3
    //   178: invokevirtual 512	java/io/FileOutputStream:close	()V
    //   181: aload 4
    //   183: astore_1
    //   184: goto -68 -> 116
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   192: aload 4
    //   194: astore_1
    //   195: goto -79 -> 116
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_3
    //   201: aload_3
    //   202: astore_2
    //   203: aload_1
    //   204: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   207: aload 4
    //   209: astore_1
    //   210: aload_3
    //   211: ifnull -95 -> 116
    //   214: aload_3
    //   215: invokevirtual 512	java/io/FileOutputStream:close	()V
    //   218: aload 4
    //   220: astore_1
    //   221: goto -105 -> 116
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   229: aload 4
    //   231: astore_1
    //   232: goto -116 -> 116
    //   235: astore_1
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 512	java/io/FileOutputStream:close	()V
    //   246: aload_1
    //   247: athrow
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 525	java/io/IOException:printStackTrace	()V
    //   253: goto -7 -> 246
    //   256: astore_1
    //   257: goto -19 -> 238
    //   260: astore_1
    //   261: goto -60 -> 201
    //   264: astore_1
    //   265: goto -101 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	SelectCoverActivity
    //   0	268	1	paramBitmap	Bitmap
    //   13	230	2	localObject1	Object
    //   248	2	2	localIOException	java.io.IOException
    //   74	141	3	localFileOutputStream	java.io.FileOutputStream
    //   1	229	4	localObject2	Object
    //   49	48	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   110	114	151	java/io/IOException
    //   65	75	161	java/io/FileNotFoundException
    //   177	181	187	java/io/IOException
    //   65	75	198	java/io/IOException
    //   214	218	224	java/io/IOException
    //   65	75	235	finally
    //   242	246	248	java/io/IOException
    //   77	88	256	finally
    //   90	94	256	finally
    //   96	102	256	finally
    //   166	170	256	finally
    //   203	207	256	finally
    //   77	88	260	java/io/IOException
    //   90	94	260	java/io/IOException
    //   96	102	260	java/io/IOException
    //   77	88	264	java/io/FileNotFoundException
    //   90	94	264	java/io/FileNotFoundException
    //   96	102	264	java/io/FileNotFoundException
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(e, 2, "onSeekStart");
    }
    DynamicUtils.a(this.app, "0X800710B", a());
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
    }
    f();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(5)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(5);
    }
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, paramInt1, paramInt2);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 300L);
  }
  
  public void a(View paramView1, View paramView2)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_Float <= 0.0F)) {
      c(paramView1, paramView2);
    }
    paramView2.setVisibility(0);
    paramView1.setAlpha(0.0F);
    paramView2.setPivotX(0.0F);
    paramView2.setPivotY(0.0F);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramView1 = new AnimatorSet();
    paramView1.play(ObjectAnimator.ofFloat(paramView2, View.X, new float[] { this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.left })).with(ObjectAnimator.ofFloat(paramView2, View.Y, new float[] { this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.top })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_X, new float[] { this.jdField_a_of_type_Float, 1.0F })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_Y, new float[] { this.jdField_a_of_type_Float, 1.0F }));
    paramView1.setDuration(250L);
    paramView1.setInterpolator(new DecelerateInterpolator());
    paramView1.addListener(new qtj(this));
    paramView1.start();
    this.jdField_a_of_type_AndroidAnimationAnimator = paramView1;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler = new VideoDrawableHandler(this.app, this);
    if (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(e, 2, "doOnCreate return file error");
      }
      finish();
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_Int - 1) {
      return true;
    }
    int i1 = (int)(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a() / (this.jdField_a_of_type_Int - 1));
    if (paramInt == this.jdField_a_of_type_Int - 1) {
      i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a();
    }
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(i1);
        if (localObject1 == null) {
          continue;
        }
        localBitmap = DynamicUtils.a((Bitmap)localObject1, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        if ((localObject1 == null) || (localObject1 == localBitmap) || (((Bitmap)localObject1).isRecycled())) {
          continue;
        }
        ((Bitmap)localObject1).recycle();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject1;
        Bitmap localBitmap;
        if (!QLog.isColorLevel()) {
          break label271;
        }
        QLog.i(e, 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label271;
        }
        localException.printStackTrace();
        break label271;
        continue;
      }
      if (paramInt == 0) {
        this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1, localBitmap).sendToTarget();
      }
      localObject1 = null;
      try
      {
        localObject2 = AnimationUtils.loadAnimation(this, 2130968745);
        localObject1 = localObject2;
        ((Animation)localObject2).setInterpolator(new DecelerateInterpolator(2.0F));
        localObject1 = localObject2;
        ((Animation)localObject2).setFillAfter(false);
        localObject1 = localObject2;
        ((Animation)localObject2).setDuration(50L);
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(e, 2, localThrowable.getMessage(), localThrowable);
        localObject2 = localObject1;
        continue;
      }
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(0, paramInt, i1, new Object[] { localBitmap, localObject2 }).sendToTarget();
      break label271;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a();
      continue;
      label271:
      return false;
      i1 *= paramInt;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(e, 2, "onSeekEnd");
    }
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 400L);
  }
  
  public void b(View paramView1, View paramView2)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_Float <= 0.0F)) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(paramView2, View.X, new float[] { this.jdField_a_of_type_AndroidGraphicsRect.left })).with(ObjectAnimator.ofFloat(paramView2, View.Y, new float[] { this.jdField_a_of_type_AndroidGraphicsRect.top })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_X, new float[] { this.jdField_a_of_type_Float })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_Y, new float[] { this.jdField_a_of_type_Float }));
    localAnimatorSet.setDuration(250L);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.addListener(new qtk(this, paramView1, paramView2));
    localAnimatorSet.start();
    this.jdField_a_of_type_AndroidAnimationAnimator = localAnimatorSet;
  }
  
  void c()
  {
    int i1 = ImmersiveUtils.a();
    Bitmap localBitmap = DynamicUtils.a(i1, i1, (int)(0.5D * i1 - 2.0F * ImmersiveUtils.a()));
    if (localBitmap != null) {
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, new BitmapDrawable(localBitmap)).sendToTarget();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.m = getIntent().getIntExtra("param_source", 0);
    if (this.m == 0) {
      throw new IllegalArgumentException("source must not be null");
    }
    this.o = getIntent().getIntExtra("key_video_duration", 0);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("key_video_has_voice");
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("key_camera_id");
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager = ((DynamicAvatarManager)this.app.getManager(179));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.b = null;
    paramBundle = getLayoutInflater().inflate(2130904314, null);
    setContentView(paramBundle);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.a(-1);
      this.mSystemBarComp.b(-1);
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    getWindow().setBackgroundDrawable(null);
    d();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_video_file_path");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(e, 2, "doOnCreate return filepath:" + this.jdField_a_of_type_JavaLangString);
      }
      finish();
      return false;
    }
    if (Build.VERSION.SDK_INT <= 9) {
      ThreadManager.a(new qtd(this), null, true);
    }
    for (;;)
    {
      return true;
      ThreadManager.a(new qte(this), null, true);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.c();
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      int i1;
      int i2;
      do
      {
        do
        {
          Object localObject;
          CustomImgView localCustomImgView;
          do
          {
            return true;
            i1 = paramMessage.arg1;
            i2 = paramMessage.arg2;
            localObject = (Object[])paramMessage.obj;
            paramMessage = (Bitmap)localObject[0];
            localObject = (Animation)localObject[1];
            localCustomImgView = (CustomImgView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
            localCustomImgView.setImageBitmap(paramMessage);
            localCustomImgView.setTag(Integer.valueOf(i2));
            localCustomImgView.setOnTouchListener(this);
          } while (localObject == null);
          localCustomImgView.startAnimation((Animation)localObject);
          return true;
          a((Bitmap)paramMessage.obj);
          a(0);
          return true;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.b();
          a(paramMessage.arg1);
          return true;
          this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable = new VideoDrawable((Bitmap)paramMessage.obj, getResources());
          this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable.a(true);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_c_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawable);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return true;
          i1 = paramMessage.arg1;
        } while (paramMessage.arg2 == 0);
        QQToast.a(this, String.format("获取%.3fms处图片帧失败。", new Object[] { Float.valueOf(i1 / 1000.0F) }), 0).a();
        return true;
        QQToast.a(this, "获取封面失败。", 0).a();
        return true;
        i1 = paramMessage.arg1;
        i2 = paramMessage.arg2;
        paramMessage = (String)paramMessage.obj;
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(i1, paramMessage, i2);
      return true;
    }
    g();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131302293)
    {
      finish();
      DynamicUtils.a(this.app, "0X800710C", a());
    }
    while (paramView.getId() != 2131302294) {
      return;
    }
    DynamicUtils.a(this.app, "0X800710D", a());
    if (!NetworkUtil.h(this))
    {
      QQToast.a(this, 1, getString(2131369008), 0).b(getTitleBarHeight());
      return;
    }
    paramView = this.jdField_a_of_type_AndroidViewView.getBackground();
    if ((paramView != null) && ((paramView instanceof BitmapDrawable))) {
      paramView = ((BitmapDrawable)paramView).getBitmap();
    }
    for (;;)
    {
      if (paramView == null)
      {
        QQToast.a(this, "选取帧失败。", 0).a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(e, 2, "android version:" + Build.VERSION.SDK_INT);
        return;
        if ((paramView == null) || (!(paramView instanceof VideoDrawable))) {
          break label226;
        }
        paramView = ((VideoDrawable)paramView).a();
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      a(0, "正在处理图片", 0);
      ThreadManager.a(new qtf(this, paramView), null, true);
      return;
      label226:
      paramView = null;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!(paramView instanceof CustomImgView)) {}
    do
    {
      return false;
      paramView = (CustomImgView)paramView;
    } while (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.a());
    int i1 = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, i1, 0).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumbOffset(paramView.getLeft());
    DynamicUtils.a(this.app, "0X800710A", a());
    if (QLog.isColorLevel()) {
      QLog.i(e, 2, "onTouchDown");
    }
    f();
    if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 400L);
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\SelectCoverActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */