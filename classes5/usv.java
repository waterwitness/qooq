import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class usv
  implements FileFilter
{
  public usv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */