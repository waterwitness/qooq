import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.od.LoadingUI;

public class swh
  implements View.OnClickListener
{
  public swh(LoadingUI paramLoadingUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    LoadingUI.a(this.a).onBackPressed();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */