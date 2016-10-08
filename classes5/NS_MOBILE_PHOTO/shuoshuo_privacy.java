package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class shuoshuo_privacy
  extends JceStruct
{
  static ArrayList cache_mood_allowuins;
  public ArrayList mood_allowuins;
  public String mood_permission;
  
  public shuoshuo_privacy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mood_permission = "";
  }
  
  public shuoshuo_privacy(String paramString, ArrayList paramArrayList)
  {
    this.mood_permission = "";
    this.mood_permission = paramString;
    this.mood_allowuins = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mood_permission = paramJceInputStream.readString(0, true);
    if (cache_mood_allowuins == null)
    {
      cache_mood_allowuins = new ArrayList();
      cache_mood_allowuins.add(Long.valueOf(0L));
    }
    this.mood_allowuins = ((ArrayList)paramJceInputStream.read(cache_mood_allowuins, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mood_permission, 0);
    if (this.mood_allowuins != null) {
      paramJceOutputStream.write(this.mood_allowuins, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\shuoshuo_privacy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */