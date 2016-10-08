package com.tencent.biz.qqstory.storyHome.qqstorylist;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OfficialStoryBean
{
  public int a;
  public StoryVideoItem a;
  public final String a;
  public String b;
  public String c;
  public String d;
  
  public OfficialStoryBean(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public StoryVideoItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  }
  
  public OfficialStoryBean a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public OfficialStoryBean a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public OfficialStoryBean b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public OfficialStoryBean c(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "OfficialStoryBean{title='" + this.b + '\'' + ", localDrawableId=" + this.jdField_a_of_type_Int + ", coverUrl='" + this.d + '\'' + ", HotTopicVideoItem=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\OfficialStoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */