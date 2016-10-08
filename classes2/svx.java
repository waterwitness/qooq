import android.os.Environment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class svx
  implements Runnable
{
  public svx(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "perflog.txt", "rw");
      localRandomAccessFile.seek(localRandomAccessFile.length());
      localRandomAccessFile.writeBytes(new String(this.a.getBytes("iso-8859-1"), "GBK"));
      localRandomAccessFile.close();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\svx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */