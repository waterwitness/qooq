package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x592$ChangeMyNotificationReceivingStatusReq
  extends MessageMicro
{
  public static final int ADD_ME = 1;
  public static final int DELETE_ME = 2;
  public static final int OTHER_1 = 3;
  public static final int OTHER_2 = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_workflow_id" }, new Object[] { localByteStringMicro }, ChangeMyNotificationReceivingStatusReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x592\oidb_0x592$ChangeMyNotificationReceivingStatusReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */