package cooperation.qzone;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;

public class QzonePluginProxyService
  extends PluginProxyService
{
  public QzonePluginProxyService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QzonePluginProxyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */