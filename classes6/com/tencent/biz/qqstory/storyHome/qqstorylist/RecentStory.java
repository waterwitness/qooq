package com.tencent.biz.qqstory.storyHome.qqstorylist;

import android.content.Context;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class RecentStory
{
  public StoryItem a;
  public List a;
  
  public RecentStory(StoryItem paramStoryItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem = paramStoryItem;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public float a()
  {
    return StoryListUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.updateTime);
  }
  
  public StoryItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem;
  }
  
  public StoryVideoItem a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return null;
    }
    return (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public RecentStory a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.user.nickName;
  }
  
  public String a(Context paramContext)
  {
    return StoryListUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.updateTime);
  }
  
  public void a(StoryItem paramStoryItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem = paramStoryItem;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(i)).mVid.equals(paramString))
        {
          this.jdField_a_of_type_JavaUtilList.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryItem.cover;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\RecentStory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */