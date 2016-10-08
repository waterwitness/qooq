package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWatcher;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVideoWatcherListResponse
  extends BaseResponse
{
  public List a;
  public boolean a;
  public String b;
  
  public GetVideoWatcherListResponse(String paramString, qqstory_service.RspGetWatcher paramRspGetWatcher)
  {
    super(paramRspGetWatcher.result);
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = paramRspGetWatcher.next_cookie.get().toStringUtf8();
    if (paramRspGetWatcher.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      Iterator localIterator = paramRspGetWatcher.user_list.get().iterator();
      while (localIterator.hasNext())
      {
        qqstory_struct.UserInfo localUserInfo = (qqstory_struct.UserInfo)localIterator.next();
        QQUserUIItem localQQUserUIItem = new QQUserUIItem();
        localQQUserUIItem.convertFrom(localUserInfo);
        localUserManager.a(localQQUserUIItem);
        this.jdField_a_of_type_JavaUtilList.add(localQQUserUIItem);
      }
      bool1 = false;
    }
    int i = paramRspGetWatcher.view_total_num.get();
    int j = paramRspGetWatcher.stranger_view_total_num.get();
    paramRspGetWatcher = (StoryManager)SuperManager.a(5);
    paramString = paramRspGetWatcher.a(paramString);
    if (paramString != null)
    {
      paramString.mViewCount = i;
      paramString.mStrangerViewCount = j;
      paramRspGetWatcher.a(paramString.mVid, paramString);
    }
  }
  
  public String toString()
  {
    return "GetVideoWatcherListResponse{isEnd=" + this.jdField_a_of_type_Boolean + ", userList=" + this.jdField_a_of_type_JavaUtilList + ", nextCookie='" + this.b + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetVideoWatcherListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */