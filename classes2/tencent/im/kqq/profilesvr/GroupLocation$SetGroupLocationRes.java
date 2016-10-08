package tencent.im.kqq.profilesvr;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GroupLocation$SetGroupLocationRes
  extends MessageMicro
{
  public static final int GROUPLOCATION_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "grouplocation" }, new Object[] { Integer.valueOf(-1), "" }, SetGroupLocationRes.class);
  public final PBStringField grouplocation = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(-1);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\kqq\profilesvr\GroupLocation$SetGroupLocationRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */