package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 104 }, new String[] { "uint64_uin", "rspChannelArticle", "rspTopicList", "rpt_obsolete_topicid_list" }, new Object[] { Long.valueOf(0L), null, null, Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatField rpt_obsolete_topicid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public oidb_cmd0x68b.RspChannelArticle rspChannelArticle = new oidb_cmd0x68b.RspChannelArticle();
  public oidb_cmd0x68b.RspTopicList rspTopicList = new oidb_cmd0x68b.RspTopicList();
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x68b\oidb_cmd0x68b$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */