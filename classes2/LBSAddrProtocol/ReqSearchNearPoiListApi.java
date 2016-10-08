package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReqSearchNearPoiListApi
  extends JceStruct
{
  static byte[] cache_vLBSKeyData;
  static ArrayList cache_vTypes;
  public int iBeginPos;
  public int iRadius;
  public int iReqNum;
  public String strKeyword;
  public byte[] vLBSKeyData;
  public ArrayList vTypes;
  
  public ReqSearchNearPoiListApi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strKeyword = "";
    this.iRadius = 100;
    this.iReqNum = 10;
  }
  
  public ReqSearchNearPoiListApi(byte[] paramArrayOfByte, String paramString, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    this.strKeyword = "";
    this.iRadius = 100;
    this.iReqNum = 10;
    this.vLBSKeyData = paramArrayOfByte;
    this.strKeyword = paramString;
    this.vTypes = paramArrayList;
    this.iRadius = paramInt1;
    this.iBeginPos = paramInt2;
    this.iReqNum = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vLBSKeyData == null)
    {
      cache_vLBSKeyData = (byte[])new byte[1];
      ((byte[])cache_vLBSKeyData)[0] = 0;
    }
    this.vLBSKeyData = ((byte[])paramJceInputStream.read(cache_vLBSKeyData, 0, true));
    this.strKeyword = paramJceInputStream.readString(1, true);
    if (cache_vTypes == null)
    {
      cache_vTypes = new ArrayList();
      cache_vTypes.add(Integer.valueOf(0));
    }
    this.vTypes = ((ArrayList)paramJceInputStream.read(cache_vTypes, 2, true));
    this.iRadius = paramJceInputStream.read(this.iRadius, 3, true);
    this.iBeginPos = paramJceInputStream.read(this.iBeginPos, 4, true);
    this.iReqNum = paramJceInputStream.read(this.iReqNum, 5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vLBSKeyData, 0);
    paramJceOutputStream.write(this.strKeyword, 1);
    paramJceOutputStream.write(this.vTypes, 2);
    paramJceOutputStream.write(this.iRadius, 3);
    paramJceOutputStream.write(this.iBeginPos, 4);
    paramJceOutputStream.write(this.iReqNum, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\LBSAddrProtocol\ReqSearchNearPoiListApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */