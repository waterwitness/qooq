package com.tencent.mobileqq.hotchat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ssz;

public class HotChatFavoriteHelper
  implements Handler.Callback, View.OnClickListener
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final int c = 2;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public FragmentActivity a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  HotChatHandler jdField_a_of_type_ComTencentMobileqqAppHotChatHandler;
  HotChatManager jdField_a_of_type_ComTencentMobileqqAppHotChatManager;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new ssz(this);
  public QQAppInterface a;
  public HotChatInfo a;
  private boolean jdField_a_of_type_Boolean;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_b_of_type_AndroidOsHandler;
  Drawable c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = HotChatFavoriteHelper.class.getSimpleName();
  }
  
  public HotChatFavoriteHelper(ImageView paramImageView, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramHotChatInfo;
    if ((paramHotChatInfo == null) || (paramHotChatInfo.isWifiHotChat))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramImageView.getContext());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59));
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler = ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 100L);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
  }
  
  private Drawable a(int paramInt)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inScaled = true;
    ((BitmapFactory.Options)localObject1).inDensity = 320;
    ((BitmapFactory.Options)localObject1).inTargetDensity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().densityDpi;
    try
    {
      localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), paramInt, (BitmapFactory.Options)localObject1);
      if (localObject1 == null) {
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        localBitmap = null;
      }
      Object localObject3 = localBitmap.getConfig();
      Object localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = Bitmap.Config.ARGB_4444;
      }
      localObject2 = Bitmap.createBitmap(localBitmap.getWidth(), localBitmap.getHeight(), (Bitmap.Config)localObject2);
      localObject3 = new Canvas((Bitmap)localObject2);
      Paint localPaint = new Paint();
      localPaint.setColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F }));
      ((Canvas)localObject3).drawBitmap(localBitmap, new Matrix(), localPaint);
      localObject3 = new StateListDrawable();
      localObject2 = new BitmapDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), (Bitmap)localObject2);
      ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject2);
      ((StateListDrawable)localObject3).addState(StateSet.WILD_CARD, new BitmapDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources(), localBitmap));
      return (Drawable)localObject3;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130838323);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable)) {
          ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
        }
      }
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof Animatable)))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    ImageView localImageView;
    FragmentActivity localFragmentActivity;
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isFavorite)
    {
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      localFragmentActivity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isFavorite) {
        break label199;
      }
    }
    label199:
    for (int i = 2131372426;; i = 2131372427)
    {
      localImageView.setContentDescription(localFragmentActivity.getString(i));
      return;
      if (this.c == null) {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.c);
      break;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = a(2130840131);
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        continue;
        this.c = a(2130840130);
        if (this.c != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
          continue;
          a();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isFavorite) {
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, false, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 100L);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, true, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\HotChatFavoriteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */