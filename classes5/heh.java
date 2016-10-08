import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;
import com.tencent.biz.JoinGroupTransitActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class heh
  implements JoinGroupHandler.IJoinGroupCB
{
  public heh(JoinGroupTransitActivity paramJoinGroupTransitActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(1);
  }
  
  public void b()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(2);
  }
  
  public void c()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\heh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */