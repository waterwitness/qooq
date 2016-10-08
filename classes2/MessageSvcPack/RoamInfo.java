package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RoamInfo
  extends JceStruct
{
  public byte cValue;
  public long lFriendUin;
  
  public RoamInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RoamInfo(long paramLong, byte paramByte)
  {
    this.lFriendUin = paramLong;
    this.cValue = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFriendUin = paramJceInputStream.read(this.lFriendUin, 0, true);
    this.cValue = paramJceInputStream.read(this.cValue, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFriendUin, 0);
    paramJceOutputStream.write(this.cValue, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\RoamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */