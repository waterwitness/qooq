package com.tencent.mobileqq.apollo;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;
import pqq;

public class ApolloTextureView
  extends GLTextureView
  implements ITriggerRenderCallback
{
  public static final String a = "ApolloTextureView";
  private float jdField_a_of_type_Float;
  private ApolloRender jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
  protected ApolloRenderDriver a;
  protected ApolloRenderInterfaceImpl a;
  private OnApolloViewListener jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener;
  private float b;
  private float c;
  private int e;
  
  public ApolloTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = super.getContext().getResources().getDisplayMetrics().density;
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.setOpaque(false);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTextureView", 2, "[ApolloSurfaceView4Drawer] constructor");
    }
  }
  
  public ApolloRender a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
  }
  
  public ApolloRenderInterfaceImpl a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.g();
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl.a(paramLong);
    }
  }
  
  public void a(OnApolloViewListener paramOnApolloViewListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTextureView", 2, "[init], callback:" + paramOnApolloViewListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener = paramOnApolloViewListener;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = new ApolloRender(this.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener);
      super.setEGLContextFactory(new pqq(this, null));
      super.setRenderer(this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      super.setRenderMode(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver = new ApolloRenderDriver(this, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a());
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl = new ApolloRenderInterfaceImpl(this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      return;
    }
    finally {}
  }
  
  public void c()
  {
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      float f1;
      float f2;
      do
      {
        return bool1;
        this.b = paramMotionEvent.getY();
        this.c = paramMotionEvent.getX();
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        f2 = super.getBottom() - super.getTop() - f2;
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener == null);
      paramMotionEvent = ApolloActionManager.a().a();
      paramMotionEvent.lock();
      label220:
      for (;;)
      {
        try
        {
          this.e = -1;
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a() != null))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a().a(f1, f2, "Bubble")) {
              this.e = 1000;
            }
          }
          else
          {
            paramMotionEvent.unlock();
            if (this.e < 0) {
              break label220;
            }
            bool1 = bool2;
            return bool1;
          }
          int i = 0;
          if (i < ApolloConstant.a.length)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a().a(f1, f2, ApolloConstant.a[i])) {
              this.e = i;
            }
            i += 1;
          }
          else
          {
            continue;
            bool1 = false;
          }
        }
        finally
        {
          paramMotionEvent.unlock();
        }
      }
      if ((this.e >= 0) && (!this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a()) && (this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener != null))
      {
        f1 = paramMotionEvent.getX();
        f2 = this.c;
        if ((Math.abs(paramMotionEvent.getY() - this.b) <= 20.0F) && (Math.abs(f1 - f2) <= 20.0F)) {
          if (this.e == 1000) {
            this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener.a(0);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqApolloOnApolloViewListener.a(1);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\ApolloTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */