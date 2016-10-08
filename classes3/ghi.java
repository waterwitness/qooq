import com.tencent.av.funchat.magicface.MagicfaceBaseDecoder;
import com.tencent.av.funchat.magicface.MagicfaceBaseDecoder.MagicPlayListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ghi
  implements Runnable
{
  public ghi(MagicfaceBaseDecoder paramMagicfaceBaseDecoder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    this.a.jdField_a_of_type_Boolean = true;
    if (this.a.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null) {
      this.a.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener.a();
    }
    this.a.e();
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null) {
      this.a.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener.b();
    }
    Thread.currentThread().setPriority(i);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ghi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */