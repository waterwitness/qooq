package NeighborComm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class EctFragmentation
  extends JceStruct
{
  public int iSelfIndex;
  public int iTotalNum;
  
  public EctFragmentation()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EctFragmentation(int paramInt1, int paramInt2)
  {
    this.iTotalNum = paramInt1;
    this.iSelfIndex = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 0, true);
    this.iSelfIndex = paramJceInputStream.read(this.iSelfIndex, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTotalNum, 0);
    paramJceOutputStream.write(this.iSelfIndex, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NeighborComm\EctFragmentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */