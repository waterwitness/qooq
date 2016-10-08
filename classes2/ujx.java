import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.rn.RNAppManager;
import java.io.File;
import java.io.FilenameFilter;

public class ujx
  implements FilenameFilter
{
  public ujx(RNAppManager paramRNAppManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".bundle");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ujx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */