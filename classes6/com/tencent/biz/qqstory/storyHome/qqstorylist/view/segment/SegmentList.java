package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MyStoryListEventListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SegmentList
{
  public static final String a = "Q.qqstory.homeSegmentList";
  protected SegmentList.SegmentNotiChangeListener a;
  public List a;
  protected Map a;
  
  private SegmentList()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private SegmentList a(SegmentView paramSegmentView)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramSegmentView);
    this.jdField_a_of_type_JavaUtilMap.put(paramSegmentView.a(), paramSegmentView);
    return this;
  }
  
  public int a()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((SegmentView)this.jdField_a_of_type_JavaUtilList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((SegmentView)this.jdField_a_of_type_JavaUtilList.get(i)).a();
      if (paramInt < j) {
        return i;
      }
      i += 1;
    }
    j = 0;
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      SLog.b("Q.qqstory.homeSegmentList", "viewList(" + j + ")=" + this.jdField_a_of_type_JavaUtilList.get(j));
      j += 1;
    }
    SLog.b("Q.qqstory.homeSegmentList", "type=" + i + "positon=" + paramInt);
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    long l = System.currentTimeMillis();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramBaseViewHolder.b())
    {
      i -= ((SegmentView)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a();
      paramInt += 1;
    }
    SegmentView localSegmentView = (SegmentView)this.jdField_a_of_type_JavaUtilList.get(paramBaseViewHolder.b());
    paramBaseViewHolder.a(i);
    paramBaseViewHolder = localSegmentView.a(i, paramBaseViewHolder, paramViewGroup);
    if (System.currentTimeMillis() - l > 30L) {
      SLog.b("Q.qqstory.homeSegmentList", "bind view Completed:" + (System.currentTimeMillis() - l));
    }
    return paramBaseViewHolder;
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int k = a(paramInt);
    SegmentView localSegmentView = (SegmentView)this.jdField_a_of_type_JavaUtilList.get(k);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i -= ((SegmentView)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a();
      paramInt += 1;
    }
    paramViewGroup = localSegmentView.a(i, paramViewGroup);
    paramViewGroup.b(k);
    paramViewGroup.a(i);
    return paramViewGroup;
  }
  
  public BaseViewHolder a(String paramString, int paramInt)
  {
    paramString = (SegmentView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.a(paramInt);
    }
    return null;
  }
  
  public SegmentView a(String paramString)
  {
    return (SegmentView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(MyStoryListEventListener paramMyStoryListEventListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).a(paramMyStoryListEventListener);
    }
  }
  
  public void a(SegmentList.SegmentNotiChangeListener paramSegmentNotiChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList$SegmentNotiChangeListener = paramSegmentNotiChangeListener;
  }
  
  public void a(String paramString, Object paramObject)
  {
    paramString = (SegmentView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.a(paramObject);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = (SegmentView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentSegmentList$SegmentNotiChangeListener.c(paramBoolean);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\segment\SegmentList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */