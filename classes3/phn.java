import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

public class phn
  implements View.OnClickListener
{
  public phn(SelectMemberActivity paramSelectMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (this.a.Q == 11) {
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
        if (this.a.O == 3)
        {
          localObject1 = this.a.getIntent().getStringExtra("group_uin");
          localObject2 = TroopMemberUtil.a(this.a.app, this.a.app.a(), (String)localObject1) + "";
          if (!"发起视频".equals(this.a.e.getText().toString())) {
            break label360;
          }
        }
      }
    }
    label360:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, (String)localObject1, (String)localObject2, paramView, "");
      if (NetworkUtil.e(this.a)) {
        break label366;
      }
      QQToast.a(this.a, this.a.getString(2131367256), 0).b(this.a.b.getHeight());
      return;
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 2) {
        break;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
      break;
      if (this.a.Q != 10) {
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005522", "0X8005522", 0, 0, "", "", "", "");
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 2) {
        break;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005521", "0X8005521", 0, 0, "", "", "", "");
      break;
    }
    label366:
    paramView = this.a.i.iterator();
    do
    {
      if (!paramView.hasNext()) {
        break;
      }
    } while (((ResultRecord)paramView.next()).jdField_a_of_type_Int == 5);
    for (int i = 1;; i = 0)
    {
      if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ShowJoinDiscTips", false)) && (i != 0))
      {
        DialogUtil.a(this.a, 230, this.a.getString(2131363525), this.a.getString(2131368258), 2131363532, 2131363537, new pho(this), new php(this)).show();
        ReportController.b(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
        return;
      }
      if (this.a.Q == 12) {
        if (this.a.i.size() == 1)
        {
          localObject1 = (ResultRecord)this.a.i.get(0);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("select_memeber_single_friend", true);
          ((Intent)localObject2).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject1).jdField_a_of_type_Int);
          if ((((ResultRecord)localObject1).jdField_a_of_type_Int == 0) && (((ResultRecord)localObject1).jdField_a_of_type_Int != 1)) {
            break label1094;
          }
          i = 1000;
        }
      }
      for (paramView = this.a.a(((ResultRecord)localObject1).c);; paramView = null)
      {
        if (((ResultRecord)localObject1).jdField_a_of_type_Int == 2)
        {
          paramView = ((ResultRecord)localObject1).c;
          i = 1004;
        }
        for (;;)
        {
          if (((ResultRecord)localObject1).jdField_a_of_type_Int == 3) {
            i = 1021;
          }
          label1088:
          for (;;)
          {
            Object localObject3 = ((FriendsManager)this.a.app.getManager(50)).c(((ResultRecord)localObject1).jdField_a_of_type_JavaLangString);
            int j = i;
            if (localObject3 != null)
            {
              j = i;
              if (((Friends)localObject3).isFriend()) {
                j = 0;
              }
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("uin", ((ResultRecord)localObject1).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject3).putInt("uintype", j);
            ((Bundle)localObject3).putString("uinname", ((ResultRecord)localObject1).b);
            ((Bundle)localObject3).putString("troop_uin", paramView);
            ((Intent)localObject2).putExtras((Bundle)localObject3);
            this.a.setResult(-1, (Intent)localObject2);
            this.a.finish();
            for (;;)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
              return;
              if (((ResultRecord)localObject1).jdField_a_of_type_Int != 4) {
                break label1088;
              }
              i = 1006;
              break;
              this.a.h();
            }
            if (this.a.Q == 23)
            {
              paramView = new Intent();
              localObject1 = new Bundle();
              localObject2 = new ArrayList();
              localObject3 = this.a.i.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
                if (localResultRecord.jdField_a_of_type_Int == 1) {
                  ((ArrayList)localObject2).add(localResultRecord.jdField_a_of_type_JavaLangString);
                }
              }
              ((Bundle)localObject1).putStringArrayList("troopMemList", (ArrayList)localObject2);
              paramView.putExtras((Bundle)localObject1);
              this.a.setResult(-1, paramView);
              this.a.finish();
              return;
            }
            if (this.a.Q == 24)
            {
              paramView = new Intent();
              localObject1 = new Bundle();
              ((Bundle)localObject1).putParcelableArrayList("friendsSelected", this.a.i);
              paramView.putExtras((Bundle)localObject1);
              this.a.setResult(-1, paramView);
              if (this.a.w) {
                ReportController.b(null, "dc00899", "grp_story", "", "set_notsee", "clk_done", 0, 0, "", "", "", "");
              }
              for (;;)
              {
                this.a.finish();
                return;
                ReportController.b(null, "dc00899", "grp_story", "", "set_notletsee", "clk_done", 0, 0, "", "", "", "");
              }
            }
            this.a.h();
            return;
          }
        }
        label1094:
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\phn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */