import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rbm
  implements Runnable
{
  int jdField_a_of_type_Int;
  int b;
  
  public rbm(MessageProgressTextView paramMessageProgressTextView, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.b = null;
    if (!this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.c)
    {
      this.jdField_a_of_type_Int += this.b;
      MessageProgressTextView.a(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */