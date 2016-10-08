import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.io.File;
import java.util.Arrays;

public class uuk
  implements Runnable
{
  public uuk(StatisticCollector paramStatisticCollector)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 10;
    try
    {
      Object localObject = new File("/data/data/com.tencent.mobileqq/files/crashinfo/");
      if ((localObject != null) && (((File)localObject).exists()))
      {
        localObject = ((File)localObject).listFiles(new uul(this));
        if ((localObject != null) && (localObject.length > 10))
        {
          Arrays.sort((Object[])localObject, new uum(this));
          while (i < localObject.length)
          {
            localObject[i].delete();
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uuk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */