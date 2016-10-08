import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class ige
  implements BusinessObserver
{
  public ige(PublicAccountObserver paramPublicAccountObserver, String paramString, Context paramContext, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label255;
      }
      mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
      localFollowResponse.mergeFrom(paramBundle);
      paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
      if (paramInt == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, true, this.jdField_a_of_type_JavaLangString);
        }
        PublicAccountUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
      return;
    }
    if (paramInt == 58)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
      }
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364494);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
    }
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
    return;
    label255:
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
    }
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ige.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */