import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.plugin.PluginInstaller;
import java.io.File;
import java.io.FilenameFilter;

public class ydx
  implements FilenameFilter
{
  public ydx(PluginInstaller paramPluginInstaller, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */