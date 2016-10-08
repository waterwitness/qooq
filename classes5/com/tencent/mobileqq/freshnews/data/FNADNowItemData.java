package com.tencent.mobileqq.freshnews.data;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.ad.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FNADNowItemData
  extends FNBaseItemData
{
  public UserInfo a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public FNADNowItemData(FreshNewsInfo paramFreshNewsInfo)
  {
    super(paramFreshNewsInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Context paramContext, AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedType != 12L) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.userInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "FNADNowItemData update userInfo is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsAdUserInfo = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.userInfo;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedContent;
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.size() > 0)) {
      this.b = ((String)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.photoUrls.get(0));
    }
    this.c = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.attendInfo;
    this.d = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.actionUrl;
  }
  
  public String toString()
  {
    return "FNADNowItemData{userInfo=" + this.jdField_a_of_type_ComTencentMobileqqFreshnewsAdUserInfo + ", content='" + this.jdField_a_of_type_JavaLangString + '\'' + ", coverImageUrl='" + this.b + '\'' + ", extraInfo='" + this.c + '\'' + ", actionUrl='" + this.d + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\data\FNADNowItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */