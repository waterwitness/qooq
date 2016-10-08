package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MaterialItem
  extends JceStruct
{
  static Map cache_mapExtInfo;
  static MaterialFile cache_stBanner;
  static MaterialFile cache_stThumb;
  static byte[] cache_strExtFields;
  static ArrayList cache_vecFile;
  public int iExpireTime;
  public int iItemId;
  public int iItemType;
  public int iTypeId;
  public Map mapExtInfo;
  public MaterialFile stBanner;
  public MaterialFile stThumb;
  public String strDescription = "";
  public String strDesignerInfo = "";
  public byte[] strExtFields;
  public String strItemName = "";
  public String strItemSummary = "";
  public String strTraceInfo = "";
  public long uiSettleTime;
  public ArrayList vecFile;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_vecFile = new ArrayList();
    MaterialFile localMaterialFile = new MaterialFile();
    cache_vecFile.add(localMaterialFile);
    cache_stThumb = new MaterialFile();
    cache_stBanner = new MaterialFile();
    cache_strExtFields = (byte[])new byte[1];
    ((byte[])cache_strExtFields)[0] = 0;
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public MaterialItem() {}
  
  public MaterialItem(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, ArrayList paramArrayList, String paramString2, String paramString3, MaterialFile paramMaterialFile1, MaterialFile paramMaterialFile2, long paramLong, String paramString4, String paramString5, byte[] paramArrayOfByte, Map paramMap)
  {
    this.iItemId = paramInt1;
    this.iTypeId = paramInt2;
    this.iItemType = paramInt3;
    this.strItemName = paramString1;
    this.iExpireTime = paramInt4;
    this.vecFile = paramArrayList;
    this.strItemSummary = paramString2;
    this.strDescription = paramString3;
    this.stThumb = paramMaterialFile1;
    this.stBanner = paramMaterialFile2;
    this.uiSettleTime = paramLong;
    this.strTraceInfo = paramString4;
    this.strDesignerInfo = paramString5;
    this.strExtFields = paramArrayOfByte;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.iTypeId = paramJceInputStream.read(this.iTypeId, 1, false);
    this.iItemType = paramJceInputStream.read(this.iItemType, 2, false);
    this.strItemName = paramJceInputStream.readString(3, false);
    this.iExpireTime = paramJceInputStream.read(this.iExpireTime, 4, false);
    this.vecFile = ((ArrayList)paramJceInputStream.read(cache_vecFile, 5, false));
    this.strItemSummary = paramJceInputStream.readString(6, false);
    this.strDescription = paramJceInputStream.readString(7, false);
    this.stThumb = ((MaterialFile)paramJceInputStream.read(cache_stThumb, 8, false));
    this.stBanner = ((MaterialFile)paramJceInputStream.read(cache_stBanner, 9, false));
    this.uiSettleTime = paramJceInputStream.read(this.uiSettleTime, 10, false);
    this.strTraceInfo = paramJceInputStream.readString(11, false);
    this.strDesignerInfo = paramJceInputStream.readString(12, false);
    this.strExtFields = ((byte[])paramJceInputStream.read(cache_strExtFields, 13, false));
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    paramJceOutputStream.write(this.iTypeId, 1);
    paramJceOutputStream.write(this.iItemType, 2);
    if (this.strItemName != null) {
      paramJceOutputStream.write(this.strItemName, 3);
    }
    paramJceOutputStream.write(this.iExpireTime, 4);
    if (this.vecFile != null) {
      paramJceOutputStream.write(this.vecFile, 5);
    }
    if (this.strItemSummary != null) {
      paramJceOutputStream.write(this.strItemSummary, 6);
    }
    if (this.strDescription != null) {
      paramJceOutputStream.write(this.strDescription, 7);
    }
    if (this.stThumb != null) {
      paramJceOutputStream.write(this.stThumb, 8);
    }
    if (this.stBanner != null) {
      paramJceOutputStream.write(this.stBanner, 9);
    }
    paramJceOutputStream.write(this.uiSettleTime, 10);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 11);
    }
    if (this.strDesignerInfo != null) {
      paramJceOutputStream.write(this.strDesignerInfo, 12);
    }
    if (this.strExtFields != null) {
      paramJceOutputStream.write(this.strExtFields, 13);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 14);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_MOBILE_MATERIAL\MaterialItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */