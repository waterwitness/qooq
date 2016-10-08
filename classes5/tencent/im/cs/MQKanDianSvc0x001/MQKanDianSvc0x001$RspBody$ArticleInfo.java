package tencent.im.cs.MQKanDianSvc0x001;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MQKanDianSvc0x001$RspBody$ArticleInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_subject", "str_abstract", "str_content_url" }, new Object[] { "", "", "" }, ArticleInfo.class);
  public final PBStringField str_abstract = PBField.initString("");
  public final PBStringField str_content_url = PBField.initString("");
  public final PBStringField str_subject = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\MQKanDianSvc0x001\MQKanDianSvc0x001$RspBody$ArticleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */