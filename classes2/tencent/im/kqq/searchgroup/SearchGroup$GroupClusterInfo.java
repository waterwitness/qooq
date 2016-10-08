package tencent.im.kqq.searchgroup;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SearchGroup$GroupClusterInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "dwIsEnd", "dwGroupNum", "vGroupInfo", "dwTotalSearchNum" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(0) }, GroupClusterInfo.class);
  public final PBUInt32Field dwGroupNum = PBField.initUInt32(0);
  public final PBUInt32Field dwIsEnd = PBField.initUInt32(1);
  public final PBUInt32Field dwTotalSearchNum = PBField.initUInt32(0);
  public final PBRepeatMessageField vGroupInfo = PBField.initRepeatMessage(SearchGroup.GroupInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\kqq\searchgroup\SearchGroup$GroupClusterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */