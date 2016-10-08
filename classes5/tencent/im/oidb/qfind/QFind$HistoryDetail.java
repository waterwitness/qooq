package tencent.im.oidb.qfind;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QFind$HistoryDetail
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "date", "run", "walk", "duration" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HistoryDetail.class);
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBUInt32Field duration = PBField.initUInt32(0);
  public final PBUInt32Field run = PBField.initUInt32(0);
  public final PBUInt32Field walk = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qfind\QFind$HistoryDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */