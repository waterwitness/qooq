package cooperation.secmsg.ipc;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseResp
  extends BaseIpc
{
  public BaseResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static BaseResp a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("_secmsg_ipc_code", -1);
    Object localObject = (Class)b.get(i);
    if (localObject != null) {
      try
      {
        localObject = (BaseResp)((Class)localObject).newInstance();
        ((BaseResp)localObject).b(paramBundle);
        return (BaseResp)localObject;
      }
      catch (Exception paramBundle)
      {
        return null;
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\ipc\BaseResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */