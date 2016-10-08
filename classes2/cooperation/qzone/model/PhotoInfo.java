package cooperation.qzone.model;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import ymq;

public class PhotoInfo
  extends GalleryImage
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ymq();
  public static int n;
  public static int o;
  public static int p;
  public int a;
  public long a;
  public GpsInfo4LocalImage a;
  public VideoInfo a;
  public Boolean a;
  public String a;
  public ArrayList a;
  public Map a;
  private WeakReference a;
  public boolean a;
  public int b;
  public long b;
  public Boolean b;
  public String b;
  private WeakReference b;
  public boolean b;
  public long c;
  public String c;
  public String d = "";
  public boolean d;
  public String e = "";
  public boolean e;
  public String f = "";
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public int m = n;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    o = 1;
    p = 2;
  }
  
  public PhotoInfo()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_h_of_type_Int = 1;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_JavaLangString = "";
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (Drawable)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramDrawable);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_k_of_type_Int & 0x4) > 0;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return true;
  }
  
  public Rect b()
  {
    return null;
  }
  
  public Drawable b()
  {
    if (this.jdField_b_of_type_MqqUtilWeakReference != null) {
      return (Drawable)this.jdField_b_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public boolean b()
  {
    return (this.jdField_k_of_type_Int & 0x2) > 0;
  }
  
  public int c()
  {
    return 0;
  }
  
  public Drawable c()
  {
    Drawable localDrawable2 = b();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = a();
    }
    return localDrawable1;
  }
  
  public int d()
  {
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i2 = 1;
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 1;
      paramParcel.writeInt(i1);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
      paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelGpsInfo4LocalImage, paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label288;
      }
    }
    label288:
    for (int i1 = i2;; i1 = 0)
    {
      paramParcel.writeInt(i1);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeInt(this.q);
      paramParcel.writeInt(this.r);
      paramParcel.writeInt(this.s);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelVideoInfo, paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeInt(this.t);
      paramParcel.writeInt(this.u);
      paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeInt(this.v);
      return;
      i1 = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\model\PhotoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */