package tencent.im.oidb.cmd0x439;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x439$ArticleInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_article_subject = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_sum_pic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_article_id", "bytes_article_subject", "bytes_article_url", "bytes_article_sum_pic" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ArticleInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x439\oidb_cmd0x439$ArticleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */