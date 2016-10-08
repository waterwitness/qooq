package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.PublishConfigRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ijm;

public class StoryConfigManager
  extends ConfigManager
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final String c = "StoryConfigManager";
  public static final String d = "time_stamp";
  public static final String e = "publish_picture";
  public static final String f = "first_time_pic";
  public static final String g = "easter_animation_is_ready";
  public static final String h = "show_now_entry";
  public static final String i = "recent_story_refresh_time";
  public static final String j = "story_list_last_update_from_net_time";
  public static final String k = "story_list_request_data_from_net_running_state";
  public static final String l = "has_show_play_guide";
  public static final String m = "has_show_explore_guide";
  
  public StoryConfigManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(QQStoryContext.a().a());
  }
  
  public long a()
  {
    return ((Integer)b("recent_story_refresh_time", Integer.valueOf(0))).intValue();
  }
  
  public void a(boolean paramBoolean)
  {
    b("has_show_play_guide", Boolean.valueOf(paramBoolean));
  }
  
  public boolean a()
  {
    return ((Boolean)b("has_show_play_guide", Boolean.valueOf(false))).booleanValue();
  }
  
  public Object b(String paramString, Object paramObject)
  {
    return super.a(paramString + "_" + QQStoryContext.a().a(), paramObject);
  }
  
  public void b(String paramString, Object paramObject)
  {
    super.a(paramString + "_" + QQStoryContext.a().a(), paramObject);
  }
  
  public void b(boolean paramBoolean)
  {
    b("has_show_explore_guide", Boolean.valueOf(paramBoolean));
  }
  
  public boolean b()
  {
    return ((Boolean)b("has_show_explore_guide", Boolean.valueOf(false))).booleanValue();
  }
  
  public void c()
  {
    SLog.b("StoryConfigManager", "fireSyncServer");
    PublishConfigRequest localPublishConfigRequest = new PublishConfigRequest();
    CmdTaskManger.a().a(localPublishConfigRequest, new ijm(this));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\StoryConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */