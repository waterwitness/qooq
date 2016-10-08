package com.tencent.biz.qqstory.takevideo.doodle.layer.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseLayer
  implements Layer, LifeCycle
{
  private static final String a = "BaseLayer";
  protected Context a;
  protected Rect a;
  protected BaseLayer.OnLayerTouchListener a;
  protected DoodleView a;
  protected boolean b;
  protected Paint d;
  protected float e;
  protected Paint e;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  
  public BaseLayer(DoodleView paramDoodleView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramDoodleView == null) {
      throw new IllegalStateException("DoodleView can not be null.");
    }
    this.jdField_a_of_type_AndroidContentContext = paramDoodleView.getContext();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = paramDoodleView;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(-16776961);
    this.b = false;
  }
  
  public abstract String a();
  
  public void a(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void a(BaseLayer.OnLayerTouchListener paramOnLayerTouchListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener = paramOnLayerTouchListener;
  }
  
  protected abstract boolean a(MotionEvent paramMotionEvent);
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      SLog.e("BaseLayer", "Layer width or height little than 0.");
      return;
    }
    SLog.b("BaseLayer", "layer size,width=" + paramInt1 + ",height=" + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = paramInt2;
    this.s = this.jdField_a_of_type_AndroidGraphicsRect.left;
    this.t = this.jdField_a_of_type_AndroidGraphicsRect.right;
    this.q = this.jdField_a_of_type_AndroidGraphicsRect.top;
    this.r = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(this);
    }
    for (;;)
    {
      e();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a();
    }
  }
  
  public final void c(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public abstract boolean c(MotionEvent paramMotionEvent);
  
  public boolean d(MotionEvent paramMotionEvent)
  {
    return e(paramMotionEvent);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
    }
  }
  
  public final boolean e(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener.a(this, paramMotionEvent);
    }
    e();
    return a(paramMotionEvent);
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    this.b = false;
  }
  
  public void i()
  {
    this.b = true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\base\BaseLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */