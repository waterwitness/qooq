package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseIpc
{
  protected static final String BASE_IPC_CLASS_KEY = "_qwallet_ipc_class";
  
  public BaseIpc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void fromBundle(Bundle paramBundle) {}
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_qwallet_ipc_class", getClass().getName());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\ipc\BaseIpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */