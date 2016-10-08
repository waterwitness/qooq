package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetRichSigRes
  extends JceStruct
{
  static ArrayList cache_vstSigInfo;
  public byte cResult;
  public ArrayList vstSigInfo;
  
  public GetRichSigRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.cResult = -1;
  }
  
  public GetRichSigRes(byte paramByte, ArrayList paramArrayList)
  {
    this.cResult = -1;
    this.cResult = paramByte;
    this.vstSigInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cResult = paramJceInputStream.read(this.cResult, 1, true);
    if (cache_vstSigInfo == null)
    {
      cache_vstSigInfo = new ArrayList();
      ResRichSigInfo localResRichSigInfo = new ResRichSigInfo();
      cache_vstSigInfo.add(localResRichSigInfo);
    }
    this.vstSigInfo = ((ArrayList)paramJceInputStream.read(cache_vstSigInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 1);
    if (this.vstSigInfo != null) {
      paramJceOutputStream.write(this.vstSigInfo, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\GetRichSigRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */