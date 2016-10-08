package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MyStoryListEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.Iterator;
import java.util.List;

public class StoryHomeAdapter
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  protected Context a;
  public SegmentList a;
  protected boolean a;
  
  public StoryHomeAdapter(Context paramContext, SegmentList.Builder paramBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList = paramBuilder.a();
  }
  
  public void a(MyStoryListEventListener paramMyStoryListEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(paramMyStoryListEventListener);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    paramAbsListView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a.iterator();
    while (paramAbsListView.hasNext())
    {
      SegmentView localSegmentView = (SegmentView)paramAbsListView.next();
      if (paramInt == 0)
      {
        localSegmentView.c = false;
        localSegmentView.a();
      }
      else if (paramInt == 1)
      {
        localSegmentView.c = false;
      }
      else
      {
        localSegmentView.c = true;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(paramString, paramObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(paramString, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)paramView.getTag();
      paramView = localBaseViewHolder;
      if (localBaseViewHolder.b() == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(paramInt)) {}
    }
    for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(paramInt, paramViewGroup);; paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(paramInt, paramViewGroup)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.a(paramInt, paramView, paramViewGroup);
    }
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList.b();
  }
  
  public boolean isEmpty()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.isEmpty();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\StoryHomeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */