package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class SvcRequestPullDisMsgSeq
  extends JceStruct
{
  static ArrayList cache_vDisInfo;
  public byte cVerifyType;
  public ArrayList vDisInfo;
  
  public SvcRequestPullDisMsgSeq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRequestPullDisMsgSeq(ArrayList paramArrayList, byte paramByte)
  {
    this.vDisInfo = paramArrayList;
    this.cVerifyType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vDisInfo == null)
    {
      cache_vDisInfo = new ArrayList();
      PullDisSeqParam localPullDisSeqParam = new PullDisSeqParam();
      cache_vDisInfo.add(localPullDisSeqParam);
    }
    this.vDisInfo = ((ArrayList)paramJceInputStream.read(cache_vDisInfo, 0, true));
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vDisInfo, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcRequestPullDisMsgSeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */