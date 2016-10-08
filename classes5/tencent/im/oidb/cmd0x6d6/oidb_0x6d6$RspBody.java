package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d6$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "upload_file_rsp", "resend_file_rsp", "download_file_rsp", "delete_file_rsp", "rename_file_rsp", "move_file_rsp" }, new Object[] { null, null, null, null, null, null }, RspBody.class);
  public oidb_0x6d6.DeleteFileRspBody delete_file_rsp = new oidb_0x6d6.DeleteFileRspBody();
  public oidb_0x6d6.DownloadFileRspBody download_file_rsp = new oidb_0x6d6.DownloadFileRspBody();
  public oidb_0x6d6.MoveFileRspBody move_file_rsp = new oidb_0x6d6.MoveFileRspBody();
  public oidb_0x6d6.RenameFileRspBody rename_file_rsp = new oidb_0x6d6.RenameFileRspBody();
  public oidb_0x6d6.ResendRspBody resend_file_rsp = new oidb_0x6d6.ResendRspBody();
  public oidb_0x6d6.UploadFileRspBody upload_file_rsp = new oidb_0x6d6.UploadFileRspBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6d6\oidb_0x6d6$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */