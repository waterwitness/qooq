import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FilenameFilter;

public final class ylw
  implements FilenameFilter
{
  public ylw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.endsWith(".lru");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */