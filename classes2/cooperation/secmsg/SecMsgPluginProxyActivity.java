package cooperation.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class SecMsgPluginProxyActivity
  extends PluginProxyActivity
{
  public SecMsgPluginProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getPluginID()
  {
    return "secmsg_plugin.apk";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\SecMsgPluginProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */