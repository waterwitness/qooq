package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetAutoInfoReq
  extends JceStruct
{
  static int cache_sourceID;
  static int cache_sourceSubID;
  public byte cType;
  public long dwFriendUin;
  public int sourceID;
  public int sourceSubID;
  public long uin;
  
  public GetAutoInfoReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cType = 1;
    this.sourceID = 10004;
    this.sourceSubID = 0;
  }
  
  public GetAutoInfoReq(long paramLong1, long paramLong2, byte paramByte, int paramInt1, int paramInt2)
  {
    this.cType = 1;
    this.sourceID = 10004;
    this.sourceSubID = 0;
    this.uin = paramLong1;
    this.dwFriendUin = paramLong2;
    this.cType = paramByte;
    this.sourceID = paramInt1;
    this.sourceSubID = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.dwFriendUin = paramJceInputStream.read(this.dwFriendUin, 1, true);
    this.cType = paramJceInputStream.read(this.cType, 2, true);
    this.sourceID = paramJceInputStream.read(this.sourceID, 3, false);
    this.sourceSubID = paramJceInputStream.read(this.sourceSubID, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.dwFriendUin, 1);
    paramJceOutputStream.write(this.cType, 2);
    paramJceOutputStream.write(this.sourceID, 3);
    paramJceOutputStream.write(this.sourceSubID, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetAutoInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */