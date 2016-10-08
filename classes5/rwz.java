import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;

public class rwz
  implements Runnable
{
  public rwz(FileManagerRSWorker paramFileManagerRSWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.b == 0)
    {
      if (this.a.f != null)
      {
        this.a.a(this.a.f, 0L);
        return;
      }
      this.a.b();
      return;
    }
    if (this.a.f.equalsIgnoreCase(""))
    {
      this.a.a();
      return;
    }
    try
    {
      if (this.a.jdField_a_of_type_JavaIoOutputStream != null) {
        this.a.jdField_a_of_type_JavaIoOutputStream.flush();
      }
      this.a.jdField_a_of_type_Long = FileManagerUtil.a(this.a.d);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.a.c + "]retry request Httpmsg,rd[" + String.valueOf(this.a.jdField_a_of_type_Long) + "]");
      FileManagerRSWorker.a(this.a, this.a.jdField_a_of_type_Long, this.a.h);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, localIOException.getMessage());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rwz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */