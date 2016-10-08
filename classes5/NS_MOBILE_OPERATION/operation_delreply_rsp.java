package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class operation_delreply_rsp
  extends JceStruct
{
  public int iRet;
  public String strErrMsg;
  
  public operation_delreply_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strErrMsg = "";
  }
  
  public operation_delreply_rsp(int paramInt, String paramString)
  {
    this.strErrMsg = "";
    this.iRet = paramInt;
    this.strErrMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.strErrMsg = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.strErrMsg, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\operation_delreply_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */