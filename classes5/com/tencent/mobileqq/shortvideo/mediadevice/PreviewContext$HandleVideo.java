package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PreviewContext$HandleVideo
  implements Runnable
{
  public PreviewContext$HandleVideo(PreviewContext paramPreviewContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((SVHwEncoder)this.a.mEncodeRef.get() != null) {
      if (PreviewContext.access$000(this.a))
      {
        this.a.mAVCodec.handleQQVideoFrameWithCallback();
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] HandleVideo: handleQQVideoFrameWithCallback");
        }
      }
    }
    for (;;)
    {
      this.a.mCamera.a.a(7, new Object[] { Integer.valueOf(0) });
      this.a.mVideoFrameProcess.incrementAndGet();
      return;
      this.a.mAVCodec.handleQQVideoOneFrame();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] HandleVideo: handleQQVideoOneFrame");
      }
      this.a.encodeOneFrameNotify();
      continue;
      this.a.mAVCodec.handleQQVideo();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] HandleVideo: encode=null");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\PreviewContext$HandleVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */