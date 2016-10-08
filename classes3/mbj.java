import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class mbj
  implements AdapterView.OnItemClickListener
{
  public mbj(PublicAccountListActivity paramPublicAccountListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    paramView = paramView.getTag();
    if ((paramView instanceof mbv)) {}
    String str;
    do
    {
      paramAdapterView = ((mbv)paramView).a;
      while (paramAdapterView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w(PublicAccountListActivity.a, 2, "onItemClick - info = null[position = " + paramInt + "]");
        }
        return;
        if ((paramView instanceof mbw)) {
          paramAdapterView = ((mbw)paramView).a;
        }
      }
      paramView = new Intent(this.a, ChatActivity.class);
      str = paramAdapterView.a.getUin();
      paramInt = 1008;
      if (paramAdapterView.a.extendType == 2)
      {
        paramView.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      if (!TextUtils.isEmpty(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w(PublicAccountListActivity.a, 2, "onItemClick - uin = null");
    return;
    paramView.putExtra("uin", str);
    paramView.putExtra("uintype", paramInt);
    paramView.putExtra("uinname", paramAdapterView.a.name);
    paramView.putExtra("selfSet_leftViewText", this.a.getString(2131371914));
    paramView.putExtra("jump_from", 3);
    this.a.startActivity(paramView);
    PublicAccountHandler.a(this.a.app, str, "Pb_account_lifeservice", "mp_msg_sys_4", "contacts_aio");
    ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, str, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */