package com.tencent.biz.pubaccount;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hqz;
import hra;
import mqq.os.MqqHandler;

public class PublicAccountUnfollowTask
  extends PublicAccountObserver
{
  public static final String a;
  private static final int i = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String b;
  private int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PublicAccountUnfollowTask.class.getSimpleName();
  }
  
  public PublicAccountUnfollowTask(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.b();
  }
  
  public void a()
  {
    if ((this.j >= 3) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "retry count reach max value or app = null ! retryCount : " + this.j);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new hqz(this));
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    int k = this.j;
    this.j = (k + 1);
    if (k < 3)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "unfollow account fail ! uin : " + this.b + " , errCode : " + paramInt + ", retry : " + this.j);
      this.jdField_a_of_type_MqqOsMqqHandler.post(new hra(this));
    }
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "unfollow account success ! uin : " + paramString + ",retry : " + this.j);
      int k = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b);
      RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, k);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.b, 1008);
      ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162)).a().g();
      return;
    }
    a(-1, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountUnfollowTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */