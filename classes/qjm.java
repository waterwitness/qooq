import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetNearbyRecommender;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qjm
  extends CardObserver
{
  public qjm(GetNearbyRecommender paramGetNearbyRecommender)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetNearbyRecommender onGetDetailInfo|uin=" + paramString);
    }
    if (!GetNearbyRecommender.a(this.a).b.a().equals(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */