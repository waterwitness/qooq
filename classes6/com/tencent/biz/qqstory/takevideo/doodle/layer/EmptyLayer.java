package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class EmptyLayer
  extends BaseLayer
{
  public static final String a = EmptyLayer.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EmptyLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a()
  {
    return a;
  }
  
  public void a() {}
  
  protected void a(Canvas paramCanvas) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(Canvas paramCanvas) {}
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    SLog.b(a, "EmptyLayer handle touch event.");
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\EmptyLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */