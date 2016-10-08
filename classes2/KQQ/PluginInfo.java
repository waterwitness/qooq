package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PluginInfo
  extends JceStruct
{
  public long Count;
  public boolean Flag;
  public long Id;
  public String PicUrl;
  public boolean RedPoint;
  public boolean Tab;
  public String Text;
  
  public PluginInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.Text = "";
    this.PicUrl = "";
    this.Tab = true;
  }
  
  public PluginInfo(long paramLong1, long paramLong2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.Text = "";
    this.PicUrl = "";
    this.Tab = true;
    this.Id = paramLong1;
    this.Count = paramLong2;
    this.Flag = paramBoolean1;
    this.Text = paramString1;
    this.PicUrl = paramString2;
    this.RedPoint = paramBoolean2;
    this.Tab = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Id = paramJceInputStream.read(this.Id, 0, true);
    this.Count = paramJceInputStream.read(this.Count, 1, true);
    this.Flag = paramJceInputStream.read(this.Flag, 2, true);
    this.Text = paramJceInputStream.readString(3, false);
    this.PicUrl = paramJceInputStream.readString(4, false);
    this.RedPoint = paramJceInputStream.read(this.RedPoint, 5, false);
    this.Tab = paramJceInputStream.read(this.Tab, 6, false);
  }
  
  public String toString()
  {
    return "id=" + this.Id + ",count=" + this.Count + ",flag=" + this.Flag + ",text=" + this.Text + ",picurl=" + this.PicUrl + ",redpoint=" + this.RedPoint + ",tab=" + this.Tab;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Id, 0);
    paramJceOutputStream.write(this.Count, 1);
    paramJceOutputStream.write(this.Flag, 2);
    if (this.Text != null) {
      paramJceOutputStream.write(this.Text, 3);
    }
    if (this.PicUrl != null) {
      paramJceOutputStream.write(this.PicUrl, 4);
    }
    paramJceOutputStream.write(this.RedPoint, 5);
    paramJceOutputStream.write(this.Tab, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\PluginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */