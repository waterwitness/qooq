package com.tencent.mobileqq.managers;

import android.content.Intent;
import com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import mqq.manager.Manager;

public class PullActiveManager
  implements Manager
{
  public static String a;
  public static String b = "extra_notify_msg";
  public static final String c = "activepull_push_flag";
  public Intent a;
  public RecentItemPullActivePush a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForText jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "QQ";
  }
  
  public PullActiveManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush == null) {
      return 0;
    }
    return 1;
  }
  
  public MessageForText a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText = ((MessageForText)MessageRecordFactory.a(64536));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msgtype = 64536;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop = 9653;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.isread = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.senderuin = AppConstants.aW;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.frienduin = AppConstants.aW;
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = this.jdField_a_of_type_AndroidContentIntent.getStringExtra(b);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.a;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg.equals(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.b))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time != this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.a) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.a;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush = null;
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush == null)
    {
      localObject = new RecentUser();
      ((RecentUser)localObject).uin = AppConstants.aW;
      ((RecentUser)localObject).type = 9653;
      ((RecentUser)localObject).msgType = 64536;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush = new RecentItemPullActivePush((RecentUser)localObject);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject = paramIntent.getStringExtra(b);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush.a((String)localObject, l);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\managers\PullActiveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */