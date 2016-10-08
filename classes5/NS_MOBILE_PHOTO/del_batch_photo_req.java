package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class del_batch_photo_req
  extends JceStruct
{
  static Map cache_busi_param;
  static ArrayList cache_picid_list;
  public String albumid;
  public Map busi_param;
  public ArrayList picid_list;
  
  public del_batch_photo_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.albumid = "";
  }
  
  public del_batch_photo_req(String paramString, ArrayList paramArrayList, Map paramMap)
  {
    this.albumid = "";
    this.albumid = paramString;
    this.picid_list = paramArrayList;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    if (cache_picid_list == null)
    {
      cache_picid_list = new ArrayList();
      cache_picid_list.add("");
    }
    this.picid_list = ((ArrayList)paramJceInputStream.read(cache_picid_list, 1, true));
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.picid_list, 1);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\del_batch_photo_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */