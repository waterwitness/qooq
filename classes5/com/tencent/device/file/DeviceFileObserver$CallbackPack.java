package com.tencent.device.file;

import android.view.View;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class DeviceFileObserver$CallbackPack
{
  public WeakReference a;
  public WeakReference b;
  
  public DeviceFileObserver$CallbackPack(DeviceFileObserver paramDeviceFileObserver, View paramView, MessageForDeviceFile.DeviceFileItemCallback paramDeviceFileItemCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramDeviceFileItemCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public MessageForDeviceFile.DeviceFileItemCallback a()
  {
    return (MessageForDeviceFile.DeviceFileItemCallback)this.b.get();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\file\DeviceFileObserver$CallbackPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */