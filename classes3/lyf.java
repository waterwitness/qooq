import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;

public class lyf
  implements CompoundButton.OnCheckedChangeListener
{
  public lyf(NotifyPushSettingActivity paramNotifyPushSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean != this.a.app.a().b()) {
      ((NearbyRelevantHandler)this.a.app.a(66)).b(paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */