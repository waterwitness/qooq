package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;

public final class oidb_0x8f8$SubCmd01AddFeedsReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_feeds_type", "msg_feeds", "uint32_auto_pull_flag", "uint32_msg_type" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, SubCmd01AddFeedsReq.class);
  public group_feeds.GroupFeedsMessage msg_feeds = new group_feeds.GroupFeedsMessage();
  public final PBUInt32Field uint32_auto_pull_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8f8\oidb_0x8f8$SubCmd01AddFeedsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */