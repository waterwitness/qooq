import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.TroopRequestRefuseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopProxyActivity;
import java.util.ArrayList;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class mxa
  implements View.OnClickListener
{
  public mxa(TroopRequestActivity paramTroopRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((!NetworkUtil.e(this.a)) && ((paramView != this.a.b) || ((this.a.c != 1) && (this.a.c != 22)))) {
      QQToast.a(this.a, this.a.getString(2131367481), 0).b(this.a.getTitleBarHeight());
    }
    String str2;
    label462:
    label663:
    label853:
    label941:
    label1184:
    do
    {
      do
      {
        String str1;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    this.a.jdField_a_of_type_Boolean = this.a.getIntent().getExtras().getBoolean("is_unread");
                    str2 = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                    str1 = "0";
                    i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
                    if (this.a.jdField_a_of_type_Boolean) {
                      str1 = "1";
                    }
                    if (paramView != this.a.jdField_a_of_type_AndroidWidgetButton) {
                      break;
                    }
                    if (((TroopManager)this.a.app.getManager(51)).a(this.a.r) != null) {}
                    while (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
                    {
                      paramView = new Intent(this.a.getActivity(), TroopProxyActivity.class);
                      paramView.putExtra("troop_uin", this.a.r);
                      paramView.putExtra("key_is_need_update_Group_info", true);
                      this.a.startActivity(paramView);
                      TroopProxyActivity.a(this.a, paramView, this.a.app.a(), -1);
                      return;
                      TroopRemindSettingManager.a().b(this.a.r, this.a.app);
                    }
                    if (i == 2)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "doCheckPayTroopReq start: " + str2);
                      }
                      this.a.h();
                      TroopRequestActivity.a(this.a, this.a.app, str2, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback);
                      i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
                      if ((i != 2) && (i != 3))
                      {
                        i = 1;
                        if (i == 0) {
                          break label462;
                        }
                      }
                      for (paramView = "0";; paramView = "1")
                      {
                        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, str2, str1, paramView, "1");
                        return;
                        i = 0;
                        break;
                      }
                    }
                    if (i == 82)
                    {
                      this.a.h();
                      TroopRequestActivity.a(this.a, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
                      ReportController.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "focus_invite", 0, 0, "", "", "", this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
                      return;
                    }
                  } while (!TroopRequestActivity.a(this.a, 1));
                  this.a.h();
                } while (i != 1);
                if ((this.a.L == null) || ("".equals(this.a.L)))
                {
                  i = 1;
                  if (i == 0) {
                    break label663;
                  }
                }
                for (paramView = "1";; paramView = "0")
                {
                  ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, str2, str1, paramView, "1");
                  return;
                  i = 0;
                  break;
                }
                if (paramView != this.a.b) {
                  break;
                }
                if ((this.a.c == 1) || (this.a.c == 22))
                {
                  paramView = new Intent(this.a, TroopRequestRefuseActivity.class);
                  this.a.startActivityForResult(paramView, 1005);
                  ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask_has_reason", 0, 0, str2, str1, "", "1");
                  return;
                }
              } while (!TroopRequestActivity.a(this.a, 0));
              this.a.h();
              if (i == 1)
              {
                if ((this.a.L == null) || ("".equals(this.a.L)))
                {
                  i = 1;
                  if (i == 0) {
                    break label853;
                  }
                }
                for (paramView = "1";; paramView = "0")
                {
                  ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, str2, str1, paramView, "1");
                  return;
                  i = 0;
                  break;
                }
              }
            } while (i != 2);
            i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
            if ((i != 2) && (i != 3))
            {
              i = 1;
              if (i == 0) {
                break label941;
              }
            }
            for (paramView = "0";; paramView = "1")
            {
              ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, str2, str1, paramView, "1");
              return;
              i = 0;
              break;
            }
            if (paramView != this.a.rightViewText) {
              break;
            }
            if (this.a.c == 82)
            {
              if (TroopRequestActivity.a(this.a, 0)) {
                this.a.h();
              }
              ReportController.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "ignore_invite", 0, 0, "", "", "", this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
            }
          } while (!TroopRequestActivity.a(this.a, 2));
          this.a.h();
          if (i == 1)
          {
            ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "ignore_ask", 0, 0, str2, str1, "", "");
            return;
          }
        } while (i != 2);
        int i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
        if ((i != 2) && (i != 3))
        {
          i = 1;
          if (i == 0) {
            break label1184;
          }
        }
        for (paramView = "0";; paramView = "1")
        {
          ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "ignore_invite", 0, 0, str2, str1, paramView, "");
          return;
          i = 0;
          break;
        }
      } while (paramView != this.a.h);
      if (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
      {
        paramView = TroopInfoActivity.a(this.a.r, 5);
        TroopInfoActivity.a(this.a.getActivity(), paramView);
        return;
      }
      if (((TroopManager)this.a.app.getManager(51)).a(this.a.r) != null) {}
      while (((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 11) && (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 3)) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 7))
      {
        this.a.h();
        TroopRequestActivity.a(this.a, this.a.app, str2, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback);
        ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "again_join", 0, 0, str2, "", "", "");
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "refuse_retry", "req_pay_troop_getPrivilege", 0, 0, "", "", "", "");
        return;
        TroopRemindSettingManager.a().b(this.a.r, this.a.app);
      }
    } while ((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 10) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 3));
    this.a.h();
    paramView = new ArrayList();
    paramView.add(TroopRequestActivity.a(this.a));
    if ((paramView.size() > 0) && (this.a.r.length() > 0)) {
      ((TroopHandler)this.a.app.a(20)).a(this.a.r, paramView, "");
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "again_invite", 0, 0, str2, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */