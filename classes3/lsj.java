import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class lsj
  implements CompoundButton.OnCheckedChangeListener
{
  public lsj(LikeSettingActivity paramLikeSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.a.a.a())
    {
      ((NearbyRelevantHandler)this.a.app.a(66)).a(paramBoolean);
      this.a.app.a("CliOper", "0X8006729");
    }
    while (paramCompoundButton != this.a.b.a()) {
      return;
    }
    this.a.app.d(true, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */