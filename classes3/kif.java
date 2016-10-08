import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kif
  implements DialogInterface.OnClickListener
{
  public kif(AddFriendLogicActivity paramAddFriendLogicActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "P_CliOper", "Safe_AntiFraud", this.a.app.a(), "AlertDialog", "UserClick", 0, AddFriendLogicActivity.c(this.a), "", "", "", "");
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */