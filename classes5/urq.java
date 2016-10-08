import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.ParamCache;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class urq
  extends Handler
  implements Camera.AutoFocusCallback
{
  public urq(CameraProxy paramCameraProxy, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    paramMessage = (Rect)paramMessage.obj;
    Camera.Parameters localParameters = CameraControl.a().a();
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] focus area = " + paramMessage);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Camera.Area(paramMessage, 1000));
      localParameters.setFocusAreas(localArrayList);
    }
    if (CameraControl.a().a("auto")) {
      CameraControl.a().a(new urr(this));
    }
  }
  
  public String a()
  {
    String str2 = "continuous-video";
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
    }
    String str1 = str2;
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
    {
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 14) {
        str1 = "continuous-picture";
      }
    }
    return str1;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      try
      {
        throw new RuntimeException("Unimplemented CameraProxy message=" + paramMessage.what);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[Camera2Handler.handleMessage]", localException);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]OPEN_CAMERA");
        }
        i = CameraControl.a().a(FlowCameraConstant.d);
        if (i == 5) {
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { "open camera failed:errcode=" + CameraControl.a(i) });
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        int j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[@] surfaceChanged start, format = " + k + ",width = " + i + ",height = " + j);
        }
        if ((this.a.jdField_b_of_type_Int <= 0) || (i <= this.a.jdField_b_of_type_Int)) {
          break label2145;
        }
        i = this.a.jdField_b_of_type_Int;
        if ((this.a.jdField_c_of_type_Int <= 0) || (j <= this.a.jdField_c_of_type_Int)) {
          break label2142;
        }
        j = this.a.jdField_c_of_type_Int;
        CameraControl localCameraControl = CameraControl.a();
        if (Build.VERSION.SDK_INT <= 10) {
          CameraControl.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
          if (((CameraProxy.ParamCache)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!CameraControl.a().c()) {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (FlowCameraConstant.d == 1)
            {
              localObject1 = this.a.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
              continue;
            }
            if (FlowCameraConstant.d == 2)
            {
              localObject1 = this.a.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (FlowCameraConstant.d == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (FlowCameraConstant.d == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (FlowCameraConstant.d == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (FlowCameraConstant.d == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject4 = localCameraControl.a(CodecParam.j, CodecParam.k, i, j);
          if (localObject4 == null) {
            break label2136;
          }
          bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject4);
          break label2148;
          if (!bool1) {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview size failed" + (String)localObject4 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int != 2) {
            break label2162;
          }
          localObject4 = localCameraControl.b(CodecParam.j, CodecParam.k, i, j);
          bool1 = bool3;
          if (localObject4 == null) {
            break label2155;
          }
          bool1 = CameraControl.a().a((CameraControl.CustomSize)localObject4);
          break label2155;
        }
        if (!CameraControl.a().b(CodecParam.g))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (!localCameraControl.a(localCameraControl.a().jdField_a_of_type_Int, localCameraControl.a().jdField_b_of_type_Int)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set picture size failed" });
          return;
        }
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Int = CameraControl.a().a();
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = CameraControl.a().a();
        localObject4 = CameraControl.a().a();
        ((CameraProxy.ParamCache)localObject1).jdField_b_of_type_Int = localObject4[0];
        ((CameraProxy.ParamCache)localObject1).jdField_c_of_type_Int = localObject4[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4))
        {
          ((CameraProxy.ParamCache)localObject1).jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = CameraControl.a().b();
          ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_Boolean = true;
        }
        ((CameraProxy.ParamCache)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!CameraControl.a().a((String)localObject1)) && (!CameraControl.a().a("auto")) && (!CameraControl.a().a(this))) {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { "无法开启自动对焦功能" });
        }
        if (!CameraControl.a().a(90))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!CameraControl.a().a((CameraProxy.ParamCache)localObject1))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set Camera Params failed" });
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("CameraProxy", 2, "[handleMessage]Set camera param by cache params");
          continue;
        }
      }
      finally
      {
        CameraProxy.WaitDoneBundle.a(paramMessage);
      }
      Object localObject3 = CameraControl.a().a();
      int i = CameraControl.a().a();
      Object localObject4 = CameraControl.a().a();
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { localObject4, Integer.valueOf(i), localObject3 });
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
      }
      localObject3 = a();
      if ((!CameraControl.a().a((String)localObject3)) && (!CameraControl.a().a("auto")) && (!CameraControl.a().a(this)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(9, new Object[] { "无法开启自动对焦功能" });
        continue;
        a(paramMessage);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE");
        }
        localObject3 = (SurfaceTexture)paramMessage.obj;
        if (!CameraControl.a().a((SurfaceTexture)localObject3))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview texture failed" });
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (!CameraControl.a().a((SurfaceHolder)localObject3))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set surface holder failed" });
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
            }
            localObject3 = (Camera.PreviewCallback)paramMessage.obj;
            bool1 = bool2;
            if (paramMessage.arg1 > 0) {
              bool1 = true;
            }
            if (!CameraControl.a().a((Camera.PreviewCallback)localObject3, bool1))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set preview callback failed" });
              continue;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_START");
              }
              if (!CameraControl.a().a())
              {
                this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(3, new Object[] { "start preview failed" });
                continue;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
                }
                if (!CameraControl.a().b())
                {
                  this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(4, new Object[] { "stop preview failed" });
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
                  }
                  CameraControl.a().a();
                  this.a.jdField_a_of_type_Boolean = true;
                  try
                  {
                    Thread.sleep(50L);
                    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(11, new Object[] { "camera destory" });
                    continue;
                    if (QLog.isColorLevel()) {
                      QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
                    }
                    if (paramMessage.arg1 == 0)
                    {
                      if (CameraControl.a().d()) {
                        continue;
                      }
                      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "switch flash light failed" });
                      continue;
                    }
                    if (paramMessage.arg1 == 1)
                    {
                      if (CameraControl.a().a(true)) {
                        continue;
                      }
                      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn on flash light failed" });
                      continue;
                    }
                    if ((paramMessage.arg1 != 2) || (CameraControl.a().a(false))) {
                      continue;
                    }
                    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(6, new Object[] { "turn off flash light failed" });
                    continue;
                    if (QLog.isColorLevel()) {
                      QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
                    }
                    localObject3 = (urt)paramMessage.obj;
                    localObject4 = CameraControl.a();
                    if (!((CameraControl)localObject4).jdField_a_of_type_Boolean)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
                      }
                      CameraProxy.WaitDoneBundle.a(paramMessage);
                      return;
                    }
                    if (((urt)localObject3).jdField_a_of_type_JavaIoFile == null)
                    {
                      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "take picture error" });
                      CameraProxy.WaitDoneBundle.a(paramMessage);
                      return;
                    }
                    if ((!CameraCompatibleList.d(CameraCompatibleList.k)) && (!((CameraControl)localObject4).d(((urt)localObject3).jdField_a_of_type_Int)))
                    {
                      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(2, new Object[] { "set ratation " + ((urt)localObject3).jdField_a_of_type_Int + " error" });
                      CameraProxy.WaitDoneBundle.a(paramMessage);
                      return;
                    }
                    ((CameraControl)localObject4).a(((urt)localObject3).jdField_a_of_type_JavaIoFile, ((urt)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((urt)localObject3).jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback, ((urt)localObject3).jdField_a_of_type_Int);
                  }
                  catch (InterruptedException localInterruptedException)
                  {
                    for (;;) {}
                  }
                  label2136:
                  bool1 = false;
                  break label2148;
                  label2142:
                  continue;
                  label2145:
                  continue;
                  label2148:
                  localObject4 = "";
                  continue;
                  label2155:
                  localObject4 = "";
                  continue;
                  label2162:
                  localObject4 = " :[Preview Selector Error]";
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[onAutoFocus]success " + paramBoolean);
    }
    paramCamera = a();
    CameraControl.a().a(paramCamera);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */