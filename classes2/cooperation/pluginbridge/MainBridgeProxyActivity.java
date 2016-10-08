package cooperation.pluginbridge;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class MainBridgeProxyActivity
  extends PluginProxyActivity
{
  public MainBridgeProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MainBridgeProxyActivity", 2, "getProxyActivity:" + paramString);
    }
    return super.getProxyActivity(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\pluginbridge\MainBridgeProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */