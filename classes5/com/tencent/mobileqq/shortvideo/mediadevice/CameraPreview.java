package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.MotionEventUtil;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;

public class CameraPreview
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  static final int jdField_a_of_type_Int = 10;
  private static final String jdField_a_of_type_JavaLangString = "CameraPreview";
  float jdField_a_of_type_Float;
  SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  public SurfacePreviewContext a;
  
  public CameraPreview(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.getResources().getDisplayMetrics();
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = MotionEventUtil.a(paramMotionEvent);
    if (i == 1) {}
    while (i != 2) {
      return true;
    }
    switch (j)
    {
    case 6: 
    case 3: 
    case 4: 
    default: 
      return true;
    case 2: 
      float f = MotionEventUtil.a(paramMotionEvent);
      paramMotionEvent = new BigDecimal((f - this.jdField_a_of_type_Float) / 10.0F).setScale(0, 4);
      CameraControl.a().c(paramMotionEvent.intValue());
      this.jdField_a_of_type_Float = f;
      return true;
    }
    this.jdField_a_of_type_Float = MotionEventUtil.a(paramMotionEvent);
    return true;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceSurfacePreviewContext.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreview", 2, "[@] surfaceChanged end");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceSurfacePreviewContext.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceSurfacePreviewContext.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CameraPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */