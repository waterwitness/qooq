package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.ark.DispatchTask;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import nij;
import nik;

public class ArkUIView
  extends View
{
  private static Paint jdField_a_of_type_AndroidGraphicsPaint;
  private static PaintFlagsDrawFilter jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter;
  private static final String jdField_a_of_type_JavaLangString = "ArkApp";
  private static Paint jdField_b_of_type_AndroidGraphicsPaint;
  private float jdField_a_of_type_Float = 1.0F;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public View a;
  public ArkContainerWrapper a;
  protected Lock a;
  private float jdField_b_of_type_Float = 1.0F;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  public Lock b;
  private float jdField_c_of_type_Float = 6.0F;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
    jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
    jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
  }
  
  public ArkUIView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    this.jdField_b_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (RelativeLayout)paramView.getParent();
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131297451);
      if (paramView != null) {
        paramView.setVisibility(paramInt);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      localView.setVisibility(8);
      a(localView, 8);
    }
    setVisibility(0);
    requestLayout();
    if (QLog.isColorLevel()) {
      QLog.i("ark.rect", 2, String.format("onLoadSuccess.wrapper: %s uiview: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.toString(), toString() }));
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper = null;
    }
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return null;
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Bitmap a(Rect paramRect)
  {
    if (paramRect.isEmpty())
    {
      QLog.e("ark", 1, String.format("recreateBitmapBuffer.return.null uiview: %s", new Object[] { toString() }));
      return null;
    }
    paramRect = ArkContainerWrapper.a(paramRect, this.jdField_b_of_type_Float);
    int i = paramRect.width();
    int j = paramRect.height();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() >= i) && (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() >= j))
    {
      this.jdField_c_of_type_AndroidGraphicsRect = paramRect;
      paramRect = new RectF(0.0F, 0.0F, paramRect.width(), paramRect.height());
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.addRect(paramRect, Path.Direction.CW);
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(paramRect, this.jdField_c_of_type_Float * this.jdField_a_of_type_Float, this.jdField_c_of_type_Float * this.jdField_a_of_type_Float, Path.Direction.CCW);
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ark.rect.bitmap", 2, String.format("recreateBitmapBuffer.1.rect: %s", new Object[] { paramRect.toString() }));
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ark.rect.bitmap", 2, "recreateBitmapBuffer.2");
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      this.jdField_c_of_type_AndroidGraphicsRect = paramRect;
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      paramRect = new RectF(0.0F, 0.0F, paramRect.width(), paramRect.height());
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.addRect(paramRect, Path.Direction.CW);
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(paramRect, this.jdField_c_of_type_Float * this.jdField_a_of_type_Float, this.jdField_c_of_type_Float * this.jdField_a_of_type_Float, Path.Direction.CCW);
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (OutOfMemoryError paramRect)
    {
      QLog.e("ArkUIView.createCanvas.createBitmap", 1, paramRect.getMessage());
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      }
      return null;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    View localView1 = this.jdField_a_of_type_AndroidViewView;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper != null)
    {
      j = (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a() * this.jdField_a_of_type_Float);
      i = (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.b() * this.jdField_a_of_type_Float);
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int k = j;
      if (j == 0) {
        k = AIOUtils.a(352.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      }
      j = i;
      if (i == 0) {
        j = -1;
      }
      ((ViewGroup.LayoutParams)localObject).height = k;
      ((ViewGroup.LayoutParams)localObject).width = j;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localView1.setVisibility(0);
      localObject = localView1.findViewById(2131297445);
      View localView2 = localView1.findViewById(2131297448);
      a(localView1, 0);
      requestLayout();
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      if (localView2 != null) {
        localView2.setVisibility(4);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ark.rect", 2, String.format("onLoading. uiview: %s", new Object[] { toString() }));
      return;
      i = 0;
      j = 0;
    }
  }
  
  public void a(Rect paramRect)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper == null) {
      return;
    }
    paramRect = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a(paramRect);
    if (!paramRect.equals(this.jdField_a_of_type_AndroidGraphicsRect))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ark.rect", 2, String.format("onSyncRect.1.rect: %s, wrapper: %s", new Object[] { paramRect.toString(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.toString() }));
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
      measure(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
    }
    c();
  }
  
  public void a(ArkContainerWrapper paramArkContainerWrapper, View paramView)
  {
    if (paramArkContainerWrapper == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper != paramArkContainerWrapper) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ark.rect", 2, String.format("initArkView.1.same wrapper: %s, wrapper: %s uiview: %s", new Object[] { this.jdField_a_of_type_AndroidGraphicsRect.toString(), paramArkContainerWrapper.toString(), toString() }));
      return;
      setVisibility(4);
      d();
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
      this.jdField_a_of_type_Float = paramArkContainerWrapper.b();
      this.jdField_b_of_type_Float = paramArkContainerWrapper.a();
      if (QLog.isColorLevel()) {
        QLog.i("ark.rect", 2, String.format("initArkView.2: %s, wrapper: %s uiview: %s", new Object[] { this.jdField_a_of_type_AndroidGraphicsRect.toString(), paramArkContainerWrapper.toString(), toString() }));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper = paramArkContainerWrapper;
      paramArkContainerWrapper.a(this);
      this.jdField_a_of_type_AndroidGraphicsRect = paramArkContainerWrapper.a(paramArkContainerWrapper.a());
    } while (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty());
    measure(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
    requestLayout();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    label231:
    label275:
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (paramBoolean)
      {
        ((View)localObject1).setOnClickListener(new nij(this));
        Object localObject2 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = AIOUtils.a(352.0F, this.jdField_a_of_type_AndroidViewView.getResources());
        ((ViewGroup.LayoutParams)localObject2).width = -1;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        setVisibility(8);
        ((View)localObject1).setVisibility(0);
        localObject2 = ((View)localObject1).findViewById(2131297445);
        View localView = ((View)localObject1).findViewById(2131297448);
        a((View)localObject1, 0);
        requestLayout();
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(4);
        }
        if (localView != null)
        {
          localView.setVisibility(0);
          localObject1 = (TextView)localView.findViewById(2131297450);
          if (localObject1 != null)
          {
            if (paramString != null) {
              break label231;
            }
            ((TextView)localObject1).setText(paramString + getResources().getString(2131372344));
          }
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label275;
        }
        QLog.i("ark.rect", 2, String.format("onLoadFailed.wrapper: %s uiview: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.toString(), toString() }));
        return;
        ((View)localObject1).setOnClickListener(null);
        break;
        if (paramBoolean) {
          ((TextView)localObject1).setText(paramString + getResources().getString(2131372345));
        } else {
          ((TextView)localObject1).setText(paramString);
        }
      }
    }
  }
  
  public boolean a(Rect paramRect)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper == null)
    {
      QLog.e("ark", 1, String.format("onInvalidate.return.1.wrapper: null uiview: %s", new Object[] { toString() }));
      return false;
    }
    Rect localRect = ArkContainerWrapper.a(paramRect, this.jdField_b_of_type_Float);
    if ((this.jdField_a_of_type_AndroidGraphicsCanvas != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a.round == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a.round.intValue() != 0)))
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsCanvas.clipRect(localRect);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsCanvas.restore();
    }
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentLocksLock.lock();
      this.jdField_b_of_type_AndroidGraphicsRect.union(paramRect);
      this.jdField_b_of_type_JavaUtilConcurrentLocksLock.unlock();
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()) || (this.jdField_b_of_type_AndroidGraphicsCanvas == null))
      {
        QLog.e("ark", 1, String.format("onInvalidate.return.2.wrapper: %s uiview: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.toString(), toString() }));
        return false;
      }
    }
    finally {}
    this.jdField_b_of_type_AndroidGraphicsCanvas.save();
    this.jdField_b_of_type_AndroidGraphicsCanvas.clipRect(localRect);
    this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsRect, jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsCanvas.restore();
    DispatchTask.a().c(new nik(this));
    return true;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ark", 2, String.format("destroyBitmapBuffer.return.null uiview: %s", new Object[] { toString() }));
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_c_of_type_AndroidGraphicsRect.setEmpty();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()) || (this.jdField_c_of_type_AndroidGraphicsRect.isEmpty()) || (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ark.rect", 2, "onDraw.return.2");
        }
        return;
      }
      paramCanvas.setDrawFilter(jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRect, null);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void finalize()
  {
    super.finalize();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
      setMeasuredDimension(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height());
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper.a(false);
    }
  }
  
  public void setClipRadius(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ArkUIView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */