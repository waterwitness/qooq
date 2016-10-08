package com.tencent.mobileqq.newfriend;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MayKnowMessage
  extends NewFriendMessage
{
  public PushRecommend a;
  
  public MayKnowMessage(PushRecommend paramPushRecommend)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend = paramPushRecommend;
    this.jdField_a_of_type_Long = paramPushRecommend.timestamp;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.uin;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.remark)) {
        break label83;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.nick)) {
        break label72;
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.uin;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = String.format(BaseApplicationImpl.a.getString(2131369713), new Object[] { paramQQAppInterface });
      return this.jdField_a_of_type_JavaLangString;
      label72:
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.nick;
      continue;
      label83:
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.remark;
    }
  }
  
  public void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPushRecommend.isReaded;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\newfriend\MayKnowMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */