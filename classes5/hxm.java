import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoGetUrlReportData;
import com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidResponse;
import com.tencent.mobileqq.ac.ArticleCenter.RetInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class hxm
  implements BusinessObserver
{
  public hxm(ThirdVidoeManager paramThirdVidoeManager, long paramLong, String paramString, AppRuntime paramAppRuntime, NewIntent paramNewIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("THIRD_VIDEO_TAG", 2, "CMD_VIDEO_UUIDFORURL time : " + l);
    }
    Object localObject = new VideoGetUrlReportData();
    ((VideoGetUrlReportData)localObject).jdField_a_of_type_Boolean = paramBoolean;
    ((VideoGetUrlReportData)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((VideoGetUrlReportData)localObject).jdField_a_of_type_Long = l;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager.a = Long.valueOf(l);
    ReadInJoyUtils.c(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), ReadInJoyUtils.a(), paramBoolean, ((VideoGetUrlReportData)localObject).a());
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean) {
      if (ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager) != null) {
        ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager).a("error", this.jdField_a_of_type_JavaLangString);
      }
    }
    label279:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            paramBundle = paramBundle.getByteArray("data");
            if ((paramBundle == null) || (paramBundle.length <= 0))
            {
              if (ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager) != null) {
                ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager).a("error", this.jdField_a_of_type_JavaLangString);
              }
            }
            else {
              try
              {
                localObject = new ArticleCenter.GetUrlByVidResponse();
                ((ArticleCenter.GetUrlByVidResponse)localObject).mergeFrom(paramBundle);
                if (((ArticleCenter.GetUrlByVidResponse)localObject).ret_info.ret_code.get() == 0) {
                  break label279;
                }
                if (ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager) != null)
                {
                  ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager).a("error", this.jdField_a_of_type_JavaLangString);
                  return;
                }
              }
              catch (Exception paramBundle) {}
            }
          }
        } while (ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager) == null);
        ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager).a("error", this.jdField_a_of_type_JavaLangString);
        return;
        paramBundle = ((ArticleCenter.GetUrlByVidResponse)localObject).url.get();
        if (paramBundle == null) {
          break;
        }
        localObject = paramBundle.toStringUtf8();
      } while (ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager) == null);
      paramBundle = (Bundle)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramBundle = "error";
      }
      ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager).a(paramBundle, this.jdField_a_of_type_JavaLangString);
      ThirdVidoeManager.a(this.jdField_a_of_type_JavaLangString, paramBundle);
      return;
    } while (ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager) == null);
    ThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager).a("error", this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */