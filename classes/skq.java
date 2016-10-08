import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class skq
  implements DialogInterface.OnClickListener
{
  public skq(ForwardBaseOption paramForwardBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    if (this.a.jdField_a_of_type_AndroidOsBundle != null) {
      bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("from_card", false);
    }
    if (bool)
    {
      localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("pubUin");
      paramDialogInterface = (DialogInterface)localObject1;
      if (localObject1 == null) {
        paramDialogInterface = "";
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramDialogInterface, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "");
    }
    paramInt = this.a.a().getInt("key_forward_ability_type");
    paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "-->getConfirmListener--onClick--type = " + paramInt);
    }
    for (;;)
    {
      try
      {
        if ((paramInt != ForwardAbility.ForwardAbilityType.f.intValue()) && (paramInt != ForwardAbility.ForwardAbilityType.l.intValue())) {
          continue;
        }
        this.a.b(paramInt);
      }
      catch (Throwable paramDialogInterface)
      {
        Object localObject2;
        Object localObject3;
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ForwardOption.ForwardBaseOption", 2, "Throwable", paramDialogInterface);
        continue;
        if (paramInt != ForwardAbility.ForwardAbilityType.k.intValue()) {
          continue;
        }
        this.a.t();
        continue;
        this.a.k();
        continue;
        paramInt = 1001;
        continue;
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", paramInt, 0, (String)localObject1, (String)localObject2, paramDialogInterface, (String)localObject3);
        continue;
        continue;
      }
      if (this.a.a(i, paramDialogInterface, paramInt)) {
        ThreadManager.c().postDelayed(new skr(this), 300L);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_report_confirm")))
      {
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_action_name");
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("forward_report_confirm_reverse2");
        paramDialogInterface = (DialogInterface)localObject1;
        if (localObject1 == null) {
          paramDialogInterface = "";
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramDialogInterface, paramDialogInterface, 0, 0, (String)localObject1, "", "", "");
      }
      bool = false;
      if (this.a.jdField_a_of_type_AndroidOsBundle != null)
      {
        bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("from_web", false);
        if (!bool) {
          continue;
        }
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_uin");
        if (localObject1 != null) {
          continue;
        }
        localObject1 = "";
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_url");
        paramDialogInterface = (DialogInterface)localObject2;
        if (localObject2 == null) {
          paramDialogInterface = "";
        }
        localObject3 = this.a.jdField_a_of_type_AndroidOsBundle.getString("strurt_msgid");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localObject3 = AccountDetailActivity.a(paramDialogInterface);
        if (paramInt != ForwardAbility.ForwardAbilityType.e.intValue()) {
          continue;
        }
        paramInt = 1002;
        str = this.a.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
        if ((str == null) || ("".equals(str))) {
          continue;
        }
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
        if ((localObject1 == null) || (paramInt == 1002)) {
          localObject1 = "";
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005B07", "0X8005B07", paramInt, 0, str, (String)localObject2, paramDialogInterface, (String)localObject3);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (!bool))
      {
        localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("source_puin");
        if (localObject2 != null)
        {
          paramDialogInterface = this.a.jdField_a_of_type_AndroidContentIntent.getByteArrayExtra("stuctmsg_bytes");
          if (paramDialogInterface != null)
          {
            localObject3 = StructMsgFactory.a(paramDialogInterface);
            if (localObject3 != null)
            {
              localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
              paramDialogInterface = (DialogInterface)localObject1;
              if (localObject1 == null) {
                paramDialogInterface = "";
              }
              ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramDialogInterface, "0X8005B06", "0X8005B06", 0, 0, (String)localObject2, "" + ((AbsStructMsg)localObject3).msgId, "", "");
            }
          }
        }
      }
      if (this.a.c) {
        ReportCenter.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.a.jdField_a_of_type_Long), "1000", "50", "0", false);
      }
      if ((this.a.jdField_a_of_type_AndroidOsBundle != null) && (this.a.jdField_a_of_type_AndroidOsBundle.getInt("extra_key_from_apollo") > 0)) {
        VipUtils.a(null, "cmshow", "Apollo", "QQSend", 0, 0, new String[0]);
      }
      return;
      if (paramInt != ForwardAbility.ForwardAbilityType.g.intValue()) {
        continue;
      }
      this.a.o();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\skq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */