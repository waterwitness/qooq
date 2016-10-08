package com.tencent.mobileqq.openapi.sdk;

import android.database.Cursor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageItem
{
  public static final int a = 0;
  public static final String a = "[语音]";
  public static final String[] a;
  public static final int b = 1;
  public static final String b = "[图片]";
  public static final int c = 2;
  public static final String c = "[表情]";
  public static final int d = 4;
  public static final String d = "[震动]";
  public static final int e = 8;
  public static final String e = "[文件]";
  public static final int f = 16;
  public static final String f = "[不支持显示的消息]";
  public static final int g = 32;
  public static final int h = 64;
  public static final int i = 1073741824;
  public static final int j = Integer.MAX_VALUE;
  public static final int k = 1000;
  public static final int l = 1001;
  public static final int m = 1002;
  public static final int n = 1003;
  public static final int o = 1004;
  public static final int p = 1005;
  public static final int q = 1006;
  public static final int r = 1007;
  public long a;
  public boolean a;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public int s;
  public int t;
  public int u;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "uin", "uin_type", "senderUin", "msg_type", "msgid", "msgTime", "is_send", "msgContent", "media_path", "mediaStatus" };
  }
  
  private MessageItem() {}
  
  public MessageItem(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong, boolean paramBoolean, String paramString4, String paramString5, int paramInt3)
  {
    this.g = paramString1;
    this.s = paramInt1;
    this.h = paramString2;
    this.t = paramInt2;
    this.i = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.j = paramString4;
    this.k = paramString5;
    this.u = paramInt3;
  }
  
  public static MessageItem a(Cursor paramCursor)
  {
    MessageItem localMessageItem = new MessageItem();
    localMessageItem.g = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    localMessageItem.s = paramCursor.getInt(paramCursor.getColumnIndex("uin_type"));
    localMessageItem.h = paramCursor.getString(paramCursor.getColumnIndex("senderUin"));
    localMessageItem.t = paramCursor.getInt(paramCursor.getColumnIndex("msg_type"));
    localMessageItem.i = paramCursor.getString(paramCursor.getColumnIndex("msgid"));
    localMessageItem.jdField_a_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("msgTime"));
    localMessageItem.jdField_a_of_type_Boolean = paramCursor.getString(paramCursor.getColumnIndex("is_send")).equals("true");
    localMessageItem.j = paramCursor.getString(paramCursor.getColumnIndex("msgContent"));
    localMessageItem.k = paramCursor.getString(paramCursor.getColumnIndex("media_path"));
    localMessageItem.u = paramCursor.getInt(paramCursor.getColumnIndex("mediaStatus"));
    return localMessageItem;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2);
  }
  
  public Object[] a()
  {
    return new Object[] { this.g, Integer.valueOf(this.s), this.h, Integer.valueOf(this.t), this.i, Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.j, this.k, Integer.valueOf(this.u) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append(this.g).append("; ");
    localStringBuilder.append(this.t).append("; ");
    localStringBuilder.append(this.h).append("; ");
    localStringBuilder.append(this.i).append("; ");
    localStringBuilder.append(this.jdField_a_of_type_Long).append(";");
    localStringBuilder.append(this.jdField_a_of_type_Boolean).append("; ");
    localStringBuilder.append(this.j).append("; ");
    localStringBuilder.append(this.k).append("; ");
    localStringBuilder.append(this.u).append(". ");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\openapi\sdk\MessageItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */