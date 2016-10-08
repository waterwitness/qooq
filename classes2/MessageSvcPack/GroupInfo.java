package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GroupInfo
  extends JceStruct
  implements Cloneable
{
  public long lGroupCode;
  public long lGroupSeq;
  public long lMask;
  public long lMemberSeq;
  public long lRedPackTime;
  
  public GroupInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 0, true);
    this.lGroupSeq = paramJceInputStream.read(this.lGroupSeq, 1, true);
    this.lMemberSeq = paramJceInputStream.read(this.lMemberSeq, 2, true);
    this.lMask = paramJceInputStream.read(this.lMask, 3, false);
    this.lRedPackTime = paramJceInputStream.read(this.lRedPackTime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGroupCode, 0);
    paramJceOutputStream.write(this.lGroupSeq, 1);
    paramJceOutputStream.write(this.lMemberSeq, 2);
    paramJceOutputStream.write(this.lMask, 3);
    paramJceOutputStream.write(this.lRedPackTime, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */