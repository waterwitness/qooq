import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

class tlo
  implements View.OnClickListener
{
  tlo(tlm paramtlm, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      ((Dialog)paramView.getTag()).dismiss();
      if ((paramView instanceof TextView))
      {
        paramView = ((TextView)paramView).getText().toString();
        if (!this.jdField_a_of_type_Tlm.a.getString(2131372138).equals(paramView)) {
          break label171;
        }
        paramView = this.jdField_a_of_type_Tlm.a.app.a();
        paramView = "http://ti.qq.com/meilizhigl/index.html?_wv=1027&isguest=[isguest]&uin=[uin]".replace("[isguest]", "0").replace("[uin]", paramView);
        Intent localIntent = new Intent(this.jdField_a_of_type_Tlm.a, QQBrowserActivity.class);
        localIntent.putExtra("url", paramView);
        this.jdField_a_of_type_Tlm.a.startActivity(localIntent);
        ReportController.b(this.jdField_a_of_type_Tlm.a.app, "CliOper", "", "", "0X8005671", "0X8005671", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        NearbyPeopleProfileActivity.a(this.jdField_a_of_type_Tlm.a).a(this.jdField_a_of_type_Int - this.b);
        return;
        label171:
        if (this.jdField_a_of_type_Tlm.a.getString(2131369982).equals(paramView))
        {
          this.jdField_a_of_type_Tlm.a.a(300L);
          ReportController.b(this.jdField_a_of_type_Tlm.a.app, "CliOper", "", "", "0X80052B0", "0X80052B0", 0, 0, "", "", "", "");
        }
        else if (!this.jdField_a_of_type_Tlm.a.getString(2131369401).equals(paramView)) {}
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */