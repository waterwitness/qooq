package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_faces_rsp
  extends JceStruct
{
  static Map cache_facelist;
  public Map facelist;
  
  public get_faces_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public get_faces_rsp(Map paramMap)
  {
    this.facelist = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_facelist == null)
    {
      cache_facelist = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new stFaceItem());
      cache_facelist.put("", localArrayList);
    }
    this.facelist = ((Map)paramJceInputStream.read(cache_facelist, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.facelist != null) {
      paramJceOutputStream.write(this.facelist, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\get_faces_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */