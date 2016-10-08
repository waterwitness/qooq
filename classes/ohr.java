import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;

public class ohr
  extends PublicAccountObserver
{
  public ohr(PublicView paramPublicView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      PublicView.a(this.a).a(0);
      PublicView.a(this.a).sendEmptyMessage(1);
      PublicView.a(this.a).sendEmptyMessage(3);
      return;
    }
    PublicView.a(this.a).H();
    PublicView.a(this.a, 1, 2131368597);
    PublicView.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */