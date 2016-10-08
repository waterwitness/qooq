package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetOfficialRecommendStoryListRequest;
import com.tencent.biz.qqstory.network.response.GetOfficialRecommendStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class OfficialRecommendListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static final String a = ":OfficialRecommendListPageLoader";
  
  public OfficialRecommendListPageLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GetOfficialRecommendStoryListRequest paramGetOfficialRecommendStoryListRequest, GetOfficialRecommendStoryListResponse paramGetOfficialRecommendStoryListResponse, ErrorMessage paramErrorMessage)
  {
    boolean bool = true;
    SLog.b(":OfficialRecommendListPageLoader", "OfficialRecommendListPageLoader onCmdRespond return :" + paramErrorMessage);
    paramGetOfficialRecommendStoryListRequest = new OfficialRecommendListPageLoader.GetOfficialRecommendListEvent(paramErrorMessage);
    if ((paramGetOfficialRecommendStoryListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(paramGetOfficialRecommendStoryListRequest);
      return;
    }
    paramGetOfficialRecommendStoryListRequest.jdField_a_of_type_JavaUtilList = paramGetOfficialRecommendStoryListResponse.jdField_a_of_type_JavaUtilList;
    paramGetOfficialRecommendStoryListRequest.jdField_a_of_type_Boolean = true;
    if (paramGetOfficialRecommendStoryListResponse.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      paramGetOfficialRecommendStoryListRequest.c = bool;
      paramGetOfficialRecommendStoryListRequest.d = false;
      Dispatchers.get().dispatch(paramGetOfficialRecommendStoryListRequest);
      SLog.b(":OfficialRecommendListPageLoader", "dispatch OfficialRecommendListPageLoader onCmdRespond GetOfficialRecommendStoryListRequest result: " + paramGetOfficialRecommendStoryListRequest);
      return;
      bool = false;
    }
  }
  
  public void a(TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    d();
  }
  
  public void d()
  {
    GetOfficialRecommendStoryListRequest localGetOfficialRecommendStoryListRequest = new GetOfficialRecommendStoryListRequest();
    localGetOfficialRecommendStoryListRequest.a = ((QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180)).a("StorySvc.pgc_subscribe_recommend_list");
    CmdTaskManger.a().a(localGetOfficialRecommendStoryListRequest, this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\OfficialRecommendListPageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */