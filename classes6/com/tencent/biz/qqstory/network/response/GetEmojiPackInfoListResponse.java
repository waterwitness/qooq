package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.EmoticonPack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GetEmojiPackInfoListResponse
  extends BaseResponse
{
  private static final String c = "GetEmojiPackInfoListResponse";
  public final List a;
  public final boolean a;
  public final String b;
  
  public GetEmojiPackInfoListResponse(qqstory_service.RspGetEmoticonPackList paramRspGetEmoticonPackList)
  {
    super(paramRspGetEmoticonPackList.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ArrayList localArrayList;
    if (paramRspGetEmoticonPackList.is_end.get() != 0)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.b = paramRspGetEmoticonPackList.next_cookie.get().toStringUtf8();
      localArrayList = new ArrayList();
      paramRspGetEmoticonPackList = paramRspGetEmoticonPackList.pack_list.get();
      if (paramRspGetEmoticonPackList != null) {
        paramRspGetEmoticonPackList = paramRspGetEmoticonPackList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramRspGetEmoticonPackList.hasNext()) {
          break label150;
        }
        GetEmojiPackInfoListResponse.EmojiPack localEmojiPack = new GetEmojiPackInfoListResponse.EmojiPack((qqstory_struct.EmoticonPack)paramRspGetEmoticonPackList.next());
        if (localEmojiPack.a())
        {
          localArrayList.add(localEmojiPack);
          continue;
          bool = false;
          break;
        }
        SLog.d("GetEmojiPackInfoListResponse", "found invalid data we ignore it : " + localEmojiPack);
      }
    }
    label150:
    this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(localArrayList);
  }
  
  public String toString()
  {
    return "GetEmojiPackInfoListResponse{mEmojiPackList.size=" + this.jdField_a_of_type_JavaUtilList.size() + ", mIsEnd=" + this.jdField_a_of_type_Boolean + ", mNextCookie='" + this.b + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetEmojiPackInfoListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */