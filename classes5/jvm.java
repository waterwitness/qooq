import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.smartdevice.SmartDevicePluginLoader;

public class jvm
  implements DialogInterface.OnClickListener
{
  public jvm(DevicePluginDownloadActivity paramDevicePluginDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SmartDevicePluginLoader.a().a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jvm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */