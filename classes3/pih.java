import com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollGroupFloatingListener;
import com.tencent.widget.AbsListView;

public class pih
  extends SlideDetectListView.OnScrollGroupFloatingListener
{
  public pih(TroopDiscussionTroop paramTroopDiscussionTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TroopDiscussionTroop.a(this.a) != null) {
      TroopDiscussionTroop.a(this.a, paramInt1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */