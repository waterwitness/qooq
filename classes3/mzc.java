import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollGroupFloatingListener;
import com.tencent.widget.AbsListView;

public class mzc
  extends SlideDetectListView.OnScrollGroupFloatingListener
{
  public mzc(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      UncommonlyUsedContactsActivity.a(this.a, paramInt1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */