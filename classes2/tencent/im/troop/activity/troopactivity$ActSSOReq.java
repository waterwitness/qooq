package tencent.im.troop.activity;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class troopactivity$ActSSOReq
  extends MessageMicro
{
  public static final int BODY_FIELD_NUMBER = 3;
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int GROUP_CODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField cmd = PBField.initEnum(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "cmd", "group_code", "body" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, ActSSOReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\troop\activity\troopactivity$ActSSOReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */