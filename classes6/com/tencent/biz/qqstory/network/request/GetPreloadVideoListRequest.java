package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPreloadVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPreloadVideoList;
import com.tencent.biz.qqstory.network.response.GetPreloadVideoListResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetPreloadVideoListRequest
  extends NetworkRequest
{
  private static final String a = "StorySvc.videolist_preload";
  public int a;
  public List a;
  public List b;
  
  public GetPreloadVideoListRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  private byte[] b()
  {
    qqstory_service.ReqGetPreloadVideoList localReqGetPreloadVideoList = new qqstory_service.ReqGetPreloadVideoList();
    if (this.jdField_a_of_type_Int == 1) {
      localReqGetPreloadVideoList.pull_type.set(2);
    }
    while (this.jdField_a_of_type_JavaUtilList != null)
    {
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          String str = localUserManager.a(((Long)localIterator.next()).longValue());
          if (!TextUtils.isEmpty(str))
          {
            localArrayList.add(ByteStringMicro.copyFromUtf8(str));
            continue;
            localReqGetPreloadVideoList.pull_type.set(1);
            break;
          }
        }
      }
      localReqGetPreloadVideoList.union_id_list.addAll(localArrayList);
    }
    return localReqGetPreloadVideoList.toByteArray();
  }
  
  private byte[] c()
  {
    qqstory_service.ReqGetPreloadVideoList localReqGetPreloadVideoList = new qqstory_service.ReqGetPreloadVideoList();
    localReqGetPreloadVideoList.pull_type.set(3);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Int == 2)) {
      localReqGetPreloadVideoList.ugc_topic_id_list.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    return localReqGetPreloadVideoList.toByteArray();
  }
  
  private byte[] d()
  {
    qqstory_service.ReqGetPreloadVideoList localReqGetPreloadVideoList = new qqstory_service.ReqGetPreloadVideoList();
    localReqGetPreloadVideoList.pull_type.set(1);
    if (this.b != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(ByteStringMicro.copyFromUtf8(str));
        }
      }
      localReqGetPreloadVideoList.union_id_list.addAll(localArrayList);
    }
    return localReqGetPreloadVideoList.toByteArray();
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPreloadVideoList localRspGetPreloadVideoList = new qqstory_service.RspGetPreloadVideoList();
    try
    {
      localRspGetPreloadVideoList.mergeFrom(paramArrayOfByte);
      return new GetPreloadVideoListResponse(this.jdField_a_of_type_Int, localRspGetPreloadVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return "StorySvc.videolist_preload";
  }
  
  protected byte[] a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return b();
    case 2: 
      return c();
    }
    return d();
  }
  
  public String toString()
  {
    return "GetPreloadVideoListRequest{pullType=" + this.jdField_a_of_type_Int + ", uinList=" + this.jdField_a_of_type_JavaUtilList + ", unionIdList=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetPreloadVideoListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */