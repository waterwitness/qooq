package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RecommendItem;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetMediaStory;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetOfficialRecommendStoryListResponse
  extends BaseResponse
{
  public List a;
  public boolean a;
  public int b;
  
  public GetOfficialRecommendStoryListResponse(qqstory_pgc.RspGetMediaStory paramRspGetMediaStory)
  {
    this(paramRspGetMediaStory, false);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetOfficialRecommendStoryListResponse(qqstory_pgc.RspGetMediaStory paramRspGetMediaStory, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject = (qqstory_pgc.ErrorInfo)paramRspGetMediaStory.result.get();
    this.jdField_a_of_type_Int = ((qqstory_pgc.ErrorInfo)localObject).error_code.get();
    this.jdField_a_of_type_JavaLangString = ((qqstory_pgc.ErrorInfo)localObject).error_desc.get().toStringUtf8();
    int i;
    label152:
    RecommendItem localRecommendItem;
    if (((qqstory_pgc.ErrorInfo)localObject).error_code.get() == 0)
    {
      this.b = paramRspGetMediaStory.seq.get();
      localObject = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180);
      i = ((QQStoryManager)localObject).a("StorySvc.pgc_subscribe_recommend_list");
      if ((i == this.b) && (!paramBoolean))
      {
        this.jdField_a_of_type_Boolean = false;
        SLog.a("Q.qqstory.pgc", "GetOfficialRecommendStoryListResponse handleGetMediaStoryList needUpdate = false;  seq=%d", Integer.valueOf(i));
        return;
      }
      Iterator localIterator = paramRspGetMediaStory.media_storys.get().iterator();
      i = 1;
      if (localIterator.hasNext())
      {
        localRecommendItem = RecommendItem.a((qqstory_pgc.RecommendItem)localIterator.next());
        if ((localRecommendItem == null) || (!localRecommendItem.a()))
        {
          if (paramBoolean) {
            break label281;
          }
          QQStoryManager.a("QQStoryHandler handleGetMediaStoryList item=" + localRecommendItem);
          i = 0;
        }
      }
    }
    for (;;)
    {
      break label152;
      this.jdField_a_of_type_JavaUtilList.add(localRecommendItem);
      continue;
      if ((paramBoolean) || (i == 0)) {
        break;
      }
      ((QQStoryManager)localObject).a("StorySvc.pgc_subscribe_media_list", this.b, paramRspGetMediaStory.toByteArray());
      return;
      SLog.a("Q.qqstory.pgc", "QQStoryHandler handleGetMediaStoryList error_code=%d", Integer.valueOf(((qqstory_pgc.ErrorInfo)localObject).error_code.get()));
      return;
      label281:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetOfficialRecommendStoryListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */