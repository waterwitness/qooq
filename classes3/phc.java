import android.os.Handler;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class phc
  extends TroopObserver
{
  public phc(SelectMemberActivity paramSelectMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, byte paramByte)
  {
    if (paramInt == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member fail");
      }
      SelectMemberActivity.a(this.a, paramByte);
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 8)
    {
      if (paramByte != 0) {
        break label95;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member success");
      }
      this.a.a.sendEmptyMessage(0);
      if (!this.a.i)
      {
        paramInt = this.a.a();
        this.a.a(paramInt + 1);
        ReportController.b(this.a.app, "CliOper", "", "", "Grp", "Send_invite", 0, 0, "", "", "", "");
      }
    }
    return;
    label95:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add troop member fail, troopUin: " + paramString + " result: " + paramByte);
    }
    SelectMemberActivity.a(this.a, paramByte);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\phc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */