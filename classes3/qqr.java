import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileFilter;

public final class qqr
  implements FileFilter
{
  public qqr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith("hc_");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */