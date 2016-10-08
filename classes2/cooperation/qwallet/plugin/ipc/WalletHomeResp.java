package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class WalletHomeResp
  extends BaseResp
{
  public ArrayList resp;
  public int type;
  
  public WalletHomeResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.resp = ((ArrayList)paramBundle.getSerializable("_qwallet_ipc_WalletHome_resp"));
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    if (this.resp != null) {
      paramBundle.putSerializable("_qwallet_ipc_WalletHome_resp", this.resp);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\ipc\WalletHomeResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */