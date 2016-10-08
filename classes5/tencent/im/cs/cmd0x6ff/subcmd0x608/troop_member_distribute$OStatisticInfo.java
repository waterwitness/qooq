package tencent.im.cs.cmd0x6ff.subcmd0x608;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class troop_member_distribute$OStatisticInfo
  extends MessageMicro
{
  public static final int STATISTIC_TYPE_CITY = 4;
  public static final int STATISTIC_TYPE_GENDER = 1;
  public static final int STATISTIC_TYPE_MARITAL = 3;
  public static final int STATISTIC_TYPE_YEAR = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_statistic_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_desc", "uint32_count", "uint32_statistic_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, OStatisticInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x6ff\subcmd0x608\troop_member_distribute$OStatisticInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */