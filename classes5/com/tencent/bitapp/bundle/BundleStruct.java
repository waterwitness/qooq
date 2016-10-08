package com.tencent.bitapp.bundle;

import com.tencent.bitapp.utils.StringBuilderUtils;

public class BundleStruct
{
  public static final int MODULE_STATE_DEFAULT = 0;
  public static final int MODULE_STATE_DISABLE = 2;
  public static final int MODULE_STATE_ENABLE = 1;
  public boolean decrypt = true;
  public String download_url = "";
  public String localFile = "";
  public String md5 = "";
  public int module_id = 0;
  public int module_state = 1;
  public int module_version = 1;
  public String pwd = "";
  
  public BundleStruct() {}
  
  public BundleStruct(int paramInt)
  {
    this.module_id = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (getClass() != paramObject.getClass());
      paramObject = (BundleStruct)paramObject;
    } while ((this.module_id != ((BundleStruct)paramObject).module_id) || (this.module_version != ((BundleStruct)paramObject).module_version) || (this.module_state != ((BundleStruct)paramObject).module_state) || (!this.download_url.equals(((BundleStruct)paramObject).download_url)) || (!this.md5.equals(((BundleStruct)paramObject).md5)) || (this.decrypt != ((BundleStruct)paramObject).decrypt) || (!this.pwd.equals(((BundleStruct)paramObject).pwd)));
    return true;
  }
  
  public String getKey()
  {
    return String.valueOf(this.module_id);
  }
  
  public int hashCode()
  {
    return this.module_id + 31 + this.module_version;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = StringBuilderUtils.obtain();
    localStringBuilder.append("{\"module_id\": ");
    localStringBuilder.append(this.module_id);
    localStringBuilder.append(",\"module_version\": ");
    localStringBuilder.append(this.module_version);
    localStringBuilder.append(",\"module_state\": ");
    localStringBuilder.append(this.module_state);
    localStringBuilder.append(",\"download_url\": \"");
    localStringBuilder.append(this.download_url);
    localStringBuilder.append("\",\"md5\": \"");
    localStringBuilder.append(this.md5);
    localStringBuilder.append("\",\"decrypt\": \"");
    localStringBuilder.append(this.decrypt);
    localStringBuilder.append("\",\"localFile\":  \"");
    localStringBuilder.append(this.localFile);
    localStringBuilder.append("\"");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\BundleStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */