package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetStoryDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetStoryDesResponse
  extends BaseResponse
{
  public static final String b = "GetStoryDesResponse";
  public List a;
  
  public GetStoryDesResponse(qqstory_service.RspGetStoryDes paramRspGetStoryDes)
  {
    super(paramRspGetStoryDes.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
    Object localObject = paramRspGetStoryDes.story_list.get();
    paramRspGetStoryDes = (UserManager)SuperManager.a(2);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      qqstory_struct.StoryDes localStoryDes = (qqstory_struct.StoryDes)((Iterator)localObject).next();
      StoryItem localStoryItem = new StoryItem();
      localStoryItem.convertFrom(0, localStoryDes);
      localStoryItem.type = 0;
      localStoryItem.key = StoryItem.makeFriendKey(localStoryItem.user.uid);
      paramRspGetStoryDes.a(localStoryItem.user);
      this.a.add(localStoryItem);
    }
  }
  
  public String toString()
  {
    return "GetStoryDesResponse{storyItemList=" + this.a.size() + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetStoryDesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */