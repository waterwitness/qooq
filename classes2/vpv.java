import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FilenameFilter;

class vpv
  implements FilenameFilter
{
  vpv(vpu paramvpu)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */