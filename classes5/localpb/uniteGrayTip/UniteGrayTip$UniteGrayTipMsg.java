package localpb.uniteGrayTip;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UniteGrayTip$UniteGrayTipMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField business_related = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field graytip_id = PBField.initUInt32(0);
  public final PBStringField graytip_key = PBField.initString("");
  public final PBUInt32Field graytip_level = PBField.initUInt32(0);
  public final PBRepeatField graytip_mutex_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField hightlight_item = PBField.initRepeatMessage(UniteGrayTip.HightlightParam.class);
  public final PBUInt32Field isLocalTroopMsg = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64 }, new String[] { "graytip_id", "graytip_level", "graytip_mutex_id", "graytip_key", "content", "business_related", "hightlight_item", "isLocalTroopMsg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", localByteStringMicro, null, Integer.valueOf(0) }, UniteGrayTipMsg.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\localpb\uniteGrayTip\UniteGrayTip$UniteGrayTipMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */