package mqq.manager;

import java.util.List;

public abstract interface ProxyIpManager
  extends Manager
{
  public static final int PROXY_HTTP_COMMON = 2;
  public static final int PROXY_HTTP_FILE = 5;
  public static final int PROXY_HTTP_PIC = 3;
  public static final int PROXY_HTTP_PTT = 4;
  public static final int PROXY_SSO = 0;
  public static final int PROXY_TCP_COMMON = 1;
  
  public abstract List<ProxyIp> getProxyIp(int paramInt);
  
  public abstract void reloadCache(String paramString, boolean paramBoolean);
  
  public static class ProxyIp
  {
    public String ip;
    public int port;
    public int type;
    
    public String toString()
    {
      return this.ip + ":" + this.port + ":" + this.type;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\manager\ProxyIpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */