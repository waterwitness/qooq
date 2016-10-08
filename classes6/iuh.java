import android.view.View;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MyStoryListEventListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.UGCLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.UGCSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class iuh
  extends ChildViewClickListener
{
  public iuh(UGCSegment paramUGCSegment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    paramObject = (UGCLayout)paramBaseViewHolder.a(2131302953);
    if ((paramObject == null) || (((UGCLayout)paramObject).a() == null)) {
      SLog.e("UGCSegment", "onClick not found ugc view");
    }
    for (;;)
    {
      return;
      paramInt = 0;
      while (paramInt < ((UGCLayout)paramObject).getChildCount())
      {
        if (paramView == ((UGCLayout)paramObject).getChildAt(paramInt))
        {
          this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMyStoryListEventListener.a(paramInt, (HotTopicItem)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt), paramView);
          return;
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */