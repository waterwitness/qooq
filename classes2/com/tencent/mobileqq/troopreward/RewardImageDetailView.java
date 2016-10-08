package com.tencent.mobileqq.troopreward;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class RewardImageDetailView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  protected static final int a = 500;
  protected static final String a = ".troop.troop_reward.image";
  protected Handler a;
  protected GestureDetector a;
  protected View a;
  protected ImageView a;
  protected OrientationAdapterImageView a;
  protected TroopRewardInfo a;
  protected boolean a;
  protected View b;
  protected boolean b;
  
  public RewardImageDetailView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(paramContext);
  }
  
  public RewardImageDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static Drawable a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    int i = paramContext.getDefaultDisplay().getWidth();
    int j = paramContext.getDefaultDisplay().getHeight();
    i = (int)(Math.sqrt(j * j + i * i) / 2.0D * 1.1D);
    paramContext = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { Color.parseColor("#de6b84"), Color.parseColor("#3f162b") });
    paramContext.setShape(0);
    paramContext.setAlpha(150);
    paramContext.setGradientCenter(0.5F, 0.5F);
    paramContext.setGradientType(1);
    paramContext.setGradientRadius(i);
    paramContext.setDither(true);
    paramContext.setFilterBitmap(true);
    return paramContext;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return AppConstants.bE + paramString2 + "_" + paramString1 + "_blur_big.png";
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView = new OrientationAdapterImageView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(paramContext));
    addView(this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  /* Error */
  public static void a(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: new 224	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 5
    //   27: aload_3
    //   28: astore_2
    //   29: aload 5
    //   31: invokevirtual 231	java/io/File:getParentFile	()Ljava/io/File;
    //   34: invokevirtual 235	java/io/File:exists	()Z
    //   37: ifne +14 -> 51
    //   40: aload_3
    //   41: astore_2
    //   42: aload 5
    //   44: invokevirtual 231	java/io/File:getParentFile	()Ljava/io/File;
    //   47: invokevirtual 238	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: aload_3
    //   52: astore_2
    //   53: aload 5
    //   55: invokevirtual 235	java/io/File:exists	()Z
    //   58: ifeq +11 -> 69
    //   61: aload_3
    //   62: astore_2
    //   63: aload 5
    //   65: invokevirtual 241	java/io/File:delete	()Z
    //   68: pop
    //   69: aload_3
    //   70: astore_2
    //   71: new 243	java/io/FileOutputStream
    //   74: dup
    //   75: aload 5
    //   77: invokespecial 246	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_3
    //   81: aload_0
    //   82: getstatic 252	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   85: bipush 100
    //   87: aload_3
    //   88: invokevirtual 258	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   91: pop
    //   92: aload_3
    //   93: invokevirtual 261	java/io/FileOutputStream:flush	()V
    //   96: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +29 -> 128
    //   102: ldc 12
    //   104: iconst_2
    //   105: new 128	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 268
    //   115: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_3
    //   129: ifnull -118 -> 11
    //   132: aload_3
    //   133: invokevirtual 275	java/io/FileOutputStream:close	()V
    //   136: return
    //   137: astore_0
    //   138: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -130 -> 11
    //   144: ldc 12
    //   146: iconst_2
    //   147: ldc_w 277
    //   150: aload_0
    //   151: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   154: return
    //   155: astore_1
    //   156: aload 4
    //   158: astore_0
    //   159: aload_0
    //   160: astore_2
    //   161: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +15 -> 179
    //   167: aload_0
    //   168: astore_2
    //   169: ldc 12
    //   171: iconst_2
    //   172: ldc_w 277
    //   175: aload_1
    //   176: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload_0
    //   180: astore_2
    //   181: aload 5
    //   183: invokevirtual 235	java/io/File:exists	()Z
    //   186: ifeq +11 -> 197
    //   189: aload_0
    //   190: astore_2
    //   191: aload 5
    //   193: invokevirtual 241	java/io/File:delete	()Z
    //   196: pop
    //   197: aload_0
    //   198: ifnull -187 -> 11
    //   201: aload_0
    //   202: invokevirtual 275	java/io/FileOutputStream:close	()V
    //   205: return
    //   206: astore_0
    //   207: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -199 -> 11
    //   213: ldc 12
    //   215: iconst_2
    //   216: ldc_w 277
    //   219: aload_0
    //   220: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   223: return
    //   224: astore_0
    //   225: aload_2
    //   226: ifnull +7 -> 233
    //   229: aload_2
    //   230: invokevirtual 275	java/io/FileOutputStream:close	()V
    //   233: aload_0
    //   234: athrow
    //   235: astore_1
    //   236: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -6 -> 233
    //   242: ldc 12
    //   244: iconst_2
    //   245: ldc_w 277
    //   248: aload_1
    //   249: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: goto -19 -> 233
    //   255: astore_0
    //   256: aload_3
    //   257: astore_2
    //   258: goto -33 -> 225
    //   261: astore_1
    //   262: aload_3
    //   263: astore_0
    //   264: goto -105 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramBitmap	android.graphics.Bitmap
    //   0	267	1	paramString	String
    //   28	230	2	localObject1	Object
    //   13	250	3	localFileOutputStream	java.io.FileOutputStream
    //   15	142	4	localObject2	Object
    //   25	167	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   132	136	137	java/lang/Exception
    //   29	40	155	java/lang/Exception
    //   42	51	155	java/lang/Exception
    //   53	61	155	java/lang/Exception
    //   63	69	155	java/lang/Exception
    //   71	81	155	java/lang/Exception
    //   201	205	206	java/lang/Exception
    //   29	40	224	finally
    //   42	51	224	finally
    //   53	61	224	finally
    //   63	69	224	finally
    //   71	81	224	finally
    //   161	167	224	finally
    //   169	179	224	finally
    //   181	189	224	finally
    //   191	197	224	finally
    //   229	233	235	java/lang/Exception
    //   81	128	255	finally
    //   81	128	261	java/lang/Exception
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  protected void a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(500L);
    localAlphaAnimation1.setFillAfter(false);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(500L);
    localAlphaAnimation2.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView.startAnimation(localAlphaAnimation2);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation1.setDuration(500L);
      localAlphaAnimation1.setFillAfter(false);
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation1);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation1.setDuration(500L);
      localAlphaAnimation1.setFillAfter(false);
      this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation1);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView.a(paramInt);
  }
  
  public void a(TroopRewardInfo paramTroopRewardInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo = paramTroopRewardInfo;
    if (paramTroopRewardInfo != null)
    {
      String str = a(paramTroopRewardInfo.rewardId, paramTroopRewardInfo.troopUin);
      ThreadManager.a(new RewardImageDetailView.RewardImageLoadTask(paramTroopRewardInfo.blurPicUrl, "", str, 0, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidOsHandler), 8, null, true);
      if ((paramTroopRewardInfo.type == 1) && (paramTroopRewardInfo.privilege == 0))
      {
        this.jdField_a_of_type_Boolean = true;
        str = b(paramTroopRewardInfo.rewardId, paramTroopRewardInfo.troopUin);
        ThreadManager.a(new RewardImageDetailView.RewardImageLoadTask(paramTroopRewardInfo.clearPicUrl, paramTroopRewardInfo.cookie, str, 1, this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView, this.jdField_a_of_type_AndroidOsHandler), 8, null, true);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView.setImageBitmap(null);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      boolean bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 3)) {
        a();
      }
      return bool;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    this.jdField_b_of_type_Boolean = true;
    paramMotionEvent = new AlphaAnimation(0.0F, 1.0F);
    paramMotionEvent.setDuration(500L);
    paramMotionEvent.setFillAfter(true);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_ComTencentMobileqqTrooprewardOrientationAdapterImageView.startAnimation(paramMotionEvent);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      paramMotionEvent = new AlphaAnimation(1.0F, 0.0F);
      paramMotionEvent.setDuration(500L);
      paramMotionEvent.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewView.startAnimation(paramMotionEvent);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      paramMotionEvent = new AlphaAnimation(1.0F, 0.0F);
      paramMotionEvent.setDuration(500L);
      paramMotionEvent.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewView.startAnimation(paramMotionEvent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo != null) {
      ReportController.b(null, "dc00899", "Grp_paypic", "", "Guestpaypic", "Exp_clear", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin, "", "0", "");
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setOutAnimView(View paramView1, View paramView2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_b_of_type_AndroidViewView = paramView2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopreward\RewardImageDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */