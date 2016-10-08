package cooperation.dingdong.data;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DingdongOfficeOpenClient
{
  private TroopMemberApiClient a;
  
  public DingdongOfficeOpenClient(TroopMemberApiClient paramTroopMemberApiClient)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramTroopMemberApiClient;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("KeyReq", -1);
      if (i != -1)
      {
        TroopMemberApiClient.Callback localCallback = this.a.a(i);
        if (localCallback != null) {
          localCallback.a(paramBundle);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\data\DingdongOfficeOpenClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */