package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ActiveAccount
  extends AsyncStep
{
  public ActiveAccount()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onInitState: " + this.a.b.getAccount());
    }
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_AndroidContentSharedPreferences = this.a.b.a().getSharedPreferences("acc_info" + this.a.b.getAccount(), 0);
    QQAppInterface localQQAppInterface = this.a.b;
    ThemeUtil.initTheme(localQQAppInterface);
    localQQAppInterface.a(true);
    SubAccountControll.a(localQQAppInterface);
    localQQAppInterface.b();
    UniformDownloadMgr.a().b();
    UnifiedMonitor.a().b();
    OpenApiManager.a().a(localQQAppInterface);
    if (TroopNotificationUtils.a(localQQAppInterface.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
      }
      localQQAppInterface.a().d("last_group_seq", 0L);
      TroopNotificationUtils.a(localQQAppInterface.a(), false);
      localQQAppInterface.a().d("last_friend_seq_47", 0L);
    }
    if (AnonymousChatHelper.a != null) {
      AnonymousChatHelper.a().a();
    }
    return 7;
  }
  
  public void a() {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\ActiveAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */