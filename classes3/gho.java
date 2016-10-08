import android.os.Handler;
import com.tencent.av.funchat.magicface.MagicfaceBaseDecoder.MagicPlayListener;
import com.tencent.av.funchat.magicface.MagicfaceViewControllerForAV;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gho
  implements MagicfaceBaseDecoder.MagicPlayListener
{
  public gho(MagicfaceViewControllerForAV paramMagicfaceViewControllerForAV, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV.a("【magicface】 cost =" + (l1 - l2) + "ms");
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV.b("endMagicPlay");
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV.a.post(new ghp(this));
  }
  
  public void c() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */