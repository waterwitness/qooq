package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_video;
import NS_MOBILE_FEEDS.stPhotoTag;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import photo_share_struct.pic_host;

public final class Photo
  extends JceStruct
{
  static Map cache_busi_param;
  static ArrayList cache_photoTag;
  static pic_host cache_pic_host_nick = new pic_host();
  static Map cache_pics_enlargerate;
  static cell_video cache_videodata;
  public String albumid = "";
  public String bigurl = "";
  public Map busi_param;
  public int cmtnum;
  public String curkey = "";
  public String currenturl = "";
  public String desc = "";
  public int flag;
  public int height;
  public int isIndependentUgc;
  public int likenum;
  public String lloc = "";
  public String midurl = "";
  public int modifytime;
  public byte mylike;
  public String name = "";
  public byte opmask = 7;
  public int opsynflag;
  public ArrayList photoTag;
  public pic_host pic_host_nick;
  public Map pics_enlargerate;
  public int quanflag;
  public long raw;
  public int shoottime;
  public String sloc = "";
  public String smallurl = "";
  public String thumburl = "";
  public int trannum;
  public int type;
  public long uin;
  public String unikey = "";
  public int uploadtime;
  public String url = "";
  public cell_video videodata;
  public int videoflag;
  public int width;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_pics_enlargerate = new HashMap();
    cache_pics_enlargerate.put(Integer.valueOf(0), Integer.valueOf(0));
    cache_photoTag = new ArrayList();
    stPhotoTag localstPhotoTag = new stPhotoTag();
    cache_photoTag.add(localstPhotoTag);
    cache_videodata = new cell_video();
  }
  
  public Photo() {}
  
  public Photo(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, int paramInt5, int paramInt6, byte paramByte1, int paramInt7, String paramString8, String paramString9, String paramString10, String paramString11, Map paramMap1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong2, String paramString12, Map paramMap2, ArrayList paramArrayList, byte paramByte2, int paramInt12, int paramInt13, String paramString13, int paramInt14, cell_video paramcell_video, pic_host parampic_host)
  {
    this.uin = paramLong1;
    this.lloc = paramString1;
    this.sloc = paramString2;
    this.name = paramString3;
    this.desc = paramString4;
    this.uploadtime = paramInt1;
    this.modifytime = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.url = paramString5;
    this.bigurl = paramString6;
    this.smallurl = paramString7;
    this.cmtnum = paramInt5;
    this.likenum = paramInt6;
    this.mylike = paramByte1;
    this.trannum = paramInt7;
    this.unikey = paramString8;
    this.curkey = paramString9;
    this.midurl = paramString10;
    this.thumburl = paramString11;
    this.busi_param = paramMap1;
    this.type = paramInt8;
    this.isIndependentUgc = paramInt9;
    this.opsynflag = paramInt10;
    this.quanflag = paramInt11;
    this.raw = paramLong2;
    this.currenturl = paramString12;
    this.pics_enlargerate = paramMap2;
    this.photoTag = paramArrayList;
    this.opmask = paramByte2;
    this.shoottime = paramInt12;
    this.flag = paramInt13;
    this.albumid = paramString13;
    this.videoflag = paramInt14;
    this.videodata = paramcell_video;
    this.pic_host_nick = parampic_host;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.lloc = paramJceInputStream.readString(1, true);
    this.sloc = paramJceInputStream.readString(2, true);
    this.name = paramJceInputStream.readString(3, true);
    this.desc = paramJceInputStream.readString(4, true);
    this.uploadtime = paramJceInputStream.read(this.uploadtime, 5, true);
    this.modifytime = paramJceInputStream.read(this.modifytime, 6, true);
    this.width = paramJceInputStream.read(this.width, 7, true);
    this.height = paramJceInputStream.read(this.height, 8, true);
    this.url = paramJceInputStream.readString(9, true);
    this.bigurl = paramJceInputStream.readString(10, true);
    this.smallurl = paramJceInputStream.readString(11, true);
    this.cmtnum = paramJceInputStream.read(this.cmtnum, 12, true);
    this.likenum = paramJceInputStream.read(this.likenum, 13, true);
    this.mylike = paramJceInputStream.read(this.mylike, 14, true);
    this.trannum = paramJceInputStream.read(this.trannum, 15, true);
    this.unikey = paramJceInputStream.readString(16, false);
    this.curkey = paramJceInputStream.readString(17, false);
    this.midurl = paramJceInputStream.readString(18, false);
    this.thumburl = paramJceInputStream.readString(19, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 20, false));
    this.type = paramJceInputStream.read(this.type, 21, false);
    this.isIndependentUgc = paramJceInputStream.read(this.isIndependentUgc, 22, false);
    this.opsynflag = paramJceInputStream.read(this.opsynflag, 23, false);
    this.quanflag = paramJceInputStream.read(this.quanflag, 24, false);
    this.raw = paramJceInputStream.read(this.raw, 25, false);
    this.currenturl = paramJceInputStream.readString(26, false);
    this.pics_enlargerate = ((Map)paramJceInputStream.read(cache_pics_enlargerate, 27, false));
    this.photoTag = ((ArrayList)paramJceInputStream.read(cache_photoTag, 28, false));
    this.opmask = paramJceInputStream.read(this.opmask, 29, false);
    this.shoottime = paramJceInputStream.read(this.shoottime, 30, false);
    this.flag = paramJceInputStream.read(this.flag, 31, false);
    this.albumid = paramJceInputStream.readString(32, false);
    this.videoflag = paramJceInputStream.read(this.videoflag, 33, false);
    this.videodata = ((cell_video)paramJceInputStream.read(cache_videodata, 34, false));
    this.pic_host_nick = ((pic_host)paramJceInputStream.read(cache_pic_host_nick, 35, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.lloc, 1);
    paramJceOutputStream.write(this.sloc, 2);
    paramJceOutputStream.write(this.name, 3);
    paramJceOutputStream.write(this.desc, 4);
    paramJceOutputStream.write(this.uploadtime, 5);
    paramJceOutputStream.write(this.modifytime, 6);
    paramJceOutputStream.write(this.width, 7);
    paramJceOutputStream.write(this.height, 8);
    paramJceOutputStream.write(this.url, 9);
    paramJceOutputStream.write(this.bigurl, 10);
    paramJceOutputStream.write(this.smallurl, 11);
    paramJceOutputStream.write(this.cmtnum, 12);
    paramJceOutputStream.write(this.likenum, 13);
    paramJceOutputStream.write(this.mylike, 14);
    paramJceOutputStream.write(this.trannum, 15);
    if (this.unikey != null) {
      paramJceOutputStream.write(this.unikey, 16);
    }
    if (this.curkey != null) {
      paramJceOutputStream.write(this.curkey, 17);
    }
    if (this.midurl != null) {
      paramJceOutputStream.write(this.midurl, 18);
    }
    if (this.thumburl != null) {
      paramJceOutputStream.write(this.thumburl, 19);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 20);
    }
    paramJceOutputStream.write(this.type, 21);
    paramJceOutputStream.write(this.isIndependentUgc, 22);
    paramJceOutputStream.write(this.opsynflag, 23);
    paramJceOutputStream.write(this.quanflag, 24);
    paramJceOutputStream.write(this.raw, 25);
    if (this.currenturl != null) {
      paramJceOutputStream.write(this.currenturl, 26);
    }
    if (this.pics_enlargerate != null) {
      paramJceOutputStream.write(this.pics_enlargerate, 27);
    }
    if (this.photoTag != null) {
      paramJceOutputStream.write(this.photoTag, 28);
    }
    paramJceOutputStream.write(this.opmask, 29);
    paramJceOutputStream.write(this.shoottime, 30);
    paramJceOutputStream.write(this.flag, 31);
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 32);
    }
    paramJceOutputStream.write(this.videoflag, 33);
    if (this.videodata != null) {
      paramJceOutputStream.write(this.videodata, 34);
    }
    if (this.pic_host_nick != null) {
      paramJceOutputStream.write(this.pic_host_nick, 35);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\Photo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */