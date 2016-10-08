package com.tencent.mobileqq.highway.netprobe;

public class DefaultProbe
  extends ProbeChain
{
  private static final int DEFAULT_PRIORITY = 10;
  
  public DefaultProbe()
  {
    super(10);
    addProbeItem(new EchoProbe());
    addProbeItem(new TracerouteProbe());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\netprobe\DefaultProbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */