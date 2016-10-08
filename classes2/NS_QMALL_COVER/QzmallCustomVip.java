package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class QzmallCustomVip
  extends JceStruct
{
  public int iItemId;
  public String strSrcUrl;
  
  public QzmallCustomVip()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iItemId = -1;
    this.strSrcUrl = "";
  }
  
  public QzmallCustomVip(int paramInt, String paramString)
  {
    this.iItemId = -1;
    this.strSrcUrl = "";
    this.iItemId = paramInt;
    this.strSrcUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strSrcUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strSrcUrl != null) {
      paramJceOutputStream.write(this.strSrcUrl, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_QMALL_COVER\QzmallCustomVip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */