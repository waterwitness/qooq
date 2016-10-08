package localpb.richMsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MixedMsg$Msg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "elems" }, new Object[] { null }, Msg.class);
  public final PBRepeatMessageField elems = PBField.initRepeatMessage(MixedMsg.Elem.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\localpb\richMsg\MixedMsg$Msg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */