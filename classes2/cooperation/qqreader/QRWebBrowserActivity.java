package cooperation.qqreader;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.QLog;

public class QRWebBrowserActivity
  extends QRHardWareActivity
{
  public QRWebBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.e("QRWebBrowserActivity", 2, "unregisterCommond");
    }
    PluginCommunicationHandler.getInstance().unregister("qqreader_plugin_cmd");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRWebBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */