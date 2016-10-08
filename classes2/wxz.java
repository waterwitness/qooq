import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.util.HandlerPlus;
import java.lang.ref.WeakReference;

public class wxz
  implements Runnable
{
  public int a;
  public long a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public wxz(HandlerPlus paramHandlerPlus, Runnable paramRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRunnable);
  }
  
  public void run()
  {
    Runnable localRunnable = (Runnable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localRunnable != null) && (this.jdField_a_of_type_Int > 0))
    {
      this.jdField_a_of_type_Int -= 1;
      localRunnable.run();
      if (this.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_ComTencentOpenUtilHandlerPlus.postDelayed(this, this.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */