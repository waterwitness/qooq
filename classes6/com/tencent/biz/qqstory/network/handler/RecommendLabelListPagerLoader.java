package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetLabelListRequest;
import com.tencent.biz.qqstory.network.response.GetLabelListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class RecommendLabelListPagerLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static final int a = 10;
  public static final String a = "Q.qqstory.record.label.RecommendLabelListPagerLoader";
  public String b;
  public String c;
  
  public RecommendLabelListPagerLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void d()
  {
    GetLabelListRequest localGetLabelListRequest = new GetLabelListRequest();
    localGetLabelListRequest.c = this.b;
    localGetLabelListRequest.d = this.c;
    localGetLabelListRequest.a = 10;
    CmdTaskManger.a().a(localGetLabelListRequest, this);
  }
  
  public void a(GetLabelListRequest paramGetLabelListRequest, GetLabelListResponse paramGetLabelListResponse, ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.record.label.RecommendLabelListPagerLoader", "get recommend label list return %s", paramErrorMessage.toString());
    RecommendLabelListPagerLoader.GetRecommendLabelListEvent localGetRecommendLabelListEvent = new RecommendLabelListPagerLoader.GetRecommendLabelListEvent(paramErrorMessage);
    if ((paramGetLabelListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetRecommendLabelListEvent);
      return;
    }
    localGetRecommendLabelListEvent.jdField_a_of_type_JavaUtilList = paramGetLabelListResponse.jdField_a_of_type_JavaUtilList;
    localGetRecommendLabelListEvent.jdField_a_of_type_JavaLangString = paramGetLabelListRequest.c;
    localGetRecommendLabelListEvent.jdField_a_of_type_Boolean = paramGetLabelListResponse.jdField_a_of_type_Boolean;
    localGetRecommendLabelListEvent.c = TextUtils.isEmpty(paramGetLabelListRequest.d);
    this.c = paramGetLabelListResponse.b;
    localGetRecommendLabelListEvent.d = this.jdField_a_of_type_Boolean;
    Dispatchers.get().dispatch(localGetRecommendLabelListEvent);
    SLog.a("Q.qqstory.record.label.RecommendLabelListPagerLoader", "dispatch recommend label result %s", localGetRecommendLabelListEvent.toString());
  }
  
  public void a(TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.c = "";
    d();
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.b = str;
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\RecommendLabelListPagerLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */