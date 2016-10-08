package tencent.im.cs.MQKanDianSvc0x001;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MQKanDianSvc0x001$RspBody$WordsOfCut
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_str_words" }, new Object[] { "" }, WordsOfCut.class);
  public final PBRepeatField rpt_str_words = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\MQKanDianSvc0x001\MQKanDianSvc0x001$RspBody$WordsOfCut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */