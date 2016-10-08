import android.util.Pair;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.WeakReferenceHandler;

public class lmf
  extends CardObserver
{
  public lmf(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void d(boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (this.a.isFinishing()) {
          return;
        }
        this.a.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
        this.a.v();
        if ((!paramBoolean) || (paramObject == null)) {
          return;
        }
        if ((paramObject instanceof Card))
        {
          ThreadManager.a(new lmg(this, (Card)paramObject), 5, null, true);
          return;
        }
        if (!(paramObject instanceof Pair)) {
          return;
        }
        paramObject = (Pair)paramObject;
        if (((Integer)((Pair)paramObject).first).intValue() == 101107)
        {
          this.a.g = 1;
          this.a.y();
          return;
        }
      }
      catch (Exception paramObject)
      {
        ((Exception)paramObject).printStackTrace();
        return;
      }
      if (((Integer)((Pair)paramObject).first).intValue() != 101108) {
        break;
      }
      this.a.g = 2;
    }
    if ((((Integer)((Pair)paramObject).first).intValue() >= 400000) && (((Integer)((Pair)paramObject).first).intValue() <= 499999))
    {
      Toast.makeText(this.a.getApplicationContext(), (CharSequence)((Pair)paramObject).second, 0).show();
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), 2131370897, 0).show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */