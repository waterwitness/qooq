import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.Executor;

public class quk
  implements Executor
{
  Runnable jdField_a_of_type_JavaLangRunnable;
  final qum jdField_a_of_type_Qum;
  
  private quk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Qum = new qum(30);
  }
  
  protected int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Qum.a();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_Qum.a();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null) {
        QQAnimationDrawable.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Qum.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.jdField_a_of_type_Qum.a(new qul(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\quk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */