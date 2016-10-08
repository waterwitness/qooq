package com.tencent.mobileqq.fts.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.SQLUtils;
import com.tencent.mobileqq.fts.utils.SegmentUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FTSEntity
{
  public String ext1;
  public String ext2;
  public String ext3;
  @notIndex
  public byte[] exts;
  @notColumn
  public Map indexContentMap;
  
  public FTSEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.indexContentMap = new HashMap();
  }
  
  protected void doDeserialize() {}
  
  protected void doSerialize() {}
  
  public String getIndexColumnName(String paramString)
  {
    return paramString + "_index";
  }
  
  public String getTableName()
  {
    return getClass().getSimpleName();
  }
  
  public boolean needCompress()
  {
    return false;
  }
  
  public void postRead() {}
  
  public void preWrite()
  {
    try
    {
      Iterator localIterator = SQLUtils.a(getClass()).iterator();
      while (localIterator.hasNext())
      {
        Field localField = (Field)localIterator.next();
        try
        {
          String str = (String)localField.get(this);
          if (!TextUtils.isEmpty(str))
          {
            str = SegmentUtils.a(str);
            this.indexContentMap.put(localField.getName(), str);
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\entity\FTSEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */