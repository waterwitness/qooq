import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MyStorySegment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iua
  implements View.OnLongClickListener
{
  public iua(MyStorySegment paramMyStorySegment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    ((PreloadDownloaderManager)SuperManager.a(6)).a(paramView.getContext(), 1);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */