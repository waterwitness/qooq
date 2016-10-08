import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jvl
  implements DialogInterface.OnClickListener
{
  public jvl(DevicePluginDownloadActivity paramDevicePluginDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */