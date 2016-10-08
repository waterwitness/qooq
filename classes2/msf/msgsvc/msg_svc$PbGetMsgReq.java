package msf.msgsvc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbGetMsgReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field context_flag = PBField.initUInt32(0);
  public final PBUInt32Field latest_ramble_number = PBField.initUInt32(20);
  public final PBUInt32Field msg_req_type = PBField.initUInt32(0);
  public final PBUInt32Field online_sync_flag = PBField.initUInt32(1);
  public final PBUInt32Field other_ramble_number = PBField.initUInt32(3);
  public final PBBytesField pubaccount_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ramble_flag = PBField.initUInt32(1);
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
  public final PBEnumField sync_flag = PBField.initEnum(0);
  public final PBUInt32Field whisper_session_id = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.copyFromUtf8("");
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 82 }, new String[] { "sync_flag", "sync_cookie", "ramble_flag", "latest_ramble_number", "other_ramble_number", "online_sync_flag", "context_flag", "whisper_session_id", "msg_req_type", "pubaccount_cookie" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, PbGetMsgReq.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\msf\msgsvc\msg_svc$PbGetMsgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */