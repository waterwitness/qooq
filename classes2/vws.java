import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import java.io.File;
import java.io.FilenameFilter;

public class vws
  implements FilenameFilter
{
  public vws(UnifiedDebugManager paramUnifiedDebugManager, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */