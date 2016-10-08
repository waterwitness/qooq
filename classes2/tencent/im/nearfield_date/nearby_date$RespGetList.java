package tencent.im.nearfield_date;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_date$RespGetList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public nearby_date.BusiRespHead msg_head = new nearby_date.BusiRespHead();
  public final PBRepeatMessageField rpt_msg_user_list = PBField.initRepeatMessage(nearby_date.UserProfile.class);
  public final PBUInt32Field uint32_ended = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_head", "rpt_msg_user_list", "uint32_ended", "bytes_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RespGetList.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\nearfield_date\nearby_date$RespGetList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */