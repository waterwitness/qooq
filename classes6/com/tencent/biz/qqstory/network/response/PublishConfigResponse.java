package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPublishConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class PublishConfigResponse
  extends BaseResponse
{
  public boolean a;
  public boolean b;
  public boolean c;
  
  public PublishConfigResponse(qqstory_service.RspGetPublishConfig paramRspGetPublishConfig)
  {
    super(paramRspGetPublishConfig.result);
    boolean bool1 = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramRspGetPublishConfig.show_now_entry.get() == 1)
    {
      bool1 = true;
      this.a = bool1;
      if (paramRspGetPublishConfig.can_take_picture.get() != 1) {
        break label74;
      }
      bool1 = true;
      label45:
      this.b = bool1;
      if (paramRspGetPublishConfig.is_firsttime_show_take_pic.get() != 1) {
        break label79;
      }
    }
    label74:
    label79:
    for (bool1 = bool2;; bool1 = false)
    {
      this.c = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label45;
    }
  }
  
  public String toString()
  {
    return "PublishConfigResponse{firstTimePic=" + this.c + ", nowEntry=" + this.a + ", takePic=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\PublishConfigResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */