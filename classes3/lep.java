import android.content.Intent;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class lep
  extends CardObserver
{
  public lep(DetailProfileActivity paramDetailProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, Card paramCard)
  {
    this.a.b();
    if ((!paramBoolean) || (paramInt != 0))
    {
      int i = 2131371671;
      if (paramInt == 36) {
        i = 2131371672;
      }
      this.a.a(i, 1);
      return;
    }
    this.a.c();
    paramCard = new Intent();
    paramCard.putExtra("changed", true);
    this.a.setResult(-1, paramCard);
    DetailProfileActivity.a(this.a, false);
    this.a.finish();
    this.a.overridePendingTransition(0, 2130968584);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (this.a.app.a().equals(((Card)paramObject).uin)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DetailProfileActivity", 2, "on my card download");
        }
        this.a.a((Card)paramObject);
      }
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DetailProfileActivity", 2, "onGetDetailInfo, isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (paramCard != null) && (this.a.app.a().equals(paramCard.uin))) {
      this.a.a(paramCard);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DetailProfileActivity", 2, "onGetLocationDescription, isSuccess = " + paramBoolean + ", card = ");
    }
    if ((paramBoolean) && (paramString.equals(this.a.app.a())) && (paramCard != null)) {
      this.a.a(paramCard);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */