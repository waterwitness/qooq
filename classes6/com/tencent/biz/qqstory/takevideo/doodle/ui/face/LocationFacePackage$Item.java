package com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocationFacePackage$Item
{
  public Bitmap a;
  public Drawable a;
  public LocationFacePackage.Item.ItemParams a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public LocationFacePackage$Item()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams = new LocationFacePackage.Item.ItemParams();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams = new LocationFacePackage.Item.ItemParams();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.e);
      int i = localJSONObject.getInt("align");
      Object localObject = localJSONObject.getJSONArray("picture_margin");
      int j = ((JSONArray)localObject).getInt(0);
      int k = ((JSONArray)localObject).getInt(1);
      int m = ((JSONArray)localObject).getInt(2);
      int n = ((JSONArray)localObject).getInt(3);
      localObject = localJSONObject.getJSONArray("text_start_location");
      int i1 = ((JSONArray)localObject).getInt(0);
      int i2 = ((JSONArray)localObject).getInt(1);
      localObject = localJSONObject.getJSONArray("text_end_location");
      int i3 = ((JSONArray)localObject).getInt(0);
      int i4 = ((JSONArray)localObject).getInt(1);
      localObject = localJSONObject.getString("text_color");
      int i5 = localJSONObject.getInt("text_size");
      int i6 = localJSONObject.getInt("picture_width");
      int i7 = localJSONObject.getInt("picture_height");
      int i8 = localJSONObject.getInt("standard_width");
      int i9 = localJSONObject.getInt("standard_height");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.h = i;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_ArrayOfInt = new int[] { j, k, m, n };
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.b = new int[] { i1, i2 };
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.c = new int[] { i3, i4 };
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.i = i5;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.j = i6;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.k = i7;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.l = i8;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.m = i9;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public String toString()
  {
    return "Item{thumbUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.b + '\'' + ", desc='" + this.c + '\'' + ", imageUrl='" + this.d + '\'' + ", imageDrawable=" + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable + ", imageBitmap=" + this.jdField_a_of_type_AndroidGraphicsBitmap + ", layoutJson='" + this.e + '\'' + ", params=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\LocationFacePackage$Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */