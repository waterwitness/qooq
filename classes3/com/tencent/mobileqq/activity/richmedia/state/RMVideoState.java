package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.qphone.base.util.QLog;

public abstract class RMVideoState
{
  public RMVideoState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract void a();
  
  public void a(AVCodec.AVCodecCallback paramAVCodecCallback, MessageStruct paramMessageStruct) {}
  
  public void a(TCTimer.TCTimerCallback paramTCTimerCallback, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoState", 2, "[@] notify called eventId=" + paramInt);
    }
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if ((paramObject instanceof AudioCapture)) {
      switch (paramInt)
      {
      }
    }
    while (!(paramObject instanceof CameraProxy.CameraPreviewObservable))
    {
      return;
      localRMVideoStateMgr.g();
      return;
    }
    QLog.d("faceuu", 2, " notify EVENT_SET_CAMERA_PARAM eventId" + paramInt);
    if (localRMVideoStateMgr != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      QLog.d("faceuu", 2, " notify EVENT_SET_CAMERA_PARAM null");
      return;
      if (localRMVideoStateMgr.a == null) {
        continue;
      }
      localRMVideoStateMgr.a.k();
      continue;
      if ((paramVarArgs == null) || (localRMVideoStateMgr.a == null) || (!(paramVarArgs[0] instanceof CameraControl.CustomSize))) {
        continue;
      }
      paramObject = (CameraControl.CustomSize)paramVarArgs[0];
      try
      {
        localRMVideoStateMgr.a.a(((CameraControl.CustomSize)paramObject).a, ((CameraControl.CustomSize)paramObject).b);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("RMVideoState", 2, "[@] EVENT_SET_CAMERA_PARAM[success]");
      }
      catch (NullPointerException paramObject)
      {
        for (;;)
        {
          ((NullPointerException)paramObject).printStackTrace();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return false;
  }
  
  public abstract void b();
  
  public void f() {}
  
  public void g() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\state\RMVideoState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */