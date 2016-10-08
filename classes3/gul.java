import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.HYControlUI;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.CookieManager;
import cooperation.c2b.C2BBrowserActivity;
import java.lang.ref.WeakReference;

public class gul
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  private gul(HYControlUI paramHYControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = 8;
    boolean bool = false;
    if (!"3316870573".equals(this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {}
    label277:
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.getId() == 2131299075)
          {
            paramView = this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
            if ((paramView != null) && (paramView.length() > 0))
            {
              HYControlUI.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramView);
              ((Context)this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_JavaLangRefWeakReference.get()).getSharedPreferences("hycontrolui", 0).edit().putString("url", paramView).commit();
              return;
            }
            this.jdField_a_of_type_ComTencentAvUiHYControlUI.g.setText("URL不能为空!");
            return;
          }
          if ((paramView.getId() == 2131299056) || (paramView.getId() == 2131299062) || (paramView.getId() == 2131299084))
          {
            if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L)
            {
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              this.jdField_a_of_type_Int = 0;
            }
            if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int % 4 == 0) && (this.jdField_a_of_type_ComTencentAvUiHYControlUI.b != null))
            {
              paramView = this.jdField_a_of_type_ComTencentAvUiHYControlUI.b;
              if (this.jdField_a_of_type_ComTencentAvUiHYControlUI.b.getVisibility() != 0) {
                break label277;
              }
            }
            for (;;)
            {
              paramView.setVisibility(i);
              paramView = ((Context)this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_JavaLangRefWeakReference.get()).getSharedPreferences("hycontrolui", 0);
              this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_AndroidWidgetEditText.setText(paramView.getString("url", "http://"));
              this.jdField_a_of_type_Int += 1;
              return;
              i = 0;
            }
          }
          if (paramView.getId() == 2131299077)
          {
            this.jdField_a_of_type_ComTencentAvUiHYControlUI.b.setVisibility(8);
            return;
          }
        } while (paramView.getId() == 2131299078);
        Intent localIntent;
        if (paramView.getId() == 2131299076)
        {
          paramView = this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if ((paramView != null) && (paramView.length() > 0))
          {
            localObject = (AVActivity)this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_JavaLangRefWeakReference.get();
            localIntent = new Intent((Context)localObject, C2BBrowserActivity.class);
            localIntent.putExtra("portraitOnly", true);
            localIntent.putExtra("url", paramView);
            localIntent.putExtra("fromType", 0);
            localIntent.putExtra("ignoreLoginWeb", true);
            ((AVActivity)localObject).startActivity(localIntent);
            ((Context)this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_JavaLangRefWeakReference.get()).getSharedPreferences("hycontrolui", 0).edit().putString("url", paramView).commit();
            return;
          }
          this.jdField_a_of_type_ComTencentAvUiHYControlUI.g.setText("URL不能为空!");
          return;
        }
        if (paramView.getId() == 2131299079)
        {
          paramView = this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if ((paramView != null) && (paramView.length() > 0))
          {
            localObject = (AVActivity)this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_JavaLangRefWeakReference.get();
            localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
            localIntent.putExtra("portraitOnly", true);
            localIntent.putExtra("url", paramView);
            localIntent.putExtra("ignoreLoginWeb", true);
            ((AVActivity)localObject).startActivity(localIntent);
            ((Context)this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_JavaLangRefWeakReference.get()).getSharedPreferences("hycontrolui", 0).edit().putString("url", paramView).commit();
            return;
          }
          this.jdField_a_of_type_ComTencentAvUiHYControlUI.g.setText("URL不能为空!");
          return;
        }
        if (paramView.getId() != 2131299080) {
          break;
        }
        paramView = CookieManager.getInstance();
      } while (paramView == null);
      paramView.removeAllCookie();
      return;
      if (paramView.getId() == 2131299081)
      {
        this.jdField_a_of_type_ComTencentAvUiHYControlUI.a((Context)this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_JavaLangRefWeakReference.get(), ".qq.com");
        return;
      }
      if (paramView.getId() == 2131299082)
      {
        paramView = CookieManager.getInstance();
        if (paramView != null)
        {
          paramView = paramView.getCookie(".qq.com");
          this.jdField_a_of_type_ComTencentAvUiHYControlUI.g.setText(paramView + "");
          return;
        }
        this.jdField_a_of_type_ComTencentAvUiHYControlUI.g.setText("CookieManager == null");
        return;
      }
    } while (paramView.getId() != 2131299083);
    paramView = ((Context)this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_JavaLangRefWeakReference.get()).getSharedPreferences("hycontrolui", 0);
    Object localObject = this.jdField_a_of_type_ComTencentAvUiHYControlUI;
    if (!this.jdField_a_of_type_ComTencentAvUiHYControlUI.h) {
      bool = true;
    }
    ((HYControlUI)localObject).h = bool;
    paramView.edit().putBoolean("isWebViewCacheable", this.jdField_a_of_type_ComTencentAvUiHYControlUI.h).commit();
    localObject = this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_AndroidWidgetButton;
    if (this.jdField_a_of_type_ComTencentAvUiHYControlUI.h) {}
    for (paramView = "webcacheOff";; paramView = "webcacheOn")
    {
      ((Button)localObject).setText(paramView);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */