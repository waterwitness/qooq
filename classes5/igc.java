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

public final class igc
  implements BusinessObserver
{
  public igc(PublicAccountObserver paramPublicAccountObserver, String paramString, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
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
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
      }
    }
    label287:
    label325:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!paramBoolean) {
                break label325;
              }
              try
              {
                paramBundle = paramBundle.getByteArray("data");
                if (paramBundle == null) {
                  break label287;
                }
                mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
                localFollowResponse.mergeFrom(paramBundle);
                paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
                if (paramInt != 0) {
                  break;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
                  this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, true, this.jdField_a_of_type_JavaLangString);
                }
                PublicAccountUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
                return;
              }
              catch (Exception paramBundle)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
                  this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
                }
              }
            } while (!this.jdField_a_of_type_Boolean);
            PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
            return;
            if (paramInt != 58) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
            }
          } while (!this.jdField_a_of_type_Boolean);
          PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364494);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
          }
        } while (!this.jdField_a_of_type_Boolean);
        PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
        }
      } while (!this.jdField_a_of_type_Boolean);
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver.a(101, false, this.jdField_a_of_type_JavaLangString);
      }
    } while (!this.jdField_a_of_type_Boolean);
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364487);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\igc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */