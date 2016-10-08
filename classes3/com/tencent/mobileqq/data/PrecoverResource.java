package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import rcc;

public class PrecoverResource
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new rcc();
  public String businessId;
  public String md5;
  @unique
  public String pk;
  public String resId;
  public String url;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PrecoverResource() {}
  
  public PrecoverResource(Parcel paramParcel)
  {
    this.pk = paramParcel.readString();
    this.businessId = paramParcel.readString();
    this.resId = paramParcel.readString();
    this.url = paramParcel.readString();
    this.md5 = paramParcel.readString();
  }
  
  public PrecoverResource(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.businessId = paramString1;
    this.resId = paramString2;
    this.url = paramString3;
    this.md5 = paramString4;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.pk = (paramString1 + "_" + paramString2);
      return;
    }
    this.pk = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PrecoverResource))) {}
    do
    {
      return false;
      paramObject = (PrecoverResource)paramObject;
    } while ((!((PrecoverResource)paramObject).isValid()) || (!isValid()) || (!this.md5.equals(((PrecoverResource)paramObject).md5)) || (!this.url.equals(((PrecoverResource)paramObject).url)) || (!this.businessId.equals(((PrecoverResource)paramObject).businessId)) || (!this.resId.equals(((PrecoverResource)paramObject).resId)));
    return true;
  }
  
  public String getPk()
  {
    if (TextUtils.isEmpty(this.pk)) {
      if ((TextUtils.isEmpty(this.businessId)) || (TextUtils.isEmpty(this.resId))) {
        break label68;
      }
    }
    label68:
    for (this.pk = (this.businessId + "_" + this.resId);; this.pk = null) {
      return this.pk;
    }
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.businessId)) && (!TextUtils.isEmpty(this.resId)) && (!TextUtils.isEmpty(this.url)) && (!TextUtils.isEmpty(this.md5));
  }
  
  protected void postRead()
  {
    super.postRead();
  }
  
  protected void postwrite()
  {
    super.postwrite();
  }
  
  protected void prewrite()
  {
    super.prewrite();
    if ((!TextUtils.isEmpty(this.businessId)) && (!TextUtils.isEmpty(this.resId)))
    {
      this.pk = (this.businessId + "_" + this.resId);
      return;
    }
    this.pk = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrecoverResource:pk=").append(this.pk);
    localStringBuilder.append(",businessId=").append(this.businessId);
    localStringBuilder.append(",resId=").append(this.resId);
    localStringBuilder.append(",url=").append(this.url);
    localStringBuilder.append(",md5=").append(this.md5);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.pk);
    paramParcel.writeString(this.businessId);
    paramParcel.writeString(this.resId);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\PrecoverResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */