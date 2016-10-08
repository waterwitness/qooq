package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class s_reply
  extends JceStruct
{
  static s_audio cache_audio;
  static ArrayList cache_replypic;
  static s_user cache_target;
  static s_user cache_user;
  public s_audio audio;
  public String content = "";
  public int date;
  public String refer = "";
  public String replyid = "";
  public ArrayList replypic;
  public s_user target;
  public s_user user;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_user = new s_user();
    cache_audio = new s_audio();
    cache_target = new s_user();
    cache_replypic = new ArrayList();
    s_picdata locals_picdata = new s_picdata();
    cache_replypic.add(locals_picdata);
  }
  
  public s_reply() {}
  
  public s_reply(String paramString1, s_user params_user1, String paramString2, int paramInt, String paramString3, s_audio params_audio, s_user params_user2, ArrayList paramArrayList)
  {
    this.replyid = paramString1;
    this.user = params_user1;
    this.content = paramString2;
    this.date = paramInt;
    this.refer = paramString3;
    this.audio = params_audio;
    this.target = params_user2;
    this.replypic = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.replyid = paramJceInputStream.readString(0, false);
    this.user = ((s_user)paramJceInputStream.read(cache_user, 1, false));
    this.content = paramJceInputStream.readString(2, false);
    this.date = paramJceInputStream.read(this.date, 3, false);
    this.refer = paramJceInputStream.readString(4, false);
    this.audio = ((s_audio)paramJceInputStream.read(cache_audio, 5, false));
    this.target = ((s_user)paramJceInputStream.read(cache_target, 6, false));
    this.replypic = ((ArrayList)paramJceInputStream.read(cache_replypic, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.replyid != null) {
      paramJceOutputStream.write(this.replyid, 0);
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
    if (this.audio != null) {
      paramJceOutputStream.write(this.audio, 5);
    }
    if (this.target != null) {
      paramJceOutputStream.write(this.target, 6);
    }
    if (this.replypic != null) {
      paramJceOutputStream.write(this.replypic, 7);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_reply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */