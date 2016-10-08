package com.tencent.biz.qqstory.takevideo.music;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQStoryMusicInfo
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  String a;
  public String b;
  String c;
  public String d;
  String e;
  int jdField_f_of_type_Int;
  String jdField_f_of_type_JavaLangString;
  public int g;
  public String g;
  public int h;
  public int i;
  
  public QQStoryMusicInfo(int paramInt, String paramString)
  {
    this.a = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_f_of_type_Int = 0;
    this.h = 0;
    this.jdField_f_of_type_Int = paramInt;
    this.b = paramString;
  }
  
  public QQStoryMusicInfo(qqstory_struct.MusicConfigInfo paramMusicConfigInfo)
  {
    this.a = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_f_of_type_Int = 0;
    this.h = 0;
    this.b = paramMusicConfigInfo.title.get().toStringUtf8();
    this.d = paramMusicConfigInfo.audio_url.get().toStringUtf8();
    this.jdField_f_of_type_Int = -1;
  }
  
  public QQStoryMusicInfo(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_f_of_type_Int = 0;
    this.h = 0;
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("title");
      this.d = paramString.optString("audio_url");
      this.jdField_f_of_type_Int = -1;
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("zivonchen", 2, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\music\QQStoryMusicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */