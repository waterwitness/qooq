import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class wty
  implements Comparator
{
  public wty()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(String paramString1, String paramString2)
  {
    return paramString1.compareTo(paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */