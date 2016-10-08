package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id")
public class BlessTask
  extends Entity
{
  public String defaultShareTitle;
  public String defaultVoice;
  public int defaultVoiceLength;
  public String entranceBegin;
  public int entranceEnabled;
  public String entranceEnd;
  public String entranceHint;
  public String ex1;
  public String ex2;
  public int ex3;
  public int ex4;
  @unique
  public int id;
  public boolean isDeleted;
  public boolean isNew;
  public String mainBanner;
  public String mainCenter;
  public int ptvEnabled;
  public String sendBackBegin;
  public String sendBackEnd;
  public int sendTotalLimit;
  public String starAvator;
  public String starBegin;
  public String starBless;
  public String starEnd;
  public String starVideo;
  public String starVideoCoverFileName;
  public String starVideoCoverFolderName;
  public String starWord;
  public String succeededBanner;
  public String typeBanner;
  public int uinTotalLimit;
  public int unread;
  public boolean videoPlayed;
  
  public BlessTask()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.id = 1000;
    this.isNew = true;
    this.starVideoCoverFolderName = "cover";
    this.starVideoCoverFileName = "cover";
    this.ex1 = "";
    this.ex2 = "";
  }
  
  public static boolean parse(String paramString, BlessTask paramBlessTask, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      paramBlessTask.entranceEnabled = paramString.getInt("mb_open");
      paramBlessTask.ptvEnabled = paramString.getInt("mb_ptv_open");
      paramBlessTask.starVideo = paramString.getString("mb_star_video");
      paramBlessTask.starAvator = paramString.getString("mb_star_avator");
      paramBlessTask.starWord = paramString.getString("mb_star_word");
      paramBlessTask.starBless = paramString.getString("mb_star_bless");
      paramBlessTask.ex2 = paramString.getString("mb_star_bless_orange");
      paramBlessTask.entranceHint = paramString.getString("mb_hint");
      paramBlessTask.entranceBegin = paramString.getString("mb_begin");
      paramBlessTask.entranceEnd = paramString.getString("mb_end");
      paramBlessTask.sendBackBegin = paramString.getString("mb_return_begin");
      paramBlessTask.sendBackEnd = paramString.getString("mb_return_end");
      paramBlessTask.starBegin = paramString.getString("mb_star_begin");
      paramBlessTask.starEnd = paramString.getString("mb_star_end");
      paramBlessTask.unread = paramString.getInt("mb_redpoint");
      paramBlessTask.mainBanner = paramString.getString("mb_main_banner");
      paramBlessTask.mainCenter = paramString.getString("mb_center_banner");
      paramBlessTask.typeBanner = paramString.getString("mb_type_banner");
      paramBlessTask.succeededBanner = paramString.getString("mb_succed_banner");
      paramBlessTask.uinTotalLimit = paramString.getInt("mb_uin_limit");
      paramBlessTask.sendTotalLimit = paramString.getInt("mb_send_limit");
      paramBlessTask.defaultVoiceLength = paramString.getInt("mb_default_voice_length");
      paramBlessTask.defaultShareTitle = paramString.getString("mb_default_share_title");
      JSONArray localJSONArray = paramString.getJSONArray("mb_words");
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramArrayList2.add(new BlessWording(localJSONArray.getString(i)));
        i += 1;
      }
      paramBlessTask.defaultVoice = paramString.getString("mb_default_voice");
      paramString = paramString.getJSONArray("mb_ptvs");
      i = 0;
      while (i < paramString.length())
      {
        paramBlessTask = paramString.getJSONObject(i);
        paramArrayList1.add(new BlessPtvModule(paramBlessTask.getString("mb_name"), paramBlessTask.getString("mb_data"), paramBlessTask.getString("mb_id"), paramBlessTask.getString("mb_viplevel"), paramBlessTask.getInt("mb_music_length"), paramBlessTask.getString("mb_share_title")));
        i += 1;
      }
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */