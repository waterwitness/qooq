package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class FramesProcessor$Frame
{
  public int a;
  public Bitmap a;
  
  public FramesProcessor$Frame()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void finalize()
  {
    super.finalize();
    if ((this.a != null) && (!this.a.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Frames", 2, "recycle bitmap");
      }
      this.a.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\trimvideo\video\widget\FramesProcessor$Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */