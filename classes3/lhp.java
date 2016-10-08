import android.os.Handler;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lhp
  extends CardObserver
{
  public lhp(EditTagActivity paramEditTagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    if (paramBoolean) {
      this.a.d(2131369177);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
      return;
      this.a.d(2131369178);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */