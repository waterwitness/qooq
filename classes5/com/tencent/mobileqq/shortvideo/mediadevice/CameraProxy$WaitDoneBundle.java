package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import uru;

public class CameraProxy$WaitDoneBundle
{
  public final Object a;
  public final Runnable a;
  
  CameraProxy$WaitDoneBundle()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangRunnable = new uru(this);
  }
  
  public static void a(Message paramMessage)
  {
    if (paramMessage == null) {}
    while (!(paramMessage.obj instanceof WaitDoneBundle)) {
      return;
    }
    ((WaitDoneBundle)paramMessage.obj).jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CameraProxy$WaitDoneBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */