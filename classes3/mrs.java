import android.os.Bundle;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class mrs
  implements BusinessObserver
{
  public mrs(TroopLowCreditLevelNotifyActivity paramTroopLowCreditLevelNotifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.d();
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "mGetTroopAppListObserver: !isSuccess");
      }
    }
    label130:
    do
    {
      Object localObject;
      do
      {
        do
        {
          for (;;)
          {
            return;
            paramBundle = paramBundle.getByteArray("data");
            localObject = new oidb_sso.OIDBSSOPkg();
            try
            {
              ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramBundle);
              paramInt = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
              if (paramInt == 0) {
                break label130;
              }
              if (QLog.isColorLevel())
              {
                QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "mGetTroopAppListObserver: result = " + paramInt);
                return;
              }
            }
            catch (Exception paramBundle) {}
          }
        } while (!QLog.isColorLevel());
        QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "mGetTroopAppListObserver: " + paramBundle.getMessage());
        return;
        paramBundle = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
        localObject = (TroopManager)this.a.app.getManager(51);
      } while ((Arrays.equals(paramBundle, ((TroopManager)localObject).a(this.a.b))) || (paramBundle == null));
      ((TroopManager)localObject).a(this.a.b, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "mGetTroopAppListObserver: Success");
      }
      paramBundle = this.a.a(1);
    } while (paramBundle == null);
    this.a.a(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */