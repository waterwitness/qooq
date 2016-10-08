import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;

public class ipd
  implements Runnable
{
  public ipd(StoryPlayVideoActivity.VideoViewPagerAdapter paramVideoViewPagerAdapter, StoryVideoItem paramStoryVideoItem, StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = ImageUtil.a();
    localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.app, 1, Long.toString(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid), 3, (Drawable)localObject, (Drawable)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.runOnUiThread(new ipe(this, (FaceDrawable)localObject));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */