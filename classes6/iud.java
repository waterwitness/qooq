import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.UserClickManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MyStoryListEventListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.RecentStorySegment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;

public class iud
  extends ChildViewClickListener
{
  public iud(RecentStorySegment paramRecentStorySegment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    StoryItem localStoryItem = (StoryItem)paramObject;
    if (localStoryItem.preLoadStatus == 0)
    {
      localStoryItem.preLoadStatus = 1;
      this.a.a(localStoryItem);
      ((StoryManager)SuperManager.a(5)).a().a().a(IPreloadVideoSource.a, String.valueOf(localStoryItem.user.uid));
      ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131302886);
      TextView localTextView = (TextView)paramBaseViewHolder.a(2131302890);
      localTextView.setText("加载中...");
      ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 0.85F, 1.0F, 0.85F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation1.setDuration(300L);
      localScaleAnimation1.setFillAfter(false);
      ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131302885);
      ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.0F, 0.85F, 1.0F, 0.85F, 0, 0.5F, 1, 0.5F);
      localScaleAnimation2.setDuration(300L);
      localScaleAnimation2.setFillAfter(false);
      ((TextView)paramBaseViewHolder.a(2131302888)).startAnimation(localScaleAnimation2);
      localImageView.startAnimation(localScaleAnimation1);
      localTextView.startAnimation(localScaleAnimation2);
      if (!NetworkUtil.h(this.a.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, "当前网络不可用，请检查你的网络设置", 0).a();
        localStoryItem.preLoadStatus = 0;
        return;
      }
      this.a.jdField_a_of_type_JavaUtilHashMap.put(localStoryItem.key, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      localProgressBar.postDelayed(new iue(this, localProgressBar), 150L);
      if (Build.VERSION.SDK_INT >= 16) {
        paramBaseViewHolder.a().setBackground(localProgressBar.getResources().getDrawable(2130841384));
      }
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.a(paramInt, (StoryItem)paramObject, paramView);
  }
  
  public void b(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    paramObject = (StoryItem)paramObject;
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.a(paramInt, paramView, (StoryItem)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */