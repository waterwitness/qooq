import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;

public class hwy
  implements DialogInterface.OnKeyListener
{
  public hwy(ReadInJoySettingActivity paramReadInJoySettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      ReadInJoySettingActivity.a(this.a, true);
      ReadInJoySettingActivity.a(this.a).setChecked(ReadInJoySettingActivity.a(this.a));
      ReadInJoySettingActivity.a(this.a).cancel();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */