package tencent.im.new_year_report;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackReport$PkgReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uin", "promotion_id", "report", "seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L) }, PkgReq.class);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBRepeatMessageField report = PBField.initRepeatMessage(PackReport.Report.class);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\new_year_report\PackReport$PkgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */