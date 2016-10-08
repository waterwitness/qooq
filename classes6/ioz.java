import android.os.Handler;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ioz
  implements Runnable
{
  public ioz(StoryPlayVideoActivity.VideoViewPagerAdapter paramVideoViewPagerAdapter, QQStoryLoadingView paramQQStoryLoadingView, QQStoryVideoPlayerErrorView paramQQStoryVideoPlayerErrorView, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.a.postDelayed(this, 50L);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ioz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */