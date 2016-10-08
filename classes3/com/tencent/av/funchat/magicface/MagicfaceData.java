package com.tencent.av.funchat.magicface;

import android.graphics.Rect;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MagicfaceData
{
  private static final String jdField_c_of_type_JavaLangString = "AVMagicfaceData";
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  int d;
  int e;
  
  public MagicfaceData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 8;
    this.c = 1;
    this.jdField_b_of_type_Boolean = false;
    this.d = 0;
    this.e = 0;
  }
  
  public MagicfaceData(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 8;
    this.c = 1;
    this.jdField_b_of_type_Boolean = false;
    this.d = 0;
    this.e = 0;
    a("init|config=" + paramString);
    paramString = new JSONObject(paramString);
    JSONObject localJSONObject = paramString.getJSONObject("video");
    this.jdField_a_of_type_Boolean = localJSONObject.getBoolean("full_screen");
    this.jdField_a_of_type_AndroidGraphicsRect.left = localJSONObject.getInt("location_x");
    this.jdField_a_of_type_AndroidGraphicsRect.top = localJSONObject.getInt("location_y");
    this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_a_of_type_AndroidGraphicsRect.left + localJSONObject.getInt("width"));
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_AndroidGraphicsRect.top + localJSONObject.getInt("height"));
    this.jdField_a_of_type_Int = localJSONObject.getInt("frame_count");
    this.jdField_a_of_type_JavaLangString = localJSONObject.getString("src_prefix");
    this.jdField_b_of_type_Int = localJSONObject.getInt("fps");
    this.c = localJSONObject.getInt("repeat_count");
    if (paramString.has("audio"))
    {
      paramString = paramString.getJSONObject("audio");
      this.jdField_b_of_type_JavaLangString = paramString.getString("src");
      this.jdField_b_of_type_Boolean = paramString.getBoolean("is_repeat");
      this.d = paramString.getInt("frame_index");
      this.e = this.jdField_a_of_type_Int;
    }
  }
  
  void a(String paramString)
  {
    QLog.i("AVMagicfaceData", 2, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\funchat\magicface\MagicfaceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */