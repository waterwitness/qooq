import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class hxg
  implements ActionSheet.OnDismissListener
{
  public hxg(ReadInJoySettingActivity paramReadInJoySettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    ReadInJoySettingActivity.b(this.a).cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */