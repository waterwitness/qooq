import android.text.format.Time;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import java.io.File;
import java.io.FilenameFilter;

public class uyp
  implements FilenameFilter
{
  public uyp(ShareAppLogHelper paramShareAppLogHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if (!paramString.endsWith(".log")) {}
    do
    {
      return false;
      paramFile = ShareAppLogHelper.a(this.a, paramString);
    } while ((paramFile == null) || (paramFile.toMillis(false) < ShareAppLogHelper.a(this.a).toMillis(false)) || (paramFile.toMillis(false) > ShareAppLogHelper.b(this.a).toMillis(false)));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */