import com.tencent.mobileqq.config.struct.NearbyBannerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.Comparator;

public class rba
  implements Comparator
{
  public rba(NearbyBannerManager paramNearbyBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() > paramFile1.lastModified()) {
      return 1;
    }
    if (paramFile2.lastModified() < paramFile1.lastModified()) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */