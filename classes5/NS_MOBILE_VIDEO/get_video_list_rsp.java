package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class get_video_list_rsp
  extends JceStruct
{
  static ArrayList cache_video_list;
  public String attach_info_new;
  public String attach_info_old;
  public boolean has_more;
  public String msg;
  public boolean old_video_hint_flag;
  public int ret;
  public ArrayList video_list;
  
  public get_video_list_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.msg = "";
    this.has_more = true;
    this.attach_info_new = "";
    this.attach_info_old = "";
    this.old_video_hint_flag = true;
  }
  
  public get_video_list_rsp(int paramInt, String paramString1, ArrayList paramArrayList, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    this.msg = "";
    this.has_more = true;
    this.attach_info_new = "";
    this.attach_info_old = "";
    this.old_video_hint_flag = true;
    this.ret = paramInt;
    this.msg = paramString1;
    this.video_list = paramArrayList;
    this.has_more = paramBoolean1;
    this.attach_info_new = paramString2;
    this.attach_info_old = paramString3;
    this.old_video_hint_flag = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_video_list == null)
    {
      cache_video_list = new ArrayList();
      Video localVideo = new Video();
      cache_video_list.add(localVideo);
    }
    this.video_list = ((ArrayList)paramJceInputStream.read(cache_video_list, 2, false));
    this.has_more = paramJceInputStream.read(this.has_more, 3, false);
    this.attach_info_new = paramJceInputStream.readString(4, false);
    this.attach_info_old = paramJceInputStream.readString(5, false);
    this.old_video_hint_flag = paramJceInputStream.read(this.old_video_hint_flag, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.video_list != null) {
      paramJceOutputStream.write(this.video_list, 2);
    }
    paramJceOutputStream.write(this.has_more, 3);
    if (this.attach_info_new != null) {
      paramJceOutputStream.write(this.attach_info_new, 4);
    }
    if (this.attach_info_old != null) {
      paramJceOutputStream.write(this.attach_info_old, 5);
    }
    paramJceOutputStream.write(this.old_video_hint_flag, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\get_video_list_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */