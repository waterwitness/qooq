import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.model.RecordVolume.RecordVolumeListener;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;

public class tbc
  implements RecordVolume.RecordVolumeListener
{
  public tbc(MagicfaceActionManager paramMagicfaceActionManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.b(paramInt, MagicfaceActionManager.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */