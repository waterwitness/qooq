import android.os.Handler;
import com.tencent.biz.now.NowVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class hkl
  extends Thread
{
  public hkl(NowVideoView paramNowVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      if (!this.a.jdField_a_of_type_Boolean)
      {
        if ((this.a.b != 0L) && (System.currentTimeMillis() - this.a.b > 2000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NowVideoView", 2, "no draw for Now");
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        }
      }
      else
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
        continue;
      }
      try
      {
        Thread.sleep(1000L);
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */