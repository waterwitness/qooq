import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.Comparator;

public class wtx
  implements Comparator
{
  public wtx()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareTo(paramFile2.getName());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */