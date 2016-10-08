import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;

public class srx
  implements View.OnClickListener
{
  public srx(NearbyTopicFeedActivity paramNearbyTopicFeedActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c())
    {
      paramView = ActionSheet.c(this.a);
      paramView.c(2131369187);
      paramView.c(2131369188);
      paramView.d(2131367262);
      paramView.a(new sry(this, paramView));
      paramView.show();
    }
    for (;;)
    {
      NearbyTitleBarActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "0X8005A1D");
      return;
      paramView = new QQCustomDialog(this.a, 2131558973);
      paramView.setContentView(2130904163);
      ((TextView)paramView.findViewById(2131301654)).setText(String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a()) + "心");
      paramView.setNegativeButton("忽略", new srz(this, paramView));
      paramView.setPositiveButton("去看攻略", new ssa(this));
      paramView.setCanceledOnTouchOutside(false);
      paramView.show();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */