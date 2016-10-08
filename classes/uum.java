import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.Comparator;

class uum
  implements Comparator
{
  uum(uuk paramuuk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile1.lastModified() - paramFile2.lastModified();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */