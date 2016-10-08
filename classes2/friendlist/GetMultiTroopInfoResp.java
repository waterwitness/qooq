package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class GetMultiTroopInfoResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList cache_vecTroopInfo;
  public short errorCode;
  public int result;
  public String sGroupClassXMLPath;
  public long uin;
  public ArrayList vecTroopInfo;
  
  public GetMultiTroopInfoResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sGroupClassXMLPath = "";
  }
  
  public GetMultiTroopInfoResp(long paramLong, int paramInt, short paramShort, ArrayList paramArrayList, String paramString)
  {
    this.sGroupClassXMLPath = "";
    this.uin = paramLong;
    this.result = paramInt;
    this.errorCode = paramShort;
    this.vecTroopInfo = paramArrayList;
    this.sGroupClassXMLPath = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 2, true);
    if (cache_vecTroopInfo == null)
    {
      cache_vecTroopInfo = new ArrayList();
      stTroopInfoV2 localstTroopInfoV2 = new stTroopInfoV2();
      cache_vecTroopInfo.add(localstTroopInfoV2);
    }
    this.vecTroopInfo = ((ArrayList)paramJceInputStream.read(cache_vecTroopInfo, 3, true));
    this.sGroupClassXMLPath = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.errorCode, 2);
    paramJceOutputStream.write(this.vecTroopInfo, 3);
    if (this.sGroupClassXMLPath != null) {
      paramJceOutputStream.write(this.sGroupClassXMLPath, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetMultiTroopInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */