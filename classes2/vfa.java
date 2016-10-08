import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;

public class vfa
  implements View.OnFocusChangeListener
{
  public vfa(NearbyTroopsView paramNearbyTroopsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    ((InputMethodManager)this.a.a().getSystemService("input_method")).hideSoftInputFromWindow(this.a.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    if (System.currentTimeMillis() - this.a.b < 1000L)
    {
      paramView.clearFocus();
      return;
    }
    this.a.b = System.currentTimeMillis();
    int i;
    if ((paramView == this.a.jdField_a_of_type_AndroidWidgetEditText) && (paramBoolean))
    {
      if (this.a.g != 10) {
        break label238;
      }
      i = 3;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.a.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", "http://qun.qq.com/qqweb/m/qun/search/index.html?_wv=1031&_bid=2073&ver1=" + i);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      this.a.b(localIntent);
      this.a.a(2130968592, 2130968589);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "search", "Clk_search", 0, 0, "" + i, "", "", "");
      paramView.clearFocus();
      return;
      label238:
      if (this.a.g == 23) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */