import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;

public class hwv
  implements CompoundButton.OnCheckedChangeListener
{
  public hwv(ReadInJoySettingActivity paramReadInJoySettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.a(this.a, paramBoolean);
    if ((ReadInJoySettingActivity.a(this.a).isPressed()) && (!this.a.c))
    {
      if (paramBoolean)
      {
        ReadInJoySettingActivity.a(this.a, ReadInJoySettingActivity.a(this.a));
        return;
      }
      ReadInJoySettingActivity.a(this.a).show();
      return;
    }
    this.a.c = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */