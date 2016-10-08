package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import nhm;

public class AnimationTopGestureLayout
  extends RelativeLayout
  implements Handler.Callback
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 8;
  public static final int e = 1;
  private static final int f = 2000;
  private long jdField_a_of_type_Long;
  public Handler a;
  public BitmapAnimTask a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  Random jdField_a_of_type_JavaUtilRandom = new Random(1000L);
  private volatile boolean jdField_a_of_type_Boolean = true;
  private volatile boolean b;
  private volatile int g;
  private int h;
  private int i;
  private int j;
  
  public AnimationTopGestureLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  public AnimationTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AnimationTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private void a(BitmapAnimTask paramBitmapAnimTask, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      if ((paramInt != 1) && (paramInt == 2))
      {
        paramInt = 0;
        while (paramInt < 3)
        {
          paramBitmapAnimTask.a(b(), c(), 2000, a(paramInt), 1.5F, a());
          paramInt += 1;
        }
      }
    }
  }
  
  int a()
  {
    int m = this.jdField_a_of_type_JavaUtilRandom.nextInt(5);
    int k = m;
    if (m == this.i) {
      k = (m + 1) % 5;
    }
    this.i = k;
    return k;
  }
  
  int a(int paramInt)
  {
    return paramInt * 120 + this.jdField_a_of_type_JavaUtilRandom.nextInt(100);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.g -= 1;
      if (this.g > 0)
      {
        this.jdField_a_of_type_Long = (SystemClock.uptimeMillis() + this.h - 1L);
        this.b = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, this.h);
        return;
      }
      a(false);
      return;
    }
    a(false);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      paramView = BitmapManager.b(getResources(), 2130838129);
      Bitmap localBitmap1 = BitmapManager.b(getResources(), 2130838130);
      Bitmap localBitmap2 = BitmapManager.b(getResources(), 2130838131);
      Bitmap localBitmap3 = BitmapManager.b(getResources(), 2130838132);
      Bitmap localBitmap4 = BitmapManager.b(getResources(), 2130838133);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localBitmap1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localBitmap2);
      this.jdField_a_of_type_JavaUtilArrayList.add(localBitmap3);
      this.jdField_a_of_type_JavaUtilArrayList.add(localBitmap4);
    }
    paramView = new BitmapAnimTask(5000, 3000, this.jdField_a_of_type_JavaUtilArrayList);
    a(paramView, paramInt1);
    a(paramView, paramInt5 / 2, paramInt6, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(BitmapAnimTask paramBitmapAnimTask, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.v("aaa", String.format("(%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask = paramBitmapAnimTask;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Long = (SystemClock.uptimeMillis() + paramInt3 - 1L);
    this.b = true;
    this.jdField_a_of_type_AndroidOsHandler.post(new nhm(this));
  }
  
  public void a(BitmapAnimTask paramBitmapAnimTask, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_Boolean = true;
    this.g = paramInt4;
    this.h = paramInt5;
    a(paramBitmapAnimTask, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask = null;
    this.jdField_a_of_type_Long = 0L;
    this.g = 0;
    this.h = 0;
    this.jdField_a_of_type_Boolean = false;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((Bitmap)localIterator.next()).recycle();
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    invalidate();
  }
  
  int b()
  {
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(40) - 20 - 90;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask != null)
    {
      BitmapAnimTask localBitmapAnimTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask;
      localBitmapAnimTask.jdField_a_of_type_Float *= 2.0F;
      int m = (int)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
      int k = 0;
      while (k < 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.a(b(), c(), 2000, a(k) + m, 1.5F, a());
        k += 1;
      }
    }
  }
  
  int c()
  {
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(100) - 50 + 500;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Log.d("test", "do dispatchDraw : ");
    super.dispatchDraw(paramCanvas);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask != null) && (!this.b)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.a(paramCanvas, (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask == null);
    int k = (int)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    if (k > this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.jdField_a_of_type_Float) {
      a();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask != null)
    {
      invalidate(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.jdField_a_of_type_AndroidGraphicsRect);
      return false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.a(k);
      this.b = false;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 8L);
      }
    }
    invalidate();
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\AnimationTopGestureLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */