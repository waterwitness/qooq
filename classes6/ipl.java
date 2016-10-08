import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.WatcherListPagerLoader;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListView.OnWatcherViewListener;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ipl
  implements QQStoryWatcherListView.OnWatcherViewListener
{
  ipl(ipk paramipk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(true);
    if (this.a.a.a.J == 1) {
      this.a.a.a(ipk.a(this.a), 0);
    }
    for (;;)
    {
      this.a.a.a.a(this.a.a.a.P);
      ipk.a(this.a);
      return;
      if (this.a.a.a.J == 2) {
        this.a.a.a(ipk.a(this.a), 5);
      }
    }
  }
  
  public void a(int paramInt)
  {
    ipk.a(this.a).a.setText(StoryVideoItem.getViewCountString(paramInt));
  }
  
  public void b()
  {
    this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatcherListPagerLoader.a(null, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */