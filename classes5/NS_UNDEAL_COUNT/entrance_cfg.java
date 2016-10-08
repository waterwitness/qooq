package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class entrance_cfg
  extends JceStruct
{
  public int iEntranceId;
  public int isDefualt;
  public String sEntranceAction;
  public String sEntranceIcon;
  public String sEntranceName;
  public int tabid;
  
  public entrance_cfg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sEntranceName = "";
    this.sEntranceIcon = "";
    this.sEntranceAction = "";
  }
  
  public entrance_cfg(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    this.sEntranceName = "";
    this.sEntranceIcon = "";
    this.sEntranceAction = "";
    this.iEntranceId = paramInt1;
    this.sEntranceName = paramString1;
    this.sEntranceIcon = paramString2;
    this.sEntranceAction = paramString3;
    this.isDefualt = paramInt2;
    this.tabid = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iEntranceId = paramJceInputStream.read(this.iEntranceId, 0, false);
    this.sEntranceName = paramJceInputStream.readString(1, false);
    this.sEntranceIcon = paramJceInputStream.readString(2, false);
    this.sEntranceAction = paramJceInputStream.readString(3, false);
    this.isDefualt = paramJceInputStream.read(this.isDefualt, 4, false);
    this.tabid = paramJceInputStream.read(this.tabid, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iEntranceId, 0);
    if (this.sEntranceName != null) {
      paramJceOutputStream.write(this.sEntranceName, 1);
    }
    if (this.sEntranceIcon != null) {
      paramJceOutputStream.write(this.sEntranceIcon, 2);
    }
    if (this.sEntranceAction != null) {
      paramJceOutputStream.write(this.sEntranceAction, 3);
    }
    paramJceOutputStream.write(this.isDefualt, 4);
    paramJceOutputStream.write(this.tabid, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\entrance_cfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */