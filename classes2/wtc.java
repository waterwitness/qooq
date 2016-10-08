import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.downloadnew.MyAppApi;

public class wtc
  implements Runnable
{
  public wtc(BaseJsCallBack paramBaseJsCallBack, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MyAppApi.a().a(this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */