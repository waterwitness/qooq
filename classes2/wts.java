import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.applist.WebAppActivity.HttpGetAppInfoAsyncTask;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.smtt.sdk.WebView;

public class wts
  extends Handler
{
  public wts(WebAppActivity paramWebAppActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    LogUtility.c("WebAppActivity", "handleMessage >>> " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        return;
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask = new WebAppActivity.HttpGetAppInfoAsyncTask(this.a);
        paramMessage = new Bundle();
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask.execute(new Bundle[] { paramMessage });
        return;
        if (this.a.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
        }
        this.a.a();
        if (TextUtils.isEmpty(CommonDataAdapter.a().a()))
        {
          ToastUtil.a().a(2131363010, 0);
          this.a.f();
          return;
        }
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask = new WebAppActivity.HttpGetAppInfoAsyncTask(this.a);
        paramMessage = new Bundle();
        this.a.jdField_a_of_type_ComTencentOpenApplistWebAppActivity$HttpGetAppInfoAsyncTask.execute(new Bundle[] { paramMessage });
        return;
        if (this.a.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
        }
        this.a.g();
      } while (this.a.jdField_a_of_type_ComTencentSmttSdkWebView == null);
      this.a.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.a.f);
      return;
    case 5: 
      ToastUtil.a().a(2131363011, 0);
      this.a.f();
      return;
    case 6: 
      ToastUtil.a().a(2131363009, 0);
      this.a.f();
      return;
    case 7: 
      ToastUtil.a().a(2131363010, 0);
      this.a.f();
      return;
    }
    ToastUtil.a().a(2131363008, 0);
    this.a.f();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */