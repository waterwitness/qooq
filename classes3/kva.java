import android.app.Dialog;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class kva
  implements Runnable
{
  kva(kuz paramkuz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      ChatHistory.a(this.a.a, this.a.a.d, this.a.a.a);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistory", 2, "onExportMessageRecord Exception", localException);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistory", 2, "onExportMessageRecord OOM", localOutOfMemoryError);
      }
      return;
    }
    finally
    {
      this.a.a.c.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */