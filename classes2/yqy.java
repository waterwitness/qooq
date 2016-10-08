import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic;

public final class yqy
  implements DialogInterface.OnClickListener
{
  public yqy(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (QUA.a().indexOf("GM") < 0) {
        QZoneWebViewJsHandleLogic.a(QzoneConfig.a().a("H5Url", "DownloadQzoneClient", "http://m.qzone.com/client/fwd?bid=update&_wv=7"), this.a);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "simpleBrowserJump exception", paramDialogInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */