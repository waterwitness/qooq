package cooperation.qqreader;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QRPluginProxyActivity
  extends PluginProxyActivity
{
  public static boolean a;
  
  public QRPluginProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getPluginID()
  {
    return "qqreaderplugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if ("com.qqreader.ReaderPage".equals(paramString)) {
      return QRReaderPageProxyActivity.class;
    }
    if ("com.qqreader.webview.activity.ReaderBrowserActivity".equals(paramString)) {
      return QRHardWareActivity.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRPluginProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */