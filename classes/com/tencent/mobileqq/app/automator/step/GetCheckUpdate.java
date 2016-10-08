package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate;
import com.tencent.biz.common.report.BnrReport.BnrReportCheckUpdate;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigCheckUpdateItem;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GetRichSig;
import com.tencent.mobileqq.app.PreloadInfoCheckUpdateItem;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountHandler.PublicAccountCheckUpdateItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ReqDpcInfoNewItem;
import com.tencent.mobileqq.app.ReqGetSettingsItem;
import com.tencent.mobileqq.app.ReqSystemMsgNewItem;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.WebViewCheckUpdataItem;
import com.tencent.mobileqq.profile.ProfileCardCheckUpdate;
import com.tencent.mobileqq.qcall.PstnInfoCheckUpdateItem;
import com.tencent.mobileqq.service.message.GetBlackListItem;
import com.tencent.mobileqq.service.profile.GetSimpleInfoCheckUpdateItem;
import com.tencent.mobileqq.util.QQSettingUtil.UserBitFlagCheckUpdate;
import qjf;

public class GetCheckUpdate
  extends AsyncStep
{
  qjf a;
  
  public GetCheckUpdate()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(1);
    if (this.h == 42) {}
    for (int i = 1;; i = 4)
    {
      localFriendListHandler.a(true, i);
      return 2;
    }
  }
  
  public void a()
  {
    super.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b;
    if (this.h == 42)
    {
      PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)localQQAppInterface.a(11);
      if (localPublicAccountHandler.c())
      {
        Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
        localPublicAccountHandler.getClass();
        localAutomator.a(102, new PublicAccountHandler.PublicAccountCheckUpdateItem(localPublicAccountHandler));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, new QQSettingUtil.UserBitFlagCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, new BnrReport.BnrReportCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(127, new OfflineExpire.OfflineExpireCheckUpdate(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(117, new ReqDpcInfoNewItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, new GetSimpleInfoCheckUpdateItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, new GetBlackListItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, new ReqSystemMsgNewItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, new ReqGetSettingsItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(122, new ProfileCardCheckUpdate(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new GetRichSig(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, new AioAnimationConfigCheckUpdateItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(123, new PreloadInfoCheckUpdateItem(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(126, new WebViewCheckUpdataItem(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(128, new PstnInfoCheckUpdateItem(localQQAppInterface, 128));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(129, new PstnInfoCheckUpdateItem(localQQAppInterface, 129));
    }
    if (this.jdField_a_of_type_Qjf == null)
    {
      this.jdField_a_of_type_Qjf = new qjf(this, null);
      localQQAppInterface.a(this.jdField_a_of_type_Qjf);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qjf != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_Qjf);
      this.jdField_a_of_type_Qjf = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetCheckUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */