import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qiv
  extends PublicAccountObserver
{
  private qiv(CheckPublicAccount paramCheckPublicAccount)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "PublicAccount onUpdateUserFollowList:" + paramBoolean + " " + paramInt);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      CheckPublicAccount.a(this.a).a.edit().putBoolean("isPublicAccountListOK", true).commit();
      this.a.a(7);
    }
    while (paramInt == 0) {
      return;
    }
    this.a.a(6);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */