package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stFaceItem
  extends JceStruct
{
  static int cache_quanstate = 0;
  public boolean FromSys = true;
  public String faceUrl = "";
  public String faceid = "";
  public long h;
  public long opertime;
  public String photo_id = "";
  public String quanid = "";
  public int quanstate;
  public String targetnick = "";
  public long targetuin;
  public long w;
  public String writernick = "";
  public long writeruin;
  public long x;
  public long y;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public stFaceItem() {}
  
  public stFaceItem(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, String paramString2, String paramString3, long paramLong6, String paramString4, long paramLong7, String paramString5, String paramString6, boolean paramBoolean)
  {
    this.photo_id = paramString1;
    this.x = paramLong1;
    this.y = paramLong2;
    this.w = paramLong3;
    this.h = paramLong4;
    this.quanstate = paramInt;
    this.opertime = paramLong5;
    this.faceid = paramString2;
    this.quanid = paramString3;
    this.targetuin = paramLong6;
    this.targetnick = paramString4;
    this.writeruin = paramLong7;
    this.writernick = paramString5;
    this.faceUrl = paramString6;
    this.FromSys = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photo_id = paramJceInputStream.readString(0, true);
    this.x = paramJceInputStream.read(this.x, 1, true);
    this.y = paramJceInputStream.read(this.y, 2, true);
    this.w = paramJceInputStream.read(this.w, 3, true);
    this.h = paramJceInputStream.read(this.h, 4, true);
    this.quanstate = paramJceInputStream.read(this.quanstate, 5, true);
    this.opertime = paramJceInputStream.read(this.opertime, 6, true);
    this.faceid = paramJceInputStream.readString(7, false);
    this.quanid = paramJceInputStream.readString(8, false);
    this.targetuin = paramJceInputStream.read(this.targetuin, 9, false);
    this.targetnick = paramJceInputStream.readString(10, false);
    this.writeruin = paramJceInputStream.read(this.writeruin, 11, false);
    this.writernick = paramJceInputStream.readString(12, false);
    this.faceUrl = paramJceInputStream.readString(13, false);
    this.FromSys = paramJceInputStream.read(this.FromSys, 14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.photo_id, 0);
    paramJceOutputStream.write(this.x, 1);
    paramJceOutputStream.write(this.y, 2);
    paramJceOutputStream.write(this.w, 3);
    paramJceOutputStream.write(this.h, 4);
    paramJceOutputStream.write(this.quanstate, 5);
    paramJceOutputStream.write(this.opertime, 6);
    if (this.faceid != null) {
      paramJceOutputStream.write(this.faceid, 7);
    }
    if (this.quanid != null) {
      paramJceOutputStream.write(this.quanid, 8);
    }
    paramJceOutputStream.write(this.targetuin, 9);
    if (this.targetnick != null) {
      paramJceOutputStream.write(this.targetnick, 10);
    }
    paramJceOutputStream.write(this.writeruin, 11);
    if (this.writernick != null) {
      paramJceOutputStream.write(this.writernick, 12);
    }
    if (this.faceUrl != null) {
      paramJceOutputStream.write(this.faceUrl, 13);
    }
    paramJceOutputStream.write(this.FromSys, 14);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\stFaceItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */