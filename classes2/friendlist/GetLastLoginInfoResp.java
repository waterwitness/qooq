package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetLastLoginInfoResp
  extends JceStruct
{
  static int cache_result;
  static LastLoginPageInfo cache_stPageInfo;
  static ArrayList cache_vecLastLoginInfo;
  public short errorCode;
  public int iRefreshIntervalMin;
  public int result;
  public LastLoginPageInfo stPageInfo;
  public ArrayList vecLastLoginInfo;
  
  public GetLastLoginInfoResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetLastLoginInfoResp(int paramInt1, short paramShort, LastLoginPageInfo paramLastLoginPageInfo, ArrayList paramArrayList, int paramInt2)
  {
    this.result = paramInt1;
    this.errorCode = paramShort;
    this.stPageInfo = paramLastLoginPageInfo;
    this.vecLastLoginInfo = paramArrayList;
    this.iRefreshIntervalMin = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 1, true);
    if (cache_stPageInfo == null) {
      cache_stPageInfo = new LastLoginPageInfo();
    }
    this.stPageInfo = ((LastLoginPageInfo)paramJceInputStream.read(cache_stPageInfo, 2, false));
    if (cache_vecLastLoginInfo == null)
    {
      cache_vecLastLoginInfo = new ArrayList();
      LastLoginInfo localLastLoginInfo = new LastLoginInfo();
      cache_vecLastLoginInfo.add(localLastLoginInfo);
    }
    this.vecLastLoginInfo = ((ArrayList)paramJceInputStream.read(cache_vecLastLoginInfo, 3, false));
    this.iRefreshIntervalMin = paramJceInputStream.read(this.iRefreshIntervalMin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.errorCode, 1);
    if (this.stPageInfo != null) {
      paramJceOutputStream.write(this.stPageInfo, 2);
    }
    if (this.vecLastLoginInfo != null) {
      paramJceOutputStream.write(this.vecLastLoginInfo, 3);
    }
    paramJceOutputStream.write(this.iRefreshIntervalMin, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetLastLoginInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */