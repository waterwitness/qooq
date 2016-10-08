import android.view.View;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class jxg
{
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public WeakReference b;
  
  public jxg(DeviceAVFileMsgObserver paramDeviceAVFileMsgObserver, View paramView, DeviceAVFileMsgObserver.DevMsgViewCallback paramDevMsgViewCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramDevMsgViewCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public DeviceAVFileMsgObserver.DevMsgViewCallback a()
  {
    return (DeviceAVFileMsgObserver.DevMsgViewCallback)this.b.get();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */