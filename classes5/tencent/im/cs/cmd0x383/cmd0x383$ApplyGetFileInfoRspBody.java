package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x383$ApplyGetFileInfoRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "fileInfo" }, new Object[] { null }, ApplyGetFileInfoRspBody.class);
  public cmd0x383.ApplyGetFileListRspBody.FileInfo fileInfo = new cmd0x383.ApplyGetFileListRspBody.FileInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\cmd0x383\cmd0x383$ApplyGetFileInfoRspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */