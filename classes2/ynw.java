import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class ynw
  implements ServiceConnection
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  
  public ynw(ynu paramynu, ServiceConnection paramServiceConnection, Context paramContext, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    do
    {
      try
      {
        this.jdField_a_of_type_AndroidContentContext.getApplicationContext().unbindService(this);
        if (QLog.isColorLevel()) {
          QLog.i("patch", 2, "onServiceConnected, " + this);
        }
        this.jdField_a_of_type_AndroidContentServiceConnection.onServiceConnected(???, paramIBinder);
      }
      catch (Exception localException)
      {
        synchronized (ynu.a(this.jdField_a_of_type_Ynu))
        {
          do
          {
            paramIBinder = (ynw)ynu.a(this.jdField_a_of_type_Ynu).poll();
            if (paramIBinder == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("patch", 2, "continue process");
            }
            ynu.a(this.jdField_a_of_type_Ynu, paramIBinder, 300);
            return;
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.i("patch", 2, "unbindService, " + this);
        }
      }
      ynu.a(this.jdField_a_of_type_Ynu, false);
    } while (!QLog.isColorLevel());
    QLog.i("patch", 2, "queue empty");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "onServiceDisconnected, " + this);
    }
    this.jdField_a_of_type_AndroidContentServiceConnection.onServiceDisconnected(paramComponentName);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */