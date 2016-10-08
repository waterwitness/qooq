package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetFaceToFaceTroopMemberListResp
  extends JceStruct
{
  static int cache_eNetworkType;
  static int cache_result;
  public long dwStatus;
  public int eNetworkType;
  public short errorCode;
  public long iTermType;
  public int result;
  public long uAbiFlag;
  
  public GetFaceToFaceTroopMemberListResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.eNetworkType = 0;
  }
  
  public GetFaceToFaceTroopMemberListResp(int paramInt1, short paramShort, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    this.eNetworkType = 0;
    this.result = paramInt1;
    this.errorCode = paramShort;
    this.dwStatus = paramLong1;
    this.iTermType = paramLong2;
    this.uAbiFlag = paramLong3;
    this.eNetworkType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 1, true);
    this.dwStatus = paramJceInputStream.read(this.dwStatus, 2, false);
    this.iTermType = paramJceInputStream.read(this.iTermType, 3, false);
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 4, false);
    this.eNetworkType = paramJceInputStream.read(this.eNetworkType, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.errorCode, 1);
    paramJceOutputStream.write(this.dwStatus, 2);
    paramJceOutputStream.write(this.iTermType, 3);
    paramJceOutputStream.write(this.uAbiFlag, 4);
    paramJceOutputStream.write(this.eNetworkType, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetFaceToFaceTroopMemberListResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */