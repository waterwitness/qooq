import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.MyAppApi;

public final class wsm
  implements Runnable
{
  public wsm(Activity paramActivity, Bundle paramBundle, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MyAppApi.a().a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */