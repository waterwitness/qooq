package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class HotRishState
  extends JceStruct
{
  public int iActId;
  public int iDataId;
  
  public HotRishState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HotRishState(int paramInt1, int paramInt2)
  {
    this.iActId = paramInt1;
    this.iDataId = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iActId = paramJceInputStream.read(this.iActId, 0, true);
    this.iDataId = paramJceInputStream.read(this.iDataId, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iActId, 0);
    paramJceOutputStream.write(this.iDataId, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\HotRishState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */