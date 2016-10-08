import EncounterSvc.RespEncounterInfo;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.AdViewHolder;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter.ViewHolder;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.nearpeople.EncounterHolder;
import com.tencent.mobileqq.nearpeople.EncounterHolder.EncounterHolderOpt;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.qphone.base.util.QLog;

public class snm
  implements View.OnClickListener
{
  public snm(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof PeopleAroundAdapter.ViewHolder))
    {
      paramView = (PeopleAroundAdapter.ViewHolder)paramView.getTag();
      if (!(paramView.a instanceof EncounterHolder.EncounterHolderOpt)) {
        return;
      }
      localObject = ((EncounterHolder.EncounterHolderOpt)paramView.a).a.encounter;
      NearbyCmdHelper.a(5, this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, (RespEncounterInfo)localObject, this.a.q);
      NearbyFragment.a(this.a, String.valueOf(((RespEncounterInfo)localObject).lEctID));
      NearbyFragment.a(this.a, String.valueOf(((RespEncounterInfo)localObject).tiny_id));
      if (String.valueOf(((RespEncounterInfo)localObject).lEctID).equals(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a())) {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent() == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getIntExtra("FROM_WHERE", -1) != 0) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getIntent().getBooleanExtra("IS_HAS_REDTOUCH", false))) {
          break label1015;
        }
      }
    }
    label321:
    label926:
    label1015:
    for (int i = 1;; i = 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X800482F", "0X800482F", 0, 0, "1", "", "", "");
      if (((RespEncounterInfo)localObject).iVoteIncrement > 0)
      {
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
        if (i == 0) {
          break label321;
        }
      }
      for (i = 1;; i = 0)
      {
        paramView.c("CliOper", "", "", "0X8004ED8", "0X8004ED8", i, 0, "", "", "", "");
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter.a.b = true;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(0);
        }
        ThreadManager.a(new snn(this), 5, null, false);
        return;
      }
      NearbyFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramView.b, true);
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(1);
      }
      if ((((RespEncounterInfo)localObject).host_flag == 1) && (((RespEncounterInfo)localObject).host_online_flag == 1) && (((RespEncounterInfo)localObject).tiny_id > 0L)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "list_click", 0, 0, String.valueOf(((RespEncounterInfo)localObject).tiny_id), "", "yes", "android");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUserBehaviorReport.b(1);
      }
      if ((((RespEncounterInfo)localObject).host_flag == 1) && (((RespEncounterInfo)localObject).host_online_flag == 1) && (((RespEncounterInfo)localObject).tiny_id > 0L)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "list_click", 0, 0, String.valueOf(((RespEncounterInfo)localObject).tiny_id), "", "yes", "android");
      }
      NearbyFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramView.b, true);
      return;
      if (!(paramView.getTag() instanceof PeopleAroundAdapter.AdViewHolder)) {
        break;
      }
      paramView = (PeopleAroundAdapter.AdViewHolder)paramView.getTag();
      if (paramView.a == null) {
        break;
      }
      paramView = paramView.a;
      if (!(paramView instanceof AdData)) {
        break;
      }
      paramView = (AdData)paramView;
      i = 0;
      if (!TextUtils.isEmpty(paramView.actionData)) {}
      try
      {
        localObject = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class);
        ((Intent)localObject).setData(Uri.parse(paramView.actionData));
        this.a.startActivity((Intent)localObject);
        i = 1;
        if (QLog.isColorLevel()) {
          QLog.d("NearbyFragment", 2, "actionData: " + paramView.actionData);
        }
        if ((i == 0) && (paramView.jump_url != null) && (paramView.jump_url.length() > 0)) {
          if (!paramView.jump_url.startsWith("http://")) {
            break label926;
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            localObject = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramView.jump_url));
            this.a.startActivity((Intent)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("NearbyFragment", 2, "click ad pos=" + paramView.position + " src=" + paramView.ad_source + " jump=" + paramView.jump_url);
            }
            AdData.reportTValue(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramView.position, paramView.ad_source, false);
            if (paramView.ad_source != 0) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8005B67", "0X8005B67", 0, 0, Integer.toString(paramView.position), "", "", "");
            return;
            localException1 = localException1;
            if (QLog.isColorLevel()) {
              QLog.d("NearbyFragment", 2, "jumpNativeSuccess, " + localException1);
            }
            i = 0;
          }
          catch (Exception localException2)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("NearbyFragment", 2, "click ad error, " + localException2);
            continue;
          }
          if (paramView.jump_url.startsWith("mqqapi://"))
          {
            try
            {
              Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, JumpActivity.class);
              localIntent.setData(Uri.parse(paramView.jump_url));
              this.a.startActivity(localIntent);
            }
            catch (Exception localException3) {}
            if (QLog.isColorLevel()) {
              QLog.d("NearbyFragment", 2, "click ad error, " + localException3);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */