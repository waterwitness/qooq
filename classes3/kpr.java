import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FilenameFilter;

class kpr
  implements FilenameFilter
{
  kpr(kpq paramkpq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */