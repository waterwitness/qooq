import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicHandler;
import com.tencent.mobileqq.olympic.activity.OlympicSettingActivity;

public class trr
  implements CompoundButton.OnCheckedChangeListener
{
  public trr(OlympicSettingActivity paramOlympicSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.a.b == paramBoolean) {
      return;
    }
    ((OlympicHandler)this.a.app.a(94)).a(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */