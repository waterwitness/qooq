import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileFilter;

public final class yom
  implements FileFilter
{
  public yom()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".cfg");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */