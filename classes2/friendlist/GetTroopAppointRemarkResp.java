package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetTroopAppointRemarkResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList cache_vecTroopRemark;
  public long GroupCode;
  public long GroupUin;
  public short errorCode;
  public long office_mode;
  public int result;
  public long uin;
  public ArrayList vecTroopRemark;
  
  public GetTroopAppointRemarkResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetTroopAppointRemarkResp(long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList, int paramInt, short paramShort, long paramLong4)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.vecTroopRemark = paramArrayList;
    this.result = paramInt;
    this.errorCode = paramShort;
    this.office_mode = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 2, true);
    if (cache_vecTroopRemark == null)
    {
      cache_vecTroopRemark = new ArrayList();
      stTroopRemarkInfo localstTroopRemarkInfo = new stTroopRemarkInfo();
      cache_vecTroopRemark.add(localstTroopRemarkInfo);
    }
    this.vecTroopRemark = ((ArrayList)paramJceInputStream.read(cache_vecTroopRemark, 3, true));
    this.result = paramJceInputStream.read(this.result, 4, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 5, false);
    this.office_mode = paramJceInputStream.read(this.office_mode, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 2);
    paramJceOutputStream.write(this.vecTroopRemark, 3);
    paramJceOutputStream.write(this.result, 4);
    paramJceOutputStream.write(this.errorCode, 5);
    paramJceOutputStream.write(this.office_mode, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetTroopAppointRemarkResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */