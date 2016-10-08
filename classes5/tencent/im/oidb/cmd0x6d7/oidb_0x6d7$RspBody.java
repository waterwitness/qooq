package tencent.im.oidb.cmd0x6d7;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d7$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "create_folder_rsp", "delete_folder_rsp", "rename_folder_rsp", "move_folder_rsp" }, new Object[] { null, null, null, null }, RspBody.class);
  public oidb_0x6d7.CreateFolderRspBody create_folder_rsp = new oidb_0x6d7.CreateFolderRspBody();
  public oidb_0x6d7.DeleteFolderRspBody delete_folder_rsp = new oidb_0x6d7.DeleteFolderRspBody();
  public oidb_0x6d7.MoveFolderRspBody move_folder_rsp = new oidb_0x6d7.MoveFolderRspBody();
  public oidb_0x6d7.RenameFolderRspBody rename_folder_rsp = new oidb_0x6d7.RenameFolderRspBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6d7\oidb_0x6d7$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */