package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stFavoriteGroup
  extends JceStruct
{
  public long dwGroupCode;
  public long dwOpenTimestamp;
  public long dwSnsFlag;
  public long dwTimestamp;
  
  public stFavoriteGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.dwSnsFlag = 1L;
  }
  
  public stFavoriteGroup(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.dwSnsFlag = 1L;
    this.dwGroupCode = paramLong1;
    this.dwTimestamp = paramLong2;
    this.dwSnsFlag = paramLong3;
    this.dwOpenTimestamp = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 0, true);
    this.dwTimestamp = paramJceInputStream.read(this.dwTimestamp, 1, false);
    this.dwSnsFlag = paramJceInputStream.read(this.dwSnsFlag, 2, false);
    this.dwOpenTimestamp = paramJceInputStream.read(this.dwOpenTimestamp, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupCode, 0);
    paramJceOutputStream.write(this.dwTimestamp, 1);
    paramJceOutputStream.write(this.dwSnsFlag, 2);
    paramJceOutputStream.write(this.dwOpenTimestamp, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\stFavoriteGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */