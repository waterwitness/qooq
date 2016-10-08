package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class TNowBroadcastInfo
  extends JceStruct
{
  public int iFlag;
  public String strHrefURL;
  public String strIconURL;
  
  public TNowBroadcastInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strIconURL = "";
    this.strHrefURL = "";
  }
  
  public TNowBroadcastInfo(int paramInt, String paramString1, String paramString2)
  {
    this.strIconURL = "";
    this.strHrefURL = "";
    this.iFlag = paramInt;
    this.strIconURL = paramString1;
    this.strHrefURL = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFlag = paramJceInputStream.read(this.iFlag, 0, false);
    this.strIconURL = paramJceInputStream.readString(1, false);
    this.strHrefURL = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFlag, 0);
    if (this.strIconURL != null) {
      paramJceOutputStream.write(this.strIconURL, 1);
    }
    if (this.strHrefURL != null) {
      paramJceOutputStream.write(this.strHrefURL, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\TNowBroadcastInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */