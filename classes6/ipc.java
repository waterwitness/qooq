import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ipc
  implements DialogInterface.OnDismissListener
{
  public ipc(StoryPlayVideoActivity.VideoViewPagerAdapter paramVideoViewPagerAdapter, StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder paramVideoViewHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter$VideoViewHolder.a != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter$VideoViewHolder.a.start();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */