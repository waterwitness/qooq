import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class vpu
  implements Runnable
{
  public vpu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File[] arrayOfFile;
    do
    {
      try
      {
        Thread.sleep(3000L);
        File localFile = new File(AppConstants.by);
        if (!localFile.isDirectory()) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
      arrayOfFile = localInterruptedException.listFiles(new vpv(this));
    } while ((arrayOfFile == null) || (arrayOfFile.length < 100));
    Object localObject = new ArrayList(arrayOfFile.length);
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(Long.valueOf(arrayOfFile[i].lastModified()));
      i += 1;
    }
    Collections.sort((List)localObject);
    long l = ((Long)((List)localObject).get(((List)localObject).size() - 100)).longValue();
    j = arrayOfFile.length;
    i = 0;
    while (i < j)
    {
      localObject = arrayOfFile[i];
      if (((File)localObject).lastModified() < l) {
        ((File)localObject).deleteOnExit();
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */