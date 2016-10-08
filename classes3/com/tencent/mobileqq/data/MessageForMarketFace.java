package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.MarketFace;

public class MessageForMarketFace
  extends ChatMessage
{
  public MarkFaceMessage mMarkFaceMessage;
  public int msgVia;
  public boolean needToPlay;
  public String sendFaceName;
  
  public MessageForMarketFace()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static MessageForMarketFace parsePb(im_msg_body.MarketFace paramMarketFace)
  {
    MarkFaceMessage localMarkFaceMessage = new MarkFaceMessage();
    localMarkFaceMessage.cFaceInfo = paramMarketFace.uint32_face_info.get();
    localMarkFaceMessage.cSubType = paramMarketFace.uint32_sub_type.get();
    localMarkFaceMessage.dwMSGItemType = paramMarketFace.uint32_item_type.get();
    localMarkFaceMessage.dwTabID = paramMarketFace.uint32_tab_id.get();
    localMarkFaceMessage.sbfKey = paramMarketFace.bytes_key.get().toByteArray();
    localMarkFaceMessage.sbufID = paramMarketFace.bytes_face_id.get().toByteArray();
    localMarkFaceMessage.mediaType = paramMarketFace.uint32_media_type.get();
    localMarkFaceMessage.mobileparam = paramMarketFace.bytes_mobileparam.get().toByteArray();
    localMarkFaceMessage.resvAttr = paramMarketFace.bytes_ext_info.get().toByteArray();
    paramMarketFace = new MessageForMarketFace();
    paramMarketFace.mMarkFaceMessage = localMarkFaceMessage;
    return paramMarketFace;
  }
  
  protected void doParse()
  {
    try
    {
      this.mMarkFaceMessage = ((MarkFaceMessage)MessagePkgUtils.a(this.msgData));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public im_msg_body.MarketFace getSerialPB()
  {
    im_msg_body.MarketFace localMarketFace = new im_msg_body.MarketFace();
    if (this.mMarkFaceMessage.sbufID != null) {
      localMarketFace.bytes_face_id.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.sbufID));
    }
    if (this.mMarkFaceMessage.sbfKey != null) {
      localMarketFace.bytes_key.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.sbfKey));
    }
    localMarketFace.uint32_face_info.set(this.mMarkFaceMessage.cFaceInfo);
    localMarketFace.uint32_item_type.set(this.mMarkFaceMessage.dwMSGItemType);
    localMarketFace.uint32_sub_type.set(this.mMarkFaceMessage.cSubType);
    localMarketFace.uint32_tab_id.set(this.mMarkFaceMessage.dwTabID);
    localMarketFace.uint32_media_type.set(this.mMarkFaceMessage.mediaType);
    localMarketFace.bytes_mobileparam.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.mobileparam));
    localMarketFace.bytes_ext_info.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.resvAttr));
    return localMarketFace;
  }
  
  public String getSummaryMsg()
  {
    if ((this.mMarkFaceMessage != null) && (!TextUtils.isEmpty(this.mMarkFaceMessage.faceName)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[").append(this.mMarkFaceMessage.faceName).append("]");
      return localStringBuilder.toString();
    }
    return "原创表情";
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    if (this.mMarkFaceMessage != null) {}
    try
    {
      this.msgData = MessagePkgUtils.a(this.mMarkFaceMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForMarketFace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */