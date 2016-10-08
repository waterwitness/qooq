import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

class vlo
  implements Comparator
{
  vlo(vln paramvln)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(Long paramLong1, Long paramLong2)
  {
    int i = 0;
    if (paramLong1.longValue() - paramLong2.longValue() > 0L) {
      i = 1;
    }
    while (paramLong1.longValue() - paramLong2.longValue() >= 0L) {
      return i;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vlo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */