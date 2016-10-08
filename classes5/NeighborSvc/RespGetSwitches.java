package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetSwitches
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static ArrayList cache_switches;
  public RespHeader stHeader;
  public ArrayList switches;
  
  public RespGetSwitches()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespGetSwitches(RespHeader paramRespHeader, ArrayList paramArrayList)
  {
    this.stHeader = paramRespHeader;
    this.switches = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_switches == null)
    {
      cache_switches = new ArrayList();
      Switch localSwitch = new Switch();
      cache_switches.add(localSwitch);
    }
    this.switches = ((ArrayList)paramJceInputStream.read(cache_switches, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.switches, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NeighborSvc\RespGetSwitches.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */