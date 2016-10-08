import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallProxy;
import java.util.Comparator;

public class uah
  implements Comparator
{
  public uah(QCallProxy paramQCallProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */