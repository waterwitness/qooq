import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.plugin.PluginDownloader;
import java.io.File;
import java.io.FilenameFilter;

public class ydu
  implements FilenameFilter
{
  public ydu(PluginDownloader paramPluginDownloader, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ydu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */