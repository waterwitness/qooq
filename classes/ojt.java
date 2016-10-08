import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.List;

public class ojt
  extends TroopObserver
{
  public ojt(RecommendTroopView paramRecommendTroopView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      this.a.a.a().sendEmptyMessage(105);
      RecommendTroopView.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */