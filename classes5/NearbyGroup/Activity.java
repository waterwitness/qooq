package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Activity
  extends JceStruct
{
  public String strActivityName;
  
  public Activity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strActivityName = "";
  }
  
  public Activity(String paramString)
  {
    this.strActivityName = "";
    this.strActivityName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strActivityName = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strActivityName, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */