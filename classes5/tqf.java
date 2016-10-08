import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.FutureTask;

public final class tqf
  extends FutureTask
  implements Comparable
{
  private final tqg a;
  
  public tqf(tqg paramtqg)
  {
    super(paramtqg, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramtqg;
  }
  
  public int a(tqf paramtqf)
  {
    tqc localtqc = this.a.a();
    paramtqf = paramtqf.a.a();
    if ((localtqc.b != null) && (paramtqf.b == null)) {
      return -1;
    }
    if ((localtqc.b == null) && (paramtqf.b != null)) {
      return 1;
    }
    if (!localtqc.jdField_a_of_type_JavaLangInteger.equals(paramtqf.jdField_a_of_type_JavaLangInteger)) {
      return localtqc.jdField_a_of_type_JavaLangInteger.compareTo(paramtqf.jdField_a_of_type_JavaLangInteger);
    }
    return localtqc.jdField_a_of_type_JavaLangLong.compareTo(paramtqf.jdField_a_of_type_JavaLangLong);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */