package com.tencent.mobileqq.businessCard.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.MotionEventUtil;

public class OCRSurfaceView
  extends SurfaceView
{
  public OCRSurfaceView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = MotionEventUtil.a(paramMotionEvent);
    if (i == 1) {}
    switch (j)
    {
    default: 
      return true;
    }
    CameraHelper.a().c();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\businessCard\views\OCRSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */