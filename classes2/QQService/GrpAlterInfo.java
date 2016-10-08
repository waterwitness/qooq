package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GrpAlterInfo
  extends JceStruct
{
  static ArrayList cache_AlterInfo;
  public ArrayList AlterInfo;
  public long GrpId;
  
  public GrpAlterInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GrpAlterInfo(long paramLong, ArrayList paramArrayList)
  {
    this.GrpId = paramLong;
    this.AlterInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.GrpId = paramJceInputStream.read(this.GrpId, 0, true);
    if (cache_AlterInfo == null)
    {
      cache_AlterInfo = new ArrayList();
      GrpInfoItem localGrpInfoItem = new GrpInfoItem();
      cache_AlterInfo.add(localGrpInfoItem);
    }
    this.AlterInfo = ((ArrayList)paramJceInputStream.read(cache_AlterInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GrpId, 0);
    paramJceOutputStream.write(this.AlterInfo, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\GrpAlterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */