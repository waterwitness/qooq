package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import java.math.BigDecimal;

public class NewStoryCameraZoom
{
  private static final int jdField_a_of_type_Int = 20;
  private static final String jdField_a_of_type_JavaLangString = "NewStoryCameraZoom";
  private float jdField_a_of_type_Float;
  
  public NewStoryCameraZoom(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2) {
      SLog.a("NewStoryCameraZoom", "onTouchEvent %s", new Object[] { paramMotionEvent });
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 3: 
    case 4: 
    case 6: 
    default: 
    case 5: 
      for (;;)
      {
        return false;
        this.a = TakeVideoUtils.a(paramMotionEvent);
      }
    }
    float f = TakeVideoUtils.a(paramMotionEvent);
    int i = new BigDecimal((f - this.a) / 20.0F).setScale(0, 4).intValue();
    SLog.a("NewStoryCameraZoom", "set camera zoom increase value %d", new Object[] { Integer.valueOf(i) });
    CameraControl.a().c(i);
    this.a = f;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryCameraZoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */