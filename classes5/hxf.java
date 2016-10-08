import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class hxf
  implements ActionSheet.OnButtonClickListener
{
  public hxf(ReadInJoySettingActivity paramReadInJoySettingActivity)
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
      ReadInJoySettingActivity.b(this.a).cancel();
      return;
      ReadInJoySettingActivity.c(this.a, false);
      ReadInJoySettingActivity.c(this.a, ReadInJoySettingActivity.c(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */