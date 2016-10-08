package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class HwSessionInfoPersistentPB
{
  public static final class HwSessionInfoPB
    extends MessageMicro<HwSessionInfoPB>
  {
    public static final int BYTES_HTTPCONN_SIG_SESSION_FIELD_NUMBER = 1;
    public static final int BYTES_SESSION_KEY_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_httpconn_sig_session = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_httpconn_sig_session", "bytes_session_key" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, HwSessionInfoPB.class);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\protocol\HwSessionInfoPersistentPB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */