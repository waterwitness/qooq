package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class material_tab_get_rsp
  extends JceStruct
{
  static Map cache_mapExtInfo;
  static MaterialTab cache_stTab;
  public int iCode;
  public int iHasMore;
  public Map mapExtInfo;
  public MaterialTab stTab;
  public String strAttachInfo = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_stTab = new MaterialTab();
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public material_tab_get_rsp() {}
  
  public material_tab_get_rsp(int paramInt1, MaterialTab paramMaterialTab, String paramString, int paramInt2, Map paramMap)
  {
    this.iCode = paramInt1;
    this.stTab = paramMaterialTab;
    this.strAttachInfo = paramString;
    this.iHasMore = paramInt2;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, false);
    this.stTab = ((MaterialTab)paramJceInputStream.read(cache_stTab, 1, false));
    this.strAttachInfo = paramJceInputStream.readString(2, false);
    this.iHasMore = paramJceInputStream.read(this.iHasMore, 3, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.stTab != null) {
      paramJceOutputStream.write(this.stTab, 1);
    }
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 2);
    }
    paramJceOutputStream.write(this.iHasMore, 3);
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_MOBILE_MATERIAL\material_tab_get_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */