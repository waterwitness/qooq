package localpb.richMsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MixedMsg$Elem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "textMsg", "picMsg", "markfaceMsg", "sourceMsgInfo" }, new Object[] { "", null, null, "" }, Elem.class);
  public MarketFaceMsg.MarketFaceRec markfaceMsg = new MarketFaceMsg.MarketFaceRec();
  public RichMsg.PicRec picMsg = new RichMsg.PicRec();
  public final PBStringField sourceMsgInfo = PBField.initString("");
  public final PBStringField textMsg = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\localpb\richMsg\MixedMsg$Elem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */