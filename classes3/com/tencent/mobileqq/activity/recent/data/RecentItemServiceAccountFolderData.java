package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class RecentItemServiceAccountFolderData
  extends RecentUserBaseData
{
  private static final String a = RecentItemServiceAccountFolderData.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecentItemServiceAccountFolderData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.G = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    label31:
    ServiceAccountFolderManager localServiceAccountFolderManager;
    if (PublicAccountConfigUtil.a)
    {
      this.K |= 0x1;
      localServiceAccountFolderManager = ServiceAccountFolderManager.a();
      this.jdField_b_of_type_JavaLangString = ServiceAccountFolderManager.a(paramQQAppInterface);
      this.jdField_b_of_type_Long = localServiceAccountFolderManager.a(paramQQAppInterface);
      this.H = localServiceAccountFolderManager.b();
      if (this.H > 0) {
        break label425;
      }
      if ((!localServiceAccountFolderManager.a()) || (this.jdField_b_of_type_Long <= localServiceAccountFolderManager.c())) {
        break label417;
      }
      this.G = 2;
      this.H = 1;
      label96:
      if (this.jdField_b_of_type_Long == 0L) {
        break label433;
      }
      this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
      label123:
      this.jdField_b_of_type_JavaLangCharSequence = localServiceAccountFolderManager.a(paramQQAppInterface);
      if (!localServiceAccountFolderManager.b()) {
        break label445;
      }
      this.F = 4;
      label144:
      if ((this.H <= 0) || (this.G != 1)) {
        break label453;
      }
      this.jdField_c_of_type_JavaLangCharSequence = localServiceAccountFolderManager.a();
      this.J = paramContext.getResources().getColor(2131428324);
    }
    for (;;)
    {
      if (AppSetting.j)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
        if (this.jdField_c_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
        this.d = paramQQAppInterface.toString();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(a, 2, "mTitleName:" + this.jdField_b_of_type_JavaLangString + ", mDisplayTime:" + this.jdField_b_of_type_Long + ", mUnreadNum:" + this.H + ", mUnreadFlag:" + this.G + ", mShowTime:" + this.jdField_c_of_type_JavaLangString + ", mStatus:" + this.F + ", mMsgExtroInfo:" + this.jdField_c_of_type_JavaLangCharSequence + ", mExtraInfoColor:" + this.J + ", mLastMsg:" + this.jdField_b_of_type_JavaLangCharSequence);
      return;
      this.K &= 0xFFFFFFFE;
      break label31;
      label417:
      this.G = 0;
      break label96;
      label425:
      this.G = 1;
      break label96;
      label433:
      this.jdField_c_of_type_JavaLangString = localServiceAccountFolderManager.b(paramQQAppInterface);
      break label123;
      label445:
      this.F = 0;
      break label144;
      label453:
      this.jdField_c_of_type_JavaLangCharSequence = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemServiceAccountFolderData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */