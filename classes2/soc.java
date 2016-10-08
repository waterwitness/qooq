import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

class soc
  implements View.OnClickListener
{
  soc(snz paramsnz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      ((Dialog)paramView.getTag()).dismiss();
      paramView.setTag(null);
      if ((paramView instanceof TextView))
      {
        paramView = ((TextView)paramView).getText().toString();
        if (this.a.a.getString(2131372138).equals(paramView))
        {
          paramView = this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
          paramView = "http://ti.qq.com/meilizhigl/index.html?_wv=1027&isguest=[isguest]&uin=[uin]".replace("[isguest]", "0").replace("[uin]", paramView);
          Intent localIntent = new Intent(this.a.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", paramView);
          this.a.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
          return;
        }
        boolean bool = this.a.a.getString(2131369401).equals(paramView);
        if (bool) {}
      }
    }
    catch (Exception paramView) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\soc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */