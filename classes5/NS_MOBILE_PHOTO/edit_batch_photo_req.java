package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class edit_batch_photo_req
  extends JceStruct
{
  static EditPhoto cache_PhotoInfo;
  static Map cache_busi_param;
  static ArrayList cache_picid_list;
  static Map cache_picid_time_list;
  public EditPhoto PhotoInfo;
  public String albumid = "";
  public Map busi_param;
  public int operatype;
  public ArrayList picid_list;
  public Map picid_time_list;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_picid_list = new ArrayList();
    cache_picid_list.add("");
    cache_PhotoInfo = new EditPhoto();
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_picid_time_list = new HashMap();
    EditPhoto localEditPhoto = new EditPhoto();
    cache_picid_time_list.put("", localEditPhoto);
  }
  
  public edit_batch_photo_req() {}
  
  public edit_batch_photo_req(String paramString, ArrayList paramArrayList, EditPhoto paramEditPhoto, Map paramMap1, int paramInt, Map paramMap2)
  {
    this.albumid = paramString;
    this.picid_list = paramArrayList;
    this.PhotoInfo = paramEditPhoto;
    this.busi_param = paramMap1;
    this.operatype = paramInt;
    this.picid_time_list = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.picid_list = ((ArrayList)paramJceInputStream.read(cache_picid_list, 1, true));
    this.PhotoInfo = ((EditPhoto)paramJceInputStream.read(cache_PhotoInfo, 2, true));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 3, false));
    this.operatype = paramJceInputStream.read(this.operatype, 4, false);
    this.picid_time_list = ((Map)paramJceInputStream.read(cache_picid_time_list, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.picid_list, 1);
    paramJceOutputStream.write(this.PhotoInfo, 2);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 3);
    }
    paramJceOutputStream.write(this.operatype, 4);
    if (this.picid_time_list != null) {
      paramJceOutputStream.write(this.picid_time_list, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\edit_batch_photo_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */