import android.view.View;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class skb
  implements Runnable
{
  public skb(FileWebView paramFileWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.getContentHeight() * this.a.getScale() - (this.a.getView().getHeight() + this.a.getWebScrollY()) < this.a.getView().getHeight() / 5) && (!FileManagerUtil.a()) && (this.a.a != null)) {
      this.a.a.g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\skb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */