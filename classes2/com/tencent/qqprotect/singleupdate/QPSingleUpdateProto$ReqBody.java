package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QPSingleUpdateProto$ReqBody
  extends MessageMicro
{
  public static final int MSG_REPORT_FIELD_NUMBER = 2;
  public static final int RPT_FILE_ITEM_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_file_item_list", "msg_report" }, new Object[] { null, null }, ReqBody.class);
  public QPSingleUpdateProto.UploadBody msg_report = new QPSingleUpdateProto.UploadBody();
  public final PBRepeatMessageField rpt_file_item_list = PBField.initRepeatMessage(QPSingleUpdateProto.FileItem.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqprotect\singleupdate\QPSingleUpdateProto$ReqBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */