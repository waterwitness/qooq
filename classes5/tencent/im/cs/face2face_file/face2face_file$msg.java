package tencent.im.cs.face2face_file;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class face2face_file$msg
  extends MessageMicro
{
  public static final int RESULT_FIELD_NUMBER = 2;
  public static final int VERSION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "version", "result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, msg.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\face2face_file\face2face_file$msg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */