package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import tencent.im.oidb.cmd0x6cd.RedpointInfo;
import tencent.im.oidb.cmd0x6cd.RepointExtraInfo;

public class RedTouchItem
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  public byte[] bytes;
  public String configVersion;
  public int count;
  public long curSeq;
  public long fromId;
  public String icon;
  public int lastRecvTime;
  public int passThroughLevel;
  public long receiveTime;
  public int redtouchType;
  public int taskId;
  public String tips;
  public boolean unReadFlag;
  public int validTimeRemained;
  
  public RedTouchItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.unReadFlag = true;
  }
  
  public static RedTouchItem getRedTouchItem(cmd0x6cd.RedpointInfo paramRedpointInfo)
  {
    long l2 = 0L;
    int j = 0;
    if ((paramRedpointInfo == null) || (!paramRedpointInfo.uint32_taskid.has()) || (!paramRedpointInfo.uint64_cur_seq.has())) {
      return null;
    }
    RedTouchItem localRedTouchItem = new RedTouchItem();
    int i;
    long l1;
    label82:
    label106:
    label158:
    label181:
    label225:
    String str;
    if (paramRedpointInfo.uint32_taskid.has())
    {
      i = paramRedpointInfo.uint32_taskid.get();
      localRedTouchItem.taskId = i;
      if (!paramRedpointInfo.uint64_cur_seq.has()) {
        break label334;
      }
      l1 = paramRedpointInfo.uint64_cur_seq.get();
      localRedTouchItem.curSeq = l1;
      if (!paramRedpointInfo.enum_redpoint_type.has()) {
        break label340;
      }
      i = paramRedpointInfo.enum_redpoint_type.get();
      localRedTouchItem.redtouchType = i;
      l1 = l2;
      if (paramRedpointInfo.uint64_from_id.has()) {
        l1 = paramRedpointInfo.uint64_from_id.get();
      }
      localRedTouchItem.fromId = l1;
      if (!paramRedpointInfo.uint32_last_recv_time.has()) {
        break label345;
      }
      i = paramRedpointInfo.uint32_last_recv_time.get();
      localRedTouchItem.lastRecvTime = i;
      if (!paramRedpointInfo.int32_remained_time.has()) {
        break label350;
      }
      i = paramRedpointInfo.int32_remained_time.get();
      localRedTouchItem.validTimeRemained = i;
      localRedTouchItem.receiveTime = System.currentTimeMillis();
      localRedTouchItem.configVersion = paramRedpointInfo.str_config_version.get();
      if (!paramRedpointInfo.msg_redpoint_extra_info.has()) {
        break label355;
      }
      paramRedpointInfo = (cmd0x6cd.RepointExtraInfo)paramRedpointInfo.msg_redpoint_extra_info.get();
      if (paramRedpointInfo != null)
      {
        i = j;
        if (paramRedpointInfo.uint32_count.has()) {
          i = paramRedpointInfo.uint32_count.get();
        }
        localRedTouchItem.count = i;
        if (!paramRedpointInfo.str_icon_url.has()) {
          break label360;
        }
        str = paramRedpointInfo.str_icon_url.get();
        label273:
        localRedTouchItem.icon = str;
        if (!paramRedpointInfo.str_tips.has()) {
          break label366;
        }
        str = paramRedpointInfo.str_tips.get();
        label296:
        localRedTouchItem.tips = str;
        if (!paramRedpointInfo.bytes_data.has()) {
          break label372;
        }
      }
    }
    label334:
    label340:
    label345:
    label350:
    label355:
    label360:
    label366:
    label372:
    for (paramRedpointInfo = paramRedpointInfo.bytes_data.get().toByteArray();; paramRedpointInfo = null)
    {
      localRedTouchItem.bytes = paramRedpointInfo;
      return localRedTouchItem;
      i = 0;
      break;
      l1 = 0L;
      break label82;
      i = 0;
      break label106;
      i = 0;
      break label158;
      i = 0;
      break label181;
      paramRedpointInfo = null;
      break label225;
      str = "";
      break label273;
      str = "";
      break label296;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\redtouch\RedTouchItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */