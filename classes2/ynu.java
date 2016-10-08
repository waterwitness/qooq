import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZonePatchService;
import java.util.Iterator;
import java.util.LinkedList;

public class ynu
{
  private static final String jdField_a_of_type_JavaLangString = "patch";
  private static ynu jdField_a_of_type_Ynu;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private volatile boolean jdField_a_of_type_Boolean;
  
  private ynu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static ynu a()
  {
    if (jdField_a_of_type_Ynu == null) {}
    try
    {
      if (jdField_a_of_type_Ynu == null) {
        jdField_a_of_type_Ynu = new ynu();
      }
      return jdField_a_of_type_Ynu;
    }
    finally {}
  }
  
  private void a(ynw paramynw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "processInner, " + paramynw + ", " + QZonePatchService.class);
    }
    if (QZonePatchService.class == null) {}
    do
    {
      return;
      Context localContext = ynw.a(paramynw).getApplicationContext();
      Intent localIntent = new Intent(localContext, QZonePatchService.class);
      try
      {
        localContext.bindService(localIntent, paramynw, 1);
        return;
      }
      catch (SecurityException paramynw) {}
    } while (!QLog.isColorLevel());
    QLog.i("patch", 2, "processInner", paramynw);
  }
  
  private void a(ynw paramynw, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "processInnerDelay. " + paramInt + ", " + paramynw);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ynv(this, paramynw), paramInt);
  }
  
  public void a(Context arg1, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "PluginRemoteProcessor.process, " + paramInt);
    }
    paramServiceConnection = new ynw(this, paramServiceConnection, ???, paramInt);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "queue");
      }
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.offer(paramServiceConnection);
        return;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(paramServiceConnection);
  }
  
  public void a(ServiceConnection paramServiceConnection)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        ynw localynw = (ynw)localIterator.next();
        if (ynw.a(localynw) == paramServiceConnection) {
          ynw.a(localynw).unbindService(localynw);
        }
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */