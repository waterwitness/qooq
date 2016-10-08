import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;
import com.tencent.mobileqq.troopreward.TroopRewardInfo;

class vvx
  implements Runnable
{
  vvx(vvw paramvvw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((TroopHandler)this.a.a.app.a(20)).a(this.a.a.a.troopUin, this.a.a.a.ownerUin, this.a.a.a.rewardId, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */