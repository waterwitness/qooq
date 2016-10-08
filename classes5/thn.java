import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.qphone.base.util.QLog;

public class thn
  extends Handler
{
  public thn(NearbyFakeActivity paramNearbyFakeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        NearbyFakeActivity.a(this.a, true);
        boolean bool = NearbyFakeActivity.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.i(NearbyFakeActivity.jdField_a_of_type_JavaLangString, 2, "dataPreload timeout, nearbyProcDone? " + bool);
        }
        if (!bool) {
          continue;
        }
        NearbyFakeActivity.a(this.a, 2);
      }
      if (QLog.isColorLevel()) {
        QLog.i(NearbyFakeActivity.jdField_a_of_type_JavaLangString, 2, "procPreload time out");
      }
      NearbyFakeActivity.a(this.a, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */