import android.os.Bundle;
import com.tencent.mobileqq.activity.ModifyTroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class lvo
  implements BusinessObserver
{
  public lvo(ModifyTroopMemberCardActivity paramModifyTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("data");
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      localOIDBSSOPkg.mergeFrom(paramBundle);
      int i = localOIDBSSOPkg.uint32_result.get();
      if ((!paramBoolean) || (i != 0))
      {
        this.a.a();
        paramInt = 2131367951;
        if (i == 1015) {
          paramInt = 2131367952;
        }
        this.a.a(paramInt, 1);
        if (QLog.isColorLevel()) {
          QLog.i("ModifyTroopMemberCardActivity", 2, "修改群名片失败 resultCode:" + i);
        }
      }
      else
      {
        ModifyTroopMemberCardActivity.a(this.a);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      this.a.a();
      if (QLog.isColorLevel()) {
        QLog.i("ModifyTroopMemberCardActivity", 2, "修改群名片回包解压失败" + paramBundle.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */