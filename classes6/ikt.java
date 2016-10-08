import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ikt
  implements View.OnClickListener
{
  public ikt(QQStoryDiscoverActivity paramQQStoryDiscoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ((PreloadDownloaderManager)SuperManager.a(6)).a(paramView.getContext(), 2);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */