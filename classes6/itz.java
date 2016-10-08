import android.view.View;
import android.widget.ProgressBar;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.UserClickManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MyStoryListEventListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MyStorySegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.SegmentList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class itz
  extends ChildViewClickListener
{
  public itz(MyStorySegment paramMyStorySegment, BaseViewHolder paramBaseViewHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    boolean bool;
    if (paramView == paramBaseViewHolder.a(2131302911))
    {
      paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a())
      {
        bool = true;
        paramView.a(bool);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a());
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a()) {
          break label101;
        }
        paramView = "1";
        label77:
        StoryReportor.a("mystory", "clk_fold", 0, 0, new String[] { paramView });
      }
    }
    label101:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        paramView = "2";
        break label77;
        if (paramView == paramBaseViewHolder.a(2131302913))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a());
          return;
        }
      } while (paramView != this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder.a());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys, paramView);
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a() == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() <= 0));
    paramView = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() - 1);
    ((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.c, String.valueOf(QQStoryContext.a().a()), paramView.mVid);
    ((StoryManager)SuperManager.a(5)).a().a().a(IPreloadVideoSource.c, String.valueOf(QQStoryContext.a().a()));
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
    if (((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.c, QQStoryContext.a().a(), true)) {}
    for (paramInt = 2;; paramInt = 0)
    {
      paramView.g = paramInt;
      SLog.d(MyStorySegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment), "onClick my story,mpreloadState=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.g);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.g == 2) {
        break;
      }
      if (NetworkUtil.h(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_AndroidContentContext)) {
        break label424;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_AndroidContentContext, 1, "当前网络不可用，请检查你的网络设置", 0).a();
      return;
    }
    label424:
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentMyStorySegment.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    ((ProgressBar)paramBaseViewHolder.a(2131302906)).setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */