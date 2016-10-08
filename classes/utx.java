import com.tencent.mobileqq.startup.step.MigrateSubscribeDB;
import java.io.File;
import java.util.Comparator;

public class utx
  implements Comparator
{
  public utx(MigrateSubscribeDB paramMigrateSubscribeDB) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile2.lastModified() - paramFile1.lastModified();
    if (l > 0L) {
      return 1;
    }
    if (l == 0L) {
      return 0;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\utx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */