package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetFaceToFaceTroopMemberListReq
  extends JceStruct
{
  public long dwReqType;
  public long dwUin;
  public String strMobile;
  
  public GetFaceToFaceTroopMemberListReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strMobile = "";
  }
  
  public GetFaceToFaceTroopMemberListReq(long paramLong1, long paramLong2, String paramString)
  {
    this.strMobile = "";
    this.dwReqType = paramLong1;
    this.dwUin = paramLong2;
    this.strMobile = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwReqType = paramJceInputStream.read(this.dwReqType, 0, true);
    this.dwUin = paramJceInputStream.read(this.dwUin, 1, false);
    this.strMobile = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwReqType, 0);
    paramJceOutputStream.write(this.dwUin, 1);
    if (this.strMobile != null) {
      paramJceOutputStream.write(this.strMobile, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetFaceToFaceTroopMemberListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */