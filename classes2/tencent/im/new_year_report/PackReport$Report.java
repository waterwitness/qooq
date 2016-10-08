package tencent.im.new_year_report;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackReport$Report
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "elems" }, new Object[] { Long.valueOf(0L), null }, Report.class);
  public final PBRepeatMessageField elems = PBField.initRepeatMessage(PackReport.ReportElem.class);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\new_year_report\PackReport$Report.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */