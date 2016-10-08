package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop$SQQSHPAccoutRelation
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "puin", "binduin", "distance", "customerservice" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(-1), Integer.valueOf(0) }, SQQSHPAccoutRelation.class);
  public final PBUInt64Field binduin = PBField.initUInt64(0L);
  public final PBInt32Field customerservice = PBField.initInt32(0);
  public final PBInt32Field distance = PBField.initInt32(-1);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qqshop\qqshop$SQQSHPAccoutRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */