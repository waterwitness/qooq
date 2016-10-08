package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;
import java.util.Set;

public class ForwardArkMsgOption
  extends ForwardBaseOption
{
  public ForwardArkMsgOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
      }
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct"))
    {
      b();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    return true;
  }
  
  protected boolean b()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    localSessionInfo.b = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    if ((localSessionInfo.jdField_a_of_type_Int < 0) || (TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_name");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_view");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_ver");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_meta");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_config");
    String str6 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_compat");
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
    {
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "0", "2000", "2006", "1", false);
      }
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_app_direct")) {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "0", "2000", "2006", "0", false);
    }
    localObject1 = new ArkAppMessage(str3, (String)localObject2, str1, (String)localObject1, str2, str4, str5, str6);
    localObject2 = (ArkAppMessage)ArkAppCenterCheckEvent.a(2, (String)localObject2, this.jdField_a_of_type_AndroidOsBundle, localObject1);
    if (localObject2 == null) {}
    for (;;)
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, (ArkAppMessage)localObject1);
      return true;
      localObject1 = localObject2;
    }
  }
  
  protected boolean c()
  {
    b();
    return super.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardArkMsgOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */