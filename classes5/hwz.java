import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.widget.Switch;

public class hwz
  implements QQProgressDialog.Callback
{
  public hwz(ReadInJoySettingActivity paramReadInJoySettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    Switch localSwitch;
    if (this.a.b)
    {
      localSwitch = ReadInJoySettingActivity.a(this.a);
      if (ReadInJoySettingActivity.a(this.a)) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      localSwitch.setChecked(bool);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */