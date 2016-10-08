import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.downloadnew.MyAppApi;

public class wtd
  implements Runnable
{
  public wtd(BaseJsCallBack paramBaseJsCallBack, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MyAppApi.a().b(this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */