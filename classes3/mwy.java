import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class mwy
  implements View.OnClickListener
{
  public mwy(TroopRequestActivity paramTroopRequestActivity)
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
    if (((FriendsManager)this.a.app.getManager(50)).b(this.a.G)) {
      paramView = new ProfileActivity.AllInOne(this.a.G, 1);
    }
    for (;;)
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.a.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.a, paramView);
      return;
      if ((this.a.a.msg.group_msg_type.get() != 2) || (this.a.a.msg.sub_type.get() != 3)) {
        break;
      }
      paramView = new ProfileActivity.AllInOne(this.a.G, 26);
      paramView.d = 1;
    }
    paramView = new ProfileActivity.AllInOne(this.a.G, 24);
    switch (this.a.c)
    {
    }
    for (;;)
    {
      break;
      paramView.k = 3;
      break;
      paramView.k = 1;
      break;
      paramView.k = 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */