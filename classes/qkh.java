import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qkh
  extends TroopObserver
{
  private qkh(UpdateTroop paramUpdateTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "updateTroopList:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(6);
      return;
    }
    UpdateTroop.a(this.a).a.edit().putBoolean("isTrooplistok", true).commit();
    UpdateTroop.b(this.a).a(3, true, Integer.valueOf(2));
    this.a.a(7);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */