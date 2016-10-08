package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.mobileqq.portal.SaQianView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import xtk;

public class HongBaoListView
  extends FPSSwipListView
{
  public static final long a = 300L;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final long h = 1500L;
  public static final int i = 8;
  public int a;
  public Bitmap a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public ConversationHongBao a;
  public HongBaoPendantHolder a;
  public HongBaoListViewListener a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  public boolean a;
  public float[] a;
  public int b;
  Drawable b;
  public boolean b;
  public boolean[] b;
  public int c;
  public boolean c;
  public boolean d;
  public boolean e;
  public int j;
  public boolean t;
  
  public HongBaoListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_ArrayOfFloat = new float[10];
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new xtk(this));
  }
  
  public HongBaoListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_ArrayOfBoolean = new boolean[10];
    this.jdField_a_of_type_ArrayOfFloat = new float[10];
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new xtk(this));
  }
  
  public void E()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a();
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a.c();
    }
  }
  
  public void F()
  {
    if (!this.d) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "hideHongBao ," + this.d);
    }
    E();
    this.d = false;
  }
  
  public void G()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showHongBao ," + this.d);
    }
    E();
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.e = 255;
  }
  
  public int a()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int n = s();
    if (n >= this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (k = 0; localIterator.hasNext(); k = ((ListView.FixedViewInfo)localIterator.next()).jdField_a_of_type_AndroidViewView.getHeight() + k) {}
      return -localView.getTop() + (n - this.jdField_a_of_type_JavaUtilArrayList.size()) * localView.getHeight() + k;
    }
    int k = 0;
    int m = 0;
    while (k < n)
    {
      m += ((ListView.FixedViewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_AndroidViewView.getHeight();
      k += 1;
    }
    return -localView.getTop() + m;
  }
  
  public void a(int paramInt)
  {
    setHongBaoAlpha(255);
    setSelection(0);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 5, paramInt, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 150L);
  }
  
  public void a(long paramLong)
  {
    H();
  }
  
  public boolean b()
  {
    boolean bool = isShown();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showPreGuideTwice, " + bool + ", " + this.jdField_a_of_type_Boolean);
    }
    if ((!bool) || (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
      return false;
    }
    setHongBaoAlpha(255);
    setSelection(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return true;
  }
  
  public int c()
  {
    return computeVerticalScrollOffset();
  }
  
  public void c()
  {
    super.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    d();
    setComboListener(null);
    super.setOverscrollHeader(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
    super.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    setOverscrollHeaderShadowEnable(true);
    this.jdField_a_of_type_Boolean = false;
    F();
    g();
    this.l = false;
  }
  
  public void c(int paramInt1, int paramInt2) {}
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.mScrollY < 0;
    }
    return super.c();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean == true)
    {
      if (this.t)
      {
        OverScroller.jdField_b_of_type_Int = 300;
        return;
      }
      OverScroller.jdField_b_of_type_Int = 600;
      return;
    }
    OverScroller.jdField_b_of_type_Int = 400;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int m = 0;
    super.draw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.d) && (!this.jdField_b_of_type_Boolean))
    {
      int n = a();
      int k = n;
      if (n < 0) {
        k = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.l = (-k);
      k = m;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramCanvas)) {
        k = 1;
      }
      if (k != 0) {
        invalidate();
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    f();
    this.jdField_a_of_type_Boolean = true;
    super.setOverScrollListener(null);
    super.setOverscrollHeader(null);
    super.setOverScrollHeader(null);
    setOverscrollHeaderShadowEnable(false);
    this.l = true;
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder = new HongBaoPendantHolder(this);
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(true, this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    setIsShowingPreguide(false);
  }
  
  public void h()
  {
    E();
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(false, this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.d();
    invalidate();
  }
  
  public int l()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.l();
    }
    return this.jdField_c_of_type_Int;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.d()) {
      return bool;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getY();
      this.jdField_b_of_type_ArrayOfBoolean[0] = true;
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a(this);
      }
      if ((this.d) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a().contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        this.jdField_c_of_type_Boolean = true;
        super.onInterceptTouchEvent(paramMotionEvent);
        return true;
      }
      this.jdField_c_of_type_Boolean = false;
      g();
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
      this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a(paramInt1, paramInt2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.d()) {
      return bool;
    }
    bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return bool;
      if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
        this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b(this);
      }
      if (paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int) == -1) {}
      switch (this.ag)
      {
      case 4: 
      default: 
        break;
      case 3: 
      case 5: 
        if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null)
        {
          int k = paramMotionEvent.getPointerCount();
          if (k > this.jdField_b_of_type_Int) {
            this.jdField_b_of_type_Int = k;
          }
          float f1 = 0.0F;
          k = 0;
          while (k < paramMotionEvent.getPointerCount())
          {
            float f3 = paramMotionEvent.getY(k) - this.jdField_a_of_type_ArrayOfFloat[k];
            float f2 = f1;
            if (this.jdField_b_of_type_ArrayOfBoolean[k] != 0)
            {
              f2 = f1;
              if (f3 > f1) {
                f2 = f3;
              }
            }
            k += 1;
            f1 = f2;
          }
          if (-getScrollY() >= this.j / 2)
          {
            if (f1 > this.j / 2)
            {
              setSpringbackOffset(-this.j);
              this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a();
              k = 0;
              while (k < this.jdField_b_of_type_Int)
              {
                this.jdField_b_of_type_ArrayOfBoolean[k] = false;
                k += 1;
              }
            }
            this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a();
            continue;
            if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) && (getScrollY() == 0) && (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a().contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
              this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b();
            }
            this.jdField_c_of_type_Boolean = false;
            if (this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
              this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.c(this);
            }
            this.jdField_a_of_type_Int = -1;
            continue;
            this.jdField_a_of_type_Int = -1;
            this.jdField_c_of_type_Boolean = false;
            continue;
            k = paramMotionEvent.getActionIndex();
            this.jdField_a_of_type_ArrayOfFloat[k] = ((int)paramMotionEvent.getY(k));
            this.jdField_b_of_type_ArrayOfBoolean[k] = true;
            continue;
            k = paramMotionEvent.getActionIndex();
            this.jdField_b_of_type_ArrayOfBoolean[k] = false;
          }
        }
        break;
      }
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.e)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 400L);
      this.e = false;
    }
  }
  
  public void setComboListener(HongBaoListViewListener paramHongBaoListViewListener)
  {
    this.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener = paramHongBaoListViewListener;
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    setSpeciaContentBackground(paramDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setHongBaoAlpha(int paramInt) {}
  
  public void setIsShowingPreguide(boolean paramBoolean)
  {
    this.t = paramBoolean;
    d();
  }
  
  public void setLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(paramBoolean, paramBitmap);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidate();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "setLogo ," + this.d + ", " + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  public void setOverScrollHeader(View paramView)
  {
    setSpeciaOverScrollHeader(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    setSpeciaOverScrollListener(paramOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = paramOverScrollViewListener;
  }
  
  public void setOverscrollHeader(Drawable paramDrawable)
  {
    setSpeciaOverscrollHeader(paramDrawable);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setOverscrollHeaderShadowEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.g = getResources().getDrawable(2130838671);
      return;
    }
    this.g = null;
  }
  
  public void setSpeciaContentBackground(Drawable paramDrawable)
  {
    if (this.l)
    {
      super.setContentBackground(paramDrawable, false);
      return;
    }
    super.setContentBackground(paramDrawable);
  }
  
  public void setSpeciaOverScrollHeader(View paramView)
  {
    if (this.l)
    {
      super.setOverScrollHeader(null);
      return;
    }
    super.setOverScrollHeader(paramView);
  }
  
  public void setSpeciaOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    if (this.l)
    {
      super.setOverScrollListener(null);
      return;
    }
    super.setOverScrollListener(paramOverScrollViewListener);
  }
  
  public void setSpeciaOverscrollHeader(Drawable paramDrawable)
  {
    if (this.l)
    {
      super.setOverscrollHeader(null);
      return;
    }
    super.setOverscrollHeader(paramDrawable);
  }
  
  public void setSpringbackOffset(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\HongBaoListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */