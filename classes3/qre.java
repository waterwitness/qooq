import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileFilter;

public final class qre
  implements FileFilter
{
  public qre()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile)
  {
    if (!paramFile.isDirectory()) {}
    while (!ArkLocalAppMgr.a(paramFile.getName())) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */