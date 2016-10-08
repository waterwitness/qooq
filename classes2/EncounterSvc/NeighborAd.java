package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class NeighborAd
  extends JceStruct
{
  public String ad_item;
  public int ad_postion;
  public int ad_source;
  
  public NeighborAd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.ad_item = "";
  }
  
  public NeighborAd(String paramString, int paramInt1, int paramInt2)
  {
    this.ad_item = "";
    this.ad_item = paramString;
    this.ad_postion = paramInt1;
    this.ad_source = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ad_item = paramJceInputStream.readString(0, true);
    this.ad_postion = paramJceInputStream.read(this.ad_postion, 1, true);
    this.ad_source = paramJceInputStream.read(this.ad_source, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ad_item, 0);
    paramJceOutputStream.write(this.ad_postion, 1);
    paramJceOutputStream.write(this.ad_source, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\NeighborAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */