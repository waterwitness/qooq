import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.od.LoadingUI;
import com.tencent.mobileqq.intervideo.od.LoadingUI.Event;

public class swi
  implements View.OnClickListener
{
  public swi(LoadingUI paramLoadingUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (LoadingUI.a(this.a) != null) {
      LoadingUI.a(this.a).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */