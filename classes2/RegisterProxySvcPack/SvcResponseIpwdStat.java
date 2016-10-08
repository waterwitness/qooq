package RegisterProxySvcPack;

import IPwdPxyMQQ.RespondHeader;
import IPwdPxyMQQ.RespondQueryIPwdStat;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcResponseIpwdStat
  extends JceStruct
{
  static RespondHeader cache_stRespondHeader;
  static RespondQueryIPwdStat cache_stRespondQueryIPwdStat;
  public RespondHeader stRespondHeader;
  public RespondQueryIPwdStat stRespondQueryIPwdStat;
  
  public SvcResponseIpwdStat()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcResponseIpwdStat(RespondHeader paramRespondHeader, RespondQueryIPwdStat paramRespondQueryIPwdStat)
  {
    this.stRespondHeader = paramRespondHeader;
    this.stRespondQueryIPwdStat = paramRespondQueryIPwdStat;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stRespondHeader == null) {
      cache_stRespondHeader = new RespondHeader();
    }
    this.stRespondHeader = ((RespondHeader)paramJceInputStream.read(cache_stRespondHeader, 0, true));
    if (cache_stRespondQueryIPwdStat == null) {
      cache_stRespondQueryIPwdStat = new RespondQueryIPwdStat();
    }
    this.stRespondQueryIPwdStat = ((RespondQueryIPwdStat)paramJceInputStream.read(cache_stRespondQueryIPwdStat, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stRespondHeader, 0);
    paramJceOutputStream.write(this.stRespondQueryIPwdStat, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\SvcResponseIpwdStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */