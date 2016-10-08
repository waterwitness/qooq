import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.AccountInfo;
import com.tencent.open.util.HandlerPlus;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import mqq.observer.BusinessObserver;

public class wpy
  implements BusinessObserver
{
  public wpy(AuthorityActivity paramAuthorityActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a.equals(localObject)) {}
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      if (paramBoolean)
      {
        GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
        try
        {
          localObject = paramBundle.getByteArray("data");
          paramBundle = (Bundle)localObject;
          if (!this.a.j) {
            paramBundle = this.a.b((byte[])localObject);
          }
          if (paramBundle != null)
          {
            localGetAppinfoResponse.mergeFrom(paramBundle);
            if ((localGetAppinfoResponse.has()) && (localGetAppinfoResponse.ret.get() == 0))
            {
              paramBundle = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
              paramBundle.what = 3;
              paramBundle.obj = localGetAppinfoResponse;
              this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage(paramBundle);
              return;
            }
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */