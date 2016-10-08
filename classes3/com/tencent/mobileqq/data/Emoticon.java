package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="eId,epId")
public class Emoticon
  extends Entity
  implements Serializable
{
  public static final int JOB_H5_MAGIC = 4;
  public static final int JOB_MAGIC = 2;
  public static final int JOB_NORMAL = 0;
  public static final int JOB_QFACE = 1;
  public static final int JOB_SMALL = 3;
  public static final int MEDIA_TYPE_H5_MAGIC = 3;
  public static final int MEDIA_TYPE_QFACE = 2;
  public static final int MEDIA_TYPE_SOUND = 1;
  private static final long serialVersionUID = 2994277280135415857L;
  public String businessExtra;
  public String character;
  public String eId;
  public String encryptKey;
  public String epId;
  public int extensionHeight;
  public int extensionWidth;
  public int height;
  public boolean isSound;
  public int jobType;
  public String keyword;
  public String keywords;
  public String magicValue;
  public String name;
  public boolean value;
  public int width;
  
  public Emoticon()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Emoticon))) {}
    do
    {
      return false;
      paramObject = (Emoticon)paramObject;
    } while ((((Emoticon)paramObject).eId == null) || (!((Emoticon)paramObject).eId.equals(this.eId)) || (((Emoticon)paramObject).epId == null) || (!((Emoticon)paramObject).epId.equals(this.epId)));
    return true;
  }
  
  public String getMapKey()
  {
    return this.epId + "_" + this.eId;
  }
  
  public boolean hasEncryptKey()
  {
    return !TextUtils.isEmpty(this.encryptKey);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\Emoticon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */