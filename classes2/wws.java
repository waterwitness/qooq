import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.MyAppApi;

public class wws
  implements Runnable
{
  public wws(MyAppApi paramMyAppApi, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.e) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a != null))
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.d(this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */