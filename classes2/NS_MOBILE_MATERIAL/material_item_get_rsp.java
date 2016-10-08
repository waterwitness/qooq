package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public final class material_item_get_rsp
  extends JceStruct
{
  static Map cache_mapExtInfo;
  static MaterialItem cache_stItem;
  public int iCode;
  public Map mapExtInfo;
  public MaterialItem stItem;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_stItem = new MaterialItem();
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public material_item_get_rsp() {}
  
  public material_item_get_rsp(int paramInt, MaterialItem paramMaterialItem, Map paramMap)
  {
    this.iCode = paramInt;
    this.stItem = paramMaterialItem;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, false);
    this.stItem = ((MaterialItem)paramJceInputStream.read(cache_stItem, 1, false));
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.stItem != null) {
      paramJceOutputStream.write(this.stItem, 1);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_MOBILE_MATERIAL\material_item_get_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */