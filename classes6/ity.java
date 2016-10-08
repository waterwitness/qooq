import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MyStoryListEventListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MyStoryChildSegment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class ity
  extends ChildViewClickListener
{
  public ity(MyStoryChildSegment paramMyStoryChildSegment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramView == paramBaseViewHolder.a(2131302924)) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.a(paramInt, (MyStorys)paramObject);
    }
    do
    {
      return;
      if (paramView == paramBaseViewHolder.a())
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.a(paramInt, (StoryVideoItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt), paramView);
        return;
      }
    } while (paramView != paramBaseViewHolder.a(2131302923));
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.b(paramInt, (StoryVideoItem)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt), paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */