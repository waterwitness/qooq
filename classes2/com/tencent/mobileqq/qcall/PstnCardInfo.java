package com.tencent.mobileqq.qcall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import tyx;

public class PstnCardInfo
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new tyx();
  public int pstn_c2c_call_time;
  public int pstn_c2c_last_guide_recharge_time;
  public int pstn_c2c_try_status;
  public int pstn_c2c_vip;
  public int pstn_ever_c2c_vip;
  public int pstn_ever_multi_vip;
  public int pstn_multi_call_time;
  public int pstn_multi_last_guide_recharge_time;
  public int pstn_multi_try_status;
  public int pstn_multi_vip;
  @unique
  public String uin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PstnCardInfo() {}
  
  public PstnCardInfo(Parcel paramParcel)
  {
    this.uin = paramParcel.readString();
    this.pstn_c2c_vip = paramParcel.readInt();
    this.pstn_multi_vip = paramParcel.readInt();
    this.pstn_ever_c2c_vip = paramParcel.readInt();
    this.pstn_ever_multi_vip = paramParcel.readInt();
    this.pstn_c2c_try_status = paramParcel.readInt();
    this.pstn_multi_try_status = paramParcel.readInt();
    this.pstn_c2c_call_time = paramParcel.readInt();
    this.pstn_multi_call_time = paramParcel.readInt();
    this.pstn_c2c_last_guide_recharge_time = paramParcel.readInt();
    this.pstn_multi_last_guide_recharge_time = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" == PstnCardInfo : ");
    localStringBuilder.append("pstn_c2c_vip: ").append(this.pstn_c2c_vip).append(",pstn_multi_vip: ").append(this.pstn_multi_vip).append(", pstn_ever_c2c_vip: ").append(this.pstn_ever_c2c_vip).append(", pstn_ever_multi_vip: ").append(this.pstn_ever_multi_vip).append(", pstn_c2c_try_status: ").append(this.pstn_c2c_try_status).append(", pstn_multi_try_status: ").append(this.pstn_multi_try_status).append(", pstn_c2c_call_time: ").append(this.pstn_c2c_call_time).append(", pstn_multi_call_time: ").append(this.pstn_multi_call_time).append(", pstn_c2c_last_guide_recharge_time: ").append(this.pstn_c2c_last_guide_recharge_time).append(", pstn_multi_last_guide_recharge_time: ").append(this.pstn_multi_last_guide_recharge_time);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.pstn_c2c_vip);
    paramParcel.writeInt(this.pstn_multi_vip);
    paramParcel.writeInt(this.pstn_ever_c2c_vip);
    paramParcel.writeInt(this.pstn_ever_multi_vip);
    paramParcel.writeInt(this.pstn_c2c_try_status);
    paramParcel.writeInt(this.pstn_multi_try_status);
    paramParcel.writeInt(this.pstn_c2c_call_time);
    paramParcel.writeInt(this.pstn_multi_call_time);
    paramParcel.writeInt(this.pstn_c2c_last_guide_recharge_time);
    paramParcel.writeInt(this.pstn_multi_last_guide_recharge_time);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\PstnCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */