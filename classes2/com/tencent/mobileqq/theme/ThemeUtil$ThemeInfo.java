package com.tencent.mobileqq.theme;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class ThemeUtil$ThemeInfo
  implements Serializable
{
  public String downloadUrl;
  public long downsize;
  public int fileNum;
  public boolean isVoiceTheme;
  public long size;
  public String status;
  public String themeId;
  public String version;
  
  public ThemeUtil$ThemeInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.themeId = "";
    this.status = "1";
    this.version = "";
    this.downloadUrl = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ThemeInfo.class.getName());
    localStringBuilder.append("{");
    localStringBuilder.append("themeId=");
    localStringBuilder.append(this.themeId);
    localStringBuilder.append(",status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(",downsize=");
    localStringBuilder.append(this.downsize);
    localStringBuilder.append(",size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(",version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(",isVoiceTheme=");
    localStringBuilder.append(this.isVoiceTheme);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\ThemeUtil$ThemeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */