import com.tencent.biz.ui.RefreshView.OnRefreshListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class syi
  implements RefreshView.OnRefreshListener
{
  public syi(UiApiPlugin paramUiApiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.dispatchJsEvent("qbrowserPullDown", null, null);
    UiApiPlugin.a(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */