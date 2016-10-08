import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.OpenSdkFriendService;
import com.tencent.open.agent.SocialFriendChooser;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.settings.ServerSetting;

public class wrt
  extends Handler
{
  public wrt(SocialFriendChooser paramSocialFriendChooser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
      paramMessage.putString("agentversion", CommonDataAdapter.a().d());
      paramMessage.putString("facetype", "mqqface");
      String str = ServerSetting.a().a("http://fusion.qq.com/cgi-bin/appstage/get_image_update");
      OpenSdkFriendService.a().a(str, paramMessage, new wru(this));
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask != null) && (!this.a.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.isCancelled())) {
      this.a.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.cancel(true);
    }
    this.a.l();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", "网络连接超时!");
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */