package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopRequestActivity$NumberSpan
  extends URLSpan
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  public TroopRequestActivity$NumberSpan(TroopRequestActivity paramTroopRequestActivity, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    super(paramString1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.b = paramBoolean1;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.c > 0L) && (l - TroopRequestActivity.c < 800L)) {
      return;
    }
    TroopRequestActivity.c = l;
    getURL();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.a.msg.group_msg_type.get();
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.r, 4);
      ((Bundle)localObject).putInt("t_s_f", 1001);
      QQAppInterface localQQAppInterface;
      String str;
      if ((i == 2) || (i == 10) || (i == 12))
      {
        i = 1;
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app;
        str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.a.msg.group_code.get() + "";
        if (i == 0) {
          break label200;
        }
      }
      label200:
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, paramView, "", "");
        ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, (Bundle)localObject, 2);
        return;
        i = 0;
        break;
      }
    }
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app.getManager(50)).b(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      paramView = "";
      if (this.b)
      {
        if (i != 11) {
          break label413;
        }
        paramView = "0";
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.a.msg.group_code.get() + "", paramView, "", "");
      ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, (ProfileActivity.AllInOne)localObject);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.a.msg.group_msg_type.get() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.a.msg.sub_type.get() == 3))
      {
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 26);
        ((ProfileActivity.AllInOne)localObject).d = 1;
        break;
      }
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 24);
      break;
      label413:
      if ((i == 3) || (i == 15) || (i == 16)) {
        paramView = "1";
      } else if ((i == 6) || (i == 7)) {
        paramView = "2";
      } else {
        paramView = "3";
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14697741);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopRequestActivity$NumberSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */