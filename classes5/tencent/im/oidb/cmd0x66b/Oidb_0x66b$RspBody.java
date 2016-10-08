package tencent.im.oidb.cmd0x66b;

import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x66b$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rspbody_5eb = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rspbody_gift = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_msg_vistor_info = PBField.initRepeatMessage(appoint_define.PublisherInfo.class);
  public final PBRepeatMessageField stConfigList = PBField.initRepeatMessage(Oidb_0x66b.RspConfigItem.class);
  public Oidb_0x66b.RspLikeInfo stLikeInfo = new Oidb_0x66b.RspLikeInfo();
  public Oidb_0x66b.RspPansocialInfo stPansocialInfo = new Oidb_0x66b.RspPansocialInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 480802, 481602, 482402, 483202, 484002, 484802 }, new String[] { "bytes_rspbody_5eb", "stLikeInfo", "stPansocialInfo", "bytes_rspbody_gift", "stConfigList", "rpt_msg_vistor_info" }, new Object[] { localByteStringMicro1, null, null, localByteStringMicro2, null, null }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x66b\Oidb_0x66b$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */