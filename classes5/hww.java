import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class hww
  implements ActionSheet.OnButtonClickListener
{
  public hww(ReadInJoySettingActivity paramReadInJoySettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.c(this.a).e(paramInt);
    ((TextView)this.a.findViewById(2131299950)).setText(ReadInJoySettingActivity.a(this.a)[paramInt]);
    SettingCloneUtil.writeValue(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_kandian_video_auto_flag", Integer.toString(paramInt));
    switch (paramInt)
    {
    }
    for (;;)
    {
      ReadInJoySettingActivity.c(this.a).cancel();
      return;
      ReportController.b(null, "CliOper", "", "", "0X800691C", "0X800691C", 0, 0, "", "", "", ReadInJoyUtils.c());
      continue;
      ReportController.b(null, "CliOper", "", "", "0X800691D", "0X800691D", 0, 0, "", "", "", ReadInJoyUtils.c());
      continue;
      ReportController.b(null, "CliOper", "", "", "0X800691E", "0X800691E", 0, 0, "", "", "", ReadInJoyUtils.c());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */