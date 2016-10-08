import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;

public class gph
  extends VipFunCallMediaListener
{
  public gph(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.a.a != null) {
      this.a.a.a().postDelayed(new gpi(this), 0L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      this.a.a.a().post(new gpj(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */