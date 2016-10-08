package com.tencent.biz.qqstory.pgc.model;

import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RecommendItem;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RecommendItem
{
  public Story a;
  public UserInfo a;
  
  public RecommendItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static RecommendItem a(qqstory_pgc.RecommendItem paramRecommendItem)
  {
    if ((paramRecommendItem == null) || (!paramRecommendItem.has())) {
      return null;
    }
    RecommendItem localRecommendItem = new RecommendItem();
    localRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = UserInfo.convertFrom((qqstory_pgc.UserInfo)paramRecommendItem.user.get());
    localRecommendItem.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory = Story.convertFrom((qqstory_pgc.StoryInfo)paramRecommendItem.story_info.get());
    return localRecommendItem;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.checkData()) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.checkData());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof RecommendItem))
    {
      paramObject = (RecommendItem)paramObject;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.equals(((RecommendItem)paramObject).jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo))) {}
      while ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.equals(((RecommendItem)paramObject).jdField_a_of_type_ComTencentBizQqstoryPgcModelStory))) {
        return false;
      }
    }
    return true;
  }
  
  public String toString()
  {
    return "RecommendItem{userInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo + ", story=" + this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\RecommendItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */