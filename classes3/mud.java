import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;

public class mud
  implements TabBarView.OnTabChangeListener
{
  public mud(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1;
    if (paramInt2 == 0)
    {
      this.a.m = true;
      str2 = "1";
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "onTabSelected, isPositiveSort=" + this.a.m);
      }
      if (this.a.a != null) {
        this.a.a.a();
      }
      str1 = "";
      if (this.a.W != 1) {
        break label139;
      }
      str1 = "Clk_lastactivetime";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        this.a.a(str1, str2, this.a.F);
      }
      return;
      if (paramInt2 != 1) {
        break;
      }
      this.a.m = false;
      str2 = "0";
      break;
      label139:
      if (this.a.W == 2) {
        str1 = "Clk_mberlevel";
      } else if (this.a.W == 4) {
        str1 = "Clk_jointime";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */