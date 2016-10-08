package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x75e$RspArticle
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "enum_op_type", "rpt_article_info" }, new Object[] { Integer.valueOf(1), null }, RspArticle.class);
  public final PBEnumField enum_op_type = PBField.initEnum(1);
  public final PBRepeatMessageField rpt_article_info = PBField.initRepeatMessage(oidb_cmd0x75e.ArticleInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x75e\oidb_cmd0x75e$RspArticle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */