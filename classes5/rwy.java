import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.ChangeNewPath;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class rwy
  implements FileManagerRSWorker.ChangeNewPath
{
  public rwy(FileManagerRSWorker paramFileManagerRSWorker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_Long = FileManagerUtil.a(this.a.d);
    try
    {
      if (this.a.jdField_a_of_type_JavaIoOutputStream != null)
      {
        this.a.jdField_a_of_type_JavaIoOutputStream.close();
        this.a.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.a.d, true);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          this.a.jdField_a_of_type_Boolean = false;
          FileManagerRSWorker.a(this.a, this.a.jdField_a_of_type_Long, this.a.h);
          return;
        }
        finally {}
        localException = localException;
        QLog.i("8pic", 1, "Id[" + String.valueOf(this.a.c) + "]" + "exception io FileMsg, " + localException.toString());
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rwy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */