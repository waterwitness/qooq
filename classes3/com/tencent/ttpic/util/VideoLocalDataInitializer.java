package com.tencent.ttpic.util;

import com.tencent.ttpic.model.VideoMaterialMetaData;
import java.util.ArrayList;
import java.util.List;

public class VideoLocalDataInitializer
{
  public static String[] ONLINE_MATERIAL_IDS = { "video_jinmao", "video_fenlu", "video_nethot", "video_fox", "video_water_ghost", "video_lamb", "video_xiaohuzi", "video_zhinv", "video_gentleman", "video_jiaban_dog", "video_little_mouse", "video_520", "video_zhipai", "video_cangshu", "video_huaduo", "video_wawalian", "video_aliens", "video_fangle2", "video_monalisa", "video_kangxi", "video_angrybird", "video_baby_milk", "video_dayuhaitang", "video_fawn", "video_guiguan", "video_heart_cheek", "video_heart_eye", "video_heart_lips", "video_huangguan", "video_cat", "video_raccoon", "video_liaomei", "video_limao", "video_lovely_cat", "video_lovely_eye", "video_molihuaxian", "video_mothersday", "video_ogle", "video_ruhua", "video_snake_face", "video_zhenzi", "video_xiaoxuesheng", "video_xinqing", "video_yellow_dog" };
  
  public static List<VideoMaterialMetaData> buildVideoMaterials()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoMaterialMetaData("video_rabbit", "assets://camera/camera_video/CameraVideoAnimal/video_rabbit", "", "assets://camera/camera_video/CameraVideoAnimal/video_rabbit/video_rabbit.png"));
    localArrayList.add(new VideoMaterialMetaData("video_snow_white", "assets://camera/camera_video/CameraVideoAnimal/video_snow_white", "", "assets://camera/camera_video/CameraVideoAnimal/video_snow_white/video_snow_white.png"));
    String[] arrayOfString = ONLINE_MATERIAL_IDS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localArrayList.add(new VideoMaterialMetaData(str, "", "http://st1.xiangji.qq.com/yunmaterials/" + str + "Android.zip", "http://st1.xiangji.qq.com/yunmaterials/" + str + ".png"));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoLocalDataInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */