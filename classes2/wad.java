import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;

public final class wad
  implements WebProcessManager.WebProcessStartListener
{
  public wad(PreloadProcHitSession paramPreloadProcHitSession)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a != null)) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */