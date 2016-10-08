import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.font.FontManager;
import java.io.File;
import java.io.FileFilter;

public class ymd
  implements FileFilter
{
  public ymd(FontManager paramFontManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    boolean bool1 = paramFile.endsWith(".ftf");
    boolean bool2 = paramFile.endsWith(".ttf");
    return (bool1) || (bool2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */