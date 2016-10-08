package com.tencent.mobileqq.portal;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.util.ArrayList;

public class PortalManager$RedPacketConfig
  implements Serializable
{
  public ArrayList bannerConfigs;
  public long grebInterval;
  public int id;
  public long lastGrabTime;
  public ArrayList portalConfigs;
  public long reportActiveInterval;
  public long reportNormalInterval;
  public long showGesturesTime;
  public int version;
  
  protected PortalManager$RedPacketConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.grebInterval = -1L;
    this.reportActiveInterval = -1L;
    this.reportNormalInterval = -1L;
    this.portalConfigs = new ArrayList();
    this.bannerConfigs = new ArrayList();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\PortalManager$RedPacketConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */