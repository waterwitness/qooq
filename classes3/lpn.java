import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class lpn
  extends CardObserver
{
  public lpn(InterestSwitchEditActivity paramInterestSwitchEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (paramBoolean)
    {
      if ((this.a.app.a().equals(paramString)) && (paramCard != null) && (-1 != paramCard.switch_interest) && (-1 != paramCard.switch_music) && (-1 != paramCard.switch_recent_activity) && (-1 != paramCard.switch_star) && (-1 != paramCard.switch_joined_troop) && (-1 != paramCard.switch_ktv) && (-1 != paramCard.switch_eat) && (-1 != paramCard.switch_reader) && (-1 != paramCard.switch_radio) && (-1 != paramCard.switch_now) && (-1 != paramCard.switch_comic))
      {
        InterestSwitchEditActivity.a(this.a, paramCard);
        InterestSwitchEditActivity.a(this.a);
      }
      return;
    }
    QQToast.a(this.a, "拉取开关信息失败", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */