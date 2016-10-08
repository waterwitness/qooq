package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class CustomAlbumTemplate
  extends JceStruct
{
  static MaterialFile cache_stTmpBgImageLarge;
  static MaterialFile cache_stTmpBgImageMiddle;
  static MaterialFile cache_stTmpBgImageSmall;
  static ArrayList cache_vecItems;
  static ArrayList cache_vecPhotoFrameView;
  public MaterialFile stTmpBgImageLarge;
  public MaterialFile stTmpBgImageMiddle;
  public MaterialFile stTmpBgImageSmall;
  public ArrayList vecItems;
  public ArrayList vecPhotoFrameView;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_stTmpBgImageLarge = new MaterialFile();
    cache_stTmpBgImageMiddle = new MaterialFile();
    cache_stTmpBgImageSmall = new MaterialFile();
    cache_vecItems = new ArrayList();
    Object localObject = new CustomAlbumItem();
    cache_vecItems.add(localObject);
    cache_vecPhotoFrameView = new ArrayList();
    localObject = new PhotoFrameView();
    cache_vecPhotoFrameView.add(localObject);
  }
  
  public CustomAlbumTemplate() {}
  
  public CustomAlbumTemplate(MaterialFile paramMaterialFile1, MaterialFile paramMaterialFile2, MaterialFile paramMaterialFile3, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.stTmpBgImageLarge = paramMaterialFile1;
    this.stTmpBgImageMiddle = paramMaterialFile2;
    this.stTmpBgImageSmall = paramMaterialFile3;
    this.vecItems = paramArrayList1;
    this.vecPhotoFrameView = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stTmpBgImageLarge = ((MaterialFile)paramJceInputStream.read(cache_stTmpBgImageLarge, 0, false));
    this.stTmpBgImageMiddle = ((MaterialFile)paramJceInputStream.read(cache_stTmpBgImageMiddle, 1, false));
    this.stTmpBgImageSmall = ((MaterialFile)paramJceInputStream.read(cache_stTmpBgImageSmall, 2, false));
    this.vecItems = ((ArrayList)paramJceInputStream.read(cache_vecItems, 3, false));
    this.vecPhotoFrameView = ((ArrayList)paramJceInputStream.read(cache_vecPhotoFrameView, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stTmpBgImageLarge != null) {
      paramJceOutputStream.write(this.stTmpBgImageLarge, 0);
    }
    if (this.stTmpBgImageMiddle != null) {
      paramJceOutputStream.write(this.stTmpBgImageMiddle, 1);
    }
    if (this.stTmpBgImageSmall != null) {
      paramJceOutputStream.write(this.stTmpBgImageSmall, 2);
    }
    if (this.vecItems != null) {
      paramJceOutputStream.write(this.vecItems, 3);
    }
    if (this.vecPhotoFrameView != null) {
      paramJceOutputStream.write(this.vecPhotoFrameView, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_MOBILE_MATERIAL\CustomAlbumTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */