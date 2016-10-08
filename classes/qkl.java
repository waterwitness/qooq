import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr.LocationInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qkl
  extends BizTroopObserver
{
  public qkl(LbsInfoMgr paramLbsInfoMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    double d;
    if (paramBoolean)
    {
      d = TroopMemberLbsHelper.a(paramLong1, paramLong2, LbsInfoMgr.a(this.a).b, LbsInfoMgr.a(this.a).a);
      if ((d > 500.0D) || (this.a.a >= 3600000)) {
        break label182;
      }
      LbsInfoMgr localLbsInfoMgr = this.a;
      localLbsInfoMgr.a *= 2;
    }
    for (;;)
    {
      LbsInfoMgr.a(this.a).b = paramLong1;
      LbsInfoMgr.a(this.a).a = paramLong2;
      TroopMemberLbsHelper.b(LbsInfoMgr.a(this.a));
      if (QLog.isColorLevel()) {
        QLog.i("LbsInfoMgr", 2, "获得经纬度: latitude: " + LbsInfoMgr.a(this.a).b + " longitude: " + LbsInfoMgr.a(this.a).a + " next interval = " + this.a.a);
      }
      return;
      label182:
      if (d > 500.0D) {
        this.a.a = 900000;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */