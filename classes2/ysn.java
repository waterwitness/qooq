import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyPluginInstallActivity;
import cooperation.readinjoy.ReadInJoyProxyActivity;

public class ysn
  implements Runnable
{
  public ysn(ReadInJoyPluginInstallActivity paramReadInJoyPluginInstallActivity, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = this.jdField_a_of_type_CooperationReadinjoyReadInJoyPluginInstallActivity.getIntent().getStringExtra("leftViewText");
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_CooperationReadinjoyReadInJoyPluginInstallActivity.getIntent().putExtra("selfSet_leftViewText", str);
    }
    this.jdField_a_of_type_CooperationReadinjoyReadInJoyPluginInstallActivity.getIntent().putExtra("readinjoy_launch_needs_loading", true);
    ReadInJoyProxyActivity.a(this.jdField_a_of_type_CooperationReadinjoyReadInJoyPluginInstallActivity.app, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationReadinjoyReadInJoyPluginInstallActivity.getIntent(), -1, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */