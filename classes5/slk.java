import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class slk
  implements BusinessObserver
{
  public slk(ForwardSdkBaseOption paramForwardSdkBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    synchronized (ForwardSdkBaseOption.jdField_a_of_type_JavaLangObject)
    {
      this.a.j = false;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject2 = new GetAppInfoProto.GetAppinfoResponse();
          ((GetAppInfoProto.GetAppinfoResponse)localObject2).mergeFrom(paramBundle);
          this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = ((GetAppInfoProto.GetAppinfoResponse)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "get appinfo time = " + (System.currentTimeMillis() - this.a.c));
          }
          if ((this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
          {
            paramBundle = this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
            localObject2 = Share.a(this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
            if (paramBundle.sourceUrl != null) {
              this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", paramBundle.sourceUrl.get());
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)localObject2);
            }
            if (paramBundle.messagetail != null) {
              this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", paramBundle.messagetail.get());
            }
            if (paramBundle.packName != null) {
              this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", paramBundle.packName.get());
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceIcon = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
              this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
              if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName)) {
                this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.a.jdField_a_of_type_AndroidOsBundle.getString("app_name");
              }
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramBundle.getMessage());
          }
        }
      }
      ForwardSdkBaseOption.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */