import com.tencent.biz.helper.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mqu
  implements TroopInfoActivityHelper.ISetSameCityCheckTypeInfo
{
  public mqu(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    TroopInfoActivity.a(this.a, true, 0L, "");
  }
  
  public void b()
  {
    this.a.j();
    TroopInfoActivity.a(this.a, false, 0L, "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */