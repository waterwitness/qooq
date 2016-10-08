import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.ims.AccountSecurityInfo.AccSecInfoRequire;
import com.tencent.mobileqq.activity.SecurityDetectActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import mqq.app.NewIntent;

public class mkb
  extends Handler
{
  private static final int b = 4;
  private int jdField_a_of_type_Int;
  
  public mkb(SecurityDetectActivity paramSecurityDetectActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool1;
    Object localObject2;
    View localView;
    label319:
    int i;
    switch (paramMessage.what)
    {
    default: 
    case 9: 
      do
      {
        return;
        paramMessage = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304849);
      } while (paramMessage == null);
      if (this.jdField_a_of_type_Int >= 4)
      {
        paramMessage.setVisibility(4);
        return;
      }
      paramMessage.setVisibility(0);
      this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % 4);
      switch (this.jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        sendEmptyMessageDelayed(9, 500L);
        return;
        paramMessage.setText(2131370780);
        continue;
        paramMessage.setText(2131370781);
        continue;
        paramMessage.setText(2131370782);
        continue;
        paramMessage.setText("");
      }
    case 1: 
      bool1 = JumpQqPimSecureUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity);
      boolean bool2 = JumpQqPimSecureUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity);
      if (!bool1)
      {
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, 2);
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304856);
        localObject2 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304855);
        localView = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304854);
        ((ProgressBar)localObject2).setVisibility(8);
        localView.setVisibility(0);
        if (SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) == 0) {
          break label487;
        }
        localView.setBackgroundResource(2130837638);
        ((TextView)localObject1).setText(2131370794);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131428329));
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setVisibility(8);
        ((TextView)localObject1).setVisibility(0);
        ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304857)).setVisibility(0);
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "qqpimsecure status " + SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity), 0, 0, "", "", "", "");
        if (paramMessage.arg1 != 1) {
          break label530;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label536;
        }
        ((ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304860)).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304859).setVisibility(8);
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendMessage(SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).obtainMessage(2, 1, 0));
        return;
        if (!bool2)
        {
          SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, 1);
          break;
        }
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, 0);
        break;
        localView.setBackgroundResource(2130838061);
        ((TextView)localObject1).setText(2131370793);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131428303));
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setVisibility(0);
        break label319;
      }
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(8, 1000L);
      return;
    case 2: 
      localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304861);
      localObject2 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304860);
      localView = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304859);
      ((ProgressBar)localObject2).setVisibility(8);
      localView.setVisibility(0);
      ((TextView)localObject1).setVisibility(0);
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, null, "security_scan_key", "qqsetting_security_scan_key", false));
      if (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity))
      {
        localView.setBackgroundResource(2130837638);
        ((TextView)localObject1).setText(2131370797);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131428329));
        ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304862)).setVisibility(0);
        if (paramMessage.arg1 != 1) {
          break label820;
        }
        i = 1;
        if (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity)) {
          break label826;
        }
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "login secure open", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if (i == 0) {
          break label853;
        }
        ((ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304865)).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304864).setVisibility(8);
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendMessage(SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).obtainMessage(3, 1, 0));
        return;
        localView.setBackgroundResource(2130838061);
        ((TextView)localObject1).setText(2131370796);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131428303));
        break;
        i = 0;
        break label694;
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "login secure close", 0, 0, "", "", "", "");
      }
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(8, 1000L);
      return;
    case 3: 
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity;
      if (paramMessage.arg1 == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        SecurityDetectActivity.b((SecurityDetectActivity)localObject1, bool1);
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304864);
        localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304865);
        paramMessage.setVisibility(8);
        ((ProgressBar)localObject1).setVisibility(0);
        paramMessage = new AccountSecurityInfo.AccSecInfoRequire();
        paramMessage.str_version.set("6.5.5");
        paramMessage.u64_uin.set(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.getLongAccountUin());
        paramMessage.u32_client_type.set(0);
        paramMessage = paramMessage.toByteArray();
        localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, ProtoServlet.class);
        ((NewIntent)localObject1).putExtra("data", paramMessage);
        ((NewIntent)localObject1).putExtra("cmd", "DevLockSecSvc.AccountDetect");
        ((NewIntent)localObject1).setObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.startServlet((NewIntent)localObject1);
        return;
      }
    case 4: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304871);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
      paramMessage = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304872);
      if (paramMessage != null) {
        paramMessage.setVisibility(8);
      }
      paramMessage = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304873);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304875);
      if (paramMessage != null) {
        paramMessage.setVisibility(8);
      }
      paramMessage = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304876);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(5, 1000L);
      return;
    case 5: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304875);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304876);
      paramMessage.setVisibility(0);
      ((ProgressBar)localObject1).setVisibility(8);
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304877)).setVisibility(0);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304879);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304880);
      paramMessage.setVisibility(8);
      ((ProgressBar)localObject1).setVisibility(0);
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(6, 1000L);
      return;
    case 6: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304879);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304880);
      paramMessage.setVisibility(0);
      ((ProgressBar)localObject1).setVisibility(8);
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304881)).setVisibility(0);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304883);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304884);
      paramMessage.setVisibility(8);
      ((ProgressBar)localObject1).setVisibility(0);
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(7, 1000L);
      return;
    case 7: 
      label487:
      label530:
      label536:
      label694:
      label820:
      label826:
      label853:
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304883);
      localObject1 = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304884);
      paramMessage.setVisibility(0);
      ((ProgressBar)localObject1).setVisibility(8);
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304885)).setVisibility(0);
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).sendEmptyMessageDelayed(8, 1000L);
      return;
    }
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getSharedPreferences("SecurityDetectActivity", 0).edit();
    paramMessage.putLong("PimscureStatus" + this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.getAccount(), SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity));
    paramMessage.putLong("AccountStatus" + this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.getAccount(), SecurityDetectActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity));
    paramMessage.putLong("LastDetectTime" + this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.app.getAccount(), System.currentTimeMillis());
    paramMessage.commit();
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources();
    Object localObject1 = paramMessage.getString(2131370785);
    SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131297388));
    SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setVisibility(8);
    SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304852));
    int j;
    if (SecurityDetectActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) != 0)
    {
      SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setImageResource(2130842910);
      localObject1 = (String)localObject1 + paramMessage.getString(2131370788);
      localObject2 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304850);
      i = 1;
      if (SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) != 0) {
        i = 2;
      }
      j = i;
      if (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity)) {
        j = i + 1;
      }
      ((TextView)localObject2).setText(String.format(paramMessage.getString(2131370784), new Object[] { Integer.valueOf(j) }));
      ((TextView)localObject2).setVisibility(0);
      paramMessage = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131300667);
      paramMessage.setText((CharSequence)localObject1);
      paramMessage.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131428329));
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 4;
      SecurityDetectActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity, false);
      return;
      if ((SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) != 0) || (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity)))
      {
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setImageResource(2130842911);
        localObject1 = (String)localObject1 + paramMessage.getString(2131370787);
        localObject2 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304850);
        i = 0;
        if (SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity) != 0) {
          i = 1;
        }
        j = i;
        if (!SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity)) {
          j = i + 1;
        }
        ((TextView)localObject2).setText(String.format(paramMessage.getString(2131370784), new Object[] { Integer.valueOf(j) }));
        ((TextView)localObject2).setVisibility(0);
        paramMessage = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131300667);
        paramMessage.setText((CharSequence)localObject1);
        paramMessage.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131428337));
      }
      else
      {
        SecurityDetectActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity).setImageResource(2130842908);
        paramMessage = (String)localObject1 + paramMessage.getString(2131370786);
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304850);
        ((TextView)localObject1).setText(2131370789);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131304851)).setVisibility(0);
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.findViewById(2131300667);
        ((TextView)localObject1).setText(paramMessage);
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySecurityDetectActivity.getResources().getColor(2131428314));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */