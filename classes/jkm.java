import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;

public final class jkm
  implements Iterable
{
  public jkm(Iterable paramIterable, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Iterator iterator()
  {
    return new jkn(this);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jkm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */