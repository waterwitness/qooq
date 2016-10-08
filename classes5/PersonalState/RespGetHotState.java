package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetHotState
  extends JceStruct
{
  static BusiRespHead cache_oHead;
  static ArrayList cache_vHostRichSateList;
  public BusiRespHead oHead;
  public ArrayList vHostRichSateList;
  
  public RespGetHotState()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespGetHotState(BusiRespHead paramBusiRespHead, ArrayList paramArrayList)
  {
    this.oHead = paramBusiRespHead;
    this.vHostRichSateList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_oHead == null) {
      cache_oHead = new BusiRespHead();
    }
    this.oHead = ((BusiRespHead)paramJceInputStream.read(cache_oHead, 0, true));
    if (cache_vHostRichSateList == null)
    {
      cache_vHostRichSateList = new ArrayList();
      HotRishState localHotRishState = new HotRishState();
      cache_vHostRichSateList.add(localHotRishState);
    }
    this.vHostRichSateList = ((ArrayList)paramJceInputStream.read(cache_vHostRichSateList, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oHead, 0);
    paramJceOutputStream.write(this.vHostRichSateList, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\RespGetHotState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */