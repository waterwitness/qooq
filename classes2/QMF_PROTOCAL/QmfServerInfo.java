package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class QmfServerInfo
  extends JceStruct
{
  static QmfClientIpInfo cache_ipWebapp;
  public long changeTime;
  public QmfClientIpInfo ipWebapp;
  
  public QmfServerInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QmfServerInfo(QmfClientIpInfo paramQmfClientIpInfo, long paramLong)
  {
    this.ipWebapp = paramQmfClientIpInfo;
    this.changeTime = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_ipWebapp == null) {
      cache_ipWebapp = new QmfClientIpInfo();
    }
    this.ipWebapp = ((QmfClientIpInfo)paramJceInputStream.read(cache_ipWebapp, 0, true));
    this.changeTime = paramJceInputStream.read(this.changeTime, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ipWebapp, 0);
    paramJceOutputStream.write(this.changeTime, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QMF_PROTOCAL\QmfServerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */