import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.Switch;

public class hxe
  implements ActionSheet.OnDismissListener
{
  public hxe(ReadInJoySettingActivity paramReadInJoySettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    ReadInJoySettingActivity.a(this.a, true);
    ReadInJoySettingActivity.a(this.a).setChecked(ReadInJoySettingActivity.a(this.a));
    ReadInJoySettingActivity.a(this.a).cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */