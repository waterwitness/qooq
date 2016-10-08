package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class BubbleConfig
{
  public static final String a = "BubbleConfig";
  public static final String b = "config.json";
  public static final String c = "version.json";
  public static final String d = "static";
  public static final String e = "chartlet";
  public static final String f = "height";
  public static final String g = "width";
  public static final String h = "voice";
  public static final String i = "static.zip";
  public static final String j = "height.zip";
  public static final String k = "voice.zip";
  public static final String l = "all.zip";
  public static final String m = "global_version";
  public int a;
  public AnimationConfig a;
  public BubbleConfig.Chartlet a;
  public BubbleConfig.DiyTextConfig a;
  public ArrayList a;
  public boolean a;
  public int[] a;
  public int b;
  public AnimationConfig b;
  public int c;
  public AnimationConfig c;
  public int d;
  public AnimationConfig d;
  public String n;
  
  public BubbleConfig(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[ bubbleId=" + this.a).append(",");
    localStringBuffer.append("name=" + this.n).append(" ]");
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */