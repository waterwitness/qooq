import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FilenameFilter;

public final class ijk
  implements FilenameFilter
{
  public ijk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ijk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */