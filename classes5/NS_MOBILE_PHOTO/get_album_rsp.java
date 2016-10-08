package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class get_album_rsp
  extends JceStruct
{
  static Album cache_album = new Album();
  public Album album;
  public int albumCommentNum;
  public int albumFaceNum;
  public int albumLikeNum;
  public String albumLikekey = "";
  public int albumVisitNum;
  public boolean isMyLiked;
  public String largeCoverUrl = "";
  public String share_url = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public get_album_rsp() {}
  
  public get_album_rsp(Album paramAlbum, int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean, String paramString2, int paramInt4, String paramString3)
  {
    this.album = paramAlbum;
    this.albumFaceNum = paramInt1;
    this.albumLikeNum = paramInt2;
    this.albumLikekey = paramString1;
    this.albumVisitNum = paramInt3;
    this.isMyLiked = paramBoolean;
    this.largeCoverUrl = paramString2;
    this.albumCommentNum = paramInt4;
    this.share_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.album = ((Album)paramJceInputStream.read(cache_album, 0, true));
    this.albumFaceNum = paramJceInputStream.read(this.albumFaceNum, 1, false);
    this.albumLikeNum = paramJceInputStream.read(this.albumLikeNum, 2, false);
    this.albumLikekey = paramJceInputStream.readString(3, false);
    this.albumVisitNum = paramJceInputStream.read(this.albumVisitNum, 4, false);
    this.isMyLiked = paramJceInputStream.read(this.isMyLiked, 5, false);
    this.largeCoverUrl = paramJceInputStream.readString(6, false);
    this.albumCommentNum = paramJceInputStream.read(this.albumCommentNum, 7, false);
    this.share_url = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.album, 0);
    paramJceOutputStream.write(this.albumFaceNum, 1);
    paramJceOutputStream.write(this.albumLikeNum, 2);
    if (this.albumLikekey != null) {
      paramJceOutputStream.write(this.albumLikekey, 3);
    }
    paramJceOutputStream.write(this.albumVisitNum, 4);
    paramJceOutputStream.write(this.isMyLiked, 5);
    if (this.largeCoverUrl != null) {
      paramJceOutputStream.write(this.largeCoverUrl, 6);
    }
    paramJceOutputStream.write(this.albumCommentNum, 7);
    if (this.share_url != null) {
      paramJceOutputStream.write(this.share_url, 8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\get_album_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */