package com.tencent.mobileqq.app;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import pyu;
import pyv;
import pyx;

public class HotChatShare
{
  public static final String a = "HotChatShare";
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  public int a;
  public BaseActivity a;
  private FriendListObserver a;
  public QQAppInterface a;
  public HotChatInfo a;
  public QQProgressDialog a;
  public String b;
  public String c;
  
  public HotChatShare(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = null;
    this.c = null;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new pyu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramHotChatInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void d()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.joinUrl != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.joinUrl.indexOf("hotnamecode=");
      if (i == -1) {}
    }
    for (String str1 = this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.joinUrl.substring(i + 12);; str1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, "handleHotChatShare.mTroop.joinUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.joinUrl + ",hotnamecode=" + str1);
      }
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      String str3 = HotChatHelper.a(str1, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate);
      if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate != 1)
      {
        HotChatHelper.a(2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, str3, str1, "我在[" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name + "]热聊，邀请你加入!", "立即加入，一起热聊！", null, null);
        return;
      }
      String str2 = "速来围观!";
      if (!TextUtils.isEmpty(this.b)) {
        str2 = "房主是" + this.b + ",速来围观!";
      }
      String str4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(32, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin, 200);
      HotChatHelper.a(2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, str3, str1, "我在[" + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.name + "]热聊，邀请你加入!", str2, this.c, str4);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramHotChatInfo;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.info=" + paramHotChatInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.userCreate != 1)
    {
      d();
      return;
    }
    this.jdField_a_of_type_Int = 0;
    this.b = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin);
    if (!TextUtils.isEmpty(this.b)) {
      this.jdField_a_of_type_Int = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.ownerNickname=" + this.b);
    }
    if (!TextUtils.isEmpty(this.c))
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label193;
      }
      this.jdField_a_of_type_Int = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, "handleShare.ownerHeadUrl=" + this.c);
      }
      if (this.jdField_a_of_type_Int != 3) {
        break;
      }
      d();
      return;
      label193:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Int = 3;
      }
    }
    b();
    ThreadManager.a(new pyv(this), 8, null, false);
    new Handler().postDelayed(new pyx(this), 30000L);
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369268);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("HotChatShare", 2, localException.toString());
    }
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("HotChatShare", 2, localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotChatShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */