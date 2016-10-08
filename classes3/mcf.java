import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.opengroup.AppUrlOpenGroup.RspBody;

public class mcf
  implements BusinessObserver
{
  public mcf(QQBrowserActivity paramQQBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, " checkAppUrl,onReceive:isSuccess=" + paramBoolean);
    }
    if (this.a.isFinishing()) {}
    while (!paramBoolean) {
      return;
    }
    this.a.a.h = true;
    paramBundle = paramBundle.getByteArray("data");
    Object localObject = new AppUrlOpenGroup.RspBody();
    try
    {
      ((AppUrlOpenGroup.RspBody)localObject).mergeFrom(paramBundle);
      this.a.aB = ((AppUrlOpenGroup.RspBody)localObject).bytes_app_name.get().toStringUtf8();
      this.a.aC = ((AppUrlOpenGroup.RspBody)localObject).bytes_company.get().toStringUtf8();
      this.a.aE = ((AppUrlOpenGroup.RspBody)localObject).bytes_info_url.get().toStringUtf8();
      this.a.aD = ((AppUrlOpenGroup.RspBody)localObject).bytes_share_url.get().toStringUtf8();
      localObject = (RelativeLayout)this.a.titleRoot.findViewById(2131297138);
      if (this.a.centerView.getVisibility() != 8) {
        this.a.centerView.setVisibility(8);
      }
      if (((RelativeLayout)localObject).getVisibility() != 0) {
        ((RelativeLayout)localObject).setVisibility(0);
      }
      paramBundle = (TextView)((RelativeLayout)localObject).findViewById(2131297829);
      localObject = (TextView)((RelativeLayout)localObject).findViewById(2131297830);
      paramBundle.setText(this.a.centerView.getText());
      ((TextView)localObject).setText(2131367456);
      this.a.rightViewImg.setVisibility(0);
      this.a.rightViewImg.setImageResource(2130838587);
      return;
    }
    catch (Exception paramBundle) {}catch (InvalidProtocolBufferMicroException paramBundle) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */