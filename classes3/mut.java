import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;

public class mut
  implements View.OnClickListener
{
  public mut(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof String))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnPhoneCallClickListener onclick");
      }
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramView));
    if ((!MobileIssueSettings.a) && (KapalaiAdapterUtil.a().a())) {
      KapalaiAdapterUtil.a().a(localIntent);
    }
    this.a.startActivity(localIntent);
    this.a.app.a().b(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X80058F7", "0X80058F7", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */