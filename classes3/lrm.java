import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;

class lrm
  implements WebProcessManager.WebProcessStartListener
{
  lrm(lrl paramlrl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      Leba.b(this.a.a.a).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */