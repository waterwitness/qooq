import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.ipc.HYRemoteManager;
import java.util.ArrayList;

public class ydb
  implements Runnable
{
  public ydb(HYRemoteManager paramHYRemoteManager, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_CooperationHuangyeIpcHYRemoteManager.a.add(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */