package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public final class SvcRespParam
  extends JceStruct
{
  public static ArrayList cache_vOnlineInfo;
  public int PCstat;
  public int iIsSupportC2CRoamMsg;
  public int iIsSupportDataLine;
  public int iIsSupportPrintable;
  public int iIsSupportViewPCFile;
  public int iPcVersion;
  public ArrayList onlineInfos;
  public ArrayList onlineinfos;
  public long uRoamFlag;
  
  public SvcRespParam()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRespParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, ArrayList paramArrayList)
  {
    this.PCstat = paramInt1;
    this.iIsSupportC2CRoamMsg = paramInt2;
    this.iIsSupportDataLine = paramInt3;
    this.iIsSupportPrintable = paramInt4;
    this.iIsSupportViewPCFile = paramInt5;
    this.iPcVersion = paramInt6;
    this.uRoamFlag = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.PCstat = paramJceInputStream.read(this.PCstat, 0, false);
    this.iIsSupportC2CRoamMsg = paramJceInputStream.read(this.iIsSupportC2CRoamMsg, 1, false);
    this.iIsSupportDataLine = paramJceInputStream.read(this.iIsSupportDataLine, 2, false);
    this.iIsSupportPrintable = paramJceInputStream.read(this.iIsSupportPrintable, 3, false);
    this.iIsSupportViewPCFile = paramJceInputStream.read(this.iIsSupportViewPCFile, 4, false);
    this.iPcVersion = paramJceInputStream.read(this.iPcVersion, 5, false);
    this.uRoamFlag = paramJceInputStream.read(this.uRoamFlag, 6, false);
    if (cache_vOnlineInfo == null)
    {
      cache_vOnlineInfo = new ArrayList();
      OnlineInfos localOnlineInfos = new OnlineInfos();
      cache_vOnlineInfo.add(localOnlineInfos);
    }
    try
    {
      this.onlineinfos = ((ArrayList)paramJceInputStream.read(cache_vOnlineInfo, 7, false));
      return;
    }
    catch (Exception paramJceInputStream)
    {
      paramJceInputStream.printStackTrace();
      QLog.d("==read info  onlineinfos===", 2, "", paramJceInputStream);
    }
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.PCstat, 0);
    paramJceOutputStream.write(this.iIsSupportC2CRoamMsg, 1);
    paramJceOutputStream.write(this.iIsSupportDataLine, 2);
    paramJceOutputStream.write(this.iIsSupportPrintable, 3);
    paramJceOutputStream.write(this.iIsSupportViewPCFile, 4);
    paramJceOutputStream.write(this.iPcVersion, 5);
    paramJceOutputStream.write(this.uRoamFlag, 6);
    paramJceOutputStream.write(this.onlineinfos, 7);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\RegisterProxySvcPack\SvcRespParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */