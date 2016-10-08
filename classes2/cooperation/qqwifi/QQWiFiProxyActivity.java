package cooperation.qqwifi;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QQWiFiProxyActivity
  extends PluginProxyActivity
{
  public QQWiFiProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if ("com.tencent.wifisdk.activity.QQWIFIMapActivity".equals(paramString)) {
      return QQWIFIMapProxyActivity.class;
    }
    return super.getProxyActivity(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqwifi\QQWiFiProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */