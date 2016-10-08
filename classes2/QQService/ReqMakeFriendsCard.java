package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqMakeFriendsCard
  extends JceStruct
{
  static ReqHead cache_stHeader;
  public byte bReqType;
  public ReqHead stHeader;
  public int uFaceTimeStamp;
  
  public ReqMakeFriendsCard()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.uFaceTimeStamp = -1;
  }
  
  public ReqMakeFriendsCard(ReqHead paramReqHead, byte paramByte, int paramInt)
  {
    this.uFaceTimeStamp = -1;
    this.stHeader = paramReqHead;
    this.bReqType = paramByte;
    this.uFaceTimeStamp = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.bReqType = paramJceInputStream.read(this.bReqType, 1, true);
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.bReqType, 1);
    paramJceOutputStream.write(this.uFaceTimeStamp, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\ReqMakeFriendsCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */