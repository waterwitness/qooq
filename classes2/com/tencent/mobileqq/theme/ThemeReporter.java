package com.tencent.mobileqq.theme;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class ThemeReporter
{
  public static final int A = 137;
  public static final int B = -1;
  public static final int C = -3;
  public static final int D = -6;
  public static final int E = -7;
  public static final int F = -8;
  public static final int G = -9;
  public static final int H = -10;
  public static final int I = -11;
  public static final int J = -12;
  public static final int K = -13;
  public static final int L = -14;
  public static final int M = -19;
  public static final int N = -23;
  public static final int O = -24;
  public static final int P = -28;
  public static final int Q = -29;
  public static final int R = -30;
  public static final int S = -33;
  public static final int T = -34;
  public static final int U = -35;
  public static final int V = -36;
  public static final int W = -37;
  public static final int X = -40;
  public static final int Y = -41;
  public static final int Z = -43;
  public static final int a = 1;
  static final String a = "ThemeReporter";
  public static final int aa = -44;
  public static final int ab = 150;
  public static final int ac = 151;
  public static final int ad = 152;
  public static final int ae = 153;
  public static final int af = 154;
  public static final int ag = 155;
  public static final int ah = 156;
  public static final int ai = 157;
  public static final int aj = 158;
  public static final int ak = 256;
  public static final int al = 257;
  public static final int b = 2;
  public static final String b = "url";
  public static final int c = 3;
  public static final String c = "id";
  public static final int d = 7;
  public static final String d = "version";
  public static final int e = 8;
  public static final String e = "size";
  public static final int f = 9;
  public static final String f = "isSound";
  public static final int g = 10;
  public static final String g = "withoutFlowTips";
  public static final int h = 11;
  public static final String h = "isJumpTop";
  public static final int i = 12;
  public static final String i = "getStatus";
  public static final int j = 15;
  public static final String j = "errCode";
  public static final int k = 16;
  public static final String k = "theme_detail";
  public static final int l = 17;
  public static final String l = "200";
  public static final int m = 20;
  public static final String m = "201";
  public static final int n = 21;
  public static final String n = "202";
  public static final int o = 22;
  public static final String o = "203";
  public static final int p = 23;
  public static final String p = "204";
  public static final int q = 30;
  public static final String q = "205";
  public static final int r = 31;
  public static final String r = "206";
  public static final int s = 32;
  public static final String s = "207";
  public static final int t = 33;
  public static final String t = String.valueOf(153);
  public static final int u = 34;
  public static final String u = String.valueOf(153);
  public static final int v = 5000;
  public static final int w = 101;
  public static final int x = 119;
  public static final int y = 135;
  public static final int z = 136;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramInt2 < 0) {
      paramInt2 = NetworkUtil.a(null);
    }
    for (;;)
    {
      int i1 = paramInt2;
      if (paramInt2 <= 0) {
        i1 = 10;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString1, paramString2, paramInt1, i1, paramInt3, paramString3, paramString4, paramString5, "");
      paramQQAppInterface = paramString4;
      try
      {
        if (TextUtils.isEmpty(paramString4)) {
          paramQQAppInterface = "1";
        }
        VasWebviewUtil.reportVasStatus(paramString1, paramString2, paramString3, i1, paramInt1, paramInt3, Integer.parseInt(paramQQAppInterface), paramString5, "");
        if ((QLog.isColorLevel()) && (paramInt3 < 0))
        {
          paramString4 = new StringBuilder();
          paramString4.append(paramString1).append("|step:");
          paramString4.append(paramInt1).append("|from:");
          paramString4.append(paramString2).append("|resultCode:");
          paramString4.append(paramInt3).append("|id:");
          paramString4.append(paramString3).append("|version:");
          paramString4.append(paramQQAppInterface);
          QLog.i("ThemeReporter", 2, "ThemeReporterreportTheme Error data::" + paramString4.toString());
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ThemeReporter", 1, "ThemeReporter reportTheme Exception:" + paramQQAppInterface.getMessage());
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\ThemeReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */