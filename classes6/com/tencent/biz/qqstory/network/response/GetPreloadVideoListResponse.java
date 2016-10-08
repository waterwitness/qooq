package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPreloadVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.PreloadVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GetPreloadVideoListResponse
  extends BaseResponse
{
  private static final String b = "Q.qqstory.download.preload.GetPreloadVideoListResponse";
  public Map a;
  public int b;
  public Map b;
  
  public GetPreloadVideoListResponse(int paramInt, qqstory_service.RspGetPreloadVideoList paramRspGetPreloadVideoList)
  {
    super(paramRspGetPreloadVideoList.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      a(paramRspGetPreloadVideoList);
      return;
    case 2: 
      b(paramRspGetPreloadVideoList);
      return;
    }
    c(paramRspGetPreloadVideoList);
  }
  
  private void a(qqstory_service.RspGetPreloadVideoList paramRspGetPreloadVideoList)
  {
    Object localObject1 = paramRspGetPreloadVideoList.preload_video_list.get();
    paramRspGetPreloadVideoList = (StoryManager)SuperManager.a(5);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (qqstory_struct.PreloadVideoInfo)((Iterator)localObject1).next();
      long l = ((qqstory_struct.PreloadVideoInfo)localObject2).id.get();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((qqstory_struct.PreloadVideoInfo)localObject2).video_list.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        qqstory_struct.StoryVideoDes localStoryVideoDes = (qqstory_struct.StoryVideoDes)((Iterator)localObject2).next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.download.preload.GetPreloadVideoListResponse", localStoryVideoDes);
        localArrayList.add(localStoryVideoItem);
        localStoryVideoItem.mPreloadMsg = "";
        paramRspGetPreloadVideoList.a(localStoryVideoItem.mVid, localStoryVideoItem);
      }
      this.a.put(Long.valueOf(l), localArrayList);
    }
  }
  
  private void b(qqstory_service.RspGetPreloadVideoList paramRspGetPreloadVideoList)
  {
    Object localObject1 = paramRspGetPreloadVideoList.preload_video_list.get();
    paramRspGetPreloadVideoList = (StoryManager)SuperManager.a(5);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (qqstory_struct.PreloadVideoInfo)((Iterator)localObject1).next();
      long l = ((qqstory_struct.PreloadVideoInfo)localObject2).id.get();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((qqstory_struct.PreloadVideoInfo)localObject2).video_list.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        qqstory_struct.StoryVideoDes localStoryVideoDes = (qqstory_struct.StoryVideoDes)((Iterator)localObject2).next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.download.preload.GetPreloadVideoListResponse", localStoryVideoDes);
        localArrayList.add(localStoryVideoItem);
        localStoryVideoItem.mPreloadMsg = ("from ugc , uin = " + l);
        paramRspGetPreloadVideoList.a(localStoryVideoItem.mVid, localStoryVideoItem);
      }
      this.a.put(Long.valueOf(l), localArrayList);
    }
  }
  
  private void c(qqstory_service.RspGetPreloadVideoList paramRspGetPreloadVideoList)
  {
    Object localObject1 = paramRspGetPreloadVideoList.preload_video_list.get();
    paramRspGetPreloadVideoList = (StoryManager)SuperManager.a(5);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (qqstory_struct.PreloadVideoInfo)((Iterator)localObject1).next();
      String str = ((qqstory_struct.PreloadVideoInfo)localObject2).union_id.get().toStringUtf8();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((qqstory_struct.PreloadVideoInfo)localObject2).video_list.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        qqstory_struct.StoryVideoDes localStoryVideoDes = (qqstory_struct.StoryVideoDes)((Iterator)localObject2).next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.download.preload.GetPreloadVideoListResponse", localStoryVideoDes);
        localArrayList.add(localStoryVideoItem);
        localStoryVideoItem.mPreloadMsg = ("from pgc , unionId = " + str);
        paramRspGetPreloadVideoList.a(localStoryVideoItem.mVid, localStoryVideoItem);
      }
      this.jdField_b_of_type_JavaUtilMap.put(str, localArrayList);
    }
  }
  
  public String toString()
  {
    return "GetPreloadVideoListResponse{mUinPreloadVideoList=" + this.a.keySet() + ", pullType=" + this.jdField_b_of_type_Int + ", mUnionIdPreloadVideoList=" + this.jdField_b_of_type_JavaUtilMap.keySet() + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetPreloadVideoListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */