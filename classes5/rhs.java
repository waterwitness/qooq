import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.TimeoutObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rhs
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public rhs(EmojiIPCAlarmer paramEmojiIPCAlarmer, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a.a(this.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */