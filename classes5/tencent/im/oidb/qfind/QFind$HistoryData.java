package tencent.im.oidb.qfind;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QFind$HistoryData
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "details", "tag" }, new Object[] { null, Integer.valueOf(0) }, HistoryData.class);
  public final PBRepeatMessageField details = PBField.initRepeatMessage(QFind.HistoryDetail.class);
  public final PBUInt32Field tag = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\qfind\QFind$HistoryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */