package msg.uin_list;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UinList$UinListUploadReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_cmd", "friend_list" }, new Object[] { Integer.valueOf(0), null }, UinListUploadReq.class);
  public final PBRepeatMessageField friend_list = PBField.initRepeatMessage(UinList.C2C.class);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msg\uin_list\UinList$UinListUploadReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */