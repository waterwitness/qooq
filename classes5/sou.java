import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;

public class sou
  extends Handler
{
  public sou(FreshNewsDetailActivity paramFreshNewsDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.a(0, this.a.getString(2131369008), 0);
      this.a.a.H();
      return;
      this.a.b = false;
      this.a.j();
      this.a.a.H();
      if ((this.a.m == 1) || (this.a.m == 3)) {
        this.a.a("加载失败，请刷新重试", null);
      }
      this.a.a(1, "加载失败", 0);
      return;
    } while (!this.a.f);
    this.a.c("评论中...");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */