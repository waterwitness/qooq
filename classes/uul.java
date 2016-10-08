import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FilenameFilter;

class uul
  implements FilenameFilter
{
  uul(uuk paramuuk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */