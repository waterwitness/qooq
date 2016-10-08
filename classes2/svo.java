import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

public class svo
  extends WtloginListener
{
  public svo(LoginKeyHelper paramLoginKeyHelper, LoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    super.OnException(paramErrMsg, paramInt, paramWUserSigInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$GetLoginKeyListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$GetLoginKeyListener.a(this.jdField_a_of_type_JavaLangString, false, paramInt);
    }
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$AccountInfo.a = this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.jdField_a_of_type_OicqWlogin_sdkRequestWtloginHelper.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$GetLoginKeyListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$GetLoginKeyListener.a(this.jdField_a_of_type_JavaLangString, true, 0);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$GetLoginKeyListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper$GetLoginKeyListener.a(this.jdField_a_of_type_JavaLangString, false, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\svo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */