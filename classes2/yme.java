import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.font.FontManager;
import java.io.File;
import java.io.FileFilter;

public class yme
  implements FileFilter
{
  public yme(FontManager paramFontManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */