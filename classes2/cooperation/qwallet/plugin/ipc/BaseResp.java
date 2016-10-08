package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseResp
  extends BaseIpc
{
  public BaseResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static BaseResp getResp(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Object localObject = paramBundle.getString("_qwallet_ipc_class");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    try
    {
      ClassLoader localClassLoader = BaseIpc.class.getClassLoader();
      if (localClassLoader == null) {
        return null;
      }
      localObject = localClassLoader.loadClass((String)localObject);
      if (localObject == null) {
        return null;
      }
      localObject = (BaseResp)((Class)localObject).newInstance();
      ((BaseResp)localObject).fromBundle(paramBundle);
      return (BaseResp)localObject;
    }
    catch (Exception paramBundle) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\ipc\BaseResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */