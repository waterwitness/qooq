package com.tencent.biz.qqstory.utils.ffmpeg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import izj;
import izk;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FFmpegUtils
{
  public static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    return "QQStory" + a.format(new Date()) + "_" + Math.abs(paramInt) + ".mp4";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i > -1) && (i < paramString.length() - 1)) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    Object localObject1 = a(paramString2);
    Object localObject2 = new File(QQStoryConstant.r);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(QQStoryConstant.r);
    ((StringBuffer)localObject2).append(paramString2.hashCode());
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt1);
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt2);
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject2 = new String((StringBuffer)localObject2);
    localObject1 = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.i = 3;
    localFFmpegCommandUnit.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.1(paramString2, (String)localObject2, paramInt1, paramInt2);
    localFFmpegCommandUnit.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new izj(paramExecuteBinResponseCallback);
    ((ArrayList)localObject1).add(localFFmpegCommandUnit);
    paramString2 = new FFmpegCommandUnit();
    paramString2.i = 4;
    paramString2.jdField_a_of_type_JavaUtilArrayList = new FFmpegUtils.3(paramString1, (String)localObject2, paramString3);
    paramString2.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new izk(paramExecuteBinResponseCallback, (String)localObject2);
    ((ArrayList)localObject1).add(paramString2);
    paramContext = FFmpeg.a(paramContext);
    if (paramContext.a())
    {
      paramContext.b((ArrayList)localObject1);
      return;
    }
    paramContext.a((ArrayList)localObject1);
  }
  
  public static void a(String paramString)
  {
    File localFile1 = new File(QQStoryConstant.s + paramString + ".mp4");
    File localFile2 = new File(QQStoryConstant.s + paramString + ".ts");
    File localFile3 = new File(QQStoryConstant.t + paramString + ".mp4");
    paramString = new File(QQStoryConstant.t + paramString + ".png");
    if (localFile1.exists()) {
      localFile1.delete();
    }
    if (localFile2.exists()) {
      localFile2.delete();
    }
    if (localFile3.exists()) {
      localFile3.delete();
    }
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static String b(String paramString)
  {
    return "QQStoryMoment" + a.format(new Date()) + "_" + paramString + ".mp4";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\ffmpeg\FFmpegUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */