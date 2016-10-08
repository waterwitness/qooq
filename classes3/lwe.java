import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class lwe
  implements Runnable
{
  public lwe(NearbyActivity paramNearbyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ArrayOfBoolean == null) {
      return;
    }
    int i = 0;
    label13:
    if (i < NearbyActivity.jdField_a_of_type_ArrayOfJavaLangString.length) {
      if (3 != i) {
        break label62;
      }
    }
    for (BusinessInfoCheckUpdate.AppInfo localAppInfo = this.a.a();; localAppInfo = this.a.b.a().a(NearbyActivity.jdField_a_of_type_ArrayOfJavaLangString[i]))
    {
      if (localAppInfo != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, i, 0, localAppInfo).sendToTarget();
      }
      label62:
      do
      {
        i += 1;
        break label13;
        break;
      } while (((1 == i) && (this.a.jdField_a_of_type_ArrayOfBoolean[i] == 0)) || ((2 == i) && (this.a.jdField_a_of_type_ArrayOfBoolean[i] == 0)));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */