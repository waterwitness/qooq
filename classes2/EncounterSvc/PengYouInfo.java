package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PengYouInfo
  extends JceStruct
{
  public String strPYFaceUrl;
  public String strPYName;
  
  public PengYouInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strPYName = "";
    this.strPYFaceUrl = "";
  }
  
  public PengYouInfo(String paramString1, String paramString2)
  {
    this.strPYName = "";
    this.strPYFaceUrl = "";
    this.strPYName = paramString1;
    this.strPYFaceUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPYName = paramJceInputStream.readString(0, true);
    this.strPYFaceUrl = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPYName, 0);
    paramJceOutputStream.write(this.strPYFaceUrl, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\PengYouInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */