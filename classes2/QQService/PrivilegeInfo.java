package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PrivilegeInfo
  extends JceStruct
{
  public int iFeeType;
  public int iFlag;
  public int iLevel;
  public int iSort;
  public int iType;
  public String strDeluxeIconUrl;
  public String strIconUrl;
  
  public PrivilegeInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iType = -1;
    this.iSort = -1;
    this.iFeeType = -1;
    this.iLevel = -1;
    this.strIconUrl = "";
    this.strDeluxeIconUrl = "";
  }
  
  public PrivilegeInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    this.iType = -1;
    this.iSort = -1;
    this.iFeeType = -1;
    this.iLevel = -1;
    this.strIconUrl = "";
    this.strDeluxeIconUrl = "";
    this.iType = paramInt1;
    this.iSort = paramInt2;
    this.iFeeType = paramInt3;
    this.iLevel = paramInt4;
    this.iFlag = paramInt5;
    this.strIconUrl = paramString1;
    this.strDeluxeIconUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, true);
    this.iSort = paramJceInputStream.read(this.iSort, 1, true);
    this.iFeeType = paramJceInputStream.read(this.iFeeType, 2, true);
    this.iLevel = paramJceInputStream.read(this.iLevel, 3, true);
    this.iFlag = paramJceInputStream.read(this.iFlag, 4, true);
    this.strIconUrl = paramJceInputStream.readString(5, false);
    this.strDeluxeIconUrl = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    paramJceOutputStream.write(this.iSort, 1);
    paramJceOutputStream.write(this.iFeeType, 2);
    paramJceOutputStream.write(this.iLevel, 3);
    paramJceOutputStream.write(this.iFlag, 4);
    if (this.strIconUrl != null) {
      paramJceOutputStream.write(this.strIconUrl, 5);
    }
    if (this.strDeluxeIconUrl != null) {
      paramJceOutputStream.write(this.strDeluxeIconUrl, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\PrivilegeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */