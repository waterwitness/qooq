package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAddPoiTraceRsp
  extends JceStruct
{
  public int iTotalNum = 0;
  
  public stAddPoiTraceRsp() {}
  
  public stAddPoiTraceRsp(int paramInt)
  {
    this.iTotalNum = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTotalNum, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\LBSClientInterfaceV2\stAddPoiTraceRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */