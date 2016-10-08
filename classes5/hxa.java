import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hxa
  implements CompoundButton.OnCheckedChangeListener
{
  public hxa(ReadInJoySettingActivity paramReadInJoySettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.b(this.a, paramBoolean);
    ReadInJoySettingActivity.b(this.a, ReadInJoySettingActivity.b(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */