package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationLister;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.common.galleryactivity.GalleryProgressView;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.CountDownProgressBar;
import com.tencent.widget.CountDownProgressBar.OnCountDownLinstener;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import rfl;
import rfm;
import rfn;
import rfo;
import rfq;
import rfr;

public class HotChatFlashPicActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener, AnimationLister, CountDownProgressBar.OnCountDownLinstener
{
  private static final int jdField_a_of_type_Int = 2;
  private static final long jdField_a_of_type_Long = 518400000L;
  public static final String a = "isreaded";
  public static final String b = "uniseq";
  public static final String c = "md5";
  public static final String d = "is_send";
  private static final int jdField_e_of_type_Int = 0;
  public static final String e = "self_uin";
  private static final int jdField_f_of_type_Int = 1;
  public static final String f = "self_identify";
  private static final int jdField_g_of_type_Int = 2;
  public static final String g = "curtype";
  private static final int jdField_h_of_type_Int = 3;
  public static final String h = "commen_flashpic_shot";
  private static final int jdField_i_of_type_Int = 4;
  public static final String i = "commen_flashpic_shot_deadlineday";
  private static final int jdField_j_of_type_Int = 5;
  private static final String jdField_j_of_type_JavaLangString = "Q.hotchat";
  private static final int jdField_k_of_type_Int = 6;
  private static final int jdField_l_of_type_Int = 7;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimationView jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView;
  private GalleryProgressView jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AIOImageData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
  private IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private IAIOImageProviderCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
  private CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler;
  private CountDownProgressBar jdField_a_of_type_ComTencentWidgetCountDownProgressBar;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private boolean jdField_h_of_type_Boolean;
  private boolean jdField_i_of_type_Boolean;
  private boolean jdField_j_of_type_Boolean;
  private String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean;
  private String jdField_l_of_type_JavaLangString;
  private String m;
  private String n;
  
  public HotChatFlashPicActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = new rfl(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new rfo(this);
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    int i2 = 1;
    int i4 = i2;
    if (paramInt1 != 0)
    {
      i4 = i2;
      if (paramInt2 != 0)
      {
        i4 = i2;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i4 = i2;
        }
      }
    }
    label43:
    int i3;
    label55:
    do
    {
      do
      {
        return i4;
        i2 = paramOptions.outHeight;
        i3 = paramOptions.outWidth;
        i4 = i1;
      } while (i2 <= paramInt2);
      i4 = i1;
    } while (i3 <= paramInt1);
    int i5 = Math.round(i2 / paramInt2);
    i4 = Math.round(i3 / paramInt1);
    if (i5 > i4) {}
    for (;;)
    {
      i4 = i1;
      if (i5 < 2) {
        break;
      }
      i1 <<= 1;
      i3 >>= 1;
      i2 >>= 1;
      break label55;
      i5 = i4;
    }
  }
  
  private long a()
  {
    long l1 = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l1);
    int i1 = localCalendar.get(11);
    int i2 = localCalendar.get(12);
    int i3 = localCalendar.get(13);
    return l1 + (86399000L - i1 * 3600 * 1000 - i2 * 60 * 1000 - i3 * 1000);
  }
  
  private Bitmap a(String paramString)
  {
    int i2 = 320;
    Object localObject = getResources().getDisplayMetrics();
    int i3 = ((DisplayMetrics)localObject).widthPixels;
    int i1 = ((DisplayMetrics)localObject).heightPixels;
    if ((i3 == 0) || (i1 == 0)) {
      i1 = 320;
    }
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = a(localOptions, i2, i1);
        localObject = SafeBitmapFactory.decodeFile(paramString, localOptions);
        i3 = ((Bitmap)localObject).getWidth() / 16;
        if (QLog.isColorLevel()) {
          QLog.d("Q.hotchat", 2, "reqWidth:" + i2 + ",reqHeight:" + i1 + ",inSampleSize:" + localOptions.inSampleSize + ",block:" + i3);
        }
        paramString = URLDrawableDecodeHandler.a((Bitmap)localObject, i3);
        i2 = i3;
      }
      catch (Exception localException1)
      {
        try
        {
          ((Bitmap)localObject).recycle();
          return paramString;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          localObject = paramString;
          continue;
        }
        catch (Exception localException2)
        {
          localObject = paramString;
          continue;
        }
        localException1 = localException1;
        localObject = null;
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.hotchat", 2, "FlashPicActivity getMosaicBitmap Exception：" + localException1.toString());
          return (Bitmap)localObject;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject = null;
        localOutOfMemoryError1.printStackTrace();
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.hotchat", 2, "FlashPicActivity getMosaicBitmap oom：" + localOutOfMemoryError1.toString());
          return (Bitmap)localObject;
        }
      }
    }
  }
  
  private String a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4) != null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2) != null))
    {
      this.g = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(4) != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "checkLocalFileExist,filePath:" + (String)localObject + ",isOrigin:" + false + ",isSendFromLocal:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e);
      }
      return (String)localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_JavaLangString;
      continue;
      String str = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.c);
      localObject = str;
      if (str == null)
      {
        str = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_JavaLangString);
        localObject = str;
        if (str == null)
        {
          localObject = str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
            localObject = "I:E";
          }
        }
      }
    }
  }
  
  private String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("I:N"))) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString + "_fp";
      if (!new File(str).exists()) {
        break;
      }
      paramString = str;
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.hotchat", 4, "flash pic cache file exist");
    return str;
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(localMessage);
  }
  
  private void a(Drawable paramDrawable)
  {
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int i3 = ((DisplayMetrics)localObject).widthPixels;
    int i4 = ((DisplayMetrics)localObject).heightPixels;
    float f1 = Math.min(i3 / i1, i4 / i2);
    localObject = AnimationUtils.a((int)(i1 * f1), (int)(i2 * f1), i3, i4, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(paramDrawable, localRect, (Rect)localObject, GalleryImage.a(localRect, paramDrawable), 350L);
    paramDrawable = new AlphaAnimation(0.0F, 1.0F);
    paramDrawable.setInterpolator(new AccelerateInterpolator());
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2131427673);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramDrawable);
  }
  
  private void a(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = paramString;
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  private String b()
  {
    int i1 = 7;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int < 2)) {
      return "error happen";
    }
    this.jdField_b_of_type_Long = getSharedPreferences(this.jdField_k_of_type_JavaLangString, 4).getLong("commen_flashpic_shot_deadlineday", 0L);
    double d1 = this.jdField_b_of_type_Long - System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder(getString(2131372220));
    if ((d1 < 0.0D) || (d1 >= 8.64E7D))
    {
      if (d1 < 0.0D) {}
      for (;;)
      {
        localStringBuilder.append(i1);
        localStringBuilder.append(getString(2131372221));
        return localStringBuilder.toString();
        i1 = Math.min((int)(d1 / 8.64E7D), 7);
      }
    }
    i1 = (int)(d1 / 3600000.0D);
    if (i1 != 0)
    {
      localStringBuilder.append(i1);
      localStringBuilder.append(getString(2131372222));
    }
    int i2 = (int)((d1 - i1 * 3600000.0D) / 60000.0D);
    if ((i1 == 0) && (i2 == 0))
    {
      localStringBuilder.append(1);
      localStringBuilder.append(getString(2131372223));
    }
    for (;;)
    {
      localStringBuilder.append(getString(2131372224));
      break;
      if (i2 != 0)
      {
        localStringBuilder.append(i2);
        localStringBuilder.append(getString(2131372223));
      }
    }
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      finish();
    }
    while (this.j) {
      return;
    }
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    Object localObject = getResources().getDisplayMetrics();
    int i3 = ((DisplayMetrics)localObject).widthPixels;
    int i4 = ((DisplayMetrics)localObject).heightPixels;
    float f1 = Math.min(i3 / i1, i4 / i2);
    localObject = AnimationUtils.a((int)(i1 * f1), (int)(i2 * f1), i3, i4, false, null);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(paramDrawable, localRect, (Rect)localObject, GalleryImage.a(localRect, paramDrawable), 0, 0, 350L);
    paramDrawable = new AlphaAnimation(1.0F, 0.0F);
    paramDrawable.setDuration(350L);
    paramDrawable.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramDrawable);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(7);
    paramString = a(paramString);
    if (paramString != null)
    {
      Message localMessage = new Message();
      localMessage.what = 5;
      localMessage.obj = paramString;
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(localMessage);
    }
  }
  
  private void c(String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(a(paramString));
    a(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "count down stop");
    }
    if (this.jdField_c_of_type_Boolean) {
      b(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    b(this.n);
  }
  
  public void c() {}
  
  public void d()
  {
    this.j = true;
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "on back pressed");
    }
    b(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_k_of_type_Boolean = true;
    this.mNeedStatusTrans = false;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 13) {
      getWindow().addFlags(8192);
    }
    setContentView(2130904228);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296895));
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)findViewById(2131298352));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131301904));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301905);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301906));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301907));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301908);
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar = ((CountDownProgressBar)findViewById(2131301909));
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(2500L, 3);
    this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setOnCountDownLinstener(this);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView = new GalleryProgressView();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(this, (ImageView)findViewById(2131301910));
    paramBundle = (BinderWarpper)getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = IAIOImageProvider.Stub.a(paramBundle.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData = ((AIOImageData)getIntent().getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("isreaded", false);
    this.jdField_c_of_type_Long = getIntent().getLongExtra("uniseq", 0L);
    this.l = getIntent().getStringExtra("md5");
    this.e = getIntent().getBooleanExtra("is_send", false);
    this.jdField_k_of_type_JavaLangString = getIntent().getStringExtra("self_uin");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("self_identify", true);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("curtype", 0);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBundle = getSharedPreferences(this.jdField_k_of_type_JavaLangString, 4);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = paramBundle.getInt("HOTCHAT_FLASHPIC_SHOT", 0);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Long = paramBundle.getLong("commen_flashpic_shot_deadlineday", 0L);
        if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_b_of_type_Long <= System.currentTimeMillis()))
        {
          this.jdField_b_of_type_Int = 0;
          paramBundle = paramBundle.edit();
          paramBundle.putInt("commen_flashpic_shot", this.jdField_b_of_type_Int);
          paramBundle.putLong("commen_flashpic_shot_deadlineday", 0L);
          paramBundle.commit();
        }
        this.jdField_a_of_type_ComTencentWidgetCountDownProgressBar.setTotalMills(4500L, 5);
      }
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData != null)) {
        break label655;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839453);
      if (!this.jdField_a_of_type_Boolean) {
        break label642;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372205);
      label555:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "mIsReaded:" + this.jdField_b_of_type_Boolean + ",mScreenShotCount:" + this.jdField_b_of_type_Int + ",mIsSend:" + this.e);
      }
      return true;
      this.jdField_b_of_type_Int = paramBundle.getInt("commen_flashpic_shot", 0);
      break;
      label642:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372217);
      break label555;
      label655:
      if ((this.jdField_b_of_type_Int >= 2) && (!this.e))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839453);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372209);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          break;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
        }
      }
      this.m = a();
      if ((this.m != null) && (this.m.equals("I:E")))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(1);
      }
      else if (this.m != null)
      {
        paramBundle = this.m;
        this.n = this.m;
        a(0);
        ThreadManager.a().post(new rfm(this, paramBundle));
      }
      else
      {
        this.f = true;
        a(0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(1) != null)
        {
          this.h = true;
          this.n = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a;
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotchat", 2, "flashpic thumbImageFile exists");
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, 2);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap().recycle();
      System.gc();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.hotchat", 2, "", localException);
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    if ((isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e) && (!this.g) && (this.m != null) && (!this.m.equals("I:E")))
    {
      String str = this.m;
      ThreadManager.a().post(new rfq(this, str));
    }
    super.doOnPause();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if ((this.n != null) && (this.jdField_k_of_type_Boolean))
    {
      if (!this.h) {
        break label39;
      }
      c(this.n);
    }
    for (;;)
    {
      this.jdField_k_of_type_Boolean = false;
      return;
      label39:
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.postDelayed(new rfn(this), 350L);
    }
  }
  
  public void e()
  {
    finish();
    this.j = false;
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public boolean isSupportScreenShot()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "isSupportScreenShot,mIsPicShow:" + this.jdField_c_of_type_Boolean + ",mScreenShotCount:" + this.jdField_b_of_type_Int + ",mHadShot:" + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_Int += 1;
        this.jdField_d_of_type_Boolean = true;
        ThreadManager.a().post(new rfr(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(4);
      }
      return false;
    }
    return super.isSupportScreenShot();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297083) {
      finish();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.hotchat", 2, "action down,mLargeError:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean + ",mIsLoading:" + this.f);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean) && (!this.f))
        {
          this.f = true;
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(0);
          this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a();
          a(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, 2);
          return true;
        }
      } while ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.f) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean));
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessageDelayed(3, 500L);
      return true;
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "on touch: " + paramMotionEvent.getAction());
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_b_of_type_Boolean);
    b(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable());
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\HotChatFlashPicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */