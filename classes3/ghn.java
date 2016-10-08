import com.tencent.av.funchat.magicface.MagicfaceBaseDecoder.MagicPlayListener;
import com.tencent.av.funchat.magicface.MagicfacePlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;

public class ghn
  implements MagicfaceBaseDecoder.MagicPlayListener
{
  public ghn(MagicfacePlayer paramMagicfacePlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.c("play video begin.");
    if (this.a.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null) {
      this.a.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.c("play audio begin.");
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_JavaLangString, 100);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_JavaLangString, 1);
  }
  
  public void b()
  {
    this.a.c("play video end.");
    if (this.a.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener != null) {
      this.a.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener.b();
    }
    if (MagicfacePlayer.a(this.a) != null)
    {
      MagicfacePlayer.a(this.a).a();
      MagicfacePlayer.a(this.a, null);
    }
    synchronized (this.a)
    {
      if ((this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData != null)) {
        this.a.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData, this.a.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener, this.a.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener);
      }
      return;
    }
  }
  
  public void c()
  {
    this.a.c("play audio end.");
    this.a.a(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ghn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */