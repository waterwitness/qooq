package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetRichSigReq
  extends JceStruct
{
  static ArrayList cache_vstReqRichInfo;
  public boolean checkupdate;
  public boolean showdatesig;
  public ArrayList vstReqRichInfo;
  
  public GetRichSigReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetRichSigReq(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.vstReqRichInfo = paramArrayList;
    this.checkupdate = paramBoolean1;
    this.showdatesig = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vstReqRichInfo == null)
    {
      cache_vstReqRichInfo = new ArrayList();
      ReqRichInfo localReqRichInfo = new ReqRichInfo();
      cache_vstReqRichInfo.add(localReqRichInfo);
    }
    this.vstReqRichInfo = ((ArrayList)paramJceInputStream.read(cache_vstReqRichInfo, 1, true));
    this.checkupdate = paramJceInputStream.read(this.checkupdate, 2, false);
    this.showdatesig = paramJceInputStream.read(this.showdatesig, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vstReqRichInfo, 1);
    paramJceOutputStream.write(this.checkupdate, 2);
    paramJceOutputStream.write(this.showdatesig, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\GetRichSigReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */