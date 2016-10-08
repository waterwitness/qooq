import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollGroupFloatingListener;
import com.tencent.widget.AbsListView;

public class okn
  extends SlideDetectListView.OnScrollGroupFloatingListener
{
  public okn(TroopView paramTroopView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      TroopView.a(this.a, paramInt1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\okn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */