import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import java.util.HashMap;

public class tao
  implements Runnable
{
  public tao(PngFrameManager paramPngFrameManager, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).put(Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(true));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */