import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class mwx
  implements View.OnClickListener
{
  public mwx(TroopRequestActivity paramTroopRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.d > 0L) && (l - TroopRequestActivity.d < 800L)) {
      return;
    }
    TroopRequestActivity.d = l;
    Bundle localBundle = TroopInfoActivity.a(this.a.r, 4);
    localBundle.putInt("t_s_f", 1001);
    int i = this.a.a.msg.group_msg_type.get();
    QQAppInterface localQQAppInterface;
    String str;
    if ((i == 2) || (i == 10) || (i == 12))
    {
      i = 1;
      localQQAppInterface = this.a.app;
      str = this.a.a.msg.group_code.get() + "";
      if (i == 0) {
        break label188;
      }
    }
    label188:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, paramView, "", "");
      ChatSettingForTroop.a(this.a, localBundle, 2);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */