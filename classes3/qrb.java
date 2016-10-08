import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileFilter;

public final class qrb
  implements FileFilter
{
  public qrb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isFile()) && (paramFile.exists());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */