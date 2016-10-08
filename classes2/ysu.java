import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.smartdevice.SmartDevicePluginLoader;

public class ysu
  implements DialogInterface.OnShowListener
{
  public ysu(SmartDevicePluginLoader paramSmartDevicePluginLoader, QQProgressDialog paramQQProgressDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.hide();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */