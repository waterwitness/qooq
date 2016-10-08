package tencent.im.kqq.searchgroup;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SearchGroup$SearchGroupReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64 }, new String[] { "qwUin", "dwVersion", "dwReqUinNum", "dwPageNo", "eSubCmd", "sReqContent", "eGroupSortType", "dwNextRecTime" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf(0) }, SearchGroupReq.class);
  public final PBUInt32Field dwNextRecTime = PBField.initUInt32(0);
  public final PBUInt32Field dwPageNo = PBField.initUInt32(0);
  public final PBUInt32Field dwReqUinNum = PBField.initUInt32(0);
  public final PBUInt32Field dwVersion = PBField.initUInt32(0);
  public final PBEnumField eGroupSortType = PBField.initEnum(1);
  public final PBEnumField eSubCmd = PBField.initEnum(1);
  public final PBUInt64Field qwUin = PBField.initUInt64(0L);
  public final PBStringField sReqContent = PBField.initString("");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\kqq\searchgroup\SearchGroup$SearchGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */