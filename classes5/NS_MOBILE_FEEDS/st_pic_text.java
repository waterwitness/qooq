package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class st_pic_text
  extends JceStruct
{
  static s_picdata cache_picinfo;
  static ArrayList cache_userlist;
  public int actiontype;
  public String actionurl = "";
  public s_picdata picinfo;
  public String postfix = "";
  public String summary = "";
  public String title = "";
  public ArrayList userlist;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_picinfo = new s_picdata();
    cache_userlist = new ArrayList();
    s_user locals_user = new s_user();
    cache_userlist.add(locals_user);
  }
  
  public st_pic_text() {}
  
  public st_pic_text(s_picdata params_picdata, ArrayList paramArrayList, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.picinfo = params_picdata;
    this.userlist = paramArrayList;
    this.summary = paramString1;
    this.title = paramString2;
    this.actiontype = paramInt;
    this.actionurl = paramString3;
    this.postfix = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picinfo = ((s_picdata)paramJceInputStream.read(cache_picinfo, 0, false));
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 1, false));
    this.summary = paramJceInputStream.readString(2, false);
    this.title = paramJceInputStream.readString(3, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 4, false);
    this.actionurl = paramJceInputStream.readString(5, false);
    this.postfix = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picinfo != null) {
      paramJceOutputStream.write(this.picinfo, 0);
    }
    if (this.userlist != null) {
      paramJceOutputStream.write(this.userlist, 1);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 2);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 3);
    }
    paramJceOutputStream.write(this.actiontype, 4);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 5);
    }
    if (this.postfix != null) {
      paramJceOutputStream.write(this.postfix, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\st_pic_text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */