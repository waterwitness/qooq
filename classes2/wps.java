import android.content.res.Resources;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.util.HandlerPlus;
import com.tencent.qphone.base.util.QLog;

public class wps
  implements Runnable
{
  public wps(AuthorityActivity paramAuthorityActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.a;
    int i = ((AuthorityActivity)localObject).x;
    ((AuthorityActivity)localObject).x = (i - 1);
    if (i > 0)
    {
      localObject = (String)this.a.getResources().getText(2131369839);
      AuthorityActivity localAuthorityActivity = this.a;
      i = localAuthorityActivity.y;
      localAuthorityActivity.y = (i + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.postDelayed(this.a.b, 500L);
        return;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·  ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·· ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "···");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.a.h = true;
    this.a.i = false;
    if (this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "AutoAuth:" + SystemClock.elapsedRealtime());
      }
      localObject = this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
      this.a.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.sendMessage((Message)localObject);
      this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AutoAuth -- doAuthorize(): " + SystemClock.elapsedRealtime());
    }
    this.a.j();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */