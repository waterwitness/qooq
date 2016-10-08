package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class ReqGetSettings
  extends JceStruct
{
  static ArrayList cache_Paths;
  public long Count;
  public long Offset;
  public ArrayList Paths;
  public int Revision;
  
  public ReqGetSettings()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReqGetSettings(int paramInt, ArrayList paramArrayList, long paramLong1, long paramLong2)
  {
    this.Revision = paramInt;
    this.Paths = paramArrayList;
    this.Offset = paramLong1;
    this.Count = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Revision = paramJceInputStream.read(this.Revision, 0, true);
    if (cache_Paths == null)
    {
      cache_Paths = new ArrayList();
      cache_Paths.add("");
    }
    this.Paths = ((ArrayList)paramJceInputStream.read(cache_Paths, 1, true));
    this.Offset = paramJceInputStream.read(this.Offset, 2, false);
    this.Count = paramJceInputStream.read(this.Count, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Revision, 0);
    paramJceOutputStream.write(this.Paths, 1);
    paramJceOutputStream.write(this.Offset, 2);
    paramJceOutputStream.write(this.Count, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GeneralSettings\ReqGetSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */