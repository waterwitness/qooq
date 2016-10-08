package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.net.URLEncoder;
import vkt;

public class TroopTagViewActivity
  extends QQBrowserActivity
{
  public static final int a = 1;
  public static final String a = "troopuin";
  public static final int b = 2;
  public static final String b = "request_params";
  public static final int c = 3;
  public static final String c = "from";
  public static final String d = "tags";
  public static final String e = "subclass";
  public static final String f = "isAdmin";
  public static final String g = "act_type";
  private static final String m = "hide_operation_bar";
  private static final String n = "http://web.qun.qq.com/tag/index.html?_bid=146&t=%d#tags=%s&gc=%s&base=%s&modifyToSrv=%s";
  private static final String o = "http://web.qun.qq.com/tag/edit.html?_bid=146#tags=%s&gc=%s&base=%s&modifyToSrv=%s";
  protected boolean a;
  protected QQProgressDialog b;
  protected int d;
  public int e;
  public String h;
  public String i;
  protected String j;
  protected String k;
  public String l;
  
  public TroopTagViewActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 1;
  }
  
  protected int a(Bundle paramBundle)
  {
    int i1 = super.a(paramBundle);
    if ((this.d == 1) && (this.a))
    {
      this.rightViewText.setText(2131368747);
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setOnClickListener(new vkt(this));
      return i1;
    }
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(8);
    return i1;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null)
    {
      super.finish();
      return true;
    }
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null)
    {
      super.finish();
      return true;
    }
    this.d = localBundle.getInt("act_type", 3);
    this.i = localBundle.getString("tags");
    if (localBundle.containsKey("subclass")) {}
    for (this.j = localBundle.getString("subclass");; this.j = "")
    {
      this.h = localBundle.getString("troopuin");
      if (!TextUtils.isEmpty(this.h)) {
        break;
      }
      super.finish();
      return true;
    }
    this.a = localBundle.getBoolean("isAdmin");
    localIntent.putExtra("act_type", 3);
    localIntent.putExtra("hide_operation_bar", true);
    String str;
    if (TextUtils.isEmpty(this.i))
    {
      str = "";
      this.e = localBundle.getInt("modifyToSrv", 1);
      if (this.d != 1) {
        break label271;
      }
      this.ab = String.format("http://web.qun.qq.com/tag/index.html?_bid=146&t=%d#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { Long.valueOf(System.currentTimeMillis() / 1000L), str, this.h, this.j, Integer.valueOf(this.e) });
      localIntent.putExtra("url", this.ab);
    }
    for (;;)
    {
      localIntent.putExtra("isShowAd", false);
      super.doOnCreate(paramBundle);
      return true;
      str = URLEncoder.encode(this.i).replace("+", "%20");
      break;
      label271:
      if (this.d == 2)
      {
        this.ab = String.format("http://web.qun.qq.com/tag/edit.html?_bid=146#tags=%s&gc=%s&base=%s&modifyToSrv=%s", new Object[] { str, this.h, this.j, Integer.valueOf(this.e) });
        localIntent.putExtra("url", this.ab);
      }
      else
      {
        this.ab = localBundle.getString("url");
        localIntent.putExtra("url", this.ab);
      }
    }
  }
  
  public void finish()
  {
    if (!TextUtils.isEmpty(this.l))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("tags", this.l);
      setResult(-1, localIntent);
    }
    super.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopTagViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */