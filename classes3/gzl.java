import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gzl
  implements QavInOutAnimation.QavOutAnimationListener
{
  gzl(gzj paramgzj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.a.a.a != null)
    {
      this.a.a.a.setViewEnable(20, false);
      this.a.a.a.setViewEnable(18, false);
      this.a.a.a.setViewEnable(19, false);
      this.a.a.a.setViewEnable(21, false);
      this.a.a.a.setViewEnable(22, false);
      this.a.a.a.setViewEnable(23, false);
    }
  }
  
  public void b()
  {
    this.a.a.e = true;
    this.a.a.finish();
    this.a.a.overridePendingTransition(0, 2130968713);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */