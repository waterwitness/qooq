package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class StateByPass
  extends JceStruct
{
  static stRishState cache_oRishState;
  public stRishState oRishState;
  
  public StateByPass()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StateByPass(stRishState paramstRishState)
  {
    this.oRishState = paramstRishState;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_oRishState == null) {
      cache_oRishState = new stRishState();
    }
    this.oRishState = ((stRishState)paramJceInputStream.read(cache_oRishState, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oRishState, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\StateByPass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */