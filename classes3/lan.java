import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x5be.Oidb_0x5be.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class lan
  implements BusinessObserver
{
  public lan(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((!paramBoolean) || (this.a.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "mGetTroopAppListObserver: !isSuccess || mTroopInfoData == null");
      }
      ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, -1, this.a.a.troopUin, Boolean.toString(paramBoolean), "", "");
    }
    Object localObject;
    TroopManager localTroopManager;
    do
    {
      return;
      paramBundle = paramBundle.getByteArray("data");
      localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramBundle);
        paramInt = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (paramInt != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.chatopttroop", 2, "mGetTroopAppListObserver: result = " + paramInt);
          }
          ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, paramInt, this.a.a.troopUin, "", "", "");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop", 2, "mGetTroopAppListObserver: " + paramBundle.getMessage());
        }
        ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, -2, this.a.a.troopUin, "wrong data", "", "");
        return;
      }
      ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, 0, this.a.a.troopUin, "", "", "");
      paramBundle = new Oidb_0x5be.RspBody();
      localObject = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
      localTroopManager = (TroopManager)this.a.app.getManager(51);
    } while ((Arrays.equals((byte[])localObject, localTroopManager.a(this.a.a.troopUin))) || (localObject == null));
    localTroopManager.a(this.a.a.troopUin, (byte[])localObject);
    paramBundle.mergeFrom((byte[])localObject);
    this.a.a(paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */