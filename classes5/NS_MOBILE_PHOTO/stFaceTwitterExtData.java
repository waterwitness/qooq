package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stFaceTwitterExtData
  extends JceStruct
{
  public long owneruin;
  public String tid;
  
  public stFaceTwitterExtData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.tid = "";
  }
  
  public stFaceTwitterExtData(String paramString, long paramLong)
  {
    this.tid = "";
    this.tid = paramString;
    this.owneruin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tid = paramJceInputStream.readString(0, true);
    this.owneruin = paramJceInputStream.read(this.owneruin, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tid, 0);
    paramJceOutputStream.write(this.owneruin, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\stFaceTwitterExtData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */