package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class ChatBackgroundInfo
  extends Entity
  implements Serializable
{
  public static final int COMPLETED = 0;
  public static final String ID = "id";
  public static final int INCOMPLETE = 1;
  public static final String NAME = "name";
  public static final String THUMBURL = "thumbUrl";
  public static final String URL = "url";
  private static final long serialVersionUID = 1L;
  @unique
  public String id;
  public String name;
  public String thumbUrl;
  public String url;
  
  public ChatBackgroundInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append("id==" + this.id);
    localStringBuilder.append(",name==" + this.name);
    localStringBuilder.append(",url==" + this.url);
    localStringBuilder.append(",thumbUrl==" + this.thumbUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ChatBackgroundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */