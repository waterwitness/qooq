package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class QuanInfo
  extends JceStruct
{
  private static FaceRect a = new FaceRect();
  private static Map<String, String> b = new HashMap();
  private static FacePoint c;
  private static FacePoint d;
  private static FaceRect e;
  private static Map<String, String> f;
  public int Quanstate = 0;
  public int confidence = 0;
  public FaceRect faceRect = null;
  public long iSource = 0L;
  public long identity = 0L;
  public FacePoint leftEye = null;
  public int photoHeight = 0;
  public int photoWidth = 0;
  public Map<String, String> property = null;
  public FaceRect regionRect = null;
  public Map<String, String> reserve = null;
  public FacePoint rightEye = null;
  
  static
  {
    b.put("", "");
    c = new FacePoint();
    d = new FacePoint();
    e = new FaceRect();
    f = new HashMap();
    f.put("", "");
  }
  
  public QuanInfo() {}
  
  public QuanInfo(FaceRect paramFaceRect1, int paramInt1, Map<String, String> paramMap1, FacePoint paramFacePoint1, FacePoint paramFacePoint2, FaceRect paramFaceRect2, long paramLong1, int paramInt2, int paramInt3, Map<String, String> paramMap2, long paramLong2, int paramInt4)
  {
    this.faceRect = paramFaceRect1;
    this.confidence = paramInt1;
    this.property = paramMap1;
    this.leftEye = paramFacePoint1;
    this.rightEye = paramFacePoint2;
    this.regionRect = paramFaceRect2;
    this.identity = paramLong1;
    this.photoWidth = paramInt2;
    this.photoHeight = paramInt3;
    this.reserve = paramMap2;
    this.iSource = paramLong2;
    this.Quanstate = paramInt4;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.faceRect = ((FaceRect)paramJceInputStream.read(a, 0, true));
    this.confidence = paramJceInputStream.read(this.confidence, 1, true);
    this.property = ((Map)paramJceInputStream.read(b, 2, true));
    this.leftEye = ((FacePoint)paramJceInputStream.read(c, 3, true));
    this.rightEye = ((FacePoint)paramJceInputStream.read(d, 4, true));
    this.regionRect = ((FaceRect)paramJceInputStream.read(e, 5, true));
    this.identity = paramJceInputStream.read(this.identity, 6, true);
    this.photoWidth = paramJceInputStream.read(this.photoWidth, 7, true);
    this.photoHeight = paramJceInputStream.read(this.photoHeight, 8, true);
    this.reserve = ((Map)paramJceInputStream.read(f, 9, true));
    this.iSource = paramJceInputStream.read(this.iSource, 10, true);
    this.Quanstate = paramJceInputStream.read(this.Quanstate, 11, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.faceRect, 0);
    paramJceOutputStream.write(this.confidence, 1);
    paramJceOutputStream.write(this.property, 2);
    paramJceOutputStream.write(this.leftEye, 3);
    paramJceOutputStream.write(this.rightEye, 4);
    paramJceOutputStream.write(this.regionRect, 5);
    paramJceOutputStream.write(this.identity, 6);
    paramJceOutputStream.write(this.photoWidth, 7);
    paramJceOutputStream.write(this.photoHeight, 8);
    paramJceOutputStream.write(this.reserve, 9);
    paramJceOutputStream.write(this.iSource, 10);
    paramJceOutputStream.write(this.Quanstate, 11);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\QuanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */