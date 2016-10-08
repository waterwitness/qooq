package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DelGroup
  extends JceStruct
{
  public long dwGroupID;
  
  public DelGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DelGroup(long paramLong)
  {
    this.dwGroupID = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupID = paramJceInputStream.read(this.dwGroupID, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupID, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\DelGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */