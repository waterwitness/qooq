package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import oyx;

public class CameraPreviewNew
  extends SurfaceView
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  private static final String jdField_a_of_type_JavaLangString = CameraPreviewNew.class.getSimpleName();
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
  private Observable jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable = new CameraPreviewNew.CameraPreviewObservable(this);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CameraPreviewNew(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraPreviewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    post(new oyx(this, paramString, paramInt, getContext()));
  }
  
  public void a(Observer paramObserver, int... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramObserver, paramVarArgs);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera) {}
  
  public void setCamera(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setCamera isFromGuide" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (Build.VERSION.SDK_INT <= 10) {
      CameraControl.a().b();
    }
    if (!CameraControl.a().c())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(2, new Object[] { "set preview format failed" });
      a(2002, "抱歉，摄像头初始化失败", false);
    }
    do
    {
      return;
      paramSurfaceHolder = CameraControl.a().a(CodecParam.j, CodecParam.k, paramInt2, paramInt3);
      if ((paramSurfaceHolder == null) || (!CameraControl.a().a(paramSurfaceHolder)))
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(2, new Object[] { "set preview size failed" });
        a(2002, "抱歉，摄像头初始化大小失败", false);
        return;
      }
      if (!CameraControl.a().b(CodecParam.g))
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(2, new Object[] { "set preview fps failed" });
        a(2002, "抱歉，摄像头初始化fps失败", false);
        return;
      }
      if (!CameraControl.a().a(90))
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(2, new Object[] { "set display orientation failed" });
        a(2002, "抱歉，摄像头初始化方向失败", false);
        return;
      }
      paramSurfaceHolder = CameraControl.a().a();
      paramInt1 = CameraControl.a().a();
      CameraControl.CustomSize localCustomSize = CameraControl.a().a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(2, new Object[] { localCustomSize, Integer.valueOf(paramInt1), paramSurfaceHolder });
    } while (CameraControl.a().a(this, this.jdField_a_of_type_AndroidViewSurfaceHolder));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "surfaceChanged");
    }
    a(2002, "抱歉，摄像头预览失败", false);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(3, new Object[] { "start preview failed" });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int i = BaseApplicationImpl.a().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", FlowCameraConstant.d);
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    int j = i;
    if (!CameraAbility.c())
    {
      j = i;
      if (i == 1) {
        j = 2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "surfaceCreated sCurrentCamera=" + j);
    }
    if (CameraControl.a().a(j) != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(1, new Object[] { "open camera failed" });
      a(2002, "抱歉，打开摄像头失败", false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "surfaceCreated");
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(1, new Object[] { Boolean.valueOf(true) });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder.removeCallback(this);
    CameraControl.a().b();
    CameraControl.a().a();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "surfaceDestroyed");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\CameraPreviewNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */