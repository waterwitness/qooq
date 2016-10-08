package com.tencent.mobileqq.intervideo.now;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public class ShareToQQActivity
  extends BaseActivity
{
  static boolean a;
  
  public ShareToQQActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(getIntent().getStringExtra("storyid"))) {
      TroopShareUtility.a(this.app, this, paramInt2, paramIntent);
    }
    for (;;)
    {
      a = false;
      finish();
      return;
      TroopShareUtility.b(this.app, this, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (a) {
      finish();
    }
    a = true;
    if (!TextUtils.isEmpty(paramBundle.getStringExtra("storyid")))
    {
      MessageForQQStory localMessageForQQStory = new MessageForQQStory();
      localMessageForQQStory.coverImgUrl = paramBundle.getStringExtra("imageUrl");
      localMessageForQQStory.brief = paramBundle.getStringExtra("summary");
      localMessageForQQStory.srcName = "日迹";
      localMessageForQQStory.srcAction = "mqqapi://qstory/opendiscovery?src_type=internal&version=1";
      localMessageForQQStory.msgAction = String.format("mqqapi://now/openroom?src_type=app&version=1&roomid=%s&first=%d&bid=1&contentType=2&unionid=%s", new Object[] { Long.valueOf(paramBundle.getLongExtra("roomid", 0L)), Integer.valueOf(2), paramBundle.getStringExtra("unionid") });
      localMessageForQQStory.authorName = paramBundle.getStringExtra("anchorname");
      localMessageForQQStory.logoImgUrl = "http://p.qpic.cn/qqstory_pic/hb4ycQ6NORNib7icgbswTvTCmkTyROl41Rcw9UeasFKzLwevbfJVhMRA/";
      localMessageForQQStory.briefBgColor = -16395392;
      TroopShareUtility.a(this, localMessageForQQStory, 1001);
      return true;
    }
    TroopShareUtility.a(this, paramBundle.getExtras(), 1001);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\ShareToQQActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */