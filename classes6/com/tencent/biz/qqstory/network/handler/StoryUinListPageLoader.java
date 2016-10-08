package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetStoryUinListRequest;
import com.tencent.biz.qqstory.network.response.GetStoryUinListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryUinListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static final int a = 10;
  public static final String a = "Q.qqstory.home.friend.StoryUinListPageLoader";
  public final int b;
  public String b;
  public boolean b;
  
  public StoryUinListPageLoader(boolean paramBoolean, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(boolean paramBoolean)
  {
    GetStoryUinListRequest localGetStoryUinListRequest = new GetStoryUinListRequest(this.jdField_b_of_type_Int);
    localGetStoryUinListRequest.jdField_b_of_type_Int = 10;
    localGetStoryUinListRequest.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localGetStoryUinListRequest.jdField_a_of_type_Boolean = paramBoolean;
    CmdTaskManger.a().a(localGetStoryUinListRequest, this);
  }
  
  public void a(GetStoryUinListRequest paramGetStoryUinListRequest, GetStoryUinListResponse paramGetStoryUinListResponse, ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.home.friend.StoryUinListPageLoader", "get story return %s", paramErrorMessage.toString());
    StoryUinListPageLoader.GetStoryUinListEvent localGetStoryUinListEvent = new StoryUinListPageLoader.GetStoryUinListEvent(paramErrorMessage, paramGetStoryUinListRequest);
    if ((paramGetStoryUinListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetStoryUinListEvent);
      return;
    }
    paramErrorMessage = (UserManager)SuperManager.a(2);
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramGetStoryUinListResponse.jdField_c_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        localArrayList.add(Long.valueOf(localQQUserUIItem.uid));
        paramErrorMessage.a(localQQUserUIItem);
      }
    }
    this.jdField_b_of_type_JavaLangString = paramGetStoryUinListResponse.jdField_c_of_type_JavaLangString;
    localGetStoryUinListEvent.jdField_a_of_type_Boolean = paramGetStoryUinListResponse.jdField_a_of_type_Boolean;
    localGetStoryUinListEvent.c = TextUtils.isEmpty(paramGetStoryUinListRequest.jdField_a_of_type_JavaLangString);
    localGetStoryUinListEvent.jdField_a_of_type_JavaUtilList = localArrayList;
    Dispatchers.get().dispatch(localGetStoryUinListEvent);
  }
  
  public void a(TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_b_of_type_JavaLangString = "";
    a(this.jdField_b_of_type_Boolean);
  }
  
  public void c()
  {
    super.c();
    a(this.jdField_b_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\StoryUinListPageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */