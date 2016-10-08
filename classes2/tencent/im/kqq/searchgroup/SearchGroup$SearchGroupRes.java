package tencent.im.kqq.searchgroup;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SearchGroup$SearchGroupRes
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "dwResult", "stGroupClusterInfo", "sErrInfo", "dwNextRecTime" }, new Object[] { Integer.valueOf(1), null, "", Integer.valueOf(0) }, SearchGroupRes.class);
  public final PBUInt32Field dwNextRecTime = PBField.initUInt32(0);
  public final PBUInt32Field dwResult = PBField.initUInt32(1);
  public final PBStringField sErrInfo = PBField.initString("");
  public SearchGroup.GroupClusterInfo stGroupClusterInfo = new SearchGroup.GroupClusterInfo();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\kqq\searchgroup\SearchGroup$SearchGroupRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */