import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class typ
{
  public int a;
  public final ArrayList a;
  public final int b;
  
  public typ()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList(100);
    this.b = 99;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\typ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */