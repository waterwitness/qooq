package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class s_commment
  extends JceStruct
{
  static s_audio cache_audio;
  static ArrayList cache_commentpic;
  static ArrayList cache_picdata;
  static ArrayList cache_replys;
  static s_user cache_user;
  public s_audio audio;
  public String commentid = "";
  public ArrayList commentpic;
  public String content = "";
  public int date;
  public int floor;
  public int isPrivate;
  public ArrayList picdata;
  public String refer = "";
  public int replynum;
  public ArrayList replys;
  public s_user user;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_user = new s_user();
    cache_replys = new ArrayList();
    Object localObject = new s_reply();
    cache_replys.add(localObject);
    cache_picdata = new ArrayList();
    localObject = new s_picdata();
    cache_picdata.add(localObject);
    cache_audio = new s_audio();
    cache_commentpic = new ArrayList();
    localObject = new s_picdata();
    cache_commentpic.add(localObject);
  }
  
  public s_commment() {}
  
  public s_commment(String paramString1, s_user params_user, String paramString2, int paramInt1, String paramString3, ArrayList paramArrayList1, int paramInt2, ArrayList paramArrayList2, s_audio params_audio, ArrayList paramArrayList3, int paramInt3, int paramInt4)
  {
    this.commentid = paramString1;
    this.user = params_user;
    this.content = paramString2;
    this.date = paramInt1;
    this.refer = paramString3;
    this.replys = paramArrayList1;
    this.replynum = paramInt2;
    this.picdata = paramArrayList2;
    this.audio = params_audio;
    this.commentpic = paramArrayList3;
    this.floor = paramInt3;
    this.isPrivate = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commentid = paramJceInputStream.readString(0, false);
    this.user = ((s_user)paramJceInputStream.read(cache_user, 1, false));
    this.content = paramJceInputStream.readString(2, false);
    this.date = paramJceInputStream.read(this.date, 3, false);
    this.refer = paramJceInputStream.readString(4, false);
    this.replys = ((ArrayList)paramJceInputStream.read(cache_replys, 5, false));
    this.replynum = paramJceInputStream.read(this.replynum, 6, false);
    this.picdata = ((ArrayList)paramJceInputStream.read(cache_picdata, 7, false));
    this.audio = ((s_audio)paramJceInputStream.read(cache_audio, 8, false));
    this.commentpic = ((ArrayList)paramJceInputStream.read(cache_commentpic, 9, false));
    this.floor = paramJceInputStream.read(this.floor, 10, false);
    this.isPrivate = paramJceInputStream.read(this.isPrivate, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.commentid != null) {
      paramJceOutputStream.write(this.commentid, 0);
    }
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 1);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    paramJceOutputStream.write(this.date, 3);
    if (this.refer != null) {
      paramJceOutputStream.write(this.refer, 4);
    }
    if (this.replys != null) {
      paramJceOutputStream.write(this.replys, 5);
    }
    paramJceOutputStream.write(this.replynum, 6);
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 7);
    }
    if (this.audio != null) {
      paramJceOutputStream.write(this.audio, 8);
    }
    if (this.commentpic != null) {
      paramJceOutputStream.write(this.commentpic, 9);
    }
    paramJceOutputStream.write(this.floor, 10);
    paramJceOutputStream.write(this.isPrivate, 11);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_commment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */