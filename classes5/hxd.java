import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class hxd
  implements ActionSheet.OnButtonClickListener
{
  public hxd(ReadInJoySettingActivity paramReadInJoySettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      ReadInJoySettingActivity.a(this.a).cancel();
      return;
      ReadInJoySettingActivity.a(this.a, false);
      ReadInJoySettingActivity.a(this.a, ReadInJoySettingActivity.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */