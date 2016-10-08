import android.os.Handler;
import com.tencent.mobileqq.activity.ModifyTroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class lvp
  implements Runnable
{
  public lvp(ModifyTroopMemberCardActivity paramModifyTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.app != null)
    {
      Object localObject = (TroopManager)this.a.app.getManager(51);
      if (localObject != null) {
        ((TroopManager)localObject).a(this.a.b, this.a.d, this.a.f, -100, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
      }
      TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.a.app, this.a.b, this.a.d);
      localObject = localTroopMemberCardInfo;
      if (localTroopMemberCardInfo == null)
      {
        localObject = new TroopMemberCardInfo();
        ((TroopMemberCardInfo)localObject).troopuin = this.a.b;
        ((TroopMemberCardInfo)localObject).memberuin = this.a.d;
      }
      ((TroopMemberCardInfo)localObject).nick = this.a.f;
      ((TroopMemberCardInfo)localObject).job = this.a.g.trim();
      ((TroopMemberCardInfo)localObject).tel = this.a.h.trim();
      ((TroopMemberCardInfo)localObject).email = this.a.i.trim();
      DBUtils.a().a(this.a.app, (TroopMemberCardInfo)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("ModifyTroopMemberCardActivity", 2, "修改群名片成功 写入db TroopNick:" + ((TroopMemberCardInfo)localObject).nick + " Job:" + ((TroopMemberCardInfo)localObject).job + " Tel:" + ((TroopMemberCardInfo)localObject).tel + " Email:" + ((TroopMemberCardInfo)localObject).email);
      }
      this.a.a.postDelayed(new lvq(this), 500L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */