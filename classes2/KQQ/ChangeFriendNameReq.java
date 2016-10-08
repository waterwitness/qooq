package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ChangeFriendNameReq
  extends JceStruct
{
  public String cstrName;
  public long uFriendUin;
  
  public ChangeFriendNameReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cstrName = "";
  }
  
  public ChangeFriendNameReq(long paramLong, String paramString)
  {
    this.cstrName = "";
    this.uFriendUin = paramLong;
    this.cstrName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFriendUin = paramJceInputStream.read(this.uFriendUin, 0, true);
    this.cstrName = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFriendUin, 0);
    paramJceOutputStream.write(this.cstrName, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ChangeFriendNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */