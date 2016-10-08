import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class nog
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 200L;
  private long b;
  
  public nog(RichStatItemBuilder paramRichStatItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.jdField_a_of_type_AndroidContentContext.getResources();
    if (!NetworkUtil.e(this.a.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, ((Resources)localObject).getString(2131367256), 0).b(((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
    }
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.b) < 200L)
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, ((Resources)localObject).getString(2131372027), 0).b(((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
        return;
      }
      this.b = l;
      localObject = (RichStatItemBuilder.Holder)paramView.getTag();
      try
      {
        if (((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.getText() == null) {}
        int j;
        int k;
        for (paramView = "0";; paramView = ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.getText().toString())
        {
          j = Integer.parseInt(paramView);
          if (((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_Int != 0) {
            break label345;
          }
          ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_Int = 1;
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_on", 0, 0, "", "", "", "");
          i = 8;
          j += 1;
          k = 1;
          ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setText(j + "");
          paramView = RichStatItemBuilder.a(this.a).a(((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int, i, DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 14.0F), DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 19.0F));
          if (paramView != null) {
            ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramView, null, null, null);
          }
          paramView = (SignatureHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(41);
          if (paramView == null) {
            break;
          }
          paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_JavaLangString, 255, k);
          return;
        }
        label345:
        ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_Int = 0;
        int i = j - 1;
        if (i > 0) {}
        for (;;)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "aio_act_off", 0, 0, "", "", "", "");
          int m = 7;
          j = i;
          k = 0;
          i = m;
          break;
          i = 0;
        }
        return;
      }
      catch (Exception paramView) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */