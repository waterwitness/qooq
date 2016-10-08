import android.view.ViewGroup;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV.GetResListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ghk
  implements MagicfaceManagerForAV.GetResListener
{
  public ghk(MagicfaceManagerForAV paramMagicfaceManagerForAV, ViewGroup paramViewGroup, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_AndroidViewViewGroup.post(new ghl(this));
    }
  }
  
  public void b(String paramString, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ghk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */