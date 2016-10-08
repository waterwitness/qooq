import android.text.TextUtils;
import com.tencent.mobileqq.activity.ModifyTroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class lvj
  implements Runnable
{
  public lvj(ModifyTroopMemberCardActivity paramModifyTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.app != null)
    {
      if ((TextUtils.isEmpty(this.a.e)) && (this.a.d.equals(this.a.app.a()))) {
        this.a.e = this.a.a(this.a.b, this.a.d);
      }
      localTroopMemberCardInfo = DBUtils.a().a(this.a.app, this.a.b, this.a.d);
      this.a.a = localTroopMemberCardInfo;
      this.a.app.runOnUiThread(new lvk(this));
    }
    while (!QLog.isColorLevel())
    {
      TroopMemberCardInfo localTroopMemberCardInfo;
      return;
    }
    QLog.i("ModifyTroopMemberCardActivity", 2, "打开界面时从本地获取群个人资料卡页面数据失败");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */