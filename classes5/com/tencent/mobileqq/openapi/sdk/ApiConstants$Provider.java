package com.tencent.mobileqq.openapi.sdk;

import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ApiConstants$Provider
{
  public static final String A = "msgid";
  public static final String B = "msgSummary";
  public static final String C = "nick";
  public static final String D = "senderNick";
  public static final String E = "unreadCount";
  public static final String F = "msgContent";
  public static final String G = "pcm_path";
  public static final String H = "is_send";
  public static final String I = "is_read";
  public static final String J = "op";
  public static final String K = "is_all";
  public static final String L = "only_unread";
  public static final String M = "only_recv";
  public static final String N = "msgTime";
  public static final String O = "sampleRate";
  public static final String P = "media_path";
  public static final String Q = "mediaStatus";
  public static final String R = "sessionkey";
  public static final String S = "lastsessionkey";
  public static final String T = "imm_reg";
  public static final int a = 0;
  public static final Uri a;
  public static final String a = "com.tencent.mobileqq.openapi.provider";
  public static final String[] a;
  public static final int b = 1;
  public static final Uri b;
  public static final String b = "query_msg";
  public static final String[] b;
  public static final int c = 2;
  public static final Uri c;
  public static final String c = "query_face";
  public static final String[] c;
  public static final int d = 3;
  public static final Uri d;
  public static final String d = "query_nick";
  public static final String[] d;
  public static final int e = 4;
  public static final Uri e;
  public static final String e = "reg_receiver";
  public static final String[] e;
  public static final int f = 5;
  public static final Uri f;
  public static final String f = "send_msg";
  public static final String[] f;
  public static final int g = 6;
  public static final Uri g;
  public static final String g = "set_readed";
  public static final String[] g;
  public static final int h = 7;
  public static final Uri h;
  public static final String h = "openaio";
  public static final String[] h;
  public static final int i = 8;
  public static final Uri i;
  public static final String i = "decodesilk";
  public static final String[] i;
  public static final int j = 9;
  public static final Uri j;
  public static final String j = "download_media";
  public static final String[] j;
  public static final int k = 10;
  public static final Uri k;
  public static final String k = "exchange_uin";
  public static final String[] k;
  public static final int l = 1;
  public static final String l = "paycode_channel";
  public static final String[] l = { "msg_type", "rs_code", "msgSummary" };
  public static final int m = 2;
  public static final String m = "rs_code";
  public static final String n = "uin";
  public static final String o = "senderUin";
  public static final String p = "permission";
  public static final String q = "msg_type";
  public static final String r = "uin_type";
  public static final String s = "appid";
  public static final String t = "msg_filter";
  public static final String u = "uin_filter";
  public static final String v = "pkgName";
  public static final String w = "unread_count";
  public static final String x = "remain_unread";
  public static final String y = "count";
  public static final String z = "msgids";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/query_msg");
    jdField_b_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/query_face");
    jdField_c_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/query_nick");
    jdField_d_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/reg_receiver");
    jdField_e_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/send_msg");
    jdField_f_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/set_readed");
    jdField_g_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/openaio");
    jdField_h_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/decodesilk");
    jdField_i_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/download_media");
    jdField_j_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/exchange_uin");
    jdField_k_of_type_AndroidNetUri = Uri.parse("content://com.tencent.mobileqq.openapi.provider/paycode_channel");
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "rs_code" };
    jdField_b_of_type_ArrayOfJavaLangString = MessageItem.jdField_a_of_type_ArrayOfJavaLangString;
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "media_path" };
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "nick" };
    jdField_e_of_type_ArrayOfJavaLangString = new String[] { "rs_code", "sessionkey", "uin" };
    jdField_f_of_type_ArrayOfJavaLangString = new String[] { "msgid" };
    jdField_g_of_type_ArrayOfJavaLangString = new String[] { "rs_code" };
    jdField_h_of_type_ArrayOfJavaLangString = new String[] { "rs_code" };
    jdField_i_of_type_ArrayOfJavaLangString = new String[] { "rs_code", "sampleRate" };
    jdField_j_of_type_ArrayOfJavaLangString = new String[] { "mediaStatus" };
    jdField_k_of_type_ArrayOfJavaLangString = new String[] { "rs_code", "uin" };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\openapi\sdk\ApiConstants$Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */