import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mbh
  extends PublicAccountObserver
{
  public mbh(PublicAccountListActivity paramPublicAccountListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.f();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.f();
    }
  }
  
  public void b(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramInt == 0) {
      this.a.f();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */