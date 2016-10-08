import android.os.Handler;
import com.tencent.av.utils.SparkDot;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hbv
  implements Runnable
{
  public hbv(SparkDot paramSparkDot)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.c %= this.a.e;
    this.a.a(this.a.c);
    SparkDot localSparkDot = this.a;
    localSparkDot.c += 1;
    if (SparkDot.a(this.a)) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, this.a.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */