import android.os.Bundle;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.org.pb.TroopOrgProtocolManager;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RspBody;
import mqq.observer.BusinessObserver;

public class qhl
  implements BusinessObserver
{
  public qhl(TroopHandler paramTroopHandler, TroopOrgProtocolManager paramTroopOrgProtocolManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      paramBundle = (oidb_0x496.RspBody)this.jdField_a_of_type_ComTencentMobileqqTroopOrgPbTroopOrgProtocolManager.a(paramBundle)[1];
      if ((paramBundle != null) && (paramBundle.has())) {
        TroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler, paramBundle);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */