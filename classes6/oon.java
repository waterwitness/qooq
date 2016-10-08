import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.ContactsTroopActivity;

public class oon
  implements View.OnClickListener
{
  public oon(ContactListView paramContactListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.getContext(), ContactsTroopActivity.class);
    this.a.b(paramView, 1001);
    ReportController.b(this.a.a, "CliOper", "", "", "0X8005B38", "0X8005B38", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */