import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FilenameFilter;

public class th
  implements FilenameFilter
{
  public th(FontManager paramFontManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = new File(paramFile.getAbsolutePath() + File.separatorChar + paramString);
    if (paramFile.isDirectory()) {
      paramFile.listFiles(new ti(this));
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\th.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */