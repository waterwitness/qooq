import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

class nom
  implements Runnable
{
  nom(noj paramnoj, WeakReference paramWeakReference, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    noj localnoj = (noj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localnoj == null) {
      return;
    }
    localnoj.a(this.jdField_a_of_type_Int, -1, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */