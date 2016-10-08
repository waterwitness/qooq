import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class kkm
  implements View.OnClickListener
{
  public kkm(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = QZoneHelper.UserInfo.a();
    paramView.a = this.a.app.a();
    paramView.b = this.a.app.b();
    QZoneHelper.a(this.a, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */