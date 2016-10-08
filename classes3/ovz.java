import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GroupVideoHelper;

public class ovz
  implements View.OnClickListener
{
  public ovz(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    int j;
    if (BannerManager.a(this.a) != null)
    {
      localQQAppInterface = BannerManager.a(this.a).app;
      if (localQQAppInterface == null) {
        break label1086;
      }
      j = localQQAppInterface.a().g();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "initMultiVideoBar-->SessionType");
      }
      if ((j != 1) && (j != 2)) {
        break label300;
      }
      paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), AVActivity.class);
      if (localQQAppInterface.a().h() == 1011) {
        paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), RandomDoubleActivity.class);
      }
      paramView.addFlags(262144);
      paramView.addFlags(268435456);
      if (!localQQAppInterface.a().b(localQQAppInterface.a().f())) {
        break label228;
      }
      paramView.putExtra("sessionType", 3);
      paramView.putExtra("GroupId", localQQAppInterface.a().f());
      paramView.putExtra("isDoubleVideoMeeting", true);
      BannerManager.a(this.a).startActivity(paramView);
      BannerManager.a(this.a).overridePendingTransition(2130968683, 0);
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
    }
    label228:
    label300:
    Object localObject;
    do
    {
      return;
      localQQAppInterface = null;
      break;
      paramView.putExtra("sessionType", j);
      paramView.putExtra("uin", localQQAppInterface.a().f());
      BannerManager.a(this.a).startActivity(paramView);
      BannerManager.a(this.a).overridePendingTransition(2130968683, 0);
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
      return;
      if (j != 5) {
        break label476;
      }
      paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), PSTNC2CActivity.class);
      paramView.addFlags(262144);
      paramView.addFlags(268435456);
      localObject = new PstnSessionInfo();
      ((PstnSessionInfo)localObject).jdField_a_of_type_JavaLangString = localQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
      ((PstnSessionInfo)localObject).d = localQQAppInterface.a().a().d;
      ((PstnSessionInfo)localObject).jdField_b_of_type_JavaLangString = localQQAppInterface.a().a().jdField_b_of_type_JavaLangString;
      ((PstnSessionInfo)localObject).c = localQQAppInterface.a().a().c;
      ((PstnSessionInfo)localObject).jdField_a_of_type_Int = localQQAppInterface.a().a().jdField_a_of_type_Int;
      ((PstnSessionInfo)localObject).jdField_b_of_type_Int = localQQAppInterface.a().a().jdField_b_of_type_Int;
      paramView.putExtra("pstn_session_info", (Parcelable)localObject);
      BannerManager.a(this.a).startActivity(paramView);
      BannerManager.a(this.a).overridePendingTransition(2130968683, 0);
    } while (localQQAppInterface == null);
    PstnUtils.a(localQQAppInterface.a());
    return;
    label476:
    long l = BannerManager.a(this.a).app.a().a();
    int k = BannerManager.a(this.a).app.a().a();
    int m;
    label624:
    int i;
    if ((l != 0L) || (BannerManager.a(this.a).app.a().b() > 0))
    {
      m = localQQAppInterface.a().b(l);
      if (BannerManager.a(this.a).app.a().b() > 0) {
        if (localQQAppInterface.a().b() > 0L)
        {
          paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), GuildMultiActivity.class);
          ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80057ED", "0X80057ED", 0, 0, "", "", "", "");
          if (localQQAppInterface.a().a(k, l) <= 0L) {
            break label977;
          }
          if (!localQQAppInterface.a().a(k, l)) {
            break label971;
          }
          i = 2;
          label657:
          paramView.addFlags(262144);
          paramView.addFlags(268435456);
          paramView.putExtra("GroupId", String.valueOf(l));
          paramView.putExtra("Type", i);
          paramView.putExtra("sessionType", j);
          paramView.putExtra("uinType", UITools.b(k));
          paramView.putExtra("MultiAVType", m);
          if (m != 2) {
            break label983;
          }
          localObject = (TroopManager)localQQAppInterface.getManager(51);
          if ((localObject == null) || (((TroopManager)localObject).a(l + "") != null)) {
            break label1102;
          }
        }
      }
    }
    label971:
    label977:
    label983:
    label997:
    label1086:
    label1102:
    for (boolean bool = false;; bool = true)
    {
      paramView.putExtra("troopmember", bool);
      paramView.putExtra("Fromwhere", "SmallScreen");
      GroupVideoHelper.a(localQQAppInterface, BannerManager.a(this.a), paramView, 1);
      for (;;)
      {
        BannerManager.a(this.a).overridePendingTransition(2130968683, 0);
        if (k != 2) {
          break label997;
        }
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
        return;
        if (localQQAppInterface.a().c() == 1)
        {
          paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), RandomDoubleActivity.class);
          break label624;
        }
        if (localQQAppInterface.a().c() == 3)
        {
          paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), RandomMultiActivity.class);
          break label624;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MultiVideoBar", 2, "status error");
        return;
        if (m == 2)
        {
          paramView = new Intent();
          break label624;
        }
        paramView = new Intent(BannerManager.a(this.a).getApplicationContext(), AVActivity.class);
        break label624;
        i = 1;
        break label657;
        i = 0;
        break label657;
        BannerManager.a(this.a).startActivity(paramView);
      }
      if (k != 1) {
        break;
      }
      if (localQQAppInterface.a().b(l) == 10)
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "status error");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "app is null");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */