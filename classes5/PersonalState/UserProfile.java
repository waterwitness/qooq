package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;

public final class UserProfile
  extends JceStruct
{
  static stRishState cache_oRishState;
  static byte[] cache_vSig;
  public byte bAge;
  public byte bSex;
  public int iDistance;
  public int iLat;
  public int iLon;
  public long lEctID;
  public long nPicNum;
  public long nStatus;
  public stRishState oRishState;
  public long richTime;
  public RichStatus rs;
  public String strDesc;
  public String strLocation;
  public String strNick;
  public byte[] vSig;
  public short wFace;
  
  public UserProfile()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bSex = 2;
    this.bAge = -1;
    this.strNick = "";
    this.strLocation = "";
    this.strDesc = "";
    this.iDistance = -1;
    this.iLat = 900000000;
    this.iLon = 900000000;
  }
  
  public UserProfile(long paramLong1, short paramShort, byte paramByte1, byte paramByte2, String paramString1, stRishState paramstRishState, byte[] paramArrayOfByte, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3)
  {
    this.bSex = 2;
    this.bAge = -1;
    this.strNick = "";
    this.strLocation = "";
    this.strDesc = "";
    this.iDistance = -1;
    this.iLat = 900000000;
    this.iLon = 900000000;
    this.lEctID = paramLong1;
    this.wFace = paramShort;
    this.bSex = paramByte1;
    this.bAge = paramByte2;
    this.strNick = paramString1;
    this.oRishState = paramstRishState;
    this.vSig = paramArrayOfByte;
    this.strLocation = paramString2;
    this.strDesc = paramString3;
    this.iDistance = paramInt1;
    this.iLat = paramInt2;
    this.iLon = paramInt3;
    this.nPicNum = paramLong2;
    this.nStatus = paramLong3;
  }
  
  public RichStatus getRichStatus()
  {
    if (this.rs == null)
    {
      this.rs = RichStatus.parseStatus(this.oRishState.vState);
      this.rs.time = this.oRishState.uModifyTime;
    }
    return this.rs;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lEctID = paramJceInputStream.read(this.lEctID, 0, true);
    this.wFace = paramJceInputStream.read(this.wFace, 1, true);
    this.bSex = paramJceInputStream.read(this.bSex, 2, true);
    this.bAge = paramJceInputStream.read(this.bAge, 3, true);
    this.strNick = paramJceInputStream.readString(4, true);
    if (cache_oRishState == null) {
      cache_oRishState = new stRishState();
    }
    this.oRishState = ((stRishState)paramJceInputStream.read(cache_oRishState, 5, false));
    if (cache_vSig == null)
    {
      cache_vSig = (byte[])new byte[1];
      ((byte[])cache_vSig)[0] = 0;
    }
    this.vSig = ((byte[])paramJceInputStream.read(cache_vSig, 6, false));
    this.strLocation = paramJceInputStream.readString(7, false);
    this.strDesc = paramJceInputStream.readString(8, false);
    this.iDistance = paramJceInputStream.read(this.iDistance, 9, false);
    this.iLat = paramJceInputStream.read(this.iLat, 10, false);
    this.iLon = paramJceInputStream.read(this.iLon, 11, false);
    this.nPicNum = paramJceInputStream.read(this.nPicNum, 12, false);
    this.nStatus = paramJceInputStream.read(this.nStatus, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lEctID, 0);
    paramJceOutputStream.write(this.wFace, 1);
    paramJceOutputStream.write(this.bSex, 2);
    paramJceOutputStream.write(this.bAge, 3);
    paramJceOutputStream.write(this.strNick, 4);
    if (this.oRishState != null) {
      paramJceOutputStream.write(this.oRishState, 5);
    }
    if (this.vSig != null) {
      paramJceOutputStream.write(this.vSig, 6);
    }
    if (this.strLocation != null) {
      paramJceOutputStream.write(this.strLocation, 7);
    }
    if (this.strDesc != null) {
      paramJceOutputStream.write(this.strDesc, 8);
    }
    paramJceOutputStream.write(this.iDistance, 9);
    paramJceOutputStream.write(this.iLat, 10);
    paramJceOutputStream.write(this.iLon, 11);
    paramJceOutputStream.write(this.nPicNum, 12);
    paramJceOutputStream.write(this.nStatus, 13);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\PersonalState\UserProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */