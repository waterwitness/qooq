package msg.uin_list;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UinList$UinListFetchRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_result", "friend_list" }, new Object[] { Integer.valueOf(0), null }, UinListFetchRsp.class);
  public final PBRepeatMessageField friend_list = PBField.initRepeatMessage(UinList.C2C.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msg\uin_list\UinList$UinListFetchRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */