package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d8$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "file_info_rsp", "file_list_info_rsp", "group_file_cnt_rsp", "group_space_rsp", "file_preview_rsp" }, new Object[] { null, null, null, null, null }, RspBody.class);
  public oidb_0x6d8.GetFileInfoRspBody file_info_rsp = new oidb_0x6d8.GetFileInfoRspBody();
  public oidb_0x6d8.GetFileListRspBody file_list_info_rsp = new oidb_0x6d8.GetFileListRspBody();
  public oidb_0x6d8.GetFilePreviewRspBody file_preview_rsp = new oidb_0x6d8.GetFilePreviewRspBody();
  public oidb_0x6d8.GetFileCountRspBody group_file_cnt_rsp = new oidb_0x6d8.GetFileCountRspBody();
  public oidb_0x6d8.GetSpaceRspBody group_space_rsp = new oidb_0x6d8.GetSpaceRspBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x6d8\oidb_0x6d8$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */