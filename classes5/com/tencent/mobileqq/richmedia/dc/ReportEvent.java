package com.tencent.mobileqq.richmedia.dc;

public abstract interface ReportEvent
{
  public static final String A = "preload_status";
  public static final String B = "preload_fail_filetype";
  public static final String C = "param_uinType";
  public static final String D = "param_GroupMemberCount";
  public static final String E = "param_age";
  public static final String F = "param_gender";
  public static final String G = "param_netType";
  public static final String H = "param_userType";
  public static final String I = "param_md5";
  public static final String J = "param_fileSize";
  public static final String K = "param_duration";
  public static final String L = "param_status";
  public static final String M = "ShortVideo.Send";
  public static final String N = "param_DetailUrl";
  public static final String O = "param_shortVideoType";
  public static final String P = "param_shortVideoSourceType";
  public static final String Q = "param_isForward";
  public static final String R = "param_isExist";
  public static final String S = "param_forwardSourceUinType";
  public static final String T = "param_reportHour";
  public static final String U = "param_fileInterval";
  public static final String V = "param_forwardSourceGroupMemberCount";
  public static final String W = "ShortVideo.Preview";
  public static final String X = "param_playAction";
  public static final String Y = "ShortVideo.FullscreenPreview";
  public static final String Z = "param_playTimeCost";
  public static final int a = 1;
  public static final String aa = "ShortVideo.Save";
  public static final String ab = "RealShortVideo.Record";
  public static final String ac = "param_cameraID";
  public static final String ad = "param_hasMultiSegments";
  public static final String ae = "actStreamingVideoPlay";
  public static final String af = "StreamingVideoSupport";
  public static final String ag = "FirstBufferTime";
  public static final String ah = "PlayProgress";
  public static final String ai = "LoadProgress";
  public static final String aj = "FileDuration";
  public static final String ak = "FileLen";
  public static final String al = "param_seekTimes";
  public static final String am = "PlayResult";
  public static final String an = "LoadVideoTime";
  public static final String ao = "BufferTimes";
  public static final String ap = "ManualScrub";
  public static final String aq = "LoadResult";
  public static final String ar = "LoadSpeed";
  public static final String as = "HaveCache";
  public static final int b = 2;
  public static final int c = 0;
  public static final int d = 1001;
  public static final int e = 1002;
  public static final int f = 2000;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 3000;
  public static final String l = "Pic.AioPreview";
  public static final int m = 2001;
  public static final String m = "stay_seconds";
  public static final int n = 2002;
  public static final String n = "gesture_double_click";
  public static final int o = 2003;
  public static final String o = "view_again";
  public static final int p = 1001;
  public static final String p = "view_count";
  public static final int q = 1002;
  public static final String q = "send_type";
  public static final int r = 1003;
  public static final String r = "size_type";
  public static final int s = 1004;
  public static final String s = "format_type";
  public static final int t = 1005;
  public static final String t = "Pic.AioPreview.Progressive";
  public static final int u = 1006;
  public static final String u = "is_progressive";
  public static final int v = 1007;
  public static final String v = "view_count";
  public static final int w = 1001;
  public static final String w = "to_dp";
  public static final int x = 1002;
  public static final String x = "to_large";
  public static final int y = 1003;
  public static final String y = "failure";
  public static final String z = "Pic.AioPreview.Preload";
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\dc\ReportEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */