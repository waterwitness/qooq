package com.tencent.mobileqq.activity;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PortraitImageview$SimpleOnScaleGestureListener
  implements ScaleGestureDetector.OnScaleGestureListener
{
  public PortraitImageview$SimpleOnScaleGestureListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\PortraitImageview$SimpleOnScaleGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */